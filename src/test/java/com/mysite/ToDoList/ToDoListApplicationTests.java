package com.mysite.ToDoList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class ToDoListApplicationTests {

	//테스트를 수행하고 그 후에 db를 비운다.
	@AfterEach
	void clear(){
		new DBConnection();
	}
	@Autowired
	private ToDoRepository toDoRepository;
	@Test
	void testJpa(){
		ToDoEntity todo1 = new ToDoEntity();
		todo1.setContent("eat");
		todo1.setCompleted(Boolean.TRUE);
		this.toDoRepository.save(todo1);

		ToDoEntity todo2 = new ToDoEntity();
		todo2.setContent("play");
		todo2.setCompleted(Boolean.FALSE);
		this.toDoRepository.save(todo2);
	}
}
