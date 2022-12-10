package com.mysite.ToDoList.repository;

import com.mysite.ToDoList.domain.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
//JpaRepository 인터페이스를 상속. 리포지터리의 대상이 되는 엔티티의 타입과 해당 엔티티의 PK의 속성 타입을 지정해야함.
public interface ToDoRepository extends JpaRepository<ToDoEntity, Long> {
}
