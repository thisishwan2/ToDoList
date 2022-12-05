package com.mysite.ToDoList;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ToDoController {

    private final ToDoService toDoService;

    @RequestMapping("/todo")
    public String list(Model model){
        List<ToDoEntity> toDoEntityList = this.toDoService.getList();
        model.addAttribute("toDoEntityList", toDoEntityList);
        return "todo";
    }

    @RequestMapping("/")
    public String root(){
        return "redirect:/todo";
    }

    @PostMapping("/todo/create")
    public String todoCreate(@RequestParam String content){
        //content를 입렫하면, 다시 todo메인화면으로 간다.
        this.toDoService.create(content);
        return "redirect:/todo";
    }

    // 삭제 기능
    @DeleteMapping("/todo/delete/{id}")
    public String todoDelete(@PathVariable Integer id){
        this.toDoService.delete(id);
        return "redirect:/todo";
    }
}
