/**
 * A score table that define the score for each character. 
 * This class also contains a method that can calculate the score
 * of an input word.
 */

public class ScoreTable {

   /**
      Representation invariant:
      - the size of scoreTable is 26
      - the value in scoreTable is at least 1
    */

   // Index of array means the order of aphabet, and the value maens the score.
   int[] scoreTable;
   
   /**
    * Create a score table by defination of the frequency
      of each characters occurence.
    */
   public ScoreTable() {
      this.scoreTable = initializeScoreTable();
   }

   /**
    * Initialize the score of every characters.
    * @return score of every characters in an array form
    */
   public int[] initializeScoreTable() {
      int[] scoreTable = new int[26];
      scoreTable['a' - 'a'] = 1;
      scoreTable['b' - 'a'] = 3;
      scoreTable['c' - 'a'] = 3;
      scoreTable['d' - 'a'] = 2;
      scoreTable['e' - 'a'] = 1;
      scoreTable['f' - 'a'] = 4;
      scoreTable['g' - 'a'] = 2;
      scoreTable['h' - 'a'] = 4;
      scoreTable['i' - 'a'] = 1;
      scoreTable['j' - 'a'] = 8;
      scoreTable['k' - 'a'] = 5;
      scoreTable['l' - 'a'] = 1;
      scoreTable['m' - 'a'] = 3;
      scoreTable['n' - 'a'] = 1;
      scoreTable['o' - 'a'] = 1;
      scoreTable['p' - 'a'] = 3;
      scoreTable['q' - 'a'] = 10;
      scoreTable['r' - 'a'] = 1;
      scoreTable['s' - 'a'] = 1;
      scoreTable['t' - 'a'] = 1;
      scoreTable['u' - 'a'] = 1;
      scoreTable['v' - 'a'] = 4;
      scoreTable['w' - 'a'] = 4;
      scoreTable['x' - 'a'] = 8;
      scoreTable['y' - 'a'] = 4;
      scoreTable['z' - 'a'] = 10;
      return scoreTable;
   }

/**
 * Sum up the score of each character, and get the score of the input word.
 * @param word the target word that we want to know its score
 * @return the sum of score for the input word.
 */
   public int getWordScore(String word) {
      int sum = 0;
      for(int i = 0; i < word.length(); i ++) {
         sum += this.scoreTable[Character.toLowerCase(word.charAt(i)) - 'a'];
      }
      return sum;
   }
}
