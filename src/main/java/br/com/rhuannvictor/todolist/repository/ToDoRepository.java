package br.com.rhuannvictor.todolist.repository;

import br.com.rhuannvictor.todolist.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo,Long> {

}
