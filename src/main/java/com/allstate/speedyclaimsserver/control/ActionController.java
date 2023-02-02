package com.allstate.speedyclaimsserver.control;

import com.allstate.speedyclaimsserver.domain.Action;
import com.allstate.speedyclaimsserver.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/action")
public class ActionController {


    @Autowired
    private ActionService actionService;



    @GetMapping("/{claimId}")
    public List<Action> getAllActions(){
        return actionService.getAllActions();
    }

}
