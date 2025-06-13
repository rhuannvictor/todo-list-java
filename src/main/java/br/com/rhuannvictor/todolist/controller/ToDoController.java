package br.com.rhuannvictor.todolist.controller;

import br.com.rhuannvictor.todolist.entity.ToDo;
import br.com.rhuannvictor.todolist.service.ToDoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class ToDoController {
   private ToDoService toDoService;
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @PostMapping
    List<ToDo> create (@RequestBody ToDo toDo){
    return toDoService.creat(toDo);
   }
   @GetMapping
   List<ToDo> list (){
    return toDoService.list();
   }
   @PutMapping
   List<ToDo> upadte (@RequestBody ToDo toDo){
    return toDoService.upadte(toDo);
   }
   @DeleteMapping("{id}")
   List<ToDo> delete (@PathVariable("id") Long id){
    return toDoService.delete(id);
   }
}
