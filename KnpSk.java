/*
https://www.codechef.com/problems/KNPSK
Date: 22/10/2016
*/

import java.util.*;
import java.io.*;
class KnpSk{
    public static void main(String[] args){

       FastReader sc=new FastReader();
       StringBuilder sb=new StringBuilder();
       ArrayList<Long> arr1=new ArrayList<>();
       ArrayList<Long> arr2=new ArrayList<>();
       int n=sc.nextInt();
       long totalweight=0;
       while(n>0){
         
         int w=sc.nextInt();
         long count=sc.nextLong();
         if(w==1){
         arr1.add(count);
         }
         else{
         arr2.add(count);
         }
      totalweight+=w;
       n--;
       }
       Collections.sort(arr1,Collections.reverseOrder());
       Collections.sort(arr2,Collections.reverseOrder());
       
       int i=0;
       int j=0;
       long ans=0;
       int cw=0;
      
       for(int k=1;k<=totalweight;k++){
         long ans1=ans,ans2=ans;
         if(k-cw==1){
           if(i<arr1.size()){
               ans1+=arr1.get(i);
           }
           if(i>=1 && j<arr2.size()){
               ans2=ans2-arr1.get(i-1)+arr2.get(j);
           }
           if(ans1>ans && ans1>=ans2){
             i++;
             cw++;
             ans=ans1;
           }
           else if(ans2>ans){
             j++;
             cw++;
             ans=ans2;
             i--;
           }
         }
         else if(j<arr2.size() ){
           ans=ans+arr2.get(j);
           j++;
           cw+=2;
         }
         
       sb.append(ans+" ");
       }
       
          System.out.println(sb);
       } 
     
}

class FastReader{

    BufferedReader bf;
    StringTokenizer st;
    public FastReader(){
         bf=new BufferedReader(new InputStreamReader(System.in));
    }
    String next(){
     while(st==null || !st.hasMoreElements()){
       try{
         st=new StringTokenizer(bf.readLine());
       }
       catch(IOException e){
          e.printStackTrace();
       }
               }
     return st.nextToken();

    }
    int    nextInt(){
    return Integer.parseInt(next());
    }
    double nextDouble(){
    return Double.parseDouble(next());
    }
    long nextLong(){
    return Long.parseLong(next());
    }
    String nextLine(){
      String str="";
      try{
        str=bf.readLine();
      }catch(IOException e){e.printStackTrace();}
    return str;

    }

}