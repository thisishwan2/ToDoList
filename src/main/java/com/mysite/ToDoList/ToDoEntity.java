package com.mysite.ToDoList;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class ToDoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //컨텐츠 글자길이 200으로 제
    @Column(length = 200)
    private String content;

    //null 허용 여부 설정으로 무조건 y/n 둘중 하나이므로 null은 없다.
    @Column(nullable = false)
    private Boolean completed;
}
