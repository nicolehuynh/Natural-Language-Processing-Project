import java.util.ArrayList;

/**
 * Analyzes and processes text
 */
  public class TextProcessor {
    private String filename;
    private ArrayList<String> textList;

    public TextProcessor(String filename) {
        this.filename = filename;
        textList = FileReader.toStringList(filename);
    }

    public ArrayList<String> getTextList() {
        return textList;
    }

    /**
     * Separates each word in the reviews and returns a list of words
     * @return list of words from all reviews.
     */
  public ArrayList<String> textToWords() {
    ArrayList<String> wordList = new ArrayList<>();
    String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    for (int i = 0; i < textList.size(); i++) {
      String line = textList.get(i);
      String word = "";

      for (int j = 0; j < line.length(); j++) {
        String letter = line.substring(j, j + 1);
                
        boolean isLetter = false;
        for (int k = 0; k < alphabet.length(); k++) {
          if (letter.equals(alphabet.substring(k, k + 1))) {
            isLetter = true;
          }
        }
                
        if (isLetter) {
          word += letter;
        } else {
          if (!word.equals("")) {
            wordList.add(word);
            word = "";
          }
        }
      }
      if (!word.equals("")) {
        wordList.add(word);
      }
    }
    return wordList;
  }
}