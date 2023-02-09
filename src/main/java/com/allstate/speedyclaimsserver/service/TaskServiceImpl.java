package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.data.TaskRepository;
import com.allstate.speedyclaimsserver.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;


    @Override
    public List<Task> getAllTasks() {
        List<Task> tasks =taskRepository.findAll();
        System.out.println("There were " + tasks.size() + " found");
        return tasks;
    }

    @Override
    public List<Task> getByClaimLinkedTo(Integer claimId) {

        List<Task> allTasks = taskRepository.findAll();
        Set<Task> foundTasks = new HashSet<>();

        for(Task task : allTasks){
            if(task.getClaimLinkedTo() == claimId){
                foundTasks.add(task);
            }
        }

        List<Task> found = new ArrayList<>(foundTasks);


        return found;

    }

    @Override
    public Task saveNewTask(Task task) {
        return taskRepository.save(task);
    }





    @Override
    public Task updateTask(Integer id, HashMap<String, Object> fields) {

        Task task = taskRepository.findById(id).get(); //should really check it is there + throw an exception

        //update those fields that have changed
        if (fields.containsKey("taskStatus")) {
            task.setTaskStatus("Completed");
        }

        //save and return the payment
        return taskRepository.save(task);
    }


}
