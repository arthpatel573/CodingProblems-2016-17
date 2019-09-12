/*
https://www.codechef.com/problems/ANUDTC
Date: 22/09/2016
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class AnuDtc {
    public static void main(String args[]) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            if(360%n == 0 ){
                pw.print("y ");
            } else {
                pw.print("n ");
            }
            if(n<=360) {
                pw.print("y ");
            } else {
                pw.print("n ");
            }
            int c=n*(n+1)/2;
            if(c<=360)
                pw.println("y");
            else
                pw.println("n");
        }
        pw.close();
    }
}
