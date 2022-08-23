package com.xuanxie.pojo;

/*属性名最好更数据库中的一致,否则容易出错(除非使用特殊的map传参进行,则可以随意区属性名)*/
public class User {
    private int id;
    private String name;
    private String pwd;
/*这里解决属性名与与 数据库字段名不一致的问题
* 由于属性名不一致,导致查询此属性时为空等问题,我们可以通过 解决*/

    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + pwd + '\'' +
                '}';
    }
}
