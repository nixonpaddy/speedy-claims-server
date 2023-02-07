package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.data.ClaimRepository;
import com.allstate.speedyclaimsserver.domain.Claim;
import com.allstate.speedyclaimsserver.exceptions.ClaimNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.sql.Date;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin
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

        if(claim.getClaimAmount() >= 500.00){
            claim.setClaimStatus("Transferred");
        }




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


        if (fields.containsKey("claimDate")) {
            String newDate = fields.get("claimDate").toString();
            claim.setClaimDate( Date.valueOf(newDate));
        }


        if (fields.containsKey("claimType")) {
            claim.setClaimType(fields.get("claimType").toString());
        }

        if (fields.containsKey("vehicleMake")) {
            claim.setVehicleMake(fields.get("vehicleMake").toString());
        }

        if (fields.containsKey("vehicleModel")) {
            claim.setVehicleModel(fields.get("vehicleModel").toString());
        }

        if (fields.containsKey("vehicleYear")) {
            if(fields.get("vehicleYear") == ""){
                claim.setVehicleYear(null);
            }else{
                claim.setVehicleYear(new Integer(fields.get("vehicleYear").toString()));
            }
        }

        if (fields.containsKey("propertyAddress")) {
            claim.setPropertyAddress(fields.get("propertyAddress").toString());
        }

        if (fields.containsKey("animalType")) {
            claim.setAnimalType(fields.get("animalType").toString());
        }

        if (fields.containsKey("breedType")) {
            claim.setBreedType(fields.get("breedType").toString());
        }

        if (fields.containsKey("claimAmount")) {
            if(fields.get("claimAmount") == ""){
                claim.setClaimAmount(null);
            }else{
                claim.setClaimAmount(new Double(fields.get("claimAmount").toString()));
            }
        }

        if (fields.containsKey("reasonForClaim")) {
            claim.setReasonForClaim(fields.get("reasonForClaim").toString());
        }


        if (fields.containsKey("claimStatus")) {
            claim.setClaimStatus(fields.get("claimStatus").toString());
        }

        if (fields.containsKey("approvedPayoutAmount")) {
            claim.setApprovedPayoutAmount(fields.get("approvedPayoutAmount").toString());
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


    @Override
    public List<Claim> searchName(String name) {

        List<Claim> allClaims = claimRepository.findAll();
        Set<Claim> foundClaims = new HashSet<>();

        for(Claim claim : allClaims){
            if(claim.getSurname().toLowerCase().contains(name.toLowerCase())){
                foundClaims.add(claim);
            }
        }

        List<Claim> found = new ArrayList<>(foundClaims);


        return found;
    }

    @Override
    public List<Claim> getOpenClaims() {
        List<Claim> allClaims = claimRepository.findAll();
        Set<Claim> foundClaims = new HashSet<>();

        for(Claim claim : allClaims){
            if(claim.getClaimStatus().equals("Awaiting Assessment") ){
                foundClaims.add(claim);
            }
        }

        List<Claim> found = new ArrayList<>(foundClaims);


        return found;
    }

    @Override
    public List<Claim> getArchivedClaims() {
        List<Claim> allClaims = claimRepository.findAll();
        Set<Claim> foundClaims = new HashSet<>();

        for(Claim claim : allClaims){
            if(claim.getClaimStatus().equals("Rejected") || claim.getClaimStatus().equals("Accepted - Paid")  ){
                foundClaims.add(claim);
            }
        }

        List<Claim> found = new ArrayList<>(foundClaims);


        return found;
    }


}
