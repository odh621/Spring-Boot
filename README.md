Start-SpringBoot
===
* 2018 1학기에 진행한 Spring Boot 수업을 들으면서 작성한 코드 및 자료를 정리 및 버전관리를 위한 저장소입니다.

    * 처음으로 Spring에 대해 공부했던 자료를 정리해둔 저장소라서 저장소 이름은 Start-SpringBoot 입니다. 

* 수업을 수강하며 작성했던 예제 코드들도 같이 있습니다.

* 수업을 마무리하며 Term-Project로 제출했던 Term-Resume이 있습니다.

    * Term-Resume 프로젝트 URL : https://donghun.dev:8082

## 개발환경

|도구|버전|
|:---:|:---:|
| Framework |Spring Boot 2.0.2 |
| OS |Windows 10, Ubuntu 18.04|
|IDE |IntelliJ IDEA Ultimate |
|JDK |JDK 1.8|
|DataBase |MySQL Server 5.7|
|Build Tool | Maven 4.0.0|

## Term-Resume 실행 방법.
<details><summary>세부정보</summary>

* 준비사항.
    
    * IntelliJ IDEA

    * JDK (>= 1.8)

    * Spring Boot (>= 2.x)

* 저장소를 `clone`

    ```bash
    $ git clone https://github.com/donghL-dev/Start-SpringBoot.git
    ```
* DB는 MySQL을 쓴다고 가정.

    * 다른 DB를 사용한다면, 그 DB에 맞게 설정을 해야함.

* 프로젝트 내 src\term-resume\src\main\resources 경로에 `application.yml` 생성.

    * 밑의 양식대로 내용을 채운 뒤, `application.yml` 내용 삽입.
    <br>

    ```yml
    spring:
        datasource:
            url: jdbc:mysql://localhost/본인_DB
            username: 본인_DB_User
            password: 본인_DB_User_Password
            driver-class-name: com.mysql.jdbc.Driver
        jpa:
            hibernate:
            ddl-auto: create
    ```

* IntelliJ IDEA(>= 2018.3)에서 해당 프로젝트를 `Open`

</details>

