package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.data.ClaimRepository;
import com.allstate.speedyclaimsserver.domain.Claim;
import com.allstate.speedyclaimsserver.exceptions.ClaimNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

    @Override
    public Claim updateClaim(Integer id, HashMap<String, Object> fields) {

        Claim claim = claimRepository.findById(id).get(); //should really check it is there + throw an exception

        //update those fields that have changed
        if (fields.containsKey("firstName")) {
            claim.setFirstName(fields.get("firstName").toString());
        }

        if (fields.containsKey("surname")) {
            claim.setSurname(fields.get("surname").toString());
        }


        if (fields.containsKey("claimAmount")) {
            //any logic eg is amount > 0?
            claim.setClaimAmount(Double.parseDouble(fields.get("claimAmount").toString()));
        }

        if (fields.containsKey("otherInfo")) {
            claim.setOtherInfo(fields.get("otherInfo").toString());
        }

//        for (String field : fields.keySet()) {
//            switch(field) {
//                case "country" : payment....
//                                break;
//
//            }
//        }

        //save and return the payment
        return claimRepository.save(claim);
    }


//    @Override
//    public List<Claim> searchName(String name) {
//
//        List<Claim> allClaims = claimRepository.findAll();
//        Set<Claim> foundClaims = new HashSet<>();
//
//        for(Claim claim : allClaims){
//            if(claim.getSurname().contains(name)){
//                foundClaims.add(claim);
//            }
//        }
//
//        List<Claim> found = new ArrayList<>(foundClaims);
//
//
//        return found;
//    }







}
