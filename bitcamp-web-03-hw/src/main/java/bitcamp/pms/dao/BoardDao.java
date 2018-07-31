package bitcamp.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bitcamp.pms.domain.Board;

public class BoardDao {
    
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    String jdbcUrl;
    String username;
    String password;
    
    
    
    
    public BoardDao(String jdbcUrl, String username, String password) {
        
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
    }

    public List<Board> selectList() throws Exception{ 
        
        try (
            Connection con = DriverManager.getConnection(
                    jdbcUrl,
                    username, password);
            PreparedStatement stmt = con.prepareStatement(
                "select bno,titl,cdt from pms2_board");
            ResultSet rs = stmt.executeQuery();) {
            
            ArrayList<Board> list = new ArrayList<>();
            System.out.println(list+"22");
             while (rs.next()) {
                 Board board = new Board();
                 
                 board.setBno(rs.getInt("bno"));
                 board.setTitl(rs.getString("titl"));
                 board.setCdt(rs.getDate("cdt"));
                 list.add(board);
             }
             return list;

        }
    }
    
    public void insert(Board board) throws Exception{
       
        try (
                Connection con = DriverManager.getConnection(
                        jdbcUrl,
                        username, password);
            PreparedStatement stmt = con.prepareStatement(
                "insert into pms2_board(titl,cont,cdt) values(?,?,now())");) {
            
            stmt.setString(1, board.getTitl());
            stmt.setString(2, board.getContent());
            stmt.execute();
        }
        
    }
    
    public int delete (int bno) throws Exception{
        
        try (
                Connection con = DriverManager.getConnection(
                        jdbcUrl,
                        username, password);
            PreparedStatement stmt = con.prepareStatement(
                "delete from pms2_board where bno=?");) {
            
            stmt.setInt(1, bno);
            
            
            return stmt.executeUpdate();
            
            
            
        } 
    }
    
    public int update(Board board) throws Exception{
        
        try (
                Connection con = DriverManager.getConnection(
                        jdbcUrl,
                        username, password);
                PreparedStatement stmt = con.prepareStatement(
                        "update pms2_board set titl=?, cont=?, cdt=now() where bno=?");) {
            
            stmt.setString(1, board.getTitl());
            stmt.setString(2, board.getContent());
            stmt.setInt(3, board.getBno());
            
            return stmt.executeUpdate();
            
        }
    }
    
    public Board selectOne(int bno) throws Exception {
        
        try (
                Connection con = DriverManager.getConnection(
                        jdbcUrl,
                        username, password);
                PreparedStatement stmt = con
                        .prepareStatement("select bno,titl,cont,cdt from pms2_board where bno=?");) {

            stmt.setInt(1, bno);
            
            
            
            try (ResultSet rs = stmt.executeQuery();) {
                if (!rs.next()) {
                    return null;
                    
                }
                Board board = new Board();
                board.setBno(rs.getInt("bno"));
                board.setTitl(rs.getString("titl"));
                board.setContent(rs.getString("cont"));
                board.setCdt(rs.getDate("cdt"));
                
               
                return board;
            }
        }
    }
    
    
}
