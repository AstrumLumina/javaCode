package leetcodeSimp;

public class lid {
    public static void main(String[] args) {
        //import java.util.Scanner;
        //Scanner input = new Scanner(System.in);

        System.out.println("");
    }

    public int[] twoSum(int[] nums, int target) {
            for(int i=0;i<nums.length;++i){
                if(nums[i]<target/2) {
                    for(int j=nums.length;j>i;--j){
                        if(target==nums[i]+nums[j] ){
                            return new int[]{i,j};
                        }
                    }
                }
            }
           return new int[]{-1,-1};
    }
}
