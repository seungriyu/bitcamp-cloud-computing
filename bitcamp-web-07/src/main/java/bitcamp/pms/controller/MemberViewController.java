package bitcamp.pms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;




public class MemberViewController implements PageController{
   
    
    MemberDao memberDao;
    
    public MemberViewController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
    

    public String service(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        
        String id = request.getParameter("id");
        response.setContentType("text/html;charset=UTF-8");
        
        Member member = memberDao.selectOne(id);
        request.setAttribute("member", member);
//      request.setAttribute("view", "/member/view.jsp");
        return "/member/view.jsp";
        
        
       
        
    }
    
    
    
}
