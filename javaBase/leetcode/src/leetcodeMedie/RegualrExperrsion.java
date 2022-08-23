package leetcodeMedie;

public class RegualrExperrsion {
    public static void test(){

        String s=new String("aa");
        String p=new String("a");
        System.out.println(isMatch(s,p));

        s=new String("aab");
        p=new String("c*a*b");
        System.out.println(isMatch(s,p));

        s=new String("aa");
        p=new String("a*");
        System.out.println(isMatch(s,p));

        s=new String("aa");
        p=new String(".*");
        System.out.println(isMatch(s,p));


    }

    /*函数带改正*/
    public static boolean isMatch(String s , String p){//s正常的字符串  p:正则表达式
        int minmatched=0;
        int nowmatched=0;
        boolean unsertain=false;
        int i=0;
        while(i<p.length()) {
            if(p.charAt(i)=='.'){ //'.'
                ++nowmatched;
                if(i+1<p.length()) {
                    if (p.charAt(i + 1) == '*') {//'.'+'*'     ---匹配0个或多个前面的字符，可以不相同
                        //minmatched=nowmatched;
                        while (nowmatched < s.length()) {
                            if (s.charAt(nowmatched - 1) != s.charAt(nowmatched++)) {
                                --nowmatched;
                                break;
                            }
                        }
                        ++i;
                    }
                }
             //   }else {
                   // ++nowmatched;
              //  }
            }else if(p.charAt(i)=='*'){//‘*’号
                while(nowmatched<s.length()){
                    if(s.charAt(nowmatched-1)!=s.charAt(nowmatched++)){
                        --nowmatched;
                        break;
                    }
                }
            }else{//数字
                if(i+1<p.length()){
                    if(p.charAt(i+1)=='*'){
                        if (p.charAt(i) == s.charAt(nowmatched)) {
                            ++nowmatched;
                            while (nowmatched < s.length()) {
                                if (s.charAt(nowmatched - 1) != s.charAt(nowmatched++)) {
                                    --nowmatched;
                                    break;
                                }
                            }
                        }
                        ++i;
                    }else{
                        if(p.charAt(i)==s.charAt(nowmatched)){
                            ++nowmatched;
                        }else{
                            return false;
                        }
                    }
                }else{
                    if(p.charAt(i)==s.charAt(nowmatched)){
                        ++nowmatched;
                    }else{
                        return false;
                    }
                }
            }
            //********************************
            if(nowmatched<=s.length()){
                ++i;
            }else{
                return false;
            }
        }
        if(nowmatched==s.length()){
            return true;
        }
        return false;
    }

}
