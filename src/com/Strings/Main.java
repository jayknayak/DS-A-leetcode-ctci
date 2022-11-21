package com.Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Strings strings = new Strings();
		
//Reverse String		
//		char [] s = {'h','e','l','l','o'};
//		strings.reverseString(s);
		
//Reverse Integer
//		System.out.println("Reversed Integer:"+strings.reverseInteger(-123));
		
//Find first unique character in a String and return its index
//		System.out.println("First unique character in the string: "+strings.firstUniqChar("lleetTcode"));
		
//Is String unique
//		System.out.println("Is String unique?: "+strings.isUnique("jab"));
		
//Is valid anagram
//		System.out.println("Is valid anagram? : "+strings.isValidAnagram("anagram", "naagram"));

//Is Valid Palindrome
//		System.out.println("Is Palindrome valid?: "+strings.isValidPalindrome("A man, a plan, a canal: Panama"));
		
//String to Integer (Atoi)
//		System.out.println("Integer value of the given string: "+strings.aToi("22"));
		
//Implement strStr()
//	    System.out.println("Index of the first occurence of needle: "+strings.strStr("hello","ll"));
		
//Count and Say
//		System.out.println("'Count and Say' output of the following number: "+strings.countAndSay(5));
		
//Longest common prefix
//		String[] strs = {"a"};
//		System.out.println("Longest common prefix is: "+strings.longestCommonPrefix(strs));
		
//URLify - replace white spaces
//		char[] str= {'M',' ','R',' ','J','O','h','n',' ','S','M','I','T','H',' ',' ',' ',' ',' ',' '};
//		strings.replaceSpaces(str, 14);
		
//Is Permutation of Palindrome
//		System.out.println("Is valid permutation of palindrome?: "+strings.isPermutationOfPalindrome("Tacta coa"));
		
//String compression
	//	System.out.println("Compressed String: "+strings.compressString("aaabbccccddaaaaa"));
//		char[]chars={'a','b','b'};
//		System.out.println("Compressed String: "+strings.compress(chars));
		
//String Rotation
//		System.out.println("Is String rotated of String 1?: "+strings.isRotated("waterbottle","erbottlewat"));
		
//Longest Password
//		System.out.println("Length of longest password: "+strings.longestPassword("1$"));
		
//Repeated Strings
//		System.out.println("Count of character a "+strings.repeatedString("baa", 3));
		Main main = new Main();
		System.out.println(""+main.solution("AAABCDAAAEE",3));
		
		String S="ABDCA";
		int[] X= {2,-1,-4,-3,3};
		int[] Y= {2,-2,4,1,-3};
//		System.out.println(main.solution(S, X, Y));
	}
	 
//	public int solution(String S, int K) {
//		 int shortestLength=0;
//		 int countDistChars=Integer.MAX_VALUE;
//		 
//		 for(int tail=0;tail<S.length();tail+=3) {
//			 HashMap<Character,Integer> map = new HashMap<Character,Integer>();
//			 map.put(S.charAt(tail),tail);
//			 if(map.size()<countDistChars) {
//				 countDistChars=map.size();
//				 S.replace(, "");
//			 }
//		 }
//			int j=0,i=0;
//			int length=S.length();
//			StringBuilder sb = new StringBuilder();
//			while(i<length) {
//				int count=0;
//				while(i<length && S.charAt(i)==S.charAt(j)) {
//					count++;
//					i++;
//				}
//				if(count>9) {
//					sb.append(count);
//					sb.append(S.charAt(j));
//				}
//				else {
//					sb.append(S.charAt(j));
//					if(count>1) {
//						sb.append(count);
//					}
//				}
//				j=i;
//			}
//	        return shortestLength;
//	    }
	
//	public int solution(String S, int[] X, int[] Y) {
//		int maxPoints=0;
//		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
//		int positiveRadiusX=Integer.MAX_VALUE, positiveRadiusY=Integer.MAX_VALUE,negativeRadiusX=Integer.MIN_VALUE, negativeRadiusY=Integer.MIN_VALUE;
//		for(int i=0;i<S.length();i++) {
//			if(!map.containsKey(S.charAt(i))) {
//				map.put(S.charAt(i), i);
//			}
//			else {
//				if(map.containsKey(S.charAt(i))) {
//					if(Math.abs(X[map.get(S.charAt(i))]) == Math.abs(X[i]) && Math.abs(Y[i]) ==Math.abs(Y[map.get(S.charAt(i))])) {
//						map.remove(S.charAt(i));
//					}
//				}
//			}
////			if(map.size()>1 && i>1)
////			{
////				if(Math.abs(X[map.get(S.charAt(i-1))]) < Math.abs(X[i]) && Math.abs(Y[i]) >Math.abs(Y[map.get(S.charAt(i-1))])) {
////					map.remove(S.charAt(i));
////				}
////			}
//		}
//		maxPoints=map.size();
//		int initialX=X[0],initialY=Y[0];
//		if(map.size()==1) {
//			Entry<Character, Integer> entry = map.entrySet().iterator().next();
//			Integer value = entry.getValue();
//			if(Math.abs(X[map.get(S.charAt(value))])>Math.abs(initialX) && Math.abs(Y[map.get(S.charAt(value))])>Math.abs(initialY)) {
//				maxPoints--;
//			}
//		}
//		return maxPoints;
//	}
	
	public static int solution(String S, int k) {
	    int ret = compress(S).length();
	    for (int i = 0; i < S.length() - (k - 1); i++) {
	        String subString = getSubstring(S, i, i + k - 1);
	        ret = Math.min(ret, compress(subString).length());
	    }
	    return ret;
	}

	public static String getSubstring(String S, int begin, int end) {
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < S.length(); i++) {
	        if (i < begin || i > end) {
	            sb.append(S.charAt(i));
	        }
	    }
	    return sb.toString();
	}

	public static String compress(String str) {
	    StringBuilder result = new StringBuilder();
	    int i = 0;
	    int count = 0;
	    while (i < str.length() - 1) {
	        count++;
	        if (str.charAt(i) != str.charAt(i + 1)) {
	            if (count > 1) {
	                result.append(count).append(str.charAt(i));
	            } else {
	                result.append(str.charAt(i));
	            }
	            count = 0;
	        }
	        i++;
	    }
	    result.append(count + 1).append(str.charAt(i));
	    System.out.println(result);
	    return result.toString();
	}
}
