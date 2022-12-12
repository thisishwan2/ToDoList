package com.mysite.ToDoList;

import com.mysite.ToDoList.domain.ToDoEntity;
import com.mysite.ToDoList.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class ToDoController {

    private final ToDoService toDoService;

    @RequestMapping("/todolist")//requestMapping method를 지정하지 않으면, 모든 메서드를 지원한다.
    public String list(Model model){
        List<ToDoEntity> toDoEntityList = this.toDoService.searchAll();
        model.addAttribute("todoEntityList", toDoEntityList);
        return "todolist";
    }

    @RequestMapping("/")
    public String root(){
        return "redirect:/todolist";
    }

    @RequestMapping("/todolist/create")
    public String todoCreate(@RequestParam String title){
        this.toDoService.create(title);
        return "redirect:/todolist";
    }

    @RequestMapping("/todolist/delete/{id}") //문제 아님.
    public String todoDelete(@PathVariable("id") Long id){//여기가 문제 string이 된다.
        this.toDoService.delete(id);
        return "redirect:/todolist";
    }
}
