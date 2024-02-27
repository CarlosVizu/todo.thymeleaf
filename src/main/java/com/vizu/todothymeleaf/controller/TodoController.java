package com.vizu.todothymeleaf.controller;

import com.vizu.todothymeleaf.model.Task;
import com.vizu.todothymeleaf.repository.TaskRepository;
import com.vizu.todothymeleaf.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/todo")
@AllArgsConstructor
public class TodoController {

    private final TaskRepository data;
    private final TaskService service;

    @GetMapping("/list")
    public String listTask(Model model) {
        List<Task> tasks = service.listAll();

        model.addAttribute("taskList", tasks);
        return "todo";
    }

    @PostMapping("/new")
    public String saveTask(Task task, Model model) {
        service.save(task);
        return "redirect:/todo/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable (value="id") Long id) {
        data.deleteById(id);
        return "redirect:/todo/list";
    }

    @GetMapping("/update/{id}")
    public String updateTask(@PathVariable("id") Long id, Model model) {
        Optional<Task> task = service.getById(id);

        model.addAttribute("task", task.orElseThrow());
        return "updateTask";
    }

    @PostMapping("/update/{id}")
    public String updateTask(@PathVariable("id") Long id, @ModelAttribute("task") Task task, BindingResult result) {
        if (result.hasErrors()) {
            return "updateTask";
        }

        task.setId(id);
        service.save(task);

        return "redirect:/todo/list";
    }
}