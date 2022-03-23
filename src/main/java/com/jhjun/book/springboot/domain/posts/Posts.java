package com.jhjun.book.springboot.domain.posts;

import com.jhjun.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter//Lombok : 클래스 내 모든 필드 Getter 메소드를 자동 생성
@NoArgsConstructor//Lombok : 기본 생성자 자동 추가 (public Posts() {})와 같은 효과)
@Entity//JPA : 중요도가 높은 어노테이션을 class 가까이 둔다 : 1.테이블과 링크될 클래스
//기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭한다. (SalesManager.java -> salse_manager table)
public class Posts extends BaseTimeEntity {

    @Id//2.해당 테이블의 Pk 필드를 나타낸다
    @GeneratedValue(strategy = GenerationType.IDENTITY)//3.PK의 생성 규칙을 나타낸다 (스프링 부트 2.0에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto_increment가 된다.)
    private Long id;

    @Column(length = 500, nullable = false)//4.테이블 컬럼을 나타낸다. 굳이 선언하지 않아도 해당 클래스의 필드는 모두 컬럼이 된다.
    private String title;//그래도 사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵션이 있을 경우 사용한다.
    //문자열의 경우 VARCHAR(255)가 기본인데, 사이즈를 500으로 늘리고 싶거나, 타입을 TEXT로 변경하고 싶을 경우 사용.

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder//해당 클래스의 빌더 패턴 클래스 생성, 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    //테이블 update
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
