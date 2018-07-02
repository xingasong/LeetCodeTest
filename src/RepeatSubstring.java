class RepeatSubstring {
    public static boolean repeatedSubstringPattern(String s) {
        if(s==null||s.length()==0) return false;
        int flag = 0;
        for(int i=1; i<=s.length()/2+1; i++){
            String a = s.substring(0, i);
            int j = i;
            while(j+a.length()<=s.length()&&a.equals(s.substring(j, j+a.length()))){
                j += a.length();
                if(j==s.length()){
                    flag = 1;
                    break;
                }
            }
            if(flag==1) return true;
        }
        return false;
    }

    public static void main(String[] args){
        String s = "abcaabcabc";
        System.out.println(repeatedSubstringPattern(s));
    }
}
