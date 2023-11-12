// Name: Ching-Hau
// USC NetID: chinghau
// CS 455 PA4
// Spring 2022

/**
 * This class matched the score with each word. Each instance will include 
 * the word itself and the score calculate by the score table. Additionally, 
 * this class is comparable. The first priority is the score from high to 
 * low, and then the alphabetically order. 
 */
public class MatchedWordScore implements Comparable<MatchedWordScore>{
   /**
      Representation invariant:
      - score > 0
      - word can not contain special sign 
   */

   // score and word are instance variable of this class. 
   private int score;
   private String word;
   
   /**
    * To create a MatchedWordScore instance to make it have its own word name and score.
    * @param score each word have its own score
    * @param word the word that we want to match with score
    */
   public MatchedWordScore(int score, String word) {
      this.score = score;
      this.word = word;
   }
   /**
    * To create the string of this instance.
      For example: instance word = "haha", score = 9 => "8: haha"
    */
   public String toString() {
      return Integer.toString(this.score) + ": " + this.word;
   }
   /**
    * This instance implement the comparable interfacce, so it can compare to itself. 
      The first comparison is score. Then, it will compare the alphabetical order.
    */
   @Override
   public int compareTo(MatchedWordScore matchedWordScore) {
      if(matchedWordScore.score - this.score != 0) {
         return matchedWordScore.score - this.score;
      }
      return this.word.compareTo(matchedWordScore.word);
   }
}
