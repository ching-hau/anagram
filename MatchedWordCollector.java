// Name: Ching-Hau
// USC NetID: chinghau
// CS 455 PA4
// Spring 2022

import java.util.ArrayList;
import java.util.Collections;

public class MatchedWordCollector {
   /**
      Representation invariant:
      - dictionary can not be null
   */

   private AnagramDictionary dictionary;
   // private String currentWord;
   private ArrayList<MatchedWordScore> matchedWordColector;

   public MatchedWordCollector(AnagramDictionary dictionary, String currentWord) {
      this.dictionary = dictionary;
      // this.currentWord = currentWord;
      this.matchedWordColector = getMatchedWord(currentWord);
   }
   public ArrayList<MatchedWordScore> getMatchedWord(String currentWord) {
      ArrayList<MatchedWordScore> matchedWords = new ArrayList<>();
      Rack racks = new Rack(currentWord);
      ScoreTable scoreTable = new ScoreTable();
      ArrayList<String> subSetsOfWord = racks.getRacks();
      for(String curWord: subSetsOfWord) {
         ArrayList<String> anagrams = dictionary.getAnagramsOf(curWord);
         if( anagrams.size() > 0) { 
            for(int i = 0; i < anagrams.size(); i ++) {
               int scoreOfWord = scoreTable.getWordScore(anagrams.get(i));
               MatchedWordScore matchedWord = new MatchedWordScore(scoreOfWord, anagrams.get(i));
               matchedWords.add(matchedWord);
            }
         }
      }
      Collections.sort(matchedWords);

      return matchedWords;
   }
   public void printMatchedWordWithScore() {
      for(MatchedWordScore matchedWordScore: this.matchedWordColector) {
         System.out.println(matchedWordScore.toString());
      }
   }

   public int size() {
      return this.matchedWordColector.size();
   }
}
