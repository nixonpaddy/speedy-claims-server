package com.allstate.speedyclaimsserver.control;

import com.allstate.speedyclaimsserver.domain.Claim;
import com.allstate.speedyclaimsserver.exceptions.ClaimNotFoundException;
import com.allstate.speedyclaimsserver.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/claim")
@CrossOrigin
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @GetMapping
    public List<Claim> getAllClaims(@RequestParam(value="type", required=false) String type){
        if(type == null){

            return claimService.getAllClaims();
        } else{
            return claimService.getByClaimType(type);
        }

    }



    @GetMapping("/{claimId}")
    public Claim findById(@PathVariable("claimId") Integer id) throws ClaimNotFoundException {
        return claimService.getById(id);
    }


    @PostMapping
    public Claim saveNewClaim(@RequestBody Claim claim) {
        return claimService.saveClaim(claim);
    }


    @PutMapping("/{id}")
    public Claim updateClaim(@PathVariable Integer id, @RequestBody HashMap<String, Object> fields) {
        return claimService.updateClaim(id, fields);
    }


//    @GetMapping("/{name}")
//    public List<Claim> searchName(@PathVariable("name") String name) throws ClaimNotFoundException {
//        return claimService.searchName(name);
//    }


}
