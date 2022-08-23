package leetcodeSimp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LecodeCmp2 {

    public static void main(String[] args) {
        CountIntervals countIntervals = new CountIntervals(); // 用一个区间空集初始化对象
        countIntervals.add(2, 3);  // 将 [2, 3] 添加到区间集合中
        countIntervals.add(7, 10); // 将 [7, 10] 添加到区间集合中
        System.out.println(countIntervals.count());    // 返回 6
        // 整数 2 和 3 出现在区间 [2, 3] 中
        // 整数 7、8、9、10 出现在区间 [7, 10] 中
        countIntervals.add(5, 8);  // 将 [5, 8] 添加到区间集合中
        System.out.println(countIntervals.count());    // 返回 8
    }

    public List<String> removeAnagrams(String[] words) {
        boolean notalready=true;
        while(notalready){
            notalready=false;
            for(int i=0;i<words.length;++i){
                //初始化 counts
                if(words[i]==null){
                    continue;
                }
                int[] counts = new int[26];
                for(int j=0;j<words[i].length();++j){
                    ++counts[(int)(words[i].charAt(j)-'a')];
                }
                //查找相同的
                for(int k=i+1;k<words.length;++k){
                    if(words[k]==null) {
                        continue;
                    }
                    int[] matchs=new int[26];
                    for(int n=0;n<words[k].length();++n){
                        ++matchs[(int)(words[k].charAt(n)-'a')];
                    }
                    boolean flag=true;
                    for(int m=0;m<26;++m){
                        if(counts[m]!=matchs[m]){
                            flag=false;
                            break;
                        }
                    }
                    if(flag){
                        words[k]=null;
                        notalready=true;
                    }else{
                        break;
                    }
                }
            }
        }

        List<String> result= new ArrayList<String>();
        for(int i=0;i<words.length;++i){
            if(words[i]!=null)
                result.add(words[i]);
        }
        return result;
    }

    public int maxConsecutive(int bottom, int top, int[] special) {
        int max=0;
        int start=top;
        int i=special.length;
        for(int j=0;j<i-1;++j){
            int min=j;
            for(int m=j+1;m<i;++m){
                if(special[m]<special[min]){
                    min=m;
                }
            }
            if(min!=j){
                int temp=special[min];
                special[min]=special[j];
                special[j]=temp;
            }
        }
        ++start;
        if(i!=0)
            --bottom;
        while(i>0){
            int temp=start-special[--i]-1;
            if(temp>max)
                max=temp;
            start=special[i];
        }
        max= max>start-bottom?max:start-bottom;
        return max;
    }
}

class CountIntervals {
    class melement{
        public double min;
        public double max;
        melement next;
        melement(){
            min=0;
            max=0;
            next=null;
        }
        melement(double min,double max){
            this.min=min=0;
            this.max=max=0;
            this.next=null;

        }
        melement(double min,double max,melement next){
            this.min=min;
            this.max=max;
            this.next=next;
        }
    }
    double counts;
    boolean flag=false;
    melement melementshead;
    public CountIntervals() {
            melementshead= new melement();
            counts=0;
    }
    public void add(int left, int right) {
        flag=false;
        melement before=melementshead;
        melement now=melementshead.next;
        while(now!=null){
            if((double)left>now.min){
                before=before.next;
                now=now.next;
            }else{
                break;
            }
        }
        before.next=new melement((double)left,(double)right,now);
    }
    public int count() {
        if(!flag){
            melement now=melementshead.next;
            double start=now.min;
            double end=now.max;
            double count=start-end+1;
            now=now.next;
            while(now!=null){
                if(now.min>start){
                    start=now.min;
                    end=now.max;
                    count+=start-end+1;
                }else if(now.max>end){
                    count+=now.max-end;
                    end=now.max;
                }
                now=now.next;
            }
            counts=count;
            flag=true;
        }
        return (int)counts;
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */
