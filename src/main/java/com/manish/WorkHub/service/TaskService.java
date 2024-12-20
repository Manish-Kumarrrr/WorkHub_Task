package com.manish.WorkHub.service;

import com.manish.WorkHub.dto.TaskRequest;
import com.manish.WorkHub.dto.TaskResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService {
    TaskResponse addTask(TaskRequest taskRequest);

    Boolean changeStatus(String id, String status);

    List<TaskResponse> getAll();

    List<TaskResponse> getByUserId(String userId);
}
