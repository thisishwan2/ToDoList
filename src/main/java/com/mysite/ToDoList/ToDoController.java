package com.mysite.ToDoList;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ToDoController {

    private final ToDoRepository toDoRepository;

    @RequestMapping("/todo")
    public String list(Model model){
        List<ToDoEntity> toDoEntityList = this.toDoRepository.findAll();
        model.addAttribute("toDoEntityList", toDoEntityList);
        return "todolist";
    }

    @RequestMapping("/")
    public String root(){
        return "redirect:/todo";
    }
}
