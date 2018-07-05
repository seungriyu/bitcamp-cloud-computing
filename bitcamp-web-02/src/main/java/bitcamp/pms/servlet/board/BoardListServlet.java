package bitcamp.pms.servlet.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>게시물 목록</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>게시물 목록</h1>");
        out.println("<p><a href='form.html'>새 글</a></p>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("    <th>번호</th><th>제목</th><th>등록일</th>");
        out.println("</tr>");
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            try (
                Connection con = DriverManager.getConnection(
                    "jdbc:mysql://13.209.76.8:3306/studydb",
                    "study", "1111");
                PreparedStatement stmt = con.prepareStatement(
                    "select bno,titl,cdt from pms2_board");
                ResultSet rs = stmt.executeQuery();) {
                
                //ArrayList<Board> arr = new ArrayList<>();
                while (rs.next()) {
//                    Board board = new Board();
//                    board.setNo(rs.getInt("bno"));
//                    board.setTitle(rs.getString("titl"));
//                    board.setCreatedDate(rs.getDate("cdt"));
                    out.println("<tr>");
                    out.printf("    <td>%d</td><td><a href='view?no=%d'>%s</a></td><td>%s</td>\n",
                    rs.getInt("bno"),
                    rs.getInt("bno"),
                    rs.getString("titl"),
                    rs.getDate("cdt"));
                    out.println("</tr>");
//                    arr.add(board);
                }
//                return arr;
            }
            //List<Board> list = boardDao.selectList();
           
            out.println("</table>");
        } catch (Exception e) {
            out.println("<p>목록 가져오기 실패!</p>");
            e.printStackTrace(out);
        }
        out.println("</body>");
        out.println("</html>");
    }
}
