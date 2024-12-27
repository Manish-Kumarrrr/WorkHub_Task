package com.manish.WorkHub.repository;

import com.manish.WorkHub.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<Task, String>  {

    List<Task> findTaskByUserId(String userId);

    @Query("{'taskId': ?0}")
    @Update("{ '$set' : { 'status' : ?1 } }")
    void updateStatus(String taskId, String status);

    Page<Task> findTaskByUserId(String userId, Pageable pageable);
    Page<Task> findAll(Pageable pageable);

}
