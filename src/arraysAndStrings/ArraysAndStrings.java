package arraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class ArraysAndStrings {

  public static void main(String[] args) {
    System.out.println("hello wodrld");
    

  }

  public static boolean isUniqueA(String s) {
	  //with additional data structures
	  HashMap<Character, Character> uniqueChars = new HashMap<>();
	  for(char c : s.toCharArray()) {
		  if(uniqueChars.containsKey(c)) {
			  return false;
		  }
		  uniqueChars.put(c, c);
	  }
	  return true;
  }
  
  public static boolean isUniqueB(String s) {
//	  without additional data structures
	  for(int i = 0; i < s.length(); i++) {
		  if(s.lastIndexOf(s.charAt(i), s.length() - 1) != i) {
			  return false;
		  }
	  }
	  return true;
  }
  
  public static boolean isPermutation(String s, String t) {
	  char[] sArray = s.toCharArray();
	  char[] tArray = t.toCharArray();
	  Arrays.sort(sArray);
	  Arrays.sort(tArray);
	  return Arrays.equals(sArray,tArray);
  }
  
  public static String URLify(String s) {
	  StringBuilder tempString = new StringBuilder();
	  for(char c : s.toCharArray()) {
		  if(c == ' ') {
			  tempString.append("%20");
		  } else {
			  tempString.append(c);
		  }
	  }
	  return tempString.toString();
  }
  
  public static boolean isPalindromePermutation(String s) {
	  //if even string length:
	  	//must have even count of each char
	  //if odd length:
	  	//must have only one odd count of a char

	  HashMap<Character, Integer> charCounts = new HashMap<>();
	  
	  for(char c : s.toCharArray()) {
		  if(charCounts.containsKey(c)) {
			  charCounts.replace(c, charCounts.get(c) + 1);
		  } else {
			  charCounts.put(c, 1);
		  }
	  }
	  
	  boolean isOdd = (s.length() % 2 != 0);
	  int oddCounts = 0;
	  int evenCounts = 0;
	  
	  for(Entry<Character, Integer> e : charCounts.entrySet()) {
		  if(e.getValue() % 2 == 0) {
			  evenCounts++;
		  } else {
			  oddCounts++;
		  }
	  }

	  if(isOdd) {
		  return (oddCounts == 1);
	  } else {
		  return (oddCounts == 0);
	  }
  }
  
  public static boolean isOneAway(String s, String t) {
	  int sLength = s.length();
	  int tLength = t.length();
	  String longestString = s;
	  String shortestString = t;
	  int difference = sLength - tLength;
	  
	  if(difference > 1 || difference < -1) {
		  return false;
	  }
	  if(difference > 0) {
		  longestString = s;
		  shortestString = t;
	  } else if(difference < 0) {
		  longestString = t;
		  shortestString = s;
	  }
	  
	  for(int i = 0; i < longestString.length(); i++) {
		  StringBuilder longTemp = new StringBuilder(longestString);
		  StringBuilder shortTemp = new StringBuilder(shortestString);
		  if(difference == 0) {
			  if(sLength == 1) {
				  return true;
			  }
			  char removedLong = longTemp.charAt(i);
			  char removedShort = shortTemp.charAt(i);
			  
			  StringBuilder newLong = longTemp.deleteCharAt(i);
			  StringBuilder newShort = shortTemp.deleteCharAt(i);

			  if(newLong.toString().equals(newShort.toString())) {
				  return true;
			  } else {
				  longTemp.insert(i, removedLong);
				  shortTemp.insert(i, removedShort);
			  }
		  } else {
			  char removedTemp = longTemp.charAt(i);
			  if(longTemp.deleteCharAt(i).toString().equals(shortestString)) {
				  return true;
			  } else {
				  longTemp.insert(i, removedTemp);
			  }
		  }
	  }
	  
	    return false;
	  }
  
  public static String compressString(String s) {
	  StringBuilder compressedString = new StringBuilder();
	  int currentCount = 1;
	  for(int i = 0; i < s.length(); i++) {
		  if(i == s.length() - 1) {
			  compressedString.append(s.charAt(i) + "" + currentCount);
			  break;
		  }
		  if(s.charAt(i) == s.charAt(i + 1)) {
			  currentCount++;
		  } else {
			  compressedString.append(s.charAt(i) + "" + currentCount);
			  currentCount = 1;
		  }
	  }

	  if(compressedString.toString().length() < 2 || s.length() <= compressedString.toString().length()) {
		  return s;
	  }

	  return compressedString.toString();
	  }
  
  public static int[][] rotateImage (int[][] image) {
	  if(image.length == 0 || image.length == 1) {
		  return image;
	  }
	  int imageLength = image.length;
	  for(int i = 0; i < imageLength; i++) {
		  for(int j = i; j < imageLength - 1; j++) {

			  int temp = image[i][j]; //store top left corner
			  image[i][j] = image[image.length - 1 - j][i]; //set top left corner to bottom left corner
			  image[image.length - 1 - j][i] = image[image.length - 1 - i][image.length - 1 - j]; //set bottom left corner to bottom right corner
			  image[image.length - 1 - i][image.length - 1 - j] = image[j][image.length - 1 - i]; //set bottom right corner to top right corner
			  image[j][image.length - 1 - i] = temp;
		  }
		  imageLength--;
	  }
	    return image;
	    }
  
  public static int[][] zeroMatrix (int[][] image) {
	  int[][] newArray = new int[image.length][image[0].length];
	  for(int j = 0; j < image.length; j++) {
		  newArray[j] = Arrays.copyOf(image[j], image[j].length);
	  }
	  
	  for(int i = 0; i < newArray.length; i++) {
		  for(int j = 0; j < newArray[0].length; j++) {
//			  System.out.println("original value: " + image[i][j]);
			  if(image[i][j] == 0) {
//				  System.out.println("replacing column " + j);
				  for(int ii = 0; ii < newArray.length; ii++) {
//					  System.out.println("replacing value: " + newArray[ii][j]);
					  newArray[ii][j] = 0;
				  }
//				  System.out.println("replacing row " + i);
				  for(int jj = 0; jj < newArray[0].length; jj++) {
//					  System.out.println("replacing value: " + newArray[i][jj]);
					  newArray[i][jj] = 0;
				  }
			  }
		  }
	  }
	    return newArray;
	  }
  
  public static boolean isRotation(String s, String t) {
	  if(s.equals(t)) {
		  return true;
	  }
	  int temp = 0;
	  for(int i = 0; i < s.length(); i++) {
		  if(!s.contains(t.substring(0, i + 1))) {
			  temp = i;
			  break;
		  }
	  }
	  if(temp == 0) {
		  return false;
	  }
	  return(s.contains(t.substring(temp, t.length())));
	  }
  
}
