package com.abhinav.liveclassapp.liveclass.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
public class LiveClass {
    private Long id;
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Set<User> assignedUsers = new HashSet<>();
}
