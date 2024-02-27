package com.vizu.todothymeleaf.repository;

import com.vizu.todothymeleaf.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Long> {
}
