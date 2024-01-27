package com.example.knowledgespaceapk;

public class FeeDetails {
    public long ApplicableFees,UniversityFees,InsuranceFees,StudentActivityFees,OtherFees,
            DevelopmentFees,TuitionFees,CarryOver,TotalPayableNow,PaidTillNow,PendingAmount;

    public FeeDetails() {}

    public long getApplicableFees() {
        return ApplicableFees;
    }

    public void setApplicableFees(long applicableFees) {
        ApplicableFees = applicableFees;
    }

    public long getUniversityFees() {
        return UniversityFees;
    }

    public void setUniversityFees(long universityFees) {
        UniversityFees = universityFees;
    }

    public long getInsuranceFees() {
        return InsuranceFees;
    }

    public void setInsuranceFees(long insuranceFees) {
        InsuranceFees = insuranceFees;
    }

    public long getStudentActivityFees() {
        return StudentActivityFees;
    }

    public void setStudentActivityFees(long studentActivityFees) {
        StudentActivityFees = studentActivityFees;
    }

    public long getOtherFees() {
        return OtherFees;
    }

    public void setOtherFees(long otherFees) {
        OtherFees = otherFees;
    }

    public long getDevelopmentFees() {
        return DevelopmentFees;
    }

    public void setDevelopmentFees(long developmentFees) {
        DevelopmentFees = developmentFees;
    }

    public long getTuitionFees() {
        return TuitionFees;
    }

    public void setTuitionFees(long tuitionFees) {
        TuitionFees = tuitionFees;
    }

    public long getCarryOver() {
        return CarryOver;
    }

    public void setCarryOver(long carryOver) {
        CarryOver = carryOver;
    }

    public long getTotalPayableNow() {
        return TotalPayableNow;
    }

    public void setTotalPayableNow(long totalPayableNow) {
        TotalPayableNow = totalPayableNow;
    }

    public long getPaidTillNow() {
        return PaidTillNow;
    }

    public void setPaidTillNow(long paidTillNow) {
        PaidTillNow = paidTillNow;
    }

    public long getPendingAmount() {
        return PendingAmount;
    }

    public void setPendingAmount(long pendingAmount) {
        PendingAmount = pendingAmount;
    }

    public FeeDetails(long applicableFees, long universityFees, long insuranceFees, long studentActivityFees, long otherFees, long developmentFees, long tuitionFees, long carryOver, long totalPayableNow, long paidTillNow, long pendingAmount) {
        ApplicableFees = applicableFees;
        UniversityFees = universityFees;
        InsuranceFees = insuranceFees;
        StudentActivityFees = studentActivityFees;
        OtherFees = otherFees;
        DevelopmentFees = developmentFees;
        TuitionFees = tuitionFees;
        CarryOver = carryOver;
        TotalPayableNow = totalPayableNow;
        PaidTillNow = paidTillNow;
        PendingAmount = pendingAmount;
    }
}
