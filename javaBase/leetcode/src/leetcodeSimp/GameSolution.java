package baseTest;

public class GameSolution {
    public static void test(){
        int[] testarr=new int[] {2,3,0,1,4};
        System.out.println(" The solutino of [2,3,0,1,4] is:");
        System.out.println(jump(testarr));
        System.out.println("");
        testarr=new int[] {2,3,0,1,4};
        System.out.println(" The solutino of [2,3,0,1,4] is:");
        System.out.println(jump(testarr));
        System.out.println("");
        testarr=new int[] {2,3,1};
        System.out.println(" The solutino of [2,3,1] is:");
        System.out.println(jump(testarr));


        //[2,3,0,1,4]  --2  测试用例
        //[2,3,0,1,4]  --2  测试用例
        //[2,1]        --1  测试用例
    }

    //三种解决方法
    public static int jumptwo(int[] nums) {
        int step=0;
        int unitmove=0;
        int moves=0;
        int nowmax;
        int max=nums.length-1;
        int nextmoves;
        while(moves<max){
            nowmax=0;
            int i=nums[moves];
            while(i!=0){
                if(moves+i>=max){
                    unitmove=i;
                    break;
                }else{
                    nextmoves=i+nums[moves+i];
                    if(nextmoves>nowmax&&nums[moves+i]!=0){
                        nowmax = nextmoves;
                        unitmove = i;
                    }
                }
                --i;
            }
            moves+=unitmove;
            ++step;
        }
        return  step;
    }
    public static int jumpthree(int[] nums){
        int position=nums.length-1;
        int steps=0;
        while(position!=0){
            for(int i=0;i<position;++i){
                if(nums[i]>=position-i){
                    position=i;
                    ++steps;
                    break;
                }
            }
        }
        return steps;
    }
    public static int jump(int[] nums){
        int end=0;
        int maxposition=0;
        int step=0;
        int whilemax=nums.length-1;
        for(int i=0;i<whilemax;++i){
            maxposition=nums[i]+i>maxposition?nums[i]+i:maxposition;
          if(i==end) {
              end= maxposition;
              ++step;
          }
        }
        return step;
    }
}
