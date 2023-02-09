package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.domain.Task;

import java.util.HashMap;
import java.util.List;

public interface TaskService {

    public List<Task> getAllTasks();

    public List<Task> getByClaimLinkedTo(Integer claimId);

    public Task saveNewTask(Task task);

    Task updateTask(Integer id, HashMap<String, Object> fields);

}
