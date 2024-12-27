package com.manish.WorkHub.service;

import com.manish.WorkHub.dto.PaginationResponse;
import com.manish.WorkHub.dto.TaskRequest;
import com.manish.WorkHub.dto.TaskResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService {
    TaskResponse addTask(TaskRequest taskRequest);

    Boolean changeStatus(String id, String status);

    List<TaskResponse> getAll();

    List<TaskResponse> getAllTaskByUserId(String userId);

    PaginationResponse<TaskResponse> getAllTaskByUserId(String userId, Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

    PaginationResponse<TaskResponse> getAllTask(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
}
