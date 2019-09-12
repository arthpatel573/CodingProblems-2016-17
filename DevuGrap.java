/*https://www.codechef.com/problems/DEVUGRAP
Date: 14/12/2015
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class DevuGrp 
{
	public static void main(String args[]) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++)
		{
			int n=sc.nextInt();
			int k=sc.nextInt();
			long count=0;
			for(int j=0;j<n;j++)
			{
				int temp=sc.nextInt();
				if(temp<k)
				{
					count+=k-temp;
				}
				else
				{
					int tmp=(temp%k);
					if(tmp>(k/2))
					{
						count+=k-tmp;
					}
					else
					{
						count+=tmp;
					}
				}
			}
			System.out.println(count);
		}
	}
}