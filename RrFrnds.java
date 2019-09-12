/*
https://www.codechef.com/problems/RRFRNDS
Date: 01/09/2016
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.BitSet;
import java.util.StringTokenizer;

class RrFrnds {

	public static void main(String args[] ) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    PrintWriter w = new PrintWriter(System.out);
	        
	    int n = ip(br.readLine());
	    BitSet a[] = new BitSet[n];
	    
	    for(int i=0;i<n;i++){
	    	char temp[] = br.readLine().toCharArray();
	    	a[i] = new BitSet(n);
	    	for(int j=0;j<n;j++)
	    		if(temp[j] == '1')	a[i].set(j);
	    }
	    
	    long sugesstions = 0;
	    for(int i=0;i<n;i++){
	    	for(int j=i+1;j<n;j++){
	    		if(!a[i].get(j) && a[i].intersects(a[j]))
	    			sugesstions++;
	    	}
	    }
	    
	    w.println(2*sugesstions);
	    w.close();
	        
	}
	
	public static int ip(String s){
		return Integer.parseInt(s);
	}
}
