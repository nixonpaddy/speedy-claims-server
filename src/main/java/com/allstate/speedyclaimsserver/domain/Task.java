package com.allstate.speedyclaimsserver.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskId;

    private String taskDetails;

    private String taskStatus;

    @Column(name="claim_linked_to")
    private Integer claimLinkedTo;

    @ManyToOne
    private Claim claim;


    public Task(String taskDetails, String taskStatus, Integer claimLinkedTo) {
        //this.taskId = taskId;
        this.taskDetails = taskDetails;
        this.taskStatus = taskStatus;
        this.claimLinkedTo = claimLinkedTo;
    }

    public Task() {
    }


    @JsonIgnore
    public Claim getClaim() {
        return claim;
    }

    public void setClaim(Claim claim) {
        this.claim = claim;
    }

    public Integer getClaimLinkedTo() {
        return claimLinkedTo;
    }

    public void setClaimLinkedTo(Integer claimLinkedTo) {
        this.claimLinkedTo = claimLinkedTo;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskDetails() {
        return taskDetails;
    }

    public void setTaskDetails(String taskDetails) {
        this.taskDetails = taskDetails;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(taskId, task.taskId) && Objects.equals(taskDetails, task.taskDetails) && Objects.equals(taskStatus, task.taskStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, taskDetails, taskStatus);
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskDetails='" + taskDetails + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                '}';
    }
}
