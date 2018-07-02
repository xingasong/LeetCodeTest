import java.util.*;

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        HashSet<String> dict = new HashSet<>();
        dict.addAll(wordList);
        dict.add(beginWord);
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String s : wordList) {
            map.put(s, findNeighbor(s, dict));
        }
        map.put(beginWord, findNeighbor(beginWord,dict));
        Map<String, Integer> lengthMap = lengthMap(beginWord, endWord, map);
        //lengthMap = lengthMap(beginWord, endWord, dict);
        if(!lengthMap.containsKey(beginWord)) return res;
        int remains = lengthMap.get(beginWord);
        ArrayList<String> tmplist = new ArrayList<>();
        tmplist.add(beginWord);
        dfs(res, tmplist, lengthMap, map, beginWord, endWord, remains);
        return res;
    }

    private void dfs(List<List<String>> res,
                     ArrayList<String> tmplist,
                     Map<String, Integer> lengthMap,
                     HashMap<String, ArrayList<String>> map,
                     String word,
                     String endWord,
                     int remains) {
        if(remains==1) {
            if(word.equals(endWord)) res.add(new ArrayList<>(tmplist));
            return;
        }
        for(String next : map.get(word)) {
            if(!lengthMap.containsKey(next)) continue;
            if(tmplist.contains(next)) continue;
            tmplist.add(next);
            dfs(res, tmplist, lengthMap, map, next, endWord, remains-1);
            tmplist.remove(tmplist.size()-1);
        }

    }

    private HashMap<String, Integer> lengthMap(String beginWord, String endWord, HashMap<String, ArrayList<String>> neighborMap) {
        HashMap<String, Integer> map = new HashMap<>();
        //dict.add(beginWord);
        Queue<String> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        queue.offer(endWord);
        set.add(endWord);
        map.put(endWord, 1);
        int count = 1;
        boolean flag = false;
        while(!queue.isEmpty()) {
            count++;
            int len = queue.size();
            for(int i=0; i<len; i++) {
                String word = queue.poll();
                for(String neighbor : neighborMap.get(word)) {
                    if(set.contains(neighbor)) continue;
                    if(neighbor.equals(beginWord)) flag = true;
                    queue.offer(neighbor);
                    set.add(neighbor);
                    map.put(neighbor, count);
                }
            }
            if(flag) break;
        }
        return map;
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
        WordLadderII test = new WordLadderII();
        String beginWord = "hot";
        String endWord = "dog";
        ArrayList<String> wordList = new ArrayList<>();
        wordList.add("hot");
        //wordList.add("dot");
        wordList.add("dog");
        //wordList.add("lot");
        //wordList.add("log");
        //wordList.add("cog");
        System.out.println(test.findLadders(beginWord, endWord, wordList));
    }
}
