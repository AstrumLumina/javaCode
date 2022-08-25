package baseTest;

public class StudentGrade {
    static private int studentnum;
    static private double average;
    static private double totalgrade;
    static{
        studentnum=0;
        average=0;
    }
    private int id;
    private String name;
    private double grade ;

    public StudentGrade(){
        id=0;
        name=null;
        grade=0;
        addstudent(grade);
    }
    public StudentGrade(int aid,String aname,double agrade){
        assert(grade>=0);
        id=aid;
        name=aname;
        grade=agrade;
        addstudent(grade);
    }
    public  int addstudent(double grade){
        assert(grade>=0);
        totalgrade+=grade;
        ++studentnum;
        average=totalgrade/studentnum;
        return studentnum;
    }
    static public double getave(){
        return average;
    }
    static public int  getstunum(){
        return studentnum;
    }
    public void changestu(int aid,String aname,double agrade){
        assert(grade>=0);
        totalgrade-=grade;
        totalgrade+=agrade;
        average=totalgrade/studentnum;
        grade=agrade;
        name=aname;
        id=aid;
    }
    public static void main(String[] args) {
        StudentGrade stu1=new StudentGrade(1,"wzw",20);
        StudentGrade stu2=new StudentGrade(2,"xjx",89);
        StudentGrade stu3=new StudentGrade(3,"cjh",90);
        StudentGrade stu4=new StudentGrade(4,"gdf",60);
        System.out.println("student num is :"+StudentGrade.getstunum());
        System.out.println("The average grade is :"+StudentGrade.getave());
    }
}