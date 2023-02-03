package com.allstate.speedyclaimsserver.control;

import com.allstate.speedyclaimsserver.domain.Action;
import com.allstate.speedyclaimsserver.domain.Claim;
import com.allstate.speedyclaimsserver.exceptions.ClaimNotFoundException;
import com.allstate.speedyclaimsserver.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/action")
public class ActionController {


    @Autowired
    private ActionService actionService;


    @GetMapping
    public List<Action> getAllActions() {
        return actionService.getAllActions();
    }


    @PostMapping
    public Action saveNewAction(@RequestBody Action action) {
        return actionService.saveNewAction(action);
    }


//    @GetMapping
//    public List<Action> getActionsByPolicy() {
//        return actionService.getAllActions();
//    }


    @GetMapping("{policyId}")
    public List<Action> getActionsByPolicy(@PathVariable("policyId") Integer policyId) throws ClaimNotFoundException {
        return actionService.getActionsByPolicy(policyId);
    }


}