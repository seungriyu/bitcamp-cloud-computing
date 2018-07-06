package bitcamp.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bitcamp.pms.domain.Member;

public class MemberDao {
    //인터페이스 List 
    public static List<Member> selectList() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        
        //닫아야 하는 자원은 try ()안에 정의하라
        //정상적으로 끝나던 오류가 나던 close
        //반드시 닫아야 하는 자원 
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://13.209.76.8:3306/studydb",
                "study", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "select mid, email from pms2_member");
            ResultSet rs = stmt.executeQuery();) {
            
            ArrayList<Member> list = new ArrayList<>();
            
            
            while (rs.next()) {
                Member member = new Member();
                member.setId(rs.getString("mid")); //setId : 메모리(member)를 다루는 연산자,메서드라는 문법으로 만들어짐 setter
                member.setEmail(rs.getString("email"));
                list.add(member);
            }
            return list;
            
        }
    }
    
    public static Member selectOne(String id) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        
        
        
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://13.209.76.8:3306/studydb",
                "study", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "select mid,email from pms2_member where mid=?");) {
            
            stmt.setString(1, id);
            
            
            try (ResultSet rs = stmt.executeQuery();) {
                if (!rs.next()) {
                    return null; 
                }
                
//                    email = rs.getString("email");
                    Member member = new Member();
                    member.setId(rs.getString("mid"));
                    member.setEmail(rs.getString("email"));
                    return member;
                
                
                
            
            }
        }  
  
    }
    
    
    public static int update(Member member) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://13.209.76.8:3306/studydb",
                "study", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "update pms2_member set email=?, pwd=password(?) where mid=?");) {
            
            stmt.setString(1, member.getEmail());
            stmt.setString(2, member.getPassword());
            stmt.setString(3, member.getId());
            
            return stmt.executeUpdate();
            
        }
    }
    
    public static int delete(String id) throws Exception{
        //멤버에 해당되는 아이디 지우기
        Class.forName("com.mysql.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://13.209.76.8:3306/studydb",
                "study", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "delete from pms2_member where mid=?");) {
            
            stmt.setString(1, id);
            
            return stmt.executeUpdate();
            
        } 
        
    }
    
    public static void insert(Member member) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://13.209.76.8:3306/studydb",
                "study", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "insert into pms2_member(mid,email,pwd) values(?,?,password(?))");) {
            
            stmt.setString(1, member.getId());
            stmt.setString(2, member.getEmail());
            stmt.setString(3, member.getPassword());
            stmt.execute();
//          return stmt.executeUpdate();
        }
       
        
    }
    
}
