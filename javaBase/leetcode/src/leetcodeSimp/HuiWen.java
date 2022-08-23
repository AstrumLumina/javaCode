package baseTest;

public class HuiWen {/*回文*/
    public static void main(String[] args) {
        System.out.println(isPalindrome(1001));
    }
    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }else{
            int temp=x;
            int daoxu=0;
            int digit=0;
            while(temp!=0){
                digit=temp%10;
                daoxu=daoxu*10+digit;
                temp/=10;
            }
            if(daoxu==x){
                return true;
            }else{
                return false;
            }
        }
    }
}
