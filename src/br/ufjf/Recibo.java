package com.company;

public class Recibo {
    private String ReceiptDate;
    private String ReceiptSocialSecurityNumber;
    private String EstablishmentName;
    private String ReceiptDescription;
    private int ReceiptValue;

    public Recibo(String receiptDate, String receiptSocialSecurityNumber, String establishmentName, String receiptDescription, int receiptValue) {
        ReceiptDate = receiptDate;
        ReceiptSocialSecurityNumber = receiptSocialSecurityNumber;
        EstablishmentName = establishmentName;
        ReceiptDescription = receiptDescription;
        ReceiptValue = receiptValue;
    }

    public String getReceiptDate() {
        return ReceiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        ReceiptDate = receiptDate;
    }

    public String getReceiptSocialSecurityNumber() {
        return ReceiptSocialSecurityNumber;
    }

    public void setReceiptSocialSecurityNumber(String receiptSocialSecurityNumber) {
        ReceiptSocialSecurityNumber = receiptSocialSecurityNumber;
    }

    public String getEstablishmentName() {
        return EstablishmentName;
    }

    public void setEstablishmentName(String establishmentName) {
        EstablishmentName = establishmentName;
    }

    public String getReceiptDescription() {
        return ReceiptDescription;
    }

    public void setReceiptDescription(String receiptDescription) {
        ReceiptDescription = receiptDescription;
    }

    public int getReceiptValue() {
        return ReceiptValue;
    }

    public void setReceiptValue(int receiptValue) {
        ReceiptValue = receiptValue;
    }
}
