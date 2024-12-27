package com.manish.WorkHub.service.impl;

import com.manish.WorkHub.dto.PaginationResponse;
import com.manish.WorkHub.dto.TaskRequest;
import com.manish.WorkHub.dto.TaskResponse;
import com.manish.WorkHub.model.Task;
import com.manish.WorkHub.repository.TaskRepository;
import com.manish.WorkHub.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    @Override
    public TaskResponse addTask(TaskRequest taskRequest) {
        taskRequest.setTaskId(null);
        taskRequest.setCreatedDate(new Date());
        taskRequest.setStatus("Active");
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
        // Fetch tasks by userId
        List<Task> tasks = taskRepository.findTaskByUserId(userId);
        List<TaskResponse> taskResponses = new ArrayList<>();

        // Map each Task entity to TaskResponse DTO
        for (Task task : tasks) {
            taskResponses.add(modelMapper.map(task, TaskResponse.class));
        }
        return taskResponses;
    }

    @Override
    public PaginationResponse<TaskResponse> getAllTaskByUserId(String userId, Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize, buildSort(sortDir,sortBy));// org.springframework.data.domain

        Page<Task> pageTask=taskRepository.findTaskByUserId(userId, pageable);
        List<Task> allPosts=pageTask.getContent();
        List<TaskResponse> taskResponses=allPosts.stream().map(post -> modelMapper.map(post,TaskResponse.class)).collect(Collectors.toList());
        PaginationResponse<TaskResponse> response=new PaginationResponse<>();
        response.setContent(taskResponses);
        response.setPageNumber(pageTask.getNumber());
        response.setPageSize(pageTask.getSize());
        response.setTotalPages(pageTask.getTotalPages());
        response.setTotalElements(pageTask.getTotalElements());
        response.setLastPage(pageTask.isLast());
        return response;
    }

    @Override
    public PaginationResponse<TaskResponse> getAllTask(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize, buildSort(sortDir,sortBy));// org.springframework.data.domain

        Page<Task> pageTask=taskRepository.findAll(pageable);
        List<Task> allPosts=pageTask.getContent();
        List<TaskResponse> taskResponses=allPosts.stream().map(post -> modelMapper.map(post,TaskResponse.class)).collect(Collectors.toList());
        PaginationResponse<TaskResponse> response=new PaginationResponse<>();
        response.setContent(taskResponses);
        response.setPageNumber(pageTask.getNumber());
        response.setPageSize(pageTask.getSize());
        response.setTotalPages(pageTask.getTotalPages());
        response.setTotalElements(pageTask.getTotalElements());
        response.setLastPage(pageTask.isLast());
        return response;
    }

    Sort buildSort(String sortDir, String sortBy){
        Sort sort=null;
        if(sortDir.equalsIgnoreCase("asc")){
            sort=Sort.by(sortBy).ascending();
        }
        else
            sort=Sort.by(sortBy).descending();
        return sort;
    }

}
