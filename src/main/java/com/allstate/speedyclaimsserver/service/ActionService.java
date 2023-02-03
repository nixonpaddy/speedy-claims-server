package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.domain.Action;
import com.allstate.speedyclaimsserver.domain.Claim;

import java.util.List;

public interface ActionService {

    List<Action> getAllActions();

    public Action saveNewAction(Action action);

    List<Action> getActionsByPolicy(Integer policyNumber);




}
