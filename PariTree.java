/*
https://www.codechef.com/problems/PARITREE
Date: 12/02/2017
*/

import java.io.*;
import java.util.*;

class PariTree{
    
    public static final int mod = 1000000007;
    public static int par[],n,c[];
    public static ArrayList<Integer> adj[],color[];
    public static void main(String[] args)throws IOException {
        // TODO Auto-generated method stub
        InputStream input = System.in;
        FastReader in  = new FastReader();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
        int t = in.nextInt();
        StringBuilder sb = new StringBuilder("");
        
        while(t-- > 0)
        {
            n = in.nextInt();
            int q = in.nextInt();

            adj = new ArrayList[n];
            color = new ArrayList[n];
            par = new int[n];
            c = new int[n];
            Arrays.fill(par, -1);

            for(int i=0; i<n; i++)
            {
                adj[i] = new ArrayList<Integer>();
                color[i] = new ArrayList<Integer>();
            }

            for(int i=0; i<n-1; i++)
            {
                in.nextInt();
                in.nextInt();
            }

            for(int i=1; i<=q; i++)
            {
                int u = in.nextInt()-1;
                int v = in.nextInt()-1;
                int x = in.nextInt();

                adj[u].add(v);
                adj[v].add(u);
                color[u].add(x);
                color[v].add(x);

                merge(u,v);        
            }

            int cnt = 0;
            boolean valid = true;

            for(int i=0; i<n; i++)
            {
                if(par[i] < 0)
                {
                    valid = bfs(i);
                    cnt++;
                }

                if(!valid) break;
            }

            if(!valid) 
                sb.append("0\n");
            else
                sb.append(pow(2,cnt-1,mod)+"\n");
        }
        System.out.println(sb.toString());
    }
    
    static boolean bfs(int src)
    {
        Queue<Integer> q = new LinkedList<Integer>();
       
        q.add(src);
        c[src] = 1;
        
        while(!q.isEmpty())
        {
            int curr = q.poll();
            for(int i=0; i<adj[curr].size(); i++)
            {
                int next = adj[curr].get(i);
                int next_x = color[curr].get(i);
                
                if(c[next] == 0)
                {
                    if(next_x == 0)
                        c[next] = c[curr];
                    else
                        c[next] = c[curr]*-1;
                    q.add(next);
                }
                else
                {
                    if(next_x == 0 && c[next] != c[curr])
                        return false;
                    if(next_x == 1 && c[next] == c[curr])
                        return false;
                }
            }
        }
        
        return true;
                      
    }
    static int root(int x)
    {
        return par[x] < 0 ? x : (par[x] = root(par[x]));
    }
    
    static void merge(int x,int y)
    {
        if((x = root(x)) == (y = root(y)))
                return;
                
        if(par[y] < par[x])
        {
            par[y] += par[x];
            par[x] = y;
        }
        else
        {
            par[x] += par[y];
            par[y] = x;
        }
    }
    
    static long pow(long a,long b,long c)
    {
        long ans = 1L;
        
        a %= c;
        
        while(b > 0)
        {
            if(b%2 == 1) ans = (ans*a)%c;
            a = (a*a)%c;
            b /= 2;
        }
        
        return ans;
    }
    static int gcd(int a,int b)
    {
        if(b == 0)
            return a;
        else return gcd(b,a%b);
    }

    static int lcm(int a, int b)
    {

        return (a*b)/gcd(a,b);
    }

    static class FastReader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public FastReader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}    

