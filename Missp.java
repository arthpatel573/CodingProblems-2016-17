/*
https://www.codechef.com/problems/MISSP
Date: 14/12/2015
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
class Missp
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0)
		{
			int n=Integer.parseInt(br.readLine());
			int a[]=new int[n];
			int b[]=new int[100001];
			for(int i=0;i<n;i++)
			{
				a[i]=Integer.parseInt(br.readLine());
				b[a[i]]++;
			}
			for(int i=0;i<=100000;i++)
			{
				if(b[i]%2!=0)
				{
					System.out.println(i);
					break;
				}
			}
		}
	}
}