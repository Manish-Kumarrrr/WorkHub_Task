package com.manish.WorkHub.service.impl;

import com.manish.WorkHub.dto.TaskRequest;
import com.manish.WorkHub.dto.TaskResponse;
import com.manish.WorkHub.model.Task;
import com.manish.WorkHub.repository.TaskRepository;
import com.manish.WorkHub.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    @Override
    public TaskResponse addTask(TaskRequest taskRequest) {
        Task task=taskRepository.save(modelMapper.map(taskRequest,Task.class));
        return modelMapper.map(task,TaskResponse.class);
    }

    @Override
    public Boolean changeStatus(String id) {
        return true;
    }
}
