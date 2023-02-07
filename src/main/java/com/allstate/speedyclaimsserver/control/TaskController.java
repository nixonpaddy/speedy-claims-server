package com.allstate.speedyclaimsserver.control;


import com.allstate.speedyclaimsserver.domain.Task;
import com.allstate.speedyclaimsserver.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/task")
public class TaskController {


    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }


    @GetMapping("/{claimId}")
    public List<Task> findByClaimLinkedTo(@PathVariable("claimId")Integer claimId) {
        return taskService.getByClaimLinkedTo(claimId);
    }


}
