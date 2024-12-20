package com.manish.WorkHub.service;

import com.manish.WorkHub.dto.TaskRequest;
import com.manish.WorkHub.dto.TaskResponse;

public interface TaskService {
    TaskResponse addTask(TaskRequest taskRequest);

    Boolean changeStatus(String id);
}
