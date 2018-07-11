package bitcamp.pms.domain;

import java.sql.Date;

public class Board {
    protected int bno;
    protected String titl;
    protected String content;
    protected Date cdt;
    public int getBno() {
        return bno;
    }
    public void setBno(int bno) {
        this.bno = bno;
    }
    public String getTitl() {
        return titl;
    }
    public void setTitl(String titl) {
        this.titl = titl;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Date getCdt() {
        return cdt;
    }
    public void setCdt(Date cdt) {
        this.cdt = cdt;
    }
    @Override
    public String toString() {
        return "Board [bno=" + bno + ", titl=" + titl + ", content=" + content + ", cdt=" + cdt + "]";
    }
    
    
}
