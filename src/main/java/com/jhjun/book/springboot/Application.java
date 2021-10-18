package com.jhjun.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//스프링 부트의 자동설정, 스프링 Bean 읽기, 생성 모두 자동으로 설정된다.
//@SpringBootApplication이 있는 위치부터 설정을 읽어나간다.
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);//스프링 부트의 내장 AWS를 실행한다.
    }
}
