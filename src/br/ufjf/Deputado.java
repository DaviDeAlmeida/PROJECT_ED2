package com.company;

import java.util.ArrayList;

public class Deputado {
    private String DeputyName;
    private String PoliticalParty;
    private String StateCode;
    private int DeputyId;
    private int BuggedDate;
    private ArrayList<Recibo> Receipt = new ArrayList<Recibo>();

    public Deputado(String deputyName, String politicalParty, String stateCode, int deputyId, int buggedDate, Recibo receipt) {
        this.DeputyName = deputyName;
        this.PoliticalParty = politicalParty;
        this.StateCode = stateCode;
        this.DeputyId = deputyId;
        this.BuggedDate = buggedDate;
        this.Receipt.add(receipt);
    }

    public ArrayList<Recibo> getReceipt() {
        return Receipt;
    }

    public void setReceipt(Recibo receipt) {
        this.Receipt.add(receipt);
    }

    public String getDeputyName() {
        return DeputyName;
    }

    public void setDeputyName(String deputyName) {
        this.DeputyName = deputyName;
    }

    public String getPoliticalParty() {
        return PoliticalParty;
    }

    public void setPoliticalParty(String politicalParty) {
        this.PoliticalParty = politicalParty;
    }

    public String getStateCode() {
        return StateCode;
    }

    public void setStateCode(String stateCode) {
        this.StateCode = stateCode;
    }

    public int getDeputyId() {
        return DeputyId;
    }

    public void setDeputyId(int deputyId) {
        this.DeputyId = deputyId;
    }

    public int getBuggedDate() {
        return BuggedDate;
    }

    public void setBuggedDate(int buggedDate) {
        this.BuggedDate = buggedDate;
    }
}