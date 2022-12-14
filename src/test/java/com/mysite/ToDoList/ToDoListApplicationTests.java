package com.mysite.ToDoList;

import com.mysite.ToDoList.domain.ToDoEntity;
import com.mysite.ToDoList.repository.ToDoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
class ToDoListApplicationTests {

	@Autowired
	private ToDoRepository toDoRepository;

	@Test
	void test(){
		ToDoEntity toDoEntity1 = new ToDoEntity();
		toDoEntity1.setTitle("a");
		toDoEntity1.setCompleted(Boolean.TRUE);
		toDoRepository.save(toDoEntity1);

		ToDoEntity toDoEntity2 = new ToDoEntity();
		toDoEntity2.setTitle("b");
		toDoEntity2.setCompleted(Boolean.FALSE);
		toDoRepository.save(toDoEntity2);

		List<ToDoEntity> result = toDoRepository.findAll();

		assertThat(result.size()).isEqualTo(2);
		assertThat(toDoEntity1.getId()).isEqualTo(1);
		assertThat(toDoEntity2.getId()).isEqualTo(2);
	}
}
