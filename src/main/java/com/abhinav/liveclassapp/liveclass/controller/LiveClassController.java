package com.abhinav.liveclassapp.liveclass.controller;

import com.abhinav.liveclassapp.liveclass.dto.LiveClassDTO;
import com.abhinav.liveclassapp.liveclass.dto.UserDTO;
import com.abhinav.liveclassapp.liveclass.model.LiveClass;
import com.abhinav.liveclassapp.liveclass.model.User;
import com.abhinav.liveclassapp.liveclass.service.LiveClassService;
import com.abhinav.liveclassapp.liveclass.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class LiveClassController {

    private final LiveClassService liveClassService;
    private final UserService userService;
    @Autowired
    public LiveClassController(LiveClassService liveClassService, UserService userService){
        this.liveClassService = liveClassService;
        this.userService = userService;
    }
    @PostMapping("/users")
    public User createUser(@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO.getId(), userDTO.getName());
    }
    @PostMapping("/live-classes")
    public LiveClass createLiveClass(@RequestBody LiveClassDTO liveClassDTO){
        return liveClassService.createLiveClass(liveClassDTO.getId(),
                liveClassDTO.getTitle(), liveClassDTO.getStartTime(),
                liveClassDTO.getEndTime());
    }
    @PostMapping("/live-classes/{classId}/assign")
    public String assignUserToClass(@PathVariable Long classId, @RequestParam Long userId){
        LiveClass liveClass = liveClassService.getLiveClass(classId);
        User user = userService.getUser(userId);
        liveClassService.assignUserToClass(user, liveClass);
        return "User Assigned successfully (live class assigned)";
    }
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable Long userId){
        return userService.getUser(userId);
    }
    @GetMapping("/users/{userId}/classes")
    public Set<LiveClass> getUserAssignedClasses(@PathVariable Long userId){
        User user = userService.getUser(userId);
        return user.getAssignedClasses();
    }
    @GetMapping("/live-classes/{classId}/users")
    public Set<User> getUserInClass(@PathVariable Long classId){
        LiveClass liveClass = liveClassService.getLiveClass(classId);
        return liveClass.getAssignedUsers();
    }
    @GetMapping("/live-classes")
    public List<LiveClass> getAllLiveClasses(){
        return liveClassService.getAllLiveClasses();
    }
}
