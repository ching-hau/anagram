import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordFinder {

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      String filename = (args.length == 0) ? "sowpods.txt" : args[0];
      try {
         AnagramDictionary dictionary = new AnagramDictionary(filename);
         System.out.println("Type . to quit.");
         System.out.print("Rack? ");
         String currenString = in.next();
         while(!currenString.equals(".")) {
            MatchedWordCollector matchedWordCollector = new MatchedWordCollector(dictionary, currenString);
            System.out.println("We can make " + matchedWordCollector.size() + " words from " + "\"" + currenString + "\"");
            if(matchedWordCollector.size() > 0) {
               System.out.println("All of the words with their scores (sorted by score):");
            }
            matchedWordCollector.printMatchedWordWithScore();
            System.out.print("Rack? ");
            currenString = in.next();
         }
         
         in.close();
      }
      catch(FileNotFoundException e) {
         System.out.println("ERROR: Dictionary file \"" + filename + "\" does not exist.");
         System.out.println("Exiting program.");
      }
      catch(IllegalDictionaryException e) {
         System.out.println("ERROR: Illegal dictionary: dictionary file has a duplicate word: " + e.getMessage());
         System.out.println("Exiting program.");
      }
   }
}
