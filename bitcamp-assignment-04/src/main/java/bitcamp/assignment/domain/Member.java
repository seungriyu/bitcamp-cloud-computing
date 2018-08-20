package bitcamp.assignment.domain;

import java.io.Serializable;

public class Member implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    //서브 패키지 접근 가능
    protected int no;
    protected String name;
    protected String email;
    protected String password;
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "Member [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password + "]";
    }
    
    
}
