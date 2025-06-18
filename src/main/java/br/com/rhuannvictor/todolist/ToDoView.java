package br.com.rhuannvictor.todolist;

import br.com.rhuannvictor.todolist.entity.ToDo;
import br.com.rhuannvictor.todolist.service.ToDoService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("")
public class ToDoView extends VerticalLayout {

    private final ToDoService service;
    private final Grid<ToDo> grid = new Grid<>(ToDo.class);

    public ToDoView(@Autowired ToDoService service) {
        this.service = service;

        TextField nome = new TextField("Nome");
        TextField descricao = new TextField("Descrição");
        TextField prioridade = new TextField("Prioridade");
        TextField Id = new TextField("Id");
        Checkbox realizado = new Checkbox("Realizado");

        Button adicionar = new Button("Adicionar tarefa", e -> {
            try {
                ToDo nova = new ToDo(
                        nome.getValue(),
                        descricao.getValue(),
                        realizado.getValue(),
                        Integer.parseInt(prioridade.getValue())
                );
                service.creat(nova);
                atualizarGrid();
            } catch (Exception ex) {
                ex.printStackTrace(); // tratamento básico
            }
        });

        Button remover = new Button("Remover tarefa", e -> {
          Id.getValue();
          service.delete(Long.parseLong(Id.getValue()));
          atualizarGrid();
        });

        grid.setColumns("ID","nome", "descricao", "realizado", "prioridade");
        atualizarGrid();

        add(nome, descricao, prioridade, realizado, adicionar,Id,remover, grid);
    }

    private void atualizarGrid() {
        grid.setItems(service.list());
    }
}

