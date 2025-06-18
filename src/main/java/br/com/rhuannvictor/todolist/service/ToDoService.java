package br.com.rhuannvictor.todolist.service;

import br.com.rhuannvictor.todolist.entity.ToDo;
import br.com.rhuannvictor.todolist.repository.ToDoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    private ToDoRepository ToDoRepository;
    public ToDoService(ToDoRepository toDoRepository) {
        ToDoRepository = toDoRepository;
    }

    public List<ToDo> creat(ToDo toDo){
        ToDoRepository.save(toDo);
        return list();
    }

    public List<ToDo> list(){
        Sort sort = Sort.by("prioridade").descending().and(Sort.by("nome")
                .ascending());
        return ToDoRepository.findAll(sort);
    }

    public List<ToDo> update(ToDo toDo){
        ToDoRepository.save(toDo);
        return list();
    }
    public List<ToDo> delete(Long id){
        ToDoRepository.deleteById(id);
        return list();
    }
}
