package com.mrlonewolfer.example70;

public class FacultyBean {
    int factId;
    String factName,factDeprt,factSubject,factAddress,factDob;

    public FacultyBean(int factId, String factName, String factDeprt, String factSubject, String factAddress, String factDob) {
        this.factId = factId;
        this.factName = factName;
        this.factDeprt = factDeprt;
        this.factSubject = factSubject;
        this.factAddress = factAddress;
        this.factDob = factDob;
    }

    public int getFactId() {
        return factId;
    }

    public void setFactId(int factId) {
        this.factId = factId;
    }

    public String getFactName() {
        return factName;
    }

    public void setFactName(String factName) {
        this.factName = factName;
    }

    public String getFactDeprt() {
        return factDeprt;
    }

    public void setFactDeprt(String factDeprt) {
        this.factDeprt = factDeprt;
    }

    public String getFactSubject() {
        return factSubject;
    }

    public void setFactSubject(String factSubject) {
        this.factSubject = factSubject;
    }

    public String getFactAddress() {
        return factAddress;
    }

    public void setFactAddress(String factAddress) {
        this.factAddress = factAddress;
    }

    public String getFactDob() {
        return factDob;
    }

    public void setFactDob(String factDob) {
        this.factDob = factDob;
    }
}
