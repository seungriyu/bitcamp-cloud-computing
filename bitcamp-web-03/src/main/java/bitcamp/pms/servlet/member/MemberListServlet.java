package bitcamp.pms.servlet.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;

@SuppressWarnings("serial")
@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>멤버 목록</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>멤버 목록</h1>");
        
        out.println("<p><a href='form.html'>새회원</a></p>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("    <th>아이디</th><th>이메일</th>");
        out.println("</tr>");
        
        try {
            //ServletContext sc = this.getServletContext();
            //MemberDao가 필요하면 ServletContext에서 꺼내서 사용
            //모든 Servlet이 공유
            
            MemberDao memberDao = (MemberDao) getServletContext().getAttribute("memberDao"); 
            
             List<Member> list = memberDao.selectList();
             for(Member member : list) {
                 out.println("<tr>");
                 out.printf("    <td><a href='view?id=%s'>%s</a></td><td>%s</td>\n",
                         member.getId(),
                         member.getId(),
                         member.getEmail());
                 out.println("</tr>");
             }
                
        } catch (Exception e) {
            out.println("<p>목록 가져오기 실패!</p>");
            e.printStackTrace(out);
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        
    }
    
    
    
    
    
}
