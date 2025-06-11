package br.com.rhuannvictor.todolist.service;

import br.com.rhuannvictor.todolist.entity.ToDo;
import br.com.rhuannvictor.todolist.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    private ToDoRepository ToDoRepository;
    public ToDoService(ToDoRepository toDoRepository) {
        ToDoRepository = toDoRepository;
    }

    public List<ToDo> creat(){

    }
    public List<ToDo> list(){

    }
    public List<ToDo> upadte(){

    }
    public List<ToDo> delete(){

    }
}
