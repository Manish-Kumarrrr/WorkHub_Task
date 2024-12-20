package com.manish.WorkHub.dto;

import java.util.Date;
import java.util.List;

public class TaskResponse {
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
