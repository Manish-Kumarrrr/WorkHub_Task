package com.manish.WorkHub.service.impl;

import com.manish.WorkHub.dto.TaskRequest;
import com.manish.WorkHub.dto.TaskResponse;
import com.manish.WorkHub.model.Task;
import com.manish.WorkHub.repository.TaskRepository;
import com.manish.WorkHub.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    @Override
    public TaskResponse addTask(TaskRequest taskRequest) {
        taskRequest.setTaskId(null);
        taskRequest.setCreatedDate(new Date());
        System.out.println(taskRequest);
        Task task=taskRepository.save(modelMapper.map(taskRequest,Task.class));
        System.out.println(task);
        return modelMapper.map(task,TaskResponse.class);
    }

    @Override
    public Boolean changeStatus(String taskId, String status) {
        taskRepository.updateStatus(taskId, status);
        return true;
    }

    @Override
    public List<TaskResponse> getAll() {
        List<Task> tasks=taskRepository.findAll();
        List<TaskResponse> taskResponses = new ArrayList<>();
        for(Task task: tasks){
            taskResponses.add(modelMapper.map(task,TaskResponse.class));
        }
        return taskResponses;
    }

    @Override
    public List<TaskResponse> getAllTaskByUserId(String userId) {
        // Fetch tasks by userId (assuming a custom query method exists)
        List<Task> tasks = taskRepository.findTaskByUserId(userId);
        List<TaskResponse> taskResponses = new ArrayList<>();

        // Map each Task entity to TaskResponse DTO
        for (Task task : tasks) {
            taskResponses.add(modelMapper.map(task, TaskResponse.class));
        }
        return taskResponses;
    }

}
