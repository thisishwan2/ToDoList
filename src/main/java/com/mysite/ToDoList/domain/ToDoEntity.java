package com.mysite.ToDoList.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class ToDoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String title;

//    //order는 db의 예약어로 쓰이므로 컬럼명 지정
//    @Column(name = "todoOrder", nullable = false)
//    private Long order;

    @Column(nullable = false)
    private Boolean completed;
}
