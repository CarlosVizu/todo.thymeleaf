package com.vizu.todothymeleaf.service;

import com.vizu.todothymeleaf.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    public List<Task> listAll();
    public Optional<Task> listId(Long id);
    public Task save(Task p);
    public void delete(Long id);

    public Optional<Task> getById(Long id);
}
