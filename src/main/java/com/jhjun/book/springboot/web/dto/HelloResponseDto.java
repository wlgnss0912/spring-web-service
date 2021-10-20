package com.jhjun.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter//선택된 모든 필드의 get메소드를 생성해 준다
@RequiredArgsConstructor//선언된 모든 final 필드가 포함된 생성자를 생성해준다. //final이 없는 필드느 생성자에 포함되지 않는다.
public class HelloResponseDto {
    
    //final은 상수임으로 선언과 동시에 초기화 시키는 것이 원칙
    private final String name;
    private final int amount;

}
