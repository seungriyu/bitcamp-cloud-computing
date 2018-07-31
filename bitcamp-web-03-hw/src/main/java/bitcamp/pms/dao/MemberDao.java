
package bitcamp.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.pms.domain.Member;

public class MemberDao {
    
//    static {
//        
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        
//        
//    }
    
    SqlSessionFactory sqlSessionFactory;
    
    
    public MemberDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory =  sqlSessionFactory;
    }
    
    
    
    
    //인터페이스 List 
    public List<Member> selectList() throws Exception{
        //닫아야 하는 자원은 try ()안에 정의하라
        //정상적으로 끝나던 오류가 나던 close
        //반드시 닫아야 하는 자원 
        try (
            SqlSession sqlSession =sqlSessionFactory.openSession()){
            return sqlSession.selectList("member.selectList");
        }
    }
    
    public Member selectOne(String id) throws Exception{
        try (
                SqlSession sqlSession =sqlSessionFactory.openSession()){
                return sqlSession.selectOne("member.selectOne" ,id);
                //mapper이름.sql문 아이디
                //값을 넘겨줄때 ,(콤마) 찍고 뒤에 변수를 넣어준다.
            }
     }
    
    
    public int update(Member member) throws Exception{
        
        try (
                SqlSession sqlSession =sqlSessionFactory.openSession()){
                int count = sqlSession.update("member.update" , member);
                sqlSession.commit();
                return count;
            }
    }
    
    public int delete(String id) throws Exception{
        //멤버에 해당되는 아이디 지우기
        
        try (
                SqlSession sqlSession =sqlSessionFactory.openSession()){
                int count = sqlSession.delete("member.delete" , id);
                sqlSession.commit();
                return count;
            }
        
    }
    
    public int insert(Member member) throws Exception{
       
        try (
                SqlSession sqlSession =sqlSessionFactory.openSession()){
                int count = sqlSession.insert("member.insert" , member);
                sqlSession.commit();
                return count;
                
            }
       
        
    }
    
}
