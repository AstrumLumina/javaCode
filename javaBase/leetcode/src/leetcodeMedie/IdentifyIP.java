package leetcodeMedie;

/*
public class IdentifyIP {
    public static void main(String[] args) {
        IdentifyIP.Solution solution=new IdentifyIP.Solution();
        solution.validIPAddress();
    }


    static class  Solution {
        public static String validIPAddress(String queryIP) {
            int len=queryIP.length();
            char[] ipdividefalg={'\0','.',':'};
            int[] ipparties={0,4,8};
            int[] ipmax={0,4,5};
            boolean issixting=false;
            int ipvtype=0;
            int i=0;
            while(i<5){
                if(queryIP.charAt(i)==':'){
                    ipvtype=2;
                    break;
                }else if(queryIP.charAt(i)=='.'){
                    ipvtype=1;
                    break;
                }
                ++i;
            }
            if(ipvtype==0){
                return new String("Neither");
            }
            i=0;
            for(int j=0;j<ipparties[ipvtype];++j){
                int zerocounts=0;
                boolean hasletter=false;
                boolean isfirstnum=true;
                int numcounts=0;
                i=0;
                while(numcounts<ipmax[ipvtype]){
                    if(queryIP.charAt(i)>'0'&&queryIP.charAt(i)<='9'){

                    }else if((queryIP.charAt(i)>='A'&&queryIP.charAt(i)<'G')||(queryIP.charAt(i)>='a'&&queryIP.charAt(i)<'g')){
                        hasletter=true;
                    }else{
                        switch( queryIP.charAt(i)){
                            case:'0'
                                    ++zerocounts;
                            case:
                        }
                    }
                    ++numcounts;


                    ++i;
                }
            }

        }
        if()
    }
}
*/