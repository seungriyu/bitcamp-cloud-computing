package bitcamp.pms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.dao.MemberDao;


public class MemberDeleteController implements PageController {
    
    MemberDao memberDao;
    
    
    public MemberDeleteController(MemberDao memberDao) {
        super();
        this.memberDao = memberDao;
    }

    
    public String service(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        memberDao.delete(request.getParameter("id"));
          return "redirect:list";

    }

}
