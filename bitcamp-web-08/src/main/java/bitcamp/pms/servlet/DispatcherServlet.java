package bitcamp.pms.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.annotation.RequestMapping;



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
        
        
        
          //web-08
//        PageController pageController = 
//                (PageController)request.getServletContext().getAttribute(pathInfo);
        
        Object pageController = 
               getServletContext().getAttribute(pathInfo);
        
        
        
        
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
            //web-08
            //페이지 컨트롤러에 있는 메서드 중에서 @RequestMapping이라는 애노테이션이 붙은 메서드를 찾아 호출한다.
            Method requestHandler = getRequestHandler(pageController.getClass()); //
            if (requestHandler == null)
                throw new Exception("요청 핸들러를 찾지 못했습니다.");
//            String view = pageController.service(request, response);
            //페이지 컨트롤러의 메서드를 호출한다.
            String view = (String)requestHandler.invoke(pageController,request, response);
            //첫번쨰 객체 주소
            //두세번쨰는 파라미터 값
            
            
            
            
            
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

    //web-08
    private Method getRequestHandler(Class<?> clazz) {//class에 대한 변수 설정
        
        //클래스 정보에서 메서드 정보를 추출한다.
        //메서드 배열 리턴
        //클래스에서 메서드 목록 꺼내서
        Method[] methods = clazz.getMethods();
        
        //메서드 중에서 @RequestMapping 애노테이션이 붙은 메서드를 찾아낸다.
        for(Method m : methods) {
            //있으면 애노테이션 리턴
            //없으면 null
            //RequestMapping(애노테이션)클래스 타입의 변수 를 찾아주세요 찾았으면 애노테이션 정보를 담은 객체를 리턴 or null
            RequestMapping anno = m.getAnnotation(RequestMapping.class);
            if(anno != null) {
                return m;
            }
        }
        return null;
    }
}
