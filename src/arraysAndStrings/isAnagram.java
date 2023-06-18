package arraysAndStrings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Find if one string is a permutation or another or not. i.e god and dog are anagrams.

public class isAnagram {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		String S=sc.nextLine();
		String S1=sc.nextLine();
		System.out.print(isAnagram(S,S1));
	}
	
	
	//Solution I derived
	public static boolean isAnagram(String a,String b)
    {
        
       if(a.length()!=b.length()){
           return false;
       }
       
        Map<Character,Integer> hm=new HashMap<>();
       
       for(int i=0; i<a.length();i++){
           char ch=a.charAt(i);
           if(hm.containsKey(ch)){
               int frequency=hm.get(ch);
               frequency++;
               hm.put(ch,frequency);
           }
           else{
               hm.put(ch,1);
           }
       }
       
       for(int i=0;i<b.length();i++){
           char ch=b.charAt(i);
           if(hm.containsKey(ch)){
               int frequency=hm.get(ch);
               if(frequency<0){
                   return false;
               }
               else{
//            	   frequency++;
                   hm.put(ch,--frequency);
               }
           }else {
        	   return false;
           }
           
       }
       return true;
    }
	
	//More optimized and smaller code
	public static boolean isAnagramSmall(String a,String b)
    {
        
       if(a.length()!=b.length()){
           return false;
       }
       
       int[] arr=new int[256];
       
       for(int i=0; i<a.length();i++){
           arr[(int)a.charAt(i)]++;
           arr[(int)b.charAt(i)]--;
       }
       
       for(int i=0;i<arr.length;i++) 
       {
    	   if(arr[i]!=0) {
    		   return false; 
    	   }
       }
       return true;
    }
}
