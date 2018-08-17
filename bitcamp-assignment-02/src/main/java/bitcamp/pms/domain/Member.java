package bitcamp.pms.domain;

public class Member {
    
    protected String id;
    protected String name;
    protected String password;
    protected String email;
    protected String cellphone;
    protected String telephone;
    protected String fax;
    protected String memo;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCellphone() {
        return cellphone;
    }
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getFax() {
        return fax;
    }
    public void setFax(String fax) {
        this.fax = fax;
    }
    public String getMemo() {
        return memo;
    }
    public void setMemo(String memo) {
        this.memo = memo;
    }
    @Override
    public String toString() {
        return "Member [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", cellphone="
                + cellphone + ", telephone=" + telephone + ", fax=" + fax + ", memo=" + memo + "]";
    }
    
    
    
    
    
    
    
}
