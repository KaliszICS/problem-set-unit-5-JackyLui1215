/**

        * File: Problem Set 5

        * Author: Jacky lui

        * Date Created: May 12, 2026

        * Date Last Modified: May 17, 2026

        */

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
public class ProblemSet {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the Text Analyzer! \n");
		System.out.print("Please enter a sentence or paragraph: ");
		String userInput = scanner.nextLine();

		if (userInput.isBlank()) { //ensures input is not blank
			System.out.println("No valid text was detected.");
			scanner.close();
			return;
		}

		String original = userInput;
		userInput = userInput.replaceAll("[,!.?;:']", "").toLowerCase(); //removes all puntuation and makes all characters lowercase
		String[] unfilteredWords = userInput.split(" "); //converts to Array
		ArrayList<String> filteredWords = new ArrayList<String>();

		for (int i = 0; i < unfilteredWords.length; i ++) { //creates an filteredWordsayList of sentence or paragraph
			if (!unfilteredWords[i].isBlank()) {
				String word = unfilteredWords[i];
				if (!(word.equals("a") || word.equals("is") || word.equals("an") || word.equals("the") || word.equals("and"))) {
					filteredWords.add(unfilteredWords[i]);
				}
			}
		}

		if (filteredWords.isEmpty()) { //ensures input is not blank
			System.out.println("Total characters: " + original.length());
			System.out.println("Total words: " + unfilteredWords.length);
			System.out.println("Word was filtered out.");
			scanner.close();
			return;
		}

		//declaring important variables
		int totalCharacters = original.length();
		int totalWords = unfilteredWords.length;
		int sentences = sentenceCounter(original);
		int totalVowels = vowelCounter(unfilteredWords);
		int totalSpaces = spaceCounter(original);
		int uniqueWords = unique(filteredWords).size();
		Double averageLength = averageLength(unfilteredWords);
		String longestWord = longestWord(filteredWords).toString().replace("[", "").replace("]", "");
		String shortestWord = shortestWord(filteredWords).toString().replace("[", "").replace("]", "");
		
		//OUTPUT
		System.out.println("\nTotal Characters: " + totalCharacters);
		System.out.println("Total Words: " + totalWords);
		System.out.println("Total Vowels: " + totalVowels);
		System.out.println("Total Spaces: " + totalSpaces);
		System.out.println("\nWord Frequency: \n");
		frequencies(filteredWords); //prints out the amount of time each unique word occurs

		System.out.println("\nLongest Word: " + longestWord);
		System.out.println("Shortest Word: " + shortestWord);
		System.out.println("Average Word Length: " + averageLength);
		System.out.println("Number of sentences: " + sentences);
		System.out.println("Unique Words: " + uniqueWords);

		scanner.close();
	}

	public static int sentenceCounter(String userInput) { //determines sentences by looking for ".", "!", "?"
		int sentences = 0;
		for (int i = 0; i < userInput.length(); i++) {
			char c = userInput.charAt(i);
			if (c == '.' || c == '!' || c == '?') {
				sentences++;
			}
		}
		return sentences;
	}

	public static int vowelCounter(String[] userInput) {
		int totalVowels = 0;
		for (int i = 0; i < userInput.length; i++) { //loops through words
		String word = userInput[i];
		if (word.length() != 0) { 
			for (int b = 0; b < word.length(); b++) { //loops through characters
			char c = word.charAt(b);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') { //Checks for all vowels except y
				totalVowels++;
			}
			if(c == 'y' && b != 0) { //Special case for y
				totalVowels++;
			}
		}
		}
		}
		return totalVowels;
	}

	public static int spaceCounter(String userInput) {
		int totalSpaces = 0;
		for (int i = 0; i < userInput.length(); i++) {
			if(userInput.charAt(i) == ' ') { //counts the amount of spaces present
				totalSpaces++;
			}
		}
		return totalSpaces;
	}

	public static HashMap<String, Integer> unique(ArrayList<String> filteredWords) { //creates a HashMap with the key being the word and value being the frequency
		HashMap<String, Integer> uniquewords = new HashMap<String, Integer>();
		for (int i = 0; i < filteredWords.size(); i++) {
			if (uniquewords.containsKey(filteredWords.get(i))) {
				uniquewords.put(filteredWords.get(i), uniquewords.get(filteredWords.get(i)) + 1); //Adds one to the frequency if the same word is present
			}
			else {
				uniquewords.put(filteredWords.get(i), 1); //Adds to the unique words if not present
			}
		}
		return uniquewords;
	}

	public static void frequencies(ArrayList<String> filteredWords) { //Outputs the freqeuncies list
		HashMap<String, Integer> frequencies = unique(filteredWords);
		ArrayList<String> isSeen = new ArrayList<String>(); //temporary storage of words used
		int count = 0;
		for (int i = 0; i < filteredWords.size(); i++) {
			String currentWord = filteredWords.get(i);
			if (!isSeen.contains(currentWord)) {
				count = frequencies.get(currentWord);
				isSeen.add(currentWord);
				System.out.println(currentWord + " - " + count); //outputs word freuency

			}
		}
	}

	public static double averageLength(String[] unfilteredWords) { //Calculates sum of all words
		double averageLength = 0;
		for (int i = 0; i < unfilteredWords.length; i++) {
			averageLength += unfilteredWords[i].length();
		}
		return averageLength / unfilteredWords.length;
	}

	public static ArrayList<String> longestWord (ArrayList<String> filteredWords) { //determines longest word
		int maxLength = filteredWords.get(0).length();
		for (int i = 0; i < filteredWords.size(); i ++) { //compares all lengths of all words to determine largest value
			String word = filteredWords.get(i);
			if (maxLength < word.length()) {
				maxLength = word.length();
			}
		}

		ArrayList<String> longest = new ArrayList<String>();
		for (int i = 0; i < filteredWords.size(); i ++) { 
			String word = filteredWords.get(i);
			if (word.length() == maxLength && !longest.contains(word)) { //finds all words with the longest length
				longest.add(word);
			}
		}
		return longest;
	}

	public static ArrayList<String> shortestWord (ArrayList<String> filteredWords) { //determines shortest word
		int minLength = filteredWords.get(0).length();
		for (int i = 0; i < filteredWords.size(); i ++) { //compares all lengths of all words to determine smallest value
			String word = filteredWords.get(i);
			if (minLength > word.length()) {
				minLength = word.length();
			}
		}

		ArrayList<String> shortest = new ArrayList<String>();
		for (int i = 0; i < filteredWords.size(); i ++) { 
			String word = filteredWords.get(i);
			if(word.length() == minLength && !shortest.contains(word)) { //finds all words with the smallest length
				shortest.add(word);
			}
		}
		return shortest;
	}
}