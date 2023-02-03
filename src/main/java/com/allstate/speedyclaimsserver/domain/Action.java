package com.allstate.speedyclaimsserver.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer actionId;
    private String actionTaken;
    private Integer actionPolicyNumber;

    private Date actionDate;

    @ManyToOne
    private Claim claim;


    public Action(String actionTaken, Integer actionPolicyNumber, Date actionDate) {
        //this.actionId = actionId;
        this.actionTaken = actionTaken;
        this.actionPolicyNumber = actionPolicyNumber;
        this.actionDate = actionDate;
    }


    public Action() {
    }


    @JsonIgnore
    public Claim getClaim() {
        return claim;
    }

    public void setClaim(Claim claim) {
        this.claim = claim;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
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
