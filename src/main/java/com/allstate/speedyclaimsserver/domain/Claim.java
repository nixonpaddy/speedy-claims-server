package com.allstate.speedyclaimsserver.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer policyNumber;
    private String surname;
    private String firstName;
    private Date claimDate;
    private String claimType;
    private String vehicleMake;
    private String vehicleModel;
    private Integer vehicleYear;
    private String propertyAddress;
    private String animalType;
    private String breedType;
    private Double claimAmount;
    private String reasonForClaim;
    private String otherInfo;
    private String claimStatus;
    private String approvedPayoutAmount;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Action> actions;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Task> tasks;

    //private String[] actionsLog;



    public Claim(String surname, String firstName, Date claimDate, String claimType, String vehicleMake, String vehicleModel, Integer vehicleYear, String propertyAddress, String animalType, String breedType, Double claimAmount, String reasonForClaim, String otherInfo, String claimStatus, String approvedPayoutAmount, List<Action> actions, List<Task> tasks) {
        //this.policyNumber = policyNumber;
        this.surname = surname;
        this.firstName = firstName;
        this.claimDate = claimDate;
        this.claimType = claimType;
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.vehicleYear = vehicleYear;
        this.propertyAddress = propertyAddress;
        this.animalType = animalType;
        this.breedType = breedType;
        this.claimAmount = claimAmount;
        this.reasonForClaim = reasonForClaim;
        this.otherInfo = otherInfo;
        this.claimStatus = claimStatus;
        this.approvedPayoutAmount = approvedPayoutAmount;
        //this.actionsLog = actionsLog;
        this.actions = actions;
        this.tasks = tasks;
    }


    public Claim() {
    }

    public Integer getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(Integer policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public Integer getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(Integer vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getBreedType() {
        return breedType;
    }

    public void setBreedType(String breedType) {
        this.breedType = breedType;
    }

    public Double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(Double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public String getReasonForClaim() {
        return reasonForClaim;
    }

    public void setReasonForClaim(String reasonForClaim) {
        this.reasonForClaim = reasonForClaim;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    public String getApprovedPayoutAmount() {
        return approvedPayoutAmount;
    }

    public void setApprovedPayoutAmount(String approvedPayoutAmount) {
        this.approvedPayoutAmount = approvedPayoutAmount;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Claim claim = (Claim) o;
        return Objects.equals(policyNumber, claim.policyNumber) && Objects.equals(surname, claim.surname) && Objects.equals(firstName, claim.firstName) && Objects.equals(claimDate, claim.claimDate) && Objects.equals(claimType, claim.claimType) && Objects.equals(vehicleMake, claim.vehicleMake) && Objects.equals(vehicleModel, claim.vehicleModel) && Objects.equals(vehicleYear, claim.vehicleYear) && Objects.equals(propertyAddress, claim.propertyAddress) && Objects.equals(animalType, claim.animalType) && Objects.equals(breedType, claim.breedType) && Objects.equals(claimAmount, claim.claimAmount) && Objects.equals(reasonForClaim, claim.reasonForClaim) && Objects.equals(otherInfo, claim.otherInfo) && Objects.equals(claimStatus, claim.claimStatus) && Objects.equals(approvedPayoutAmount, claim.approvedPayoutAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber, surname, firstName, claimDate, claimType, vehicleMake, vehicleModel, vehicleYear, propertyAddress, animalType, breedType, claimAmount, reasonForClaim, otherInfo, claimStatus, approvedPayoutAmount);
    }


    @Override
    public String toString() {
        return "Claim{" +
                "policyNumber=" + policyNumber +
                ", surname='" + surname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", claimDate=" + claimDate +
                ", claimType='" + claimType + '\'' +
                ", vehicleMake='" + vehicleMake + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", vehicleYear=" + vehicleYear +
                ", propertyAddress='" + propertyAddress + '\'' +
                ", animalType='" + animalType + '\'' +
                ", breedType='" + breedType + '\'' +
                ", claimAmount=" + claimAmount +
                ", reasonForClaim='" + reasonForClaim + '\'' +
                ", otherInfo='" + otherInfo + '\'' +
                ", claimStatus='" + claimStatus + '\'' +
                ", approvedPayoutAmount='" + approvedPayoutAmount + '\'' +
                '}';
    }
}
