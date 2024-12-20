package com.manish.WorkHub.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class TaskRequest {
    private String taskId;
    private String userId;
    private String tag;
    private String charge;
    private String emailId;
    private String phoneNo;
    private Date createdDate;
    private List<String> images;
    private Boolean status;
}
