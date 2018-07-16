
## 라이브러리 추가
- mvnrepositor.com 에서 spring-context 라이브러리를 찾는다
- 'gradle cleanEclipse'를 실행하여 기존 이클립스 설정을 제거한다.
- 'gradle eclipse' 를 실행하여 이클립스 관련 설정 파일을 새로 만든다.
- 이때 추가한 의존 라이브러리가 자동으로 생성될 것이다.
- 웹 프로젝트를 리프래시 하여 라이브러리 정보를 갱신한다.

## Mybatis에서 제공하는 SqlSessionFactoryBaen 객체 사용하기
- 기존의 SqlSessionFactoryBean 대신에 Mybatis-Spring 에서 제공하는 클래스 사용
- Mybatis를 Spring과 연동하면 DataSource는 Spring에서 설정된 것을 사용해야 한다.
- Mybatis 설정 파일에 등록된 DataSource는 사용하지 않는다.

## Spring에 DataSource 등록하기
- mvnRepository.com 에서 "commons dbcp"를 검색하여 라이브러리를 찾는다.
- 라이브러리를 build.gradle 파일에 등록하고 , gradle을 이용해 가져온다.
- 웹 프로젝트를 리프래시 한다.
- application-context.xml 스프링 설정파일에 DataSource를 설정한다.
- 중요!! Spring에서 DataSource를 설정할 때는 "spring-jdbc" 라이브러리를 추가해야 한다. 
- 트랜잭션 관리자도 Spring에 등록한다.

## DAO 구현체를 자동 생성하는 MapperScannerconfigurer 등록하기
- Mybatis에서 제공하는 DAO 구현체 자동 생성기를 등록하면 개발자가 DAO 클래스를 직접 작성할 필요가 없다.
- 대신 개발자는 DAO 인터페이스만 만드렴ㄴ 된다.

## 기존의 DAO 클래스를 인터페이스로 변경하기
- 기존에 작성된 DAO 클래스를 인터페이스로 변경한다.
- 단 인터페이스명과 SQL 맴퍼의 namespace가 같게 해야 한다.
- 인터페이스의 메서드명과 SQL의 id도 같아야 한다.
- 인터페이스의 메서드 파라미터는 한 개여야 한다.
- 물론 메서드의 파라미터는 SQL의 parameterType과 같아야 한다.
