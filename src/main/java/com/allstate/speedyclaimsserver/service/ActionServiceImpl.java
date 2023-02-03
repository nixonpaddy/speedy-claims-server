package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.data.ActionRepository;
import com.allstate.speedyclaimsserver.domain.Action;
import com.allstate.speedyclaimsserver.domain.Claim;
import com.allstate.speedyclaimsserver.exceptions.ClaimNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ActionServiceImpl implements ActionService {

    @Autowired
    private ActionRepository actionRepository;

    @Override
    public List<Action> getAllActions() {
        return actionRepository.findAll();
    }

    @Override
    public Action saveNewAction(Action action) {
        return actionRepository.save(action);
    }

    @Override
    public List<Action> getActionsByPolicy(Integer policyNumber) {


        List<Action> allActions = actionRepository.findAll();
        Set<Action> foundActions = new HashSet<>();

        for(Action action : allActions){
            if(action.getActionPolicyNumber() == policyNumber){
                foundActions.add(action);
            }
        }

        List<Action> found = new ArrayList<>(foundActions);


        return found;
    }

    }

