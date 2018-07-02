public class StringIterator {

    char target;
    int count;
    int i = 0, j = 1;
    String s;


    public StringIterator(String s) {
        this.s = s;
        target = s.charAt(i);
        while (j < s.length() && Character.isDigit(s.charAt(j))) j++;
        count = Integer.parseInt(s.substring(i+1, j));
    }

    public char next() {

        if (count == 0) {
            i = j;
            j++;
            target = s.charAt(i);
            while (j < s.length() && Character.isDigit(s.charAt(j))) j++;
            count = Integer.parseInt(s.substring(i+1, j));
        }
        count--;
        return target;
    }

    public boolean hasNext() {
        return j < s.length() || count > 0;
    }
}
