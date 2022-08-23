package RefAndAnno;

public class Fortest {
    int id=0;
    String name=null;
    public Fortest(){}
    public Fortest(String name, int id){
        this.id=id;
        this.name=name;
    }
    public int getId(){
        return id;
    }
    private void addid(int unit){
        ++id;
    }
    public String toString(){
        Integer toprin=id;
        return new String(name+toprin);
    }
}
