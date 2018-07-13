# bitcamp-cloud-computing
비트캠프 클라우드 컴퓨팅 과정

## web-01 : 웹 프로젝트 폴더 준비
-gradle을 이용하여 프로젝트 폴더를 만드는 방법

## web-xml02 : 서블릿 
- 서블릿으로 웹 애플리케이션을 만들고 배포하는 방법

## web-02 : JDBC 
-JDBC를 이용하여 데이터를 다루는 방법

## web-03 : DAO + DTO(VO) + ServletContextListener
- 데이터 처리를 전문으로 하는 DAO 객체를 도입 
- ServletContextListener에서 DAO 객체를 준비한다.
- ServletContext 보관소에 DAO 객체를 저장한다.
- 서블릿은 Servlet

## web-04 : 서블릿 + DAO + JSP = MVC 아키텍처
- JSP 기술을 사용하여 출력을 단순화 하는 방법
- MVC 아키텍처의 개념

## web-05 : Persistence Framework 도입
- DAO에 mybatis 프레임워크를 적용하여 코드와 SQL문을 분리한다.
- 반복적으로 작성했던 JDBC 코드를 캡슐화 한다. 

## web-06 : Front Controller 도입
- 서블릿들이 공통으로 수행하는 작업을 프론트 컨트롤러에게 맡긴다.
- 나머지 서블릿들은 "Page Controller"로 부른다.
- 페이지 컨트롤러 POJO로 만들어도 된다.

## web-07 : Page Controller를 POJO로 변환 
- 프론트 컨트롤러가 도입되면 페이지 컨트롤러는 일반 자바 객체로 만들어도 된다.

## web-08 : 애노테이션으로 요청 핸들러 다루기
- 요청 핸들러(Request Handler) : 클라이언트 요청이 들어 왔을때 호출되는 메서드이다.
  즉, 클라이언트 요청을 처리하는 메서드.
 - 인터페이스를 구현하는 대신에 애노테이션으로 요청 핸들러를 표시하여 프론트 컨트롤러가 찾게 한다.
 - 이렇게 함으로써 페이지 컨트롤러를 맨들 때 특정 인터페이스에 종속되지 않게 한다.

## web-09 : 객체 생성을 자동화하기 위해 IOC컨테이너를 만들기
- IoC 컨테이너를 통해 페이지 컨트롤러의 객체를 자동 생성한다.
- 페이지 컨트롤러의 의존 객체를 자동으로 주입한다.

## web-10 : Spring IoC 컨테이너 도입
- 기존 직접 만든 IoC 컨테이너 대신에 스프링 컨테이너를 사용한다.

