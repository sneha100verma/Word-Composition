import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

class TrieNode {
    TrieNode[] children;
    boolean isWord;

    // TrieNode Constructor
    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
}

class LongestCompoundWord {
    TrieNode root;
    Set<String> wordsSet;
    String longestCompoundWord;
    String secondLongestCompoundWord;

    public LongestCompoundWord() {
        root = new TrieNode();
        wordsSet = new HashSet<>();
        longestCompoundWord = "";
        secondLongestCompoundWord = "";
    }

    // Function to insert a word in our tree
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isWord = true;
        wordsSet.add(word);
    }

    // Function to check if a word is a compounded word or not
    public boolean isCompoundWord(String word, boolean original) {
        // Exclude single words
        if (word.length() == 1) {
            return false;
        }

        // Exclude the original word (for ex- "hippopotamuses") from being considered as
        // compound
        if (original && (word.equals(longestCompoundWord) || word.equals(secondLongestCompoundWord))) {
            return false;
        }

        // Checking for compound word by recursively checking prefixes and suffixes
        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);

            if (wordsSet.contains(prefix) && (wordsSet.contains(suffix) || isCompoundWord(suffix, false))) {
                return true;
            }
        }

        return false;
    }

    // Function to find the longest and second-longest compound words
    public void findLongestCompoundWords(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));

        String line;
        while ((line = br.readLine()) != null) {
            insert(line.trim());
        }
        br.close();

        // update longest and second-longest words accordingly
        for (String word : wordsSet) {
            if (isCompoundWord(word, true)) {
                if (word.length() > longestCompoundWord.length()) {
                    secondLongestCompoundWord = longestCompoundWord;
                    longestCompoundWord = word;
                } else if (word.length() > secondLongestCompoundWord.length()) {
                    secondLongestCompoundWord = word;
                }
            }
        }

        System.out.println("Longest Compound Word: " + longestCompoundWord);
        System.out.println("Second Longest Compound Word: " + secondLongestCompoundWord);
    }
}

class WordCombination {

    public static void main(String[] args) throws IOException {
        LongestCompoundWord finder = new LongestCompoundWord();

        // for starting time
        long sTime = System.currentTimeMillis();
        finder.findLongestCompoundWords("Input_02.txt");
        // for ending time
        long eTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (eTime - sTime) + "ms");
    }
}
