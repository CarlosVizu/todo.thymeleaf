package com.vizu.todothymeleaf.serviceImpl;

import com.vizu.todothymeleaf.model.Task;
import com.vizu.todothymeleaf.repository.TaskRepository;
import com.vizu.todothymeleaf.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository data;

    public List<Task> listAll(){
        return data.findAll();
    }

    public Optional<Task> listId(Long id){
        return data.findById(id);
    }

    public Task save(Task p) {
        return data.save(p);
    }

    public void delete(Long id) {
        data.deleteById(id);
    }

    public Optional<Task> getById(Long id) {
        return data.findById(id);
    }
}
