package bitcamp.pms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.controller.PageController;


@SuppressWarnings("serial") //serial 관련한 경고는 보이지 않게 하기
@WebServlet("/app/*")
public class DispatcherServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        //클라이언트가 무엇을 요청했는지 출력
//        System.out.println(request.getServletPath());
//        System.out.println(request.getPathInfo());
        String pathInfo = request.getPathInfo();
        
        //클라이언트가 요청한 서비스 URL을 알아낸다.
        //즉 /app/* 에서 *에 해당하는 값을 추출한다.
        //예) /app/member/list => /member/list를 추출한다.
        
        
        response.setContentType("text/html;charset=UTF-8");
        
        //ServletContext 보관소에 저장된 페이지 컨트롤러를 찾는다.
//        ServletContext sc = request.getServletContext();
        PageController pageController = 
                (PageController)request.getServletContext().getAttribute(pathInfo);
        
        //페이지 컨트롤러 실행한다.
//        pageController.service(request, response);
        
        
        
        //다른 서블릿(페이지 컨트롤러)로 위임
//        RequestDispatcher rd = request.getRequestDispatcher(pathInfo);
//        rd.include(request, response);
        
        //페이지 컨트롤러가 실행을 끝낸 후 view 이름을 저장한 JSP를 실행한다.
//        String view = (String)request.getAttribute("view");
        try {
            if(pageController == null) 
                throw new Exception("해당 URL에 대해 서비스를 처리할 수 없습니다 ");
            
            String view = pageController.service(request, response);
            if(view.startsWith("redirect:")) {
            //view != null && view.startsWith("redirect:")
            //redirect 로 시작하면 실행
            response.sendRedirect(view.substring(9));
        } else {
                RequestDispatcher rd = request.getRequestDispatcher(view);
                rd.include(request, response);
            }
//        else(view != null) {
//            rd = request.getRequestDispatcher(view);
//            rd.include(request, response);
//            }
        }catch(Exception e){
            request.setAttribute("error", e);
            RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
        
        
        
    }
}
