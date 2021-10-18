package com.jhjun.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
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
}
