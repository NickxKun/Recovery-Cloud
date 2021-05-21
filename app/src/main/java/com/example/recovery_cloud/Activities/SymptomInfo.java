package com.example.recovery_cloud.Activities;

public class SymptomInfo {
    private String userEmail;
    private Integer spO2;
    private Float temp;
    private Boolean fever,breath,senses,fatigue,depr,cough;


    public SymptomInfo() {

    }

    public Boolean getFever(){
        return fever;
    }
    public Boolean getBreath(){
        return breath;
    }
    public Boolean getSenses(){
        return senses;
    }
    public Boolean getFatigue(){
        return fatigue;
    }
    public Boolean getDepr(){
        return depr;
    }
    public Boolean getCough(){
        return cough;
    }
    public Integer getOxi(){
        return spO2;
    }
    public Float getTemp(){
        return temp;
    }

    public void setFever(Boolean fever){
        this.fever = fever;
    }
    public void setBreath(Boolean breath){
        this.breath = breath;
    }
    public void setSenses(Boolean senses){
        this.senses = senses;
    }
    public void setFatigue(Boolean fatigue){
        this.fatigue = fatigue;
    }
    public void setDepr(Boolean depr){
        this.depr = depr;
    }
    public void setCough(Boolean cough){
        this.cough = cough;
    }
    public void setSpO2(Integer spO2){
        this.spO2 = spO2;
    }
    public void setTemp(Float temp){
        this.temp = temp;
    }
    public void setEmail(String email){
        this.userEmail = email;
    }
}
