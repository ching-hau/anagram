// Name: Ching-Hau
// USC NetID: chinghau
// CS 455 PA4
// Spring 2022

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
   A Rack of Scrabble tiles
 */

public class Rack {

   /**
      Representation invariant:
      - racks can not be null
   */
   private ArrayList<String> racks;
   
   /**
    * create racks by input string
    * @param string
    */
   public Rack(String string) {
      this.racks = getAllSubsetsByWord(string);
   }

   /**
    * By finding the unique characters of an input string and the quantities, 
      we can get all subsets of that word. 
    * @param string a target string, which we want to get the subsets
    * @return
    */
   public static ArrayList<String> getAllSubsetsByWord(String string) {
      TreeMap<Character, Integer> tm = new TreeMap<>();
      for(int i = 0; i < string.length(); i ++) {
         char currentChar = string.charAt(i);
         if(tm.containsKey(currentChar)) {
            tm.put(currentChar, tm.get(currentChar) + 1);
         }
         else {
            tm.put(currentChar, 1);
         }
      }
      String unique = "";
      int[] mult = new int[tm.size()];
      int i = 0;
      for(Map.Entry<Character, Integer> entry : tm.entrySet()) {
         mult[i++] = entry.getValue();
         unique += entry.getKey();
      }
      return allSubsets(unique, mult, 0);
   }

   /**
      Finds all subsets of the multiset starting at position k in unique and mult.
      unique and mult describe a multiset such that mult[i] is the multiplicity of the char
           unique.charAt(i).
      PRE: mult.length must be at least as big as unique.length()
           0 <= k <= unique.length()
      @param unique a string of unique letters
      @param mult the multiplicity of each letter from unique.  
      @param k the smallest index of unique and mult to consider.
      @return all subsets of the indicated multiset.  Unlike the multiset in the parameters,
      each subset is represented as a String that can have repeated characters in it.
      @author Claire Bono
    */
   private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
      ArrayList<String> allCombos = new ArrayList<>();
      
      if (k == unique.length()) {  // multiset is empty
         allCombos.add("");
         return allCombos;
      }
      
      // get all subsets of the multiset without the first unique char
      ArrayList<String> restCombos = allSubsets(unique, mult, k+1);
      
      // prepend all possible numbers of the first char (i.e., the one at position k) 
      // to the front of each string in restCombos.  Suppose that char is 'a'...
      
      String firstPart = "";          // in outer loop firstPart takes on the values: "", "a", "aa", ...
      for (int n = 0; n <= mult[k]; n++) {   
         for (int i = 0; i < restCombos.size(); i++) {  // for each of the subsets 
                                                        // we found in the recursive call
            // create and add a new string with n 'a's in front of that subset
            allCombos.add(firstPart + restCombos.get(i));  
         }
         firstPart += unique.charAt(k);  // append another instance of 'a' to the first part
      }
      
      return allCombos;
   }

   /**
    * Getter of racks
    * @return racks, this is an arraylist
    */
   public ArrayList<String> getRacks() {
      return this.racks;
   }
}
