package com.example;

import java.sql.Date;

public class MoonMission {
    private int missionId;
    private String spacecraft, carrierRocket, operator, missionType, outcome;
    private Date launchDate;

    public MoonMission(int missionId, String spacecraft, Date launchDate, String carrierRocket, String operator, String missionType, String outcome) {
        this.missionId = missionId;
        this.spacecraft = spacecraft;
        this.carrierRocket = carrierRocket;
        this.operator = operator;
        this.missionType = missionType;
        this.outcome = outcome;
        this.launchDate = launchDate;
    }

    public int getMissionId() {
        return missionId;
    }

    public void setMissionId(int missionId) {
        this.missionId = missionId;
    }

    public String getSpacecraft() {
        return spacecraft;
    }

    public void setSpacecraft(String spacecraft) {
        this.spacecraft = spacecraft;
    }

    public String getCarrierRocket() {
        return carrierRocket;
    }

    public void setCarrierRocket(String carrierRocket) {
        this.carrierRocket = carrierRocket;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getMissionType() {
        return missionType;
    }

    public void setMissionType(String missionType) {
        this.missionType = missionType;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %s | Spacecraft: %s | Rocket: %s | Operator: %s | Type: %s | Outcome: %s | Launch date: %s",
                missionId, spacecraft, carrierRocket, operator, missionType, outcome, launchDate
        );
    }
}
