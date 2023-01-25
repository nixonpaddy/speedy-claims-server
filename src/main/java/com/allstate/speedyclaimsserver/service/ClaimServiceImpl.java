package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.data.ClaimRepository;
import com.allstate.speedyclaimsserver.domain.Claim;
import com.allstate.speedyclaimsserver.exceptions.ClaimNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaimServiceImpl implements ClaimService {

    @Autowired
    private ClaimRepository claimRepository;


    @Override
    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }

    @Override
    public Claim getById(Integer id) throws ClaimNotFoundException {

        Optional<Claim> optionalClaim = claimRepository.findById(id);
        if(optionalClaim.isPresent()){
            return optionalClaim.get();
        }
        else{
            throw new ClaimNotFoundException("There is no claim with ID " + id);
        }
    }

//    @Override
//    public List<Claim> getByClaimType(String type) {
//        return null;
//    }

    @Override
    public List<Claim> getByClaimType(String type) {
        return claimRepository.findAllByClaimType(type);
    }

    @Override
    public Claim saveClaim(Claim claim) {
        return claimRepository.save(claim);
    }
}
