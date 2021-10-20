package com.jhjun.book.springboot.web;

import com.jhjun.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController//JSON을 반환하는 컨트롤러
public class HelloController {

    //HTTP Method인 GET의 요청을 받을 수 있는 API를 만들어 준다.
    //예전에는 RequestMapping(method = RequestMethod.GET)으로 사용 되었다.
    // /hello로 요청이 오면 문자열 hello를 반환하는 기능을 가지게 됨.
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    //@RequestParam : 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
    //@RequestParam("name") 외부에서 name이란 이름으로 넘긴 파라미터를 메소드 파라미터 String name에 저장하게 된다.
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
