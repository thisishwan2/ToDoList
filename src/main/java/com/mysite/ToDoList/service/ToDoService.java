package com.mysite.ToDoList.service;

import com.mysite.ToDoList.domain.ToDoEntity;
import com.mysite.ToDoList.repository.ToDoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class ToDoService {

    private ToDoRepository toDoRepository;

    //할일 생성
    public void create(String title){
        ToDoEntity toDoEntity = new ToDoEntity();
        toDoEntity.setTitle(title);
        toDoEntity.setCompleted(false);
        this.toDoRepository.save(toDoEntity);
    }

    //할일 전체 조회
    public List<ToDoEntity> searchAll(){
        return this.toDoRepository.findAll();
    }

    //삭제
    @Transactional
    public void delete(Long id){
        ToDoEntity toDoEntity = toDoRepository.findById(id).
                orElseThrow(()-> new IllegalArgumentException("해당 아이템이 없습니다. id=" + id));
        this.toDoRepository.delete(toDoEntity);
    }
}
