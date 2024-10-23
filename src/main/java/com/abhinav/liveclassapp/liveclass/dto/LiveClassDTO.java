package com.abhinav.liveclassapp.liveclass.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LiveClassDTO {
    private  Long id;
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
