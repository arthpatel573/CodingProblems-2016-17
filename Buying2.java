/*
https://www.codechef.com/problems/BUYING2
Date: 14/08/2016
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Buying2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t = ip(br.readLine());
		while (t-- > 0) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int n=ip(st.nextToken());
			int x=ip(st.nextToken());
			String[] str=br.readLine().split(" ");
			int[] arr=new int[n];
			int total=0;
			int min=101,ans=0;
			for(int i=0;i<n;i++){
				arr[i]=ip(str[i]);
				total+=arr[i];
				if(arr[i]<min){
					min=arr[i];
				}
			}
			if(total/x==(total-min)/x)
				ans=-1;
			else
				ans=total/x;
			pw.println(ans);
		}
		pw.close();
	}
	public static int ip(String s){
		return Integer.parseInt(s);
	}
}
