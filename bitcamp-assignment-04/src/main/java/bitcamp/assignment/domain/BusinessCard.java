package bitcamp.assignment.domain;

import java.io.Serializable;

public class BusinessCard implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    protected int no;
    protected int memberNo;
    protected String name;
    protected String mobileTel;
    protected String tel;
    protected String tax;
    protected String email;
    protected String memo;
    
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public int getMemberNo() {
        return memberNo;
    }
    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMobileTel() {
        return mobileTel;
    }
    public void setMobileTel(String mobileTel) {
        this.mobileTel = mobileTel;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getTax() {
        return tax;
    }
    public void setTax(String tax) {
        this.tax = tax;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMemo() {
        return memo;
    }
    public void setMemo(String memo) {
        this.memo = memo;
    }
    
    @Override
    public String toString() {
        return "BusinessCard [no=" + no + ", memberNo=" + memberNo + ", name=" + name + ", mobileTel=" + mobileTel
                + ", tel=" + tel + ", tax=" + tax + ", email=" + email + "]";
    }
    
    
}
