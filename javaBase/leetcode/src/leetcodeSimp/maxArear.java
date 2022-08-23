package baseTest;

public class maxArear {

    public static void test(){
        int[] height=new int[]{1,8,6,2,5,4,8,3,7};//测试用例 ，返回49
        int max= maxArear.findmaxArea(height);
        //int max= findmaxArea(height); //类内不用类没名限制也可
        System.out.println("Max="+max);
    }
    public static int findmaxArea(int[] height) {
        int right=height.length-1;
        int left=0;
        int arear=right*(height[0]>height[right]?height[right]:height[0]);
        while(left<right){
            boolean flag=(height[right]>height[left]);
            if(flag){//右边大，移到左边
                ++left;
            }else{//移动左边
                --right;
            }
            int temparear=(right-left)*(height[right]>height[left]?height[left]:height[right]);
            if(temparear>arear){
                arear=temparear;
            }
        }
        return arear;
    }

}
