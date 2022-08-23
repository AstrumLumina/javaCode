package baseTest;

public class cyinder {
    private double volume;
    public void cyinder(double rid,double high){
        setvol( rid, high);
       // volume=Math.PI*rid*rid*high;
    }
    public void setvol(double rid,double high){
        volume=Math.PI*rid*rid*high;
    }
    public void vol(){
        System.out.println("volume is "+volume);
    }

}
