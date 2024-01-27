package com.example.knowledgespaceapk;

public class dataModelRecVFeesHistory {
    String  typeOfFeesFeesHistTV, feesAmtFeesHistTV, transStatusFeesHistTV,orderIDFeesHistTV;
    int transactionStatusImgV;

    public dataModelRecVFeesHistory() {}

    public dataModelRecVFeesHistory(int transactionStatusImgV, String typeOfFeesFeesHistTV, String feesAmtFeesHistTV, String transStatusFeesHistTV, String orderIDFeesHistTV) {
        this.transactionStatusImgV = transactionStatusImgV;
        this.typeOfFeesFeesHistTV = typeOfFeesFeesHistTV;
        this.feesAmtFeesHistTV = feesAmtFeesHistTV;
        this.transStatusFeesHistTV = transStatusFeesHistTV;
        this.orderIDFeesHistTV = orderIDFeesHistTV;
    }

    public dataModelRecVFeesHistory(String typeOfFeesFeesHistTV, String feesAmtFeesHistTV, String transStatusFeesHistTV, String orderIDFeesHistTV) {
        this.typeOfFeesFeesHistTV = typeOfFeesFeesHistTV;
        this.feesAmtFeesHistTV = feesAmtFeesHistTV;
        this.transStatusFeesHistTV = transStatusFeesHistTV;
        this.orderIDFeesHistTV = orderIDFeesHistTV;
    }

    public int getTransactionStatusImgV() {
        return transactionStatusImgV;
    }

    public void setTransactionStatusImgV(int transactionStatusImgV) {
        this.transactionStatusImgV = transactionStatusImgV;
    }

    public String getOrderIDFeesHistTV() {
        return orderIDFeesHistTV;
    }

    public void setOrderIDFeesHistTV(String orderIDFeesHistTV) {
        this.orderIDFeesHistTV = orderIDFeesHistTV;
    }

    public String getTypeOfFeesFeesHistTV() {
        return typeOfFeesFeesHistTV;
    }

    public void setTypeOfFeesFeesHistTV(String typeOfFeesFeesHistTV) {
        this.typeOfFeesFeesHistTV = typeOfFeesFeesHistTV;
    }

    public String getFeesAmtFeesHistTV() {
        return feesAmtFeesHistTV;
    }

    public void setFeesAmtFeesHistTV(String feesAmtFeesHistTV) {
        this.feesAmtFeesHistTV = feesAmtFeesHistTV;
    }

    public String getTransStatusFeesHistTV() {
        return transStatusFeesHistTV;
    }

    public void setTransStatusFeesHistTV(String transStatusFeesHistTV) {
        this.transStatusFeesHistTV = transStatusFeesHistTV;
    }

}
