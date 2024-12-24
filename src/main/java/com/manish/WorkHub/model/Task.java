package com.manish.WorkHub.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document
public class Task {
    @Id
    private String taskId;
    private String userId;
    private String tag;
    private String pay;
    private String email;
    private String phoneNo;
    private Date createdDate;
    private List<String> images;
    private String status;
    private String description;
    private String lattitude;
    private String longitude;
    private String address;
    private String city;
    private String state;
    private String pincode;
}
