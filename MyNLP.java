import java.util.ArrayList;
import java.util.Scanner;

  public class MyNLP {
    private TextProcessor textProcessor;
    private ArrayList<String> words;
    private ArrayList<String> stopWords;

    public MyNLP() {
      textProcessor = new TextProcessor("reviews.txt"); 
      words = new ArrayList<>();
      stopWords = new ArrayList<>(); 

        // Stop words
        stopWords.add("i"); stopWords.add("and"); stopWords.add("a"); stopWords.add("the");
        stopWords.add("is"); stopWords.add("in"); stopWords.add("to"); stopWords.add("of");
        stopWords.add("that"); stopWords.add("it"); stopWords.add("for"); stopWords.add("on");
        stopWords.add("with"); stopWords.add("as"); stopWords.add("was"); stopWords.add("at");
        stopWords.add("by"); stopWords.add("an"); stopWords.add("be"); stopWords.add("this");
        stopWords.add("or"); stopWords.add("are"); stopWords.add("from"); stopWords.add("but");
        stopWords.add("not"); stopWords.add("they"); stopWords.add("you"); stopWords.add("we");
        stopWords.add("his"); stopWords.add("her"); stopWords.add("she"); stopWords.add("he");
        stopWords.add("my"); stopWords.add("our"); stopWords.add("their");
    }

    /**
     * The user to enters a keyword and finds how many times the keyword is in the reviews
     */
    public void prompt() {
      Scanner input = new Scanner(System.in);
      boolean searchAgain = true;

      while (searchAgain) {
        System.out.println("Enter a keyword to search in the reviews:");
        String keyword = input.nextLine().toLowerCase();

        if (!stopWords.contains(keyword)) {
          int frequency = countKeyword(keyword);
          if (frequency > 0) {
            System.out.println("The word '" + keyword + "' appears " + frequency + " times in the reviews.");
          } else {
            System.out.println("The word '" + keyword + "' does not appear in the reviews.");
          }
        } else {
          System.out.println("The word '" + keyword + "' is a common stop word and is not counted.");
        }

        System.out.println("Would you like to search for another keyword? (yes/no):");
        String response = input.nextLine().toLowerCase();
        searchAgain = response.equals("yes");
      }

      input.close();
    }

    /**
     * Counts the occurrences of the given keyword in the reviews and prints the reviews that contain the keyword.
     * @param keyword The keyword to search for.
     * @return The frequency of the keyword in the reviews.
     */
    public int countKeyword(String keyword) {
      int count = 0;
      ArrayList<String> reviews = textProcessor.getTextList(); 

      for (int i = 0; i < reviews.size(); i++) {
        String review = reviews.get(i).toLowerCase();
        if (review.contains(keyword)) {
          count++;
          System.out.println("- " + reviews.get(i)); 
        }
      }
      return count;
    }
}