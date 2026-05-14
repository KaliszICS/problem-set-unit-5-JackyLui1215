import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
public class ProblemSet {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the Text Analyzer! \n");
		System.out.print("Please eneter a sentence or paragraph: ");
		String sentenceOrParagraph = scanner.nextLine();
		
		//Determines amount of sentences present
		int sentences = 0;
		for (int i = 0; i < sentenceOrParagraph.length(); i++) {
			char c = sentenceOrParagraph.charAt(i);
			if (c == '.' || c == '!' || c == '?') {
				sentences++;
			}
		}

		String original = sentenceOrParagraph;
		sentenceOrParagraph = sentenceOrParagraph.replaceAll("[,!.?;:']", "").toLowerCase(); //removes all puntuation and makes all characters lowercase
		String[] unfiltered = sentenceOrParagraph.split(" ");
		ArrayList<String> filtered = new ArrayList<String>();
		
		for (int i = 0; i < unfiltered.length; i ++) { //creates an filteredayList of sentence or paragraph
			if (!unfiltered[i].isBlank()) {
				String word = unfiltered[i];
				if (!(word.equals("a") || word.equals("is") || word.equals("an") || word.equals("the"))) {
					filtered.add(unfiltered[i]);
				}
		}
		}

		if (filtered.size() == 0 || unfiltered.length == 0) {
			System.out.println("No valid word was detected.");
			scanner.close();
			return;
		}

		//declaring important variables
		int totalCharacters = original.length();
		int totalWords = unfiltered.length;
		int totalVowels = 0;
		int totalSpaces = 0;
		int uniqueWords = 0;

		for (int i = 0; i < sentenceOrParagraph.length(); i++) {
			char c = sentenceOrParagraph.charAt(i);
			if (isVowel(c)) { //uses isVowel method
				totalVowels++;
			}
			if(c == 'y' && i != 0 ) {
				totalVowels++;
			}
			if(c == ' ') { //counts the amount of spaces present
				totalSpaces++;
			}
		}	

		//delcaring important variables
		Double averageLength = 0.0;
		int wordLong = filtered.get(0).length();
		int wordShort = filtered.get(0).length();
		uniqueWords = unique(filtered).size();

		for (int i = 0; i < filtered.size(); i ++) { //compares all lengths of all words to determine smallest value
			if (wordLong < filtered.get(i).length()) {
				wordLong = filtered.get(i).length();
			}
			if (wordShort > filtered.get(i).length()) {
				wordShort = filtered.get(i).length();
			}
		}

		ArrayList<String> longest = new ArrayList<String>();
		ArrayList<String> shortest = new ArrayList<String>();
		for (int i = 0; i < filtered.size(); i ++) { //finds all words with the highest length
			if (filtered.get(i).length() == wordLong) {
				longest.add(filtered.get(i));
			}
			if(filtered.get(i).length() == wordShort) { //finds all words with the lowest length
				shortest.add(filtered.get(i));
			}
		}

		for (int i = 0; i < unfiltered.length; i++) { //sum of all words
			averageLength += unfiltered[i].length();
		}
		averageLength = averageLength / totalWords;
		
		//OUTPUT
		System.out.println("\nTotal Characters: " + totalCharacters);
		System.out.println("Total Words: " + totalWords);
		System.out.println("Total Vowels: " + totalVowels);
		System.out.println("Total Spaces: " + totalSpaces);
		System.out.println("\nWord Frequency: \n");	
		frequencies(filtered); //prints out the amount of time each unique word occurs
	
		System.out.println("\nLongest Word: " + longest.toString().replace("[", "").replace("]", ""));
		System.out.println("Shortest Word: " + shortest.toString().replace("[", "").replace("]", ""));
		System.out.println("Average Word Length: " + averageLength);
		System.out.println("Number of sentences: " + sentences);
		System.out.println("Unique Words: " + uniqueWords);
	
		scanner.close();
	}

	public static boolean isVowel(char character) {
		if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u') { //Checks for all vowels except y
			return true;
		}
		else {
			return false;
		}
	}

	public static HashMap<String, Integer> unique(ArrayList<String> filtered) {
		HashMap<String, Integer> uniquewords = new HashMap<String, Integer>();
		for (int i = 0; i < filtered.size(); i++) {
			if (uniquewords.containsKey(filtered.get(i))) {
				uniquewords.put(filtered.get(i), uniquewords.get(filtered.get(i)) + 1); //Adds one to the frequency if the same word is present
			}
			else {
				uniquewords.put(filtered.get(i), 1); //Adds to the unique words if not present
			}
		}
		return uniquewords;
	}

	public static void frequencies(ArrayList<String> filtered) {
		HashMap<String, Integer> frequencies = unique(filtered);
		ArrayDeque<String> isSeen = new ArrayDeque<String>(); //temporaroy storage of words used
		int count = 0;
		for (int i = 0; i < filtered.size(); i++) {
			String currentWord = filtered.get(i);
			if (!isSeen.contains(currentWord)) {
				count = frequencies.get(currentWord);
				isSeen.add(currentWord);
				System.out.println(currentWord + " - " + count); //outputs word freuency
				
			}
	}
	}

}
