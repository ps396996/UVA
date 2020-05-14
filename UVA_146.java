/*package whatever //do not write package name here */

import java.io.*;
import java.util.Arrays; 
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;

class Main {
    static String findmyanswer(String s){
        char tempArray[] = s.toCharArray();
        Arrays.sort(tempArray);
        char c;
        String str = "";
        for(int i=0;i<s.length();i++){
            if(s.charAt(0) == tempArray[s.length() - i -1]){
                 str = "" + tempArray[s.length() - i];
                for(int j = 0;j<s.length();j++){
                    if((s.length() - i) == j){
                        continue;
                    }
                    str = str + tempArray[j];
                }
                break;
            }
        }
        return str;
    }
	public static void main (String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String n = reader.readLine();
		while(!n.equals("#")){
		int len = n.length();
		int i=(n.length() - 1);
		String ans = "";
		while(i > 0){
		    if(n.charAt(i) > n.charAt(i-1) ){
		        ans = n.substring(0,i-1);
		        String wer = n.substring(i-1,len);
		        ans = ans + findmyanswer(wer);
		        break;
		    }
		    i--;
		}
		if(i==0){
		    System.out.println("No Successor");
		}
		else{
		System.out.println(ans);
		}
		n = reader.readLine();
		}
	}
}
