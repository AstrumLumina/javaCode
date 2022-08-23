package leetcodeMedie;

import leetcodeSimp.FullPackage;

public class PointLine {

    public static void main(String[] args) {
        PointLine.Solution solution=new PointLine.Solution();


    }

    static  class Solution {
        public int minimumLines(int[][] stockPrices) {
                double lastk=0;
                boolean flag=false;
                int sides=0;
                int min=0;
                int[] leftpoint=new int[2];
                int points=stockPrices.length;
                for(int i=0;i<points-1;++i){
                    min=i;
                    for(int j=i+1;i<points;++i){
                        if(stockPrices[j][0]<stockPrices[min][0]){
                            min=j;
                        }
                    }
                    if(i==0){
                        leftpoint[0]=stockPrices[min][0];
                        leftpoint[1]=stockPrices[min][1];
                    }else {
                        double k=(double)(stockPrices[min][0]- leftpoint[0])/(stockPrices[min][1]-leftpoint[1]);
                        if(flag){
                            if(k!=lastk){
                                ++sides;
                                leftpoint[0]=stockPrices[min][0];
                                leftpoint[1]=stockPrices[min][1];
                            }
                        }else{
                            lastk=k;
                            flag=true;
                        }
                    }
                    stockPrices[min]=stockPrices[i];
                }
                return sides;
        }
    }

}
