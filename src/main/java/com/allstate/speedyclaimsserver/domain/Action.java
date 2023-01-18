package com.allstate.speedyclaimsserver.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer actionId;
    private String actionTaken;
    private Integer actionPolicyNumber;


    public Action(Integer actionId, String actionTaken, Integer actionPolicyNumber) {
        this.actionId = actionId;
        this.actionTaken = actionTaken;
        this.actionPolicyNumber = actionPolicyNumber;
    }


    public Action() {
    }






    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public String getActionTaken() {
        return actionTaken;
    }

    public void setActionTaken(String actionTaken) {
        this.actionTaken = actionTaken;
    }

    public Integer getActionPolicyNumber() {
        return actionPolicyNumber;
    }

    public void setActionPolicyNumber(Integer actionPolicyNumber) {
        this.actionPolicyNumber = actionPolicyNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Action action = (Action) o;
        return Objects.equals(actionId, action.actionId) && Objects.equals(actionTaken, action.actionTaken) && Objects.equals(actionPolicyNumber, action.actionPolicyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actionId, actionTaken, actionPolicyNumber);
    }

    @Override
    public String toString() {
        return "Action{" +
                "actionId=" + actionId +
                ", actionTaken='" + actionTaken + '\'' +
                ", actionPolicyNumber=" + actionPolicyNumber +
                '}';
    }
}