package arraysAndStrings;

import java.util.Scanner;

//Implement and algo to determine if a string has all unique characters without using additional data structures.

public class isUnique {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		String S=sc.nextLine();
		System.out.print(isUnique(S));
	}
	
	public static boolean isUnique(String s) {
		if(s.length()>128) {
			return false;
		}
		boolean[] char_set=new boolean[128];
		for(int i=0;i<s.length();i++) {
			int value=s.charAt(i);
			if(char_set[value]) {
				return false;
			}
			char_set[value]=true;
		}
		return true;
	}
	

	// if we know given string contains only lowercase letters a-z we can write the below code.
	public static boolean lowerCaseIsUnique(String s) {
		int checker=0;
		for(int i=0;i<s.length();i++) {
			int value=s.charAt(i)-'a';
			char ch=s.charAt(i);
			if((checker & (1<<value)) > 0) {
				return false;
			}
			checker|=(1<<value);
		}
		return true;
	}
	
}
