package com.example.knowledgespaceapk;

import java.math.BigDecimal;
import java.util.Date;

public class FeesData {
    FeeDetails feeDetails = new FeeDetails();

    public FeeDetails[] getInvoices() {
        FeeDetails[] data = new FeeDetails[40];
        for (int i = 0; i < 40; i++) {
            FeeDetails row = new FeeDetails();
            data[i] = row;
        }
        return data;
    }
}

