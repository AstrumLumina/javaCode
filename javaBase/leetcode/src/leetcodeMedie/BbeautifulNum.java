package leetcodeMedie;

public class BbeautifulNum {

    public static void main(String[] args) {
        System.out.println(divisorSubstrings(240, 2));
        int[] nums=new int[4];
        nums[1]= 4;
        nums[2]= -8;
        nums[3]= 7;
        nums[0]=10 ;
        System.out.println(waysToSplitArray(nums));
        /*
        int[][] testnums={{10,11},{1,1}};
        int tangle=2;

         */
        int[][] testnums={ { 8051,8057 },{8074,8089  },{  7994,7995},{ 7969,7987 },{ 8013,8020 },{8123,8139  },{ 7930,7950 },{8096,8104  },
            { 7917,7925 },{  8027,8035},{ 8003,8011 }  };

       int tangle= 9854;
        //{{1,1,10,11}};
        System.out.println(maximumWhiteTiles(testnums, tangle));
      //  System.out.println(maxiWhiteTiles(testnums, tangle));
    }
    public static int divisorSubstrings(int num, int k) {
        int[] digits=new int[10];
        int nums=0;
        int digit=0;
        int temp3=num;
        while(temp3!=0){
            digit= temp3%10;
            digits[nums++]=digit;
            temp3/=10;
        }
        int temp=1;
        int temp2=digits[--nums];
        int i=1;
        while(i<k){
            temp*=10;
            temp2=temp2*10+digits[--nums];
            ++i;
        }
        --nums;
        int result=0;
        while(nums>=0){
            if(temp2!=0&&num%temp2==0){
                ++result;
            }
            temp2=temp2%temp*10+digits[nums];
            --nums;
        }
        if(temp2!=0&&num%temp2==0){
            ++result;
        }
        return result;
    }

    public static  int waysToSplitArray(int[] nums) {
            int i=0;
            int temp=0;
            int sum=0;
            for(int j=0;j<nums.length;++j){
                sum+=nums[j];
            }
           // sum/=2+1;
            int count=0;
            while(i<nums.length-1){
                temp+=nums[i];
                if(temp>=sum-temp){
                    ++count;
                }
                ++i;
            }
            return count;
    }

    /*
    public static int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        int i=0;
        int j=0;
        for(i=0;i<tiles.length-1;++i){
            int min=i;
            for(j=i+1;j<tiles.length;++j){
                if(tiles[j][0]<tiles[min][0]){
                    min =j;
                }
            }
            if(min!=i){
                int[] tempint=tiles[i];
                tiles[i]=tiles[min];
                tiles[min]=tempint;
            }
        }


        //******************
        int temp=0;
        int result=0;
        int end=0;
        int start=0;
        int max=tiles[tiles.length-1][1];
        i=0;
        j=0;
        for(i=0;i<tiles.length;++i){
            start=tiles[i][0];
            temp=0;
            end=tiles[i][0]+carpetLen-1;
            for(j=i;j<tiles.length&&tiles[j][1]<=end;++j) {
                temp+=tiles[j][1]-tiles[j][0]+1;
            }
            if(j<tiles.length&&tiles[j][0]<end)
                 temp+=(end-tiles[j][0]+1);
            if(temp>result)
                result=temp;
            if(end>max){
                break;
            }
        }
        return result;

    }

     */
    //*****************************************************
//    public static int maxiWhiteTiles(int[][] tiles, int carpetLen) {
//        int i=0;
//        int j=0;
//        for(i=0;i<tiles.length-1;++i){
//            int min=i;
//            for(j=i+1;j<tiles.length;++j){
//                if(tiles[j][0]<tiles[min][0]){
//                    min =j;
//                }
//            }
//            if(min!=i){
//                int[] tempint=tiles[i];
//                tiles[i]=tiles[min];
//                tiles[min]=tempint;
//            }
//        }
//
//
//        //******************
//        int temp=0;
//        int result=0;
//        int end=0;
//        int start=0;
//        int max=tiles[tiles.length-1][1];
//        int lastlenth=0;
//        i=0;
//        j=0;
//
//        for(i=0;i<tiles.length;++i){
//            start=tiles[i][0];
//            end=tiles[i][0]+carpetLen-1;
//            temp-=lastlenth;
//            lastlenth=tiles[i][1]-tiles[i][0]+1;
//            for(;j<tiles.length&&tiles[j][1]<=carpetLen;++j) {
//                temp+=tiles[j][1]-tiles[j][0]+1;
//            }
//            if(j<tiles.length&&tiles[j][0]<end){
//                temp+=(tiles[j][1]-tiles[j][0]+1);
//                if(j==i){
//                    return temp;
//                }
//            }
//
//            if(temp>result)
//                result=temp;
//            if(end>max){
//                break;
//            }
//        }
//        return result;
//
//    }

    //****************************************


    public  static int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        int i=0;
        int j=0;
        for(i=0;i<tiles.length-1;++i){
            int min=i;
            for(j=i+1;j<tiles.length;++j){
                if(tiles[j][0]<tiles[min][0]){
                    min =j;
                }
            }
            if(min!=i){
                int[] tempint=tiles[i];
                tiles[i]=tiles[min];
                tiles[min]=tempint;
            }
        }

        //******************
        int temp=0;
        int result=0;
        int end=0;
        int start=0;
        int max=tiles[tiles.length-1][1];
        int lastlenth=0;
        i=0;
        j=0;

        for(i=0;i<tiles.length;++i){
            start=tiles[i][0];
            end=tiles[i][0]+carpetLen-1;
            if(temp<lastlenth)
                return result;
            temp-=lastlenth;
            lastlenth=tiles[i][1]-tiles[i][0]+1;
            while(j<tiles.length&&tiles[j][1]<=end){
                temp+=tiles[j][1]-tiles[j][0]+1;
                ++j;
            }
            if(j<tiles.length&&tiles[j][0]<end){
                temp+=(end-tiles[j][0]+1);
            }
            if(temp>result)
                result=temp;
            if(end>max){
                return result;
            }
        }
        return result;
    }



}

