package com.example.knowledgespaceapk;

public class dataModelRecVFeeHistoryFrag {
    String feeHistoryDetails;
    int TransactionStatus;

    public dataModelRecVFeeHistoryFrag(String feeHistoryDetails, int transactionStatus) {
        this.feeHistoryDetails = feeHistoryDetails;
        this.TransactionStatus = transactionStatus;
    }

    public String getFeeHistoryDetails() {
        return feeHistoryDetails;
    }

    public void setFeeHistoryDetails(String feeHistoryDetails) {
        this.feeHistoryDetails = feeHistoryDetails;
    }

    public int getTransactionStatus() {
        return TransactionStatus;
    }

    public void setTransactionStatus(int transactionStatus) {
        TransactionStatus = transactionStatus;
    }
}
