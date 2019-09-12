/*
https://www.codechef.com/problems/MAXDIFF
Date: 22/08/2016
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class MaxDiff {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		int t=ip(br.readLine());
		while(t-->0){
			StringTokenizer st=new StringTokenizer(br.readLine());
			int n=ip(st.nextToken());
			int k=ip(st.nextToken());
			PriorityQueue<Integer> heap=new PriorityQueue<Integer>();
			StringTokenizer st1=new StringTokenizer(br.readLine());
			int sum=0;
			for(int i=0;i<n;i++){
				int tmp=ip(st1.nextToken());
				heap.add(tmp);
				sum+=tmp;
			}
			int temp=0;
			if(n/2>=k){
				while(k-->0){
					temp+=heap.poll();
				}
			}
			else{
				int x=n-k;
				while(x-->0){
					temp+=heap.poll();
				}
			}
			pw.println(sum-2*temp);
		}
		pw.close();
	}
	public static int ip(String s){
		return Integer.parseInt(s);
	}

}
