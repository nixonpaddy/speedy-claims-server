package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.domain.Claim;
import com.allstate.speedyclaimsserver.exceptions.ClaimNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.HashMap;
import java.util.List;

@CrossOrigin
public interface ClaimService {

    public List<Claim> getAllClaims();

    public Claim getById(Integer id) throws ClaimNotFoundException;

//    public List<Claim> getByInsuranceType(String type);

    List<Claim> getByClaimType(String type);

    public Claim saveClaim(Claim claim);

    Claim updateClaim(Integer id, HashMap<String, Object> fields);

    public List<Claim> searchName(String name) throws ClaimNotFoundException;

    public List<Claim> getOpenClaims();

    public List<Claim> getArchivedClaims();
}
