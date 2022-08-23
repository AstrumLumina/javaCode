package leetcodeSimp;

public class FullPackage {
    public static void main(String[] args) {
        FullPackage.Solution solution=new FullPackage.Solution();
        int[] capacity={45,65,76,65};
        int[] rocks={40,1};
        int additionalRocks=17;


    }

    static  class Solution {
        public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
            int  len=capacity.length;
            int[] rest=new int[100000000];
            int unexpected=100000000;
            int i=0;
            while(i<len){
                int res=capacity[i]-rocks[i];
                if(res<unexpected){
                    ++rest[res];
                }
                ++i;
            }
            int fulled=rest[0];
            i=1;
            while(additionalRocks>0&&fulled<len){
                if(rest[i]!=0){
                    int max=rest[i]*i;
                    if(max<=additionalRocks){
                        additionalRocks-=max;
                        fulled+=rest[i];

                    }else{
                        fulled+=(additionalRocks)/i;
                        break;
                    }
                }
                ++i;
            }
            return fulled;
        }
    }

}
