package baseTest;

public class RomanNumber {
    public static void main(String[] args) {
        String s=new String("MCMXCIV");
        System.out.println(romanToInt(s));
        s="III";
        System.out.println(romanToInt(s));
        s="VI";
        System.out.println(romanToInt(s));
        s="IV";
        System.out.println(romanToInt(s));


    }
    public  static int romanToInt(String s) {
        int result=0;
        int[] temp=new int[17];
        int i=s.length();
        temp[i]=0;
        while(i>0){
            switch(s.charAt(--i)){
                case 'I':
                    temp[i]=1;
                    break;
                case 'V':
                    temp[i]=5;
                    break;
                case 'X':
                    temp[i]=10;
                    break;
                case 'L':
                    temp[i]=50;
                    break;
                case 'C':
                    temp[i]=100;
                    break;
                case 'D':
                    temp[i]=500;
                    break;
                case 'M':
                    temp[i]=1000;
                    break;
            }
        }
        i=0;
        int count;
        while(i<s.length()){
            count=temp[i];
            while(temp[i]==temp[++i]){
                count+=temp[i];
            };
            if(temp[i]>temp[i-1]){
                result-=count;
            }else{
                result+=count;
            }
        }
        return result;
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        int samenum=strs[0].length()-1;
        for(int i=1;i<strs.length;++i){
            int j=0;
            while(j<samenum&&j<strs[i].length()){
                if(strs[0].charAt(j)!=strs[i].charAt(j)){
                    break;
                }
                ++j;
            }
            if(j<samenum){
                samenum=j;
            }
        }
        /*
        char[] result=new char[samenum+1];
        for(int i=0;i<samenum;++i){
            result[i]=strs[0].charAt(i);
        }
        result[samenum]='\0';
       return new String(result);
         */
        return strs[0].substring(0,samenum);
    }
}
/*
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
*/