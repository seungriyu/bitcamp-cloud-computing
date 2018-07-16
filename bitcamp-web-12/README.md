## web-12 : Spirng WebMVC의 ContextLoaderListener 사용하기
- 기존에 직접 만든 ContextLoaderListener 대신에 Spring WebMVC에서 제공하는 클래스를 사용한다.


## 라이브러리 추가
- mvnrepositor.com 에서 spring webMVC 라이브러리를 찾는다
- build.gardle에 의존 라이브러리 정보를 추가한다.
- 'gradle cleanEclipse'를 실행하여 기존 이클립스 설정을 제거한다.
- 'gradle eclipse' 를 실행하여 이클립스 관련 설정 파일을 새로 만든다.
- 이때 추가한 의존 라이브러리가 자동으로 생성될 것이다.
- 웹 프로젝트를 리프래시 하여 라이브러리 정보를 갱신한다.

## Spring WebMVC의 ContextLoaderListener 사용하기
- 기존에 직접 작성했던 ContextLoaderListener 대신에 Spring WebMVC에서 제공하는
  ContextLoaderLIstener 클래스를 사용한다.
-/WEB-INF/web.xml 에 리스너를 등록한다

## Spring CharacterEncodingFilter 사용하기
- 기존에 직접 작성한 CharacterEncodingFilter 대신에 Spirng에 Filter를 사용하여 POST 한글 파라미터 값을 깨지지 않도록 처리한다.
