package com.example;

import java.io.IOException;
import java.util.*;

public class CountFruits {

	private static void solution(String[] words, Boolean usePrintOptionOne) {

		// validate null pointer
		if(words == null) return;

		// put all the alphabets in a map - 0(N)
		Map<Character, List<String>> alphabet = new HashMap<>();
		for (char ch = 'A'; ch <= 'Z'; ++ch)
			alphabet.put(ch, new ArrayList<>());

		// for each of the words in array, update map value - 0(N)
		for(String word: words) {
			Character firstChar = word.charAt(0);
			List<String> list = alphabet.get(firstChar);
			list.add(word);
			alphabet.put(firstChar, list);
		}

		// output records per line
		if (usePrintOptionOne)
			printOptionOne(alphabet);
		else
			printOptionTwo(alphabet);

	}

	private static void printOptionOne(Map<Character, List<String>> map) {
		for (Map.Entry<Character, List<String>> set : map.entrySet())
			System.out.println(set.getKey() + ": " + set.getValue().size());
	}

	private static void printOptionTwo(Map<Character, List<String>> map) {
		for (Map.Entry<Character, List<String>> set : map.entrySet()) {

			// group unique strings in hash map and count occurrence
			Map<String, Integer> groupedWords = new HashMap<>();
			for(String word: set.getValue()) {
				if(groupedWords.containsKey(word))
					groupedWords.put(word, groupedWords.get(word) + 1);
				else
					groupedWords.put(word, 1);
			}

			System.out.println(set.getKey() + ": " + set.getValue().size());
			for (Map.Entry<String, Integer> printSet : groupedWords.entrySet())
				System.out.println(printSet.getValue() + " " + printSet.getKey());
			System.out.println(" ");

		}
	}

	private static String[] fetchFromAPI() {
		String[] fruits = new String[0];
		try {
			// call api
			fruits = new String[]{"Strawberry", "Mango", "Cherry", "Lime", "Guava", "Papaya", "Nectarine", "Pineapple", "Lemon", "Plum", "Tangerine", "Fig", "Blueberry", "Grape", "Jackfruit", "Pomegranate", "Apple", "Pear", "Orange", "Watermelon", "Raspberry", "Banana"};
		} catch (IOException ex) {
			//handle network error here
		} catch (ServerErrorResponseException ex) {
			//handle server error response here
		} catch (Exception ex) {
			//handle RuntimeException and others here
		}

		return fruits;
	}

	public static void main(String[] args) {
		String[] fruits = {"Strawberry", "Mango", "Cherry", "Lime", "Guava", "Papaya", "Nectarine", "Pineapple", "Lemon", "Plum", "Tangerine", "Fig", "Blueberry", "Grape", "Jackfruit", "Pomegranate", "Apple", "Pear", "Orange", "Watermelon", "Raspberry", "Banana"};
		solution(fruits, true);
	}
}

