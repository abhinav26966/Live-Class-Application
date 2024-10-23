package com.abhinav.liveclassapp.liveclass.model;

import lombok.Data;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Data
public class User {
    private Long id;
    private String name;
    @Getter
    private Set<LiveClass> assignedClasses = new HashSet<>();
}
