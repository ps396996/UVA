/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.BigInteger; 

class Main {
    public static void functioncall(PriorityQueue<BigInteger> firsthalf, PriorityQueue<BigInteger> secondhalf,int count,BigInteger b){
        if(firsthalf.size() != 0 && (firsthalf.peek()).compareTo(b) == -1){
            secondhalf.add(b);
        }
        else{
            firsthalf.add(b);
        }
        while(secondhalf.size() > count/2 ) {
            firsthalf.add(secondhalf.poll());
        }
        while(secondhalf.size() < count/2 ) {
            secondhalf.add(firsthalf.poll());
        }
    }
    
	public static void main (String[] args) throws Exception {
		Scanner sc = new Scanner((System.in));
		BigInteger arr = new BigInteger("0");
		
		PriorityQueue<BigInteger> firsthalf = new PriorityQueue<BigInteger>(Collections.reverseOrder());
		PriorityQueue<BigInteger> secondhalf = new PriorityQueue<BigInteger>();
		int count = 0;
			
		while(sc.hasNextBigInteger()){
		    count++;
		    arr = sc.nextBigInteger();
		    if(count%2 == 1){
		        functioncall(firsthalf,secondhalf,count,arr);
		        System.out.println(firsthalf.peek());
		    }
		    else{
		        functioncall(firsthalf,secondhalf,count,arr);
		        System.out.println((firsthalf.peek().add(secondhalf.peek())).divide(new BigInteger("2")));
		    }
		}
	}
}
