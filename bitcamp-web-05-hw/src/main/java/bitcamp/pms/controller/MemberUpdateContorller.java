package bitcamp.pms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;


public class MemberUpdateContorller implements PageController {
    
    MemberDao memberDao;
    
    
    public MemberUpdateContorller(MemberDao memberDao) {
        super();
        this.memberDao = memberDao;
    }


    public String service(HttpServletRequest request, HttpServletResponse response) 
            throws Exception {
        
        
        
            
            Member member = new Member();
            member.setId(request.getParameter("id"));
            member.setEmail(request.getParameter("email"));
            member.setPassword(request.getParameter("password"));
           
           
                if (memberDao.update(member) == 0) {
                   
                   return "/member/updatefail.jsp";
                   
                } else {
                    return "redirect:list";
                }
            
            
      
      
    }
    
    
     
}
