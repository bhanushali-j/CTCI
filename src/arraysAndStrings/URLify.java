package arraysAndStrings;

import java.util.Scanner;

/*Write a method to replace all the spaces in a string with ‘%20’. You may assume that the string has sufficient
space at the end to hold the additional characters, and that you are given the “true” length of the string.
*/

/*Input: "Mr John Smith", 13
Output: Mr%20John%20Smith

Input: "Mr John Smith   ", 13
Output: Mr%20John%20Smith*/


public class URLify
{
	public static void main(String args[]) 
	{
		Scanner sc=new Scanner(System.in);
		String S=sc.nextLine();
		int trueLen=sc.nextInt();
		System.out.print(URLify(S,trueLen));
	}
	public static String URLify(String s,int trueLen) {
		
		//count the spaces in the String to simply calculate the length of new required String
		char[] charArr=s.toCharArray();
		int counter=0;
		int finalLength=0;
		for(int i=0;i<trueLen;i++) {
			if(charArr[i]==' ') {
				counter++;
			}
		}
		
		/*
		 * Space is replaced by %20 which is 3 characters but we are multiplying the
		 * counter by 2 because space is also included in trueLen
		 */
		finalLength=trueLen+(2*counter);
		
		//Creating new empty char of desired length of new String
		char[] URLifyarr=new char[finalLength];
		for(int i=trueLen-1;i>=0;i--) {
			if(charArr[i]==' ') {
				URLifyarr[finalLength-1]='0';
				URLifyarr[finalLength-2]='2';
				URLifyarr[finalLength-3]='%';
				
				finalLength-=3;
			}
			else{
				URLifyarr[finalLength-1]=charArr[i];
				finalLength--;
			}
		}
		
		return charArr.toString();
	}
}
