package task2;

import java.util.*;
import java.util.stream.*;

public class word_counter {
	
	private static String[] getWords(String input) {
		// Use regex to split the string into an array of words
		return input.split("[\\s\\p{Punct}]+");
	}
	private static int countWords(String[]words) {
		return words.length;
	}
	private static int countWordsIgnoring(String []words,String[]ignoreWords) {
		//Convert both arrays to lowercase for case-insensitive comparison
		List<String>ignoreWordsList=Arrays.asList(ignoreWords).stream().map(String::toLowerCase).collect(Collectors.toList());
		//Count words excluding common words
		return (int) Arrays.stream(words).filter(word -> !ignoreWordsList.contains(word.toLowerCase())).count();
	}
	private static Map<String, Integer> getWordFrequency(String[]words){
	
		Map<String,Integer>wordFrequency=new HashMap<>();
		// Count the frequency of each word
		Arrays.stream(words).forEach(word -> wordFrequency.put(word, wordFrequency.getOrDefault(word, 0)+1));
		return wordFrequency;
	}
	
	public static void main(String[]args) {
	
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter text or provide a file path to count words : ");
		String input=sc.nextLine();
		String []words=getWords(input);
		int wordCount=countWords(words);
		System.out.println("Total number of words : "+ wordCount);
		System.out.println("Enter common words to ignore (comma-separated) : ");
		String ignoreWordsInput=sc.nextLine();
		String []ignoreWords=ignoreWordsInput.split(",");
		wordCount=countWordsIgnoring(words, ignoreWords);
		System.out.println("Total number of words (excluding common words) : "+wordCount);
		Map<String,Integer>wordFrequency=getWordFrequency(words);
		System.out.println("Number of unique words : "+wordFrequency.size());
		wordFrequency.forEach((word,count) -> System.out.println(word+" : "+count));
		sc.close();
		
	}
	
}
