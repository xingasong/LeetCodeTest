import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)) return 1;
        HashSet<String> dict = new HashSet<>();
        for(String s : wordList) {
            dict.add(s);
        }
        Queue<String> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        queue.offer(beginWord);
        set.add(beginWord);
        int count = 1;
        while(!queue.isEmpty()) {
            count++;
            int len = queue.size();
            for(int i=0; i<len; i++) {
                String word = queue.poll();
                for(String neighbor : findNeighbor(word, dict)) {
                    if(set.contains(neighbor)) continue;
                    if(neighbor.equals(endWord)) return count;
                    queue.offer(neighbor);
                    set.add(neighbor);
                }
            }
        }
        return 0;
    }

    private ArrayList<String> findNeighbor(String word, HashSet<String> dict) {
        ArrayList<String> neighbor = new ArrayList<>();
        for(char c='a'; c<='z'; c++) {
            for(int i=0; i<word.length(); i++) {
                if(word.charAt(i) != c) {
                    String next = replace(word, i, c);
                    if(dict.contains(next)) neighbor.add(next);
                }
            }
        }
        return neighbor;
    }

    private String replace(String word, int index, char ch) {
        char[] str = word.toCharArray();
        str[index] = ch;
        return new String(str);
    }

    public static void main(String[] args) {
        WordLadder test = new WordLadder();
        String beginWord = "hit";
        String endWord = "cog";
        ArrayList<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        int x = test.ladderLength(beginWord, endWord, wordList);
        System.out.println(x);
    }
}
