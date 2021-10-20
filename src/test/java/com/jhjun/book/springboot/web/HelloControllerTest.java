package com.jhjun.book.springboot.web;

import com.jhjun.book.springboot.web.HelloController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)//테스트를 진행할때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킨다.
@WebMvcTest(controllers = HelloController.class)//Web에 집중할 수 있는 어노테이션
public class HelloControllerTest {

    @Autowired//스프링이 관리하는 Bean을 주입 받음
    private MockMvc mvc;//웹 API를 테스트할 때 사용한다 //Spring MVC 테스트의 시작점 //이 클래스를 통해 HTTP,GET,POST 등에 대한 API 테스트 가능

    @Test
    public void hello() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))//MockMvc를 통해 /hello 주소로 HTTP GET 요청 //체이닝 지원으로 아래와 같은 여러 검증기능 이어서 선언 가능
                .andExpect(status().isOk())//mvc.perform의 결과 검증 //HTTP Header의 Status를 검증 // 200,400,500 상태 검증 //여기서는 200인지 아닌지 검증
                .andExpect(content().string(hello));//mvc.perform 결과 검증 ///응답 본문의 내용 검증 //Controller에서 hello를 리턴하기 때문에 이 값이 맞는지 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        //param : API 테스트할 때 사용될 요청 팔미터를 설정
        //단, 값은 String 만 허용 (숫자/날짜 등의 데이터는 문자열로 변경 필요)

        //jsonPath : json 응답값을 필드별로 검증할 수 있는 메소드
        //$를 기준으로 필드명을 명시
        mvc.perform(get("/hello/dto").param("name", name).param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }

}
