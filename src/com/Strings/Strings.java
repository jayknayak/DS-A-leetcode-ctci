package com.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Strings {
	// Reverse a String given in a character array.
	public void reverseString(char[] s) {
		if (s == null) {
			return;
		}
		char temp;
		int j = s.length;
		for (int i = 0; i < j; i++) {
			temp = s[j - 1];
			s[j - 1] = s[i];
			s[i] = temp;
			j--;
		}
	}

	// Reverse Integer
	public int reverseInteger(int x) {
		// Integer maxValue=Integer.MAX_VALUE;
		// Integer minValue=Integer.MIN_VALUE;
		int a = 0;
		a = a + 1;
		int rev = 0, pop;
		while (x != 0) {
			// popping last element from x
			pop = x % 10;
			x /= 10;

			// checking stack overflow conditions for positive integer
			// Because the final step: rev*=10+pop can cause overflow
			// if rev>Integer.MAX_VALUE/10, adding pop at the back will cause overflow
			// if rev=Integer.MAX_VALUE/10, adding pop>7 at the back will cause overlow
			if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
				return 0;
			// checking stack overflow conditions for negative integer
			if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
				return 0;

			// pushing the last element of x to the back of rev
			rev = rev * 10 + pop;
		}
		return rev;
	}

	// First Unique character in a String
	public int firstUniqueChar(String s) {
		if (s.isEmpty()) {
			return -1;
		}
		char[] charArray = s.toCharArray();
		int repeat = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < charArray.length; i++) {
			if (map.containsKey(charArray[i])) {
				map.put(charArray[i], repeat + 1);
				continue;
			}
			map.put(charArray[i], repeat);
		}
		for (int i = 0; i < charArray.length; i++) {
			if (map.get(charArray[i]) < 1) {
				return i;
			}
		}
		return -1;
	}

	// another approach
	public int firstUniqChar(String s) {
		int[] count = new int[26];
		int n = s.length();
		// build char count bucket : <charIndex, count>
		for (int i = 0; i < n; i++) {
			int index = s.charAt(i) - 'a';
			count[index]++;
		}

		// find the index
		for (int i = 0; i < n; i++) {
			int index = s.charAt(i) - 'a';
			if (count[index] == 1) {
				return i;
			}

		}
		return -1;
	}

	// Is String unique
	public boolean isUnique(String s) {
		// assuming there are 128 characters.
		boolean[] charArray = new boolean[128];
		for (int i = 0; i < s.length(); i++) {
			if (charArray[s.charAt(i)]) {
				return false;
			}
			charArray[s.charAt(i)] = true;
		}
		return true;
	}

	// another approach
	public boolean isUniqueChars(String str) {
		int checker = 0;
		int a = 1 >> 1;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}

	// Valid Anagram
	// public boolean isValidAnagram(String s, String t) {
	// if(s.length()!=t.length()) {
	// return false;
	// }
	// char[]charArray1=s.toCharArray();
	// char[]charArray2=t.toCharArray();
	// Arrays.sort(charArray1);
	// Arrays.sort(charArray2);
	//
	// return Arrays.equals(charArray1, charArray2);
	// }

	// another approach
	// Using hash tables - better O(n), O(1)
	public boolean isValidAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] nums = new int[26];
		char[] charArray1 = s.toCharArray();
		char[] charArray2 = t.toCharArray();
		for (int i = 0; i < charArray1.length; i++) {
			nums[charArray1[i] - 'a']++;
			nums[charArray2[i] - 'a']--;
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				return false;
			}
		}
		return true;
	}

	// Valid Palindrome
	public boolean isValidPalindrome(String s) {
		if (s == null) {
			return true;
		}
		int i = 0, j = s.length() - 1;
		while (i < j) {
			while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
				i++;
			}
			while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
				j--;
			}
			if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	// String to Integer (Atoi)
	public int aToi(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int i = 0, j = s.length(), num = 0, pop = 0;
		char sign = '+';

		while (i < j && s.charAt(i) == ' ') {
			i++;
		}
		if (i < j && (s.charAt(i) == '-' || s.charAt(i) == ('+'))) {
			sign = s.charAt(i);
			i++;
		}
		while (i < j) {
			if (!Character.isDigit(s.charAt(i))) {
				break;
			} else {
				// pop=Character.getNumericValue(s.charAt(i));
				pop = s.charAt(i) - '0';
				if (sign == '-') {
					pop = (-1) * pop;
				}
				if ((num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && pop > 7))) {
					return Integer.MAX_VALUE;
				}
				if ((num < Integer.MIN_VALUE / 10 || (num == Integer.MIN_VALUE / 10 && pop < -8))) {
					return Integer.MIN_VALUE;
				}
				num = num * 10 + pop;
			}
			i++;
		}
		if (num != 0) {
			return num;
		}
		return 0;
	}

	// Implement strStr - String.indexOf()
	public int strStr(String haystack, String needle) {
		if (needle.length() == 0) {
			return 0;
		}
		if (needle.length() > haystack.length()) {
			return -1;
		}
		int index = -1;

		for (int i = 0; i < haystack.length(); i++) {
			if (i + needle.length() > haystack.length()) {
				return -1;
			}
			int temp = i;
			for (int j = 0; j < needle.length(); j++) {
				if (temp < haystack.length() && needle.charAt(j) == haystack.charAt(temp)) {
					if (index == -1 && j == 0) {
						index = i;
					}
					temp++;
				} else {
					index = -1;
					break;
				}
			}
			if (index > -1) {
				return index;
			}
		}
		return index;
	}

	// Count and say
	// public String countAndSay (int n) {
	// String s="1";
	// int length=0;
	// for(int k=1;k<n;k++) {
	// length=s.length();
	// int i=1,j=0;
	// StringBuilder sb = new StringBuilder();
	// int count=1;
	// while(i<length) {
	// if(s.charAt(i)==s.charAt(i-1)) {
	// count++;
	// }
	// else {
	// sb.append(count);
	// sb.append(s.charAt(i-1));
	// count=1;
	// }
	// i++;
	// }
	// sb.append(count);
	// sb.append(s.charAt(i-1));
	// s=sb.toString();
	// }
	// return s;
	// }

	// another approach
	public String countAndSay(int n) {
		String s = "1";
		int length = 0;
		for (int k = 1; k < n; k++) {
			length = s.length();
			int i = 0, j = 0;
			// StringBuilders are faster than String concatenation operations
			StringBuilder sb = new StringBuilder();
			int count = 0;
			while (i < length) {
				while (i < length && s.charAt(i) == s.charAt(j)) {
					count++;
					i++;
				}
				sb.append(count);
				sb.append(s.charAt(j));
				count = 0;
				j = i;
			}
			s = sb.toString();
		}
		return s;
	}

	// Longest common prefix - {"flower","flow","flight"} = "fl"
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		String string1 = strs[0];
		String currentString;
		int prefix = -1;
		for (int i = 1; i < strs.length; i++) {
			currentString = strs[i];
			int j = 0;
			int index = -1;
			while (j < string1.length() && j < currentString.length()) {
				if (string1.charAt(j) == currentString.charAt(j)) {
					index++;
				} else {
					break;
				}
				j++;
			}
			if (index == -1) {
				return "";
			}
			if (prefix == -1 && index > -1) {
				prefix = index;
			}
			if (prefix > -1 && index < prefix) {
				prefix = index;
			}
		}
		if (prefix > -1) {
			return string1.substring(0, prefix + 1);
		}
		return "";
	}

	// URLify - Remove white spaces with %20 - "Mr John Smith " =
	// "Mr%20John%20Smith". Total length of string allows addition of extra
	// characters
	public char[] replaceSpaces(char[] str, int trueLength) {
		if (str == null || str.length == 0) {
			return str;
		}
		int j = str.length - 1;
		int i = trueLength - 1;
		while (i >= 0) {
			if (str[i] == ' ') {
				str[j - 2] = '%';
				str[j - 1] = '2';
				str[j] = '0';
				j = j - 2;
			} else {
				str[j] = str[i];
			}
			i--;
			j--;
		}
		return str;
	}

	// Valid permutation of palindrome - No. of unique characters remain even for
	// even length, and only one unique character is odd for odd length
	public boolean isPermutationOfPalindrome(String str) {
		if (str.length() == 0) {
			return true;
		}
		int[] numChar = new int['z' - 'a' + 2];
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				continue;
			}
			int val = str.charAt(i) - 'a';
			numChar[val]++;
		}
		boolean oddCharFound = false;
		for (int j = 0; j < numChar.length; j++) {
			if (numChar[j] == 1) {
				if (oddCharFound) {
					return false;
				}
				oddCharFound = true;
			} else {
				if (numChar[j] % 2 != 0) {
					return false;
				}
			}
		}
		return true;
	}

	// Compress String: "aabbbccd" = "2a3b2c1d"
	public String compressString(String str) {
		if (str.length() == 0) {
			return str;
		}
		int j = 0, i = 0;
		int length = str.length();
		StringBuilder sb = new StringBuilder();
		while (i < length) {
			int count = 0;
			while (i < length && str.charAt(i) == str.charAt(j)) {
				count++;
				i++;
			}
			sb.append(str.charAt(j));
			sb.append(count);
			j = i;
		}
		if (length > sb.toString().length()) {
			return sb.toString();
		}
		return str;
	}

	// For doing it in-space
	public int compress(char[] chars) {
		if (chars.length == 0) {
			return 0;
		}
		int j = 0, i = 0, k = 0;
		int length = chars.length;
		while (i < length && j < length) {
			int count = 0;
			while (i < length && chars[i] == chars[j]) {
				count++;
				i++;
			}
			chars[k] = chars[j];
			if (count > 1) {
				String num = "" + count;
				chars[++k] = num.toCharArray()[0];
				if (num.toCharArray().length > 1) {
					chars[++k] = ("" + count).toCharArray()[1];
				}
			}
			k++;
			j = i;
		}
		return k;
	}

	// String Rotation: Is second string rotated from first string
	public boolean isRotated(String s1, String s2) {
		if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0 || s1.length() != s2.length()) {
			return false;
		}
		int[] numChar = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			numChar[s1.charAt(i) - 'a']++;
			numChar[s2.charAt(i) - 'a']--;
		}
		for (int j = 0; j < s1.length(); j++) {
			if (numChar[s1.charAt(j) - 'a'] != 0) {
				return false;
			}
		}

		return true;
	}

	// Longest password
	public int longestPassword(String S) {
		int longestWordLength = -1;
		int wordLength = 0, i = 0;
		StringBuilder sb = new StringBuilder();
		while (i < S.length()) {
			sb = new StringBuilder();
			while (i < S.length() && S.charAt(i) != ' ') {
				sb.append(S.charAt(i));
				wordLength++;
				i++;
			}
			if (validPassword(sb.toString()) && wordLength > longestWordLength) {
				longestWordLength = wordLength;
			}
			wordLength = 0;
			i++;
		}
		return longestWordLength;
	}

	private boolean validPassword(String password) {
		int letters = 0, digits = 0;
		boolean isValidPassword = true;
		if (password.length() == 1) {
			if (!Character.isLetterOrDigit(password.charAt(0))) {
				return false;
			}
			if (Character.isLetter(password.charAt(0))) {
				return false;
			}
			if (Character.isDigit(password.charAt(0))) {
				return true;
			}
		}
		for (int i = 0; i < password.length(); i++) {
			if (!Character.isLetterOrDigit(password.charAt(i))) {
				return false;
			}
			if (Character.isLetter(password.charAt(i))) {
				letters++;
			}
			if (Character.isDigit(password.charAt(i))) {
				digits++;
			}
		}
		if (letters % 2 != 0) {
			isValidPassword = false;
		}
		if (digits % 2 == 0) {
			isValidPassword = false;
		}
		return isValidPassword;
	}

	// Repeated String
	public long repeatedString(String s, long n) {
		if (!s.contains("a")) {
			return 0;
		}
		long repeatedCharCount = 0;
		long numOfStrings = n / s.length();
		long rem = n % s.length();
		repeatedCharCount = countAChars(s, rem);
		if (n > s.length()) {
			repeatedCharCount += numOfStrings * countAChars(s, s.length());
		}

		return repeatedCharCount;
	}

	private long countAChars(String s, long numOfStrings) {
		long repeatedCharCount = 0;
		for (int i = 0; i < numOfStrings; i++) {
			if (s.charAt(i) == 'a') {
				repeatedCharCount++;
			}
		}
		return repeatedCharCount;
	}

	// LeetCode:Medium
	// Group Anagrams
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		if (strs.length == 0) {
			return result;
		}
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (int i = 0; i < strs.length; i++) {
			char[] c = strs[i].toCharArray();
			Arrays.sort(c);
			String key = String.valueOf(c);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<String>());
			}
			map.get(key).add(strs[i]);
		}
		result.addAll(map.values());
		return result;
	}

	// Longest Substring w/o repeating characters
	public int longestSubstring(String s) {
		HashSet<Character> set = new HashSet<Character>();
		int j = 0, i = 0;
		int length = 0;
		int n = s.length();
		while (i < n && j < n) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j));
				j++;
				length = Math.max(length, j - i);
			} else {
				set.remove(s.charAt(i));
				i++;
			}
		}
		return length;
	}

	// Longest Common Subsequence
	public int longestCommonSubsequence(String a, String b) {
		int m = a.length(), n = b.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		return dp[m][n];
	}

	// Longest Palindromic Substring
	public String longestPalindrome(String s) {
		if (s.length() == 1) {
			return s;
		}
		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length(); i++) {
			String tmp1 = helper(s, i, i);
			String tmp2 = helper(s, i, i + 1);
			String tmp = tmp1.length() > tmp2.length() ? tmp1 : tmp2;
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
		return longest;
	}

	private String helper(String s, int start, int end) {
		while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
		}
		return s.substring(start + 1, end);
	}

}
