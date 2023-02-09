package com.allstate.speedyclaimsserver.data;

import com.allstate.speedyclaimsserver.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findAllByClaimLinkedTo(Integer claimId);


}
