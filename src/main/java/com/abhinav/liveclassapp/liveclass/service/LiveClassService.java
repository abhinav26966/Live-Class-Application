package com.abhinav.liveclassapp.liveclass.service;

import com.abhinav.liveclassapp.liveclass.exception.ScheduleConflictException;
import com.abhinav.liveclassapp.liveclass.model.LiveClass;
import com.abhinav.liveclassapp.liveclass.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LiveClassService {
    private Map<Long, LiveClass> liveClasses = new HashMap<>();
    public LiveClass createLiveClass(Long id, String title, LocalDateTime startTime, LocalDateTime endTime){
        LiveClass liveClass = new LiveClass();
        liveClass.setId(id);
        liveClass.setTitle(title);
        liveClass.setStartTime(startTime);
        liveClass.setEndTime(endTime);
        liveClasses.put(id, liveClass);
        return liveClass;
    }
    public void assignUserToClass(User user, LiveClass liveClass){
        for(LiveClass lc : user.getAssignedClasses()){
            if(scheduleConfilct(lc, liveClass)){
                throw new ScheduleConflictException("Schedule conflict for user " + user.getName());
            }
        }
        user.getAssignedClasses().add(liveClass);
        liveClass.getAssignedUsers().add(user);
    }
    private boolean scheduleConfilct(LiveClass lc1, LiveClass lc2){
        return lc1.getEndTime().isAfter(lc2.getStartTime()) ||
                lc1.getStartTime().isBefore(lc2.getEndTime());
    }
    public LiveClass getLiveClass(Long id){
        return liveClasses.get(id);
    }
    public List<LiveClass> getAllLiveClasses(){
        return new ArrayList<>(liveClasses.values());
    }
}
