# bitcamp-cloud-computing
비트캠프 클라우드 컴퓨팅 과정

## web-01 : 웹 프로젝트 폴더 준비
-gradle을 이용하여 프로젝트 폴더를 만드는 방법

## web-xml02 : 서블릿 
- 서블릿으로 웹 애플리케이션을 만들고 배포하는 방법

## web-03 : JDBC 
-JDBC를 이용하여 데이터를 다루는 방법

## web-04 : DAO
- 데이터 처리를 전문으로 하는 DAO 객체를 도입 

## web-05 : 서블릿 + DAO + JSP = MVC 아키텍처
- JSP 기술을 사용하여 출력을 단순화 하는 방법
- MVC 아키텍처의 개념

#########################################################


#bitcamp-web-02 : 서블릿
pms2_member 테이블에 대한 CRUD 서블릿을 만들기

##패키지 생성
bitcamp.pms.servlet 패키지 생성\

## 회원 관리 서블릿 만들기
- servlet-api 의존 라이브러리 추가하기
  - mvnrepository.com 에서 servlet-api 라이브러리 검색
  - build.gradle에 라이브러리 등록
  - 'gradle eclipse' 실행하여 .classpath 갱신
  - 이클립스 프로젝트 refresh
- mysql jdbc driver 의존 라이브러리 추가하기  
-bitcamp.pms.servlet.member 패키지 생성
MemberListServlet, MemberViewServlet, MemberAddServlet, MemberUpdateSErvlet, Member
