// Name: Ching-Hau
// USC NetID: chinghau
// CS 455 PA4
// Spring 2022

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


/**
   A dictionary of all anagram sets. 
   Note: the processing is case-sensitive; so if the dictionary has all lower
   case words, you will likely want any string you test to have all lower case
   letters too, and likewise if the dictionary words are all upper case.
 */
public class AnagramDictionary {
   
   /**
      Representation invariant:
      - anagramDictionary can not be null
   */

   //anagramDictionary is a hash map that the key is the string in alphabetical order, and its value are all the 
   HashMap<String, ArrayList<String>> anagramDictionary;

   /**
      Create an anagram dictionary from the list of words given in the file
      indicated by fileName.  
      @param fileName  the name of the file to read from
      @throws FileNotFoundException  if the file is not found
      @throws IllegalDictionaryException  if the dictionary has any duplicate words
    */
   public AnagramDictionary(String fileName) throws FileNotFoundException,
                                                    IllegalDictionaryException {
      this.anagramDictionary = new HashMap<>();
      HashMap<String, Integer> duplicateCheckMap = new HashMap<>();
      Scanner inFile = new Scanner(new File(fileName));
      while(inFile.hasNext()) {
         String currenString = inFile.next();
         String sortString = sortString(currenString);
         if(duplicateCheckMap.containsKey(currenString)) {
            throw new IllegalDictionaryException(currenString);
         }
         else {
            duplicateCheckMap.put(currenString, 1);
         }
         if(this.anagramDictionary.containsKey(sortString)) {
            this.anagramDictionary.get(sortString).add(currenString);
         }
         else {
            ArrayList<String> initialAnagram = new ArrayList<>();
            initialAnagram.add(currenString);
            this.anagramDictionary.put(sortString, initialAnagram);
         }
      } 
   }

   /**
    * Ths method is to return a new string sorted in alphabetical order of input string.
    * @param string the string which needs to be sorted
    * @return a new string sorted in alphabetical order
    */
   public String sortString(String string) {
      char[] tempArray = string.toCharArray();
      Arrays.sort(tempArray);
      return new String(tempArray);
   }

   /**
      Get all anagrams of the given string. This method is case-sensitive.
      E.g. "CARE" and "race" would not be recognized as anagrams.
      @param s string to process
      @return a list of the anagrams of s
    */
   public ArrayList<String> getAnagramsOf(String string) {
      String sortString = sortString(string);
      return (this.anagramDictionary.containsKey(sortString)) ? this.anagramDictionary.get(sortString) : new ArrayList<String>();
   }
}
