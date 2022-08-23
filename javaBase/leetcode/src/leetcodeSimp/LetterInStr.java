package leetcodeSimp;

public class LetterInStr {
    public static void main(String[] args) {
        Solution solution=new Solution();
        String s = "foobar";
        char letter = 'o';
        System.out.println(solution.percentageLetter(s, letter));
    }

    static  class Solution {
        public  int percentageLetter(String s, char letter) {
            int i=0;
            int nums=0;
            int  len=s.length();
            while(i<len){
                if(s.charAt(i)==letter){
                    ++nums;
                }
                ++i;
            }
            double result=(double)nums/len;
            return (int)(result*100);
        }
    }
}
