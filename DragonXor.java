//https://www.codechef.com/problems/DRAGNXOR


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class DragonXor {
    public static void main(String args[]) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int t=ip(br.readLine());
        while(t-->0){
            String[] s=br.readLine().split(" ");
            int n=ip(s[0]);
            int a=Integer.bitCount(ip(s[1]));
            int b=Integer.bitCount(ip(s[2]));
            int sum=a+b;
            
            if(sum>n)
                sum=2*n-sum;
            pw.println(((1<<sum)-1)<<(n-sum));
        }
        pw.close();
    }
    public static int ip(String s){
        return Integer.parseInt(s);
    }
}
