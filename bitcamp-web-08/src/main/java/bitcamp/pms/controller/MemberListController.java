package bitcamp.pms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;


public class MemberListController {
    
    MemberDao memberDao;
    
    public MemberListController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
    
    //protected -> public 규칙은 공개되어야함
    @RequestMapping //프론트 컨트롤러에 요청 >> 이 메서드 요청하라고
    public String list(HttpServletRequest request, HttpServletResponse response)  throws Exception
            {
        // TODO Auto-generated method stub
        
        //페이징처리
        //DB에서 가져올 데이터의 페이지 정보
        HashMap<String, Object> params = new HashMap<>();
        if(request.getParameter("page")!= null && request.getParameter("size") != null) {
            int page = Integer.parseInt(request.getParameter("page"));
            int size = Integer.parseInt(request.getParameter("size"));
            params.put("startIndex", (page -1)*size);
            params.put("pageSize", size);
            //시작인덱스 = page -1 * 3
        }
        
        
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();

        
            // ServletContext sc = this.getServletContext();
            // MemberDao가 필요하면 ServletContext에서 꺼내서 사용
            // 모든 Servlet이 공유


            List<Member> list = memberDao.selectList(params);
            request.setAttribute("list", list);
            //에러가 나지 않았을때 뷰를 저장
//            request.setAttribute("view", "/member/list.jsp");
            return "/member/list.jsp";
            
   //에러 내용 저장하고 끝
            
            
        

    }

}
