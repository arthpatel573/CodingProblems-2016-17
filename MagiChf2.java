/*
https://www.codechef.com/problems/MAGICHF2
Date: 25/01/2017
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class MagiChf2
{
	public static double compute(long n,long k){
	    if(k>=n){
	        return 1.0;
	    }
	    if(k==0){
	        double val = (double)n;
	        double prob = 1.0/val;
	        return prob;
	    }
	    long hlf = 2L;
	    long p1 = n/hlf;
	    long p2 = (n-p1);
	    
	    return compute(Math.max(p1,p2),k-1);
	}
	public static void main (String[] args) throws java.lang.Exception
	{
	     FastReader sc1 = new FastReader();
	     int tc = sc1.nextInt();
	     StringBuilder sb = new StringBuilder();
	     int ch = 0;
	     while(ch<tc){
	         long n = sc1.nextLong();
	         long k = sc1.nextLong();
	         if(n==1){
	              sb.append("1.0\n");
	         }
	         else if(n==2){
	              sb.append("0.5\n");  
	         }
	         else if(k==1){
	             long hlf = 2L;
	             long p1 = n/hlf;
	             long p2 = (n-p1);
	             if(p1%2!=0 && p2%2!=0){
	                 double res = 1.0/(double)(Math.max(p1,p2)+1);
	                 sb.append(res+"\n");
	             }
	             else{
	                double res = 1.0/(double)Math.max(p1,p2);   
	                sb.append(res+"\n");
	             }
	         }
	         else{
	              double prob = compute(n,k);
	              sb.append(prob+"\n");   
	         }
	         ch++;
	     }
	     System.out.println(sb.toString());
	}
	static class FastReader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public FastReader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public FastReader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}
}
