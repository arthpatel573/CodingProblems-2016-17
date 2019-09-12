/*
https://www.codechef.com/problems/CHEFSQ
Date: 20/02/2016
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
 
class ChefSq {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out, true);
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int count = 0;
			int ns = Integer.parseInt(br.readLine());
			String[] s1 = br.readLine().split("\\s+");
			int[] s = new int[ns];
			for (int i = 0; i < ns; i++) {
				s[i] = Integer.parseInt(s1[i]);
			}
			int nf = Integer.parseInt(br.readLine());
			String[] s2 = br.readLine().split("\\s+");
			int[] f = new int[nf];
			for (int i = 0; i < nf; i++) {
				f[i] = Integer.parseInt(s2[i]);
			}
 
			for (int i = 0; i < nf; i++) {
				for (int j = 0; j < ns; j++) {
					if (f[i] == s[j]) {
						count++;
						break;
					}
				}
			}
			if(count == nf){
				pw.println("Yes");
			}else{
				pw.println("No");
			}
		}
 
	}
 
}