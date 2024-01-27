package com.example.knowledgespaceapk.CV;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class CVPersonalDetails implements Parcelable{

    public CVPersonalDetails() {} //empty args constructor

    //CV Screen MainScF :
    String pNameEditTvCvMainScF,pAddressEditTvCvMainScF,
            pEmailEditTvCVMainScF,pLinkedInLinkEditTvCVMainScF,pImgVCvMainScF;
    long pPhoneEditTvCVMainScF;

    //MainScF Constructor:
    public CVPersonalDetails(String pNameEditTvCvMainScF, String pAddressEditTvCvMainScF, String pEmailEditTvCVMainScF, String pLinkedInLinkEditTvCVMainScF, String pImgVCvMainScF, long pPhoneEditTvCVMainScF) {
        this.pNameEditTvCvMainScF = pNameEditTvCvMainScF;
        this.pAddressEditTvCvMainScF = pAddressEditTvCvMainScF;
        this.pEmailEditTvCVMainScF = pEmailEditTvCVMainScF;
        this.pLinkedInLinkEditTvCVMainScF = pLinkedInLinkEditTvCVMainScF;
        this.pImgVCvMainScF = pImgVCvMainScF;
        this.pPhoneEditTvCVMainScF = pPhoneEditTvCVMainScF;
    }

    public String getpNameEditTvCvMainScF() {
        return pNameEditTvCvMainScF;
    }

    public void setpNameEditTvCvMainScF(String pNameEditTvCvMainScF) {
        this.pNameEditTvCvMainScF = pNameEditTvCvMainScF;
    }

    public String getpAddressEditTvCvMainScF() {
        return pAddressEditTvCvMainScF;
    }

    public void setpAddressEditTvCvMainScF(String pAddressEditTvCvMainScF) {
        this.pAddressEditTvCvMainScF = pAddressEditTvCvMainScF;
    }

    public String getpEmailEditTvCVMainScF() {
        return pEmailEditTvCVMainScF;
    }

    public void setpEmailEditTvCVMainScF(String pEmailEditTvCVMainScF) {
        this.pEmailEditTvCVMainScF = pEmailEditTvCVMainScF;
    }

    public String getpLinkedInLinkEditTvCVMainScF() {
        return pLinkedInLinkEditTvCVMainScF;
    }

    public void setpLinkedInLinkEditTvCVMainScF(String pLinkedInLinkEditTvCVMainScF) {
        this.pLinkedInLinkEditTvCVMainScF = pLinkedInLinkEditTvCVMainScF;
    }

    public String getpImgVCvMainScF() {
        return pImgVCvMainScF;
    }

    public void setpImgVCvMainScF(String pImgVCvMainScF) {
        this.pImgVCvMainScF = pImgVCvMainScF;
    }

    public long getpPhoneEditTvCVMainScF() {
        return pPhoneEditTvCVMainScF;
    }

    public void setpPhoneEditTvCVMainScF(long pPhoneEditTvCVMainScF) {
        this.pPhoneEditTvCVMainScF = pPhoneEditTvCVMainScF;
    }

    // Declaration CvPerIntroScF:
    String perSummaryEditTvCvPerIntroSc,internshipJobTitleEditTvCvPerIntroScF,internshipJobPeriodEditTvCvPerIntroScF,
            companyNameEditTvCvPerIntroScF,expDescEditTvCvPerIntroScF,currentBranchNameCvPerIntroScF,
            currentInstituteNameCvPerIntroScF,higherSecondarySchoolNameCvPerIntroScF,secondarySchoolNameCvPerIntroScF;
    int higherSecondarySchoolYearCvPerIntroScF,secondarySchoolYearCvPerIntroScF;

    //Constructor CvPerIntroScF:
    public CVPersonalDetails(String perSummaryEditTvCvPerIntroSc, String internshipJobTitleEditTvCvPerIntroScF, String internshipJobPeriodEditTvCvPerIntroScF, String companyNameEditTvCvPerIntroScF, String expDescEditTvCvPerIntroScF, String currentBranchNameCvPerIntroScF, String currentInstituteNameCvPerIntroScF, String higherSecondarySchoolNameCvPerIntroScF, String secondarySchoolNameCvPerIntroScF, int higherSecondarySchoolYearCvPerIntroScF, int secondarySchoolYearCvPerIntroScF) {
        this.perSummaryEditTvCvPerIntroSc = perSummaryEditTvCvPerIntroSc;
        this.internshipJobTitleEditTvCvPerIntroScF = internshipJobTitleEditTvCvPerIntroScF;
        this.internshipJobPeriodEditTvCvPerIntroScF = internshipJobPeriodEditTvCvPerIntroScF;
        this.companyNameEditTvCvPerIntroScF = companyNameEditTvCvPerIntroScF;
        this.expDescEditTvCvPerIntroScF = expDescEditTvCvPerIntroScF;
        this.currentBranchNameCvPerIntroScF = currentBranchNameCvPerIntroScF;
        this.currentInstituteNameCvPerIntroScF = currentInstituteNameCvPerIntroScF;
        this.higherSecondarySchoolNameCvPerIntroScF = higherSecondarySchoolNameCvPerIntroScF;
        this.secondarySchoolNameCvPerIntroScF = secondarySchoolNameCvPerIntroScF;
        this.higherSecondarySchoolYearCvPerIntroScF = higherSecondarySchoolYearCvPerIntroScF;
        this.secondarySchoolYearCvPerIntroScF = secondarySchoolYearCvPerIntroScF;
    }

    public String getPerSummaryEditTvCvPerIntroSc() {
        return perSummaryEditTvCvPerIntroSc;
    }

    public void setPerSummaryEditTvCvPerIntroSc(String perSummaryEditTvCvPerIntroSc) {
        this.perSummaryEditTvCvPerIntroSc = perSummaryEditTvCvPerIntroSc;
    }

    public String getInternshipJobTitleEditTvCvPerIntroScF() {
        return internshipJobTitleEditTvCvPerIntroScF;
    }

    public void setInternshipJobTitleEditTvCvPerIntroScF(String internshipJobTitleEditTvCvPerIntroScF) {
        this.internshipJobTitleEditTvCvPerIntroScF = internshipJobTitleEditTvCvPerIntroScF;
    }

    public String getInternshipJobPeriodEditTvCvPerIntroScF() {
        return internshipJobPeriodEditTvCvPerIntroScF;
    }

    public void setInternshipJobPeriodEditTvCvPerIntroScF(String internshipJobPeriodEditTvCvPerIntroScF) {
        this.internshipJobPeriodEditTvCvPerIntroScF = internshipJobPeriodEditTvCvPerIntroScF;
    }

    public String getCompanyNameEditTvCvPerIntroScF() {
        return companyNameEditTvCvPerIntroScF;
    }

    public void setCompanyNameEditTvCvPerIntroScF(String companyNameEditTvCvPerIntroScF) {
        this.companyNameEditTvCvPerIntroScF = companyNameEditTvCvPerIntroScF;
    }

    public String getExpDescEditTvCvPerIntroScF() {
        return expDescEditTvCvPerIntroScF;
    }

    public void setExpDescEditTvCvPerIntroScF(String expDescEditTvCvPerIntroScF) {
        this.expDescEditTvCvPerIntroScF = expDescEditTvCvPerIntroScF;
    }

    public String getCurrentBranchNameCvPerIntroScF() {
        return currentBranchNameCvPerIntroScF;
    }

    public void setCurrentBranchNameCvPerIntroScF(String currentBranchNameCvPerIntroScF) {
        this.currentBranchNameCvPerIntroScF = currentBranchNameCvPerIntroScF;
    }

    public String getCurrentInstituteNameCvPerIntroScF() {
        return currentInstituteNameCvPerIntroScF;
    }

    public void setCurrentInstituteNameCvPerIntroScF(String currentInstituteNameCvPerIntroScF) {
        this.currentInstituteNameCvPerIntroScF = currentInstituteNameCvPerIntroScF;
    }

    public String getHigherSecondarySchoolNameCvPerIntroScF() {
        return higherSecondarySchoolNameCvPerIntroScF;
    }

    public void setHigherSecondarySchoolNameCvPerIntroScF(String higherSecondarySchoolNameCvPerIntroScF) {
        this.higherSecondarySchoolNameCvPerIntroScF = higherSecondarySchoolNameCvPerIntroScF;
    }

    public String getSecondarySchoolNameCvPerIntroScF() {
        return secondarySchoolNameCvPerIntroScF;
    }

    public void setSecondarySchoolNameCvPerIntroScF(String secondarySchoolNameCvPerIntroScF) {
        this.secondarySchoolNameCvPerIntroScF = secondarySchoolNameCvPerIntroScF;
    }

    public int getHigherSecondarySchoolYearCvPerIntroScF() {
        return higherSecondarySchoolYearCvPerIntroScF;
    }

    public void setHigherSecondarySchoolYearCvPerIntroScF(int higherSecondarySchoolYearCvPerIntroScF) {
        this.higherSecondarySchoolYearCvPerIntroScF = higherSecondarySchoolYearCvPerIntroScF;
    }

    public int getSecondarySchoolYearCvPerIntroScF() {
        return secondarySchoolYearCvPerIntroScF;
    }

    public void setSecondarySchoolYearCvPerIntroScF(int secondarySchoolYearCvPerIntroScF) {
        this.secondarySchoolYearCvPerIntroScF = secondarySchoolYearCvPerIntroScF;
    }

    //Declaration CvIntroPart2ScF:
    String perLang1EditTvCvPerIntroSc,perLang2EditTvCvPerIntroSc,perLang3EditTvCvPerIntroSc,
    perLang4EditTvCvPerIntroSc, per1stHobbiesEditTvCvPerIntroSc, per2ndHobbiesEditTvCvPerIntroSc,
    per3rdHobbiesEditTvCvPerIntroSc, per4thHobbiesEditTvCvPerIntroSc, per5thHobbiesEditTvCvPerIntroSc,
    per1SkillsEditTvCvPerIntroSc, per2SkillsEditTvCvPerIntroSc, per3SkillsEditTvCvPerIntroSc,
    per4SkillsEditTvCvPerIntroSc, per5SkillsEditTvCvPerIntroSc;

    //Constructor CvIntroPart2ScF:
    public CVPersonalDetails(String perLang1EditTvCvPerIntroSc, String perLang2EditTvCvPerIntroSc, String perLang3EditTvCvPerIntroSc, String perLang4EditTvCvPerIntroSc, String per1stHobbiesEditTvCvPerIntroSc, String per2ndHobbiesEditTvCvPerIntroSc, String per3rdHobbiesEditTvCvPerIntroSc, String per4thHobbiesEditTvCvPerIntroSc, String per5thHobbiesEditTvCvPerIntroSc, String per1SkillsEditTvCvPerIntroSc, String per2SkillsEditTvCvPerIntroSc, String per3SkillsEditTvCvPerIntroSc, String per4SkillsEditTvCvPerIntroSc, String per5SkillsEditTvCvPerIntroSc) {
        this.perLang1EditTvCvPerIntroSc = perLang1EditTvCvPerIntroSc;
        this.perLang2EditTvCvPerIntroSc = perLang2EditTvCvPerIntroSc;
        this.perLang3EditTvCvPerIntroSc = perLang3EditTvCvPerIntroSc;
        this.perLang4EditTvCvPerIntroSc = perLang4EditTvCvPerIntroSc;
        this.per1stHobbiesEditTvCvPerIntroSc = per1stHobbiesEditTvCvPerIntroSc;
        this.per2ndHobbiesEditTvCvPerIntroSc = per2ndHobbiesEditTvCvPerIntroSc;
        this.per3rdHobbiesEditTvCvPerIntroSc = per3rdHobbiesEditTvCvPerIntroSc;
        this.per4thHobbiesEditTvCvPerIntroSc = per4thHobbiesEditTvCvPerIntroSc;
        this.per5thHobbiesEditTvCvPerIntroSc = per5thHobbiesEditTvCvPerIntroSc;
        this.per1SkillsEditTvCvPerIntroSc = per1SkillsEditTvCvPerIntroSc;
        this.per2SkillsEditTvCvPerIntroSc = per2SkillsEditTvCvPerIntroSc;
        this.per3SkillsEditTvCvPerIntroSc = per3SkillsEditTvCvPerIntroSc;
        this.per4SkillsEditTvCvPerIntroSc = per4SkillsEditTvCvPerIntroSc;
        this.per5SkillsEditTvCvPerIntroSc = per5SkillsEditTvCvPerIntroSc;
    }

    public String getPerLang1EditTvCvPerIntroSc() {
        return perLang1EditTvCvPerIntroSc;
    }

    public void setPerLang1EditTvCvPerIntroSc(String perLang1EditTvCvPerIntroSc) {
        this.perLang1EditTvCvPerIntroSc = perLang1EditTvCvPerIntroSc;
    }

    public String getPerLang2EditTvCvPerIntroSc() {
        return perLang2EditTvCvPerIntroSc;
    }

    public void setPerLang2EditTvCvPerIntroSc(String perLang2EditTvCvPerIntroSc) {
        this.perLang2EditTvCvPerIntroSc = perLang2EditTvCvPerIntroSc;
    }

    public String getPerLang3EditTvCvPerIntroSc() {
        return perLang3EditTvCvPerIntroSc;
    }

    public void setPerLang3EditTvCvPerIntroSc(String perLang3EditTvCvPerIntroSc) {
        this.perLang3EditTvCvPerIntroSc = perLang3EditTvCvPerIntroSc;
    }

    public String getPerLang4EditTvCvPerIntroSc() {
        return perLang4EditTvCvPerIntroSc;
    }

    public void setPerLang4EditTvCvPerIntroSc(String perLang4EditTvCvPerIntroSc) {
        this.perLang4EditTvCvPerIntroSc = perLang4EditTvCvPerIntroSc;
    }

    public String getPer1stHobbiesEditTvCvPerIntroSc() {
        return per1stHobbiesEditTvCvPerIntroSc;
    }

    public void setPer1stHobbiesEditTvCvPerIntroSc(String per1stHobbiesEditTvCvPerIntroSc) {
        this.per1stHobbiesEditTvCvPerIntroSc = per1stHobbiesEditTvCvPerIntroSc;
    }

    public String getPer2ndHobbiesEditTvCvPerIntroSc() {
        return per2ndHobbiesEditTvCvPerIntroSc;
    }

    public void setPer2ndHobbiesEditTvCvPerIntroSc(String per2ndHobbiesEditTvCvPerIntroSc) {
        this.per2ndHobbiesEditTvCvPerIntroSc = per2ndHobbiesEditTvCvPerIntroSc;
    }

    public String getPer3rdHobbiesEditTvCvPerIntroSc() {
        return per3rdHobbiesEditTvCvPerIntroSc;
    }

    public void setPer3rdHobbiesEditTvCvPerIntroSc(String per3rdHobbiesEditTvCvPerIntroSc) {
        this.per3rdHobbiesEditTvCvPerIntroSc = per3rdHobbiesEditTvCvPerIntroSc;
    }

    public String getPer4thHobbiesEditTvCvPerIntroSc() {
        return per4thHobbiesEditTvCvPerIntroSc;
    }

    public void setPer4thHobbiesEditTvCvPerIntroSc(String per4thHobbiesEditTvCvPerIntroSc) {
        this.per4thHobbiesEditTvCvPerIntroSc = per4thHobbiesEditTvCvPerIntroSc;
    }

    public String getPer5thHobbiesEditTvCvPerIntroSc() {
        return per5thHobbiesEditTvCvPerIntroSc;
    }

    public void setPer5thHobbiesEditTvCvPerIntroSc(String per5thHobbiesEditTvCvPerIntroSc) {
        this.per5thHobbiesEditTvCvPerIntroSc = per5thHobbiesEditTvCvPerIntroSc;
    }

    public String getPer1SkillsEditTvCvPerIntroSc() {
        return per1SkillsEditTvCvPerIntroSc;
    }

    public void setPer1SkillsEditTvCvPerIntroSc(String per1SkillsEditTvCvPerIntroSc) {
        this.per1SkillsEditTvCvPerIntroSc = per1SkillsEditTvCvPerIntroSc;
    }

    public String getPer2SkillsEditTvCvPerIntroSc() {
        return per2SkillsEditTvCvPerIntroSc;
    }

    public void setPer2SkillsEditTvCvPerIntroSc(String per2SkillsEditTvCvPerIntroSc) {
        this.per2SkillsEditTvCvPerIntroSc = per2SkillsEditTvCvPerIntroSc;
    }

    public String getPer3SkillsEditTvCvPerIntroSc() {
        return per3SkillsEditTvCvPerIntroSc;
    }

    public void setPer3SkillsEditTvCvPerIntroSc(String per3SkillsEditTvCvPerIntroSc) {
        this.per3SkillsEditTvCvPerIntroSc = per3SkillsEditTvCvPerIntroSc;
    }

    public String getPer4SkillsEditTvCvPerIntroSc() {
        return per4SkillsEditTvCvPerIntroSc;
    }

    public void setPer4SkillsEditTvCvPerIntroSc(String per4SkillsEditTvCvPerIntroSc) {
        this.per4SkillsEditTvCvPerIntroSc = per4SkillsEditTvCvPerIntroSc;
    }

    public String getPer5SkillsEditTvCvPerIntroSc() {
        return per5SkillsEditTvCvPerIntroSc;
    }

    public void setPer5SkillsEditTvCvPerIntroSc(String per5SkillsEditTvCvPerIntroSc) {
        this.per5SkillsEditTvCvPerIntroSc = per5SkillsEditTvCvPerIntroSc;
    }


    //Declaration Cv3rdScF:
    String per1CertAuthorityEditTvCv3rdSc,per1stCertNameEditTvCv3rdSc,per2ndCertAuthorityEditTvCv3rdSc,
            per2ndCertNameEditTvCv3rdSc,per3rdCertAuthorityEditTvCv3rdSc,per3rdCertNameEditTvCv3rdSc,
            per4CertAuthorityEditTvCv3rdSc,per4stCertNameEditTvCv3rdSc,per5thCertAuthorityEditTvCv3rdSc,
            per5thCertNameEditTvCv3rdSc;

    //Constructor Cv3rdScF:
    public CVPersonalDetails(String per1CertAuthorityEditTvCv3rdSc, String per1stCertNameEditTvCv3rdSc, String per2ndCertAuthorityEditTvCv3rdSc, String per2ndCertNameEditTvCv3rdSc, String per3rdCertAuthorityEditTvCv3rdSc, String per3rdCertNameEditTvCv3rdSc, String per4CertAuthorityEditTvCv3rdSc, String per4stCertNameEditTvCv3rdSc, String per5thCertAuthorityEditTvCv3rdSc, String per5thCertNameEditTvCv3rdSc) {
        this.per1CertAuthorityEditTvCv3rdSc = per1CertAuthorityEditTvCv3rdSc;
        this.per1stCertNameEditTvCv3rdSc = per1stCertNameEditTvCv3rdSc;
        this.per2ndCertAuthorityEditTvCv3rdSc = per2ndCertAuthorityEditTvCv3rdSc;
        this.per2ndCertNameEditTvCv3rdSc = per2ndCertNameEditTvCv3rdSc;
        this.per3rdCertAuthorityEditTvCv3rdSc = per3rdCertAuthorityEditTvCv3rdSc;
        this.per3rdCertNameEditTvCv3rdSc = per3rdCertNameEditTvCv3rdSc;
        this.per4CertAuthorityEditTvCv3rdSc = per4CertAuthorityEditTvCv3rdSc;
        this.per4stCertNameEditTvCv3rdSc = per4stCertNameEditTvCv3rdSc;
        this.per5thCertAuthorityEditTvCv3rdSc = per5thCertAuthorityEditTvCv3rdSc;
        this.per5thCertNameEditTvCv3rdSc = per5thCertNameEditTvCv3rdSc;
    }

    public String getPer1CertAuthorityEditTvCv3rdSc() {
        return per1CertAuthorityEditTvCv3rdSc;
    }

    public void setPer1CertAuthorityEditTvCv3rdSc(String per1CertAuthorityEditTvCv3rdSc) {
        this.per1CertAuthorityEditTvCv3rdSc = per1CertAuthorityEditTvCv3rdSc;
    }

    public String getPer1stCertNameEditTvCv3rdSc() {
        return per1stCertNameEditTvCv3rdSc;
    }

    public void setPer1stCertNameEditTvCv3rdSc(String per1stCertNameEditTvCv3rdSc) {
        this.per1stCertNameEditTvCv3rdSc = per1stCertNameEditTvCv3rdSc;
    }

    public String getPer2ndCertAuthorityEditTvCv3rdSc() {
        return per2ndCertAuthorityEditTvCv3rdSc;
    }

    public void setPer2ndCertAuthorityEditTvCv3rdSc(String per2ndCertAuthorityEditTvCv3rdSc) {
        this.per2ndCertAuthorityEditTvCv3rdSc = per2ndCertAuthorityEditTvCv3rdSc;
    }

    public String getPer2ndCertNameEditTvCv3rdSc() {
        return per2ndCertNameEditTvCv3rdSc;
    }

    public void setPer2ndCertNameEditTvCv3rdSc(String per2ndCertNameEditTvCv3rdSc) {
        this.per2ndCertNameEditTvCv3rdSc = per2ndCertNameEditTvCv3rdSc;
    }

    public String getPer3rdCertAuthorityEditTvCv3rdSc() {
        return per3rdCertAuthorityEditTvCv3rdSc;
    }

    public void setPer3rdCertAuthorityEditTvCv3rdSc(String per3rdCertAuthorityEditTvCv3rdSc) {
        this.per3rdCertAuthorityEditTvCv3rdSc = per3rdCertAuthorityEditTvCv3rdSc;
    }

    public String getPer3rdCertNameEditTvCv3rdSc() {
        return per3rdCertNameEditTvCv3rdSc;
    }

    public void setPer3rdCertNameEditTvCv3rdSc(String per3rdCertNameEditTvCv3rdSc) {
        this.per3rdCertNameEditTvCv3rdSc = per3rdCertNameEditTvCv3rdSc;
    }

    public String getPer4CertAuthorityEditTvCv3rdSc() {
        return per4CertAuthorityEditTvCv3rdSc;
    }

    public void setPer4CertAuthorityEditTvCv3rdSc(String per4CertAuthorityEditTvCv3rdSc) {
        this.per4CertAuthorityEditTvCv3rdSc = per4CertAuthorityEditTvCv3rdSc;
    }

    public String getPer4stCertNameEditTvCv3rdSc() {
        return per4stCertNameEditTvCv3rdSc;
    }

    public void setPer4stCertNameEditTvCv3rdSc(String per4stCertNameEditTvCv3rdSc) {
        this.per4stCertNameEditTvCv3rdSc = per4stCertNameEditTvCv3rdSc;
    }

    public String getPer5thCertAuthorityEditTvCv3rdSc() {
        return per5thCertAuthorityEditTvCv3rdSc;
    }

    public void setPer5thCertAuthorityEditTvCv3rdSc(String per5thCertAuthorityEditTvCv3rdSc) {
        this.per5thCertAuthorityEditTvCv3rdSc = per5thCertAuthorityEditTvCv3rdSc;
    }

    public String getPer5thCertNameEditTvCv3rdSc() {
        return per5thCertNameEditTvCv3rdSc;
    }

    public void setPer5thCertNameEditTvCv3rdSc(String per5thCertNameEditTvCv3rdSc) {
        this.per5thCertNameEditTvCv3rdSc = per5thCertNameEditTvCv3rdSc;
    }


    //Parcelable Implementation:
    protected CVPersonalDetails(Parcel in) {
        pNameEditTvCvMainScF = in.readString();
        pImgVCvMainScF = in.readString();
        pAddressEditTvCvMainScF = in.readString();
        pEmailEditTvCVMainScF = in.readString();
        pLinkedInLinkEditTvCVMainScF = in.readString();
        perSummaryEditTvCvPerIntroSc = in.readString();
        internshipJobTitleEditTvCvPerIntroScF = in.readString();
        internshipJobPeriodEditTvCvPerIntroScF = in.readString();
        expDescEditTvCvPerIntroScF = in.readString();
        currentBranchNameCvPerIntroScF = in.readString();
        currentInstituteNameCvPerIntroScF = in.readString();
        higherSecondarySchoolNameCvPerIntroScF = in.readString();
        secondarySchoolNameCvPerIntroScF = in.readString();
        higherSecondarySchoolYearCvPerIntroScF = in.readInt();
        secondarySchoolYearCvPerIntroScF = in.readInt();
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        //MainSc Parcelable:
        dest.writeString(pNameEditTvCvMainScF);
        dest.writeString(pImgVCvMainScF);
        dest.writeString(pAddressEditTvCvMainScF);
        dest.writeString(pEmailEditTvCVMainScF);
        dest.writeString(pLinkedInLinkEditTvCVMainScF);
        dest.writeLong(pPhoneEditTvCVMainScF);

        //CvPerIntroScPart1 Parcelable:
        dest.writeString(perSummaryEditTvCvPerIntroSc);
        dest.writeString(internshipJobTitleEditTvCvPerIntroScF);
        dest.writeString(internshipJobPeriodEditTvCvPerIntroScF);
        dest.writeString(companyNameEditTvCvPerIntroScF);
        dest.writeString(expDescEditTvCvPerIntroScF);
        dest.writeString(currentBranchNameCvPerIntroScF);
        dest.writeString(currentInstituteNameCvPerIntroScF);
        dest.writeString(higherSecondarySchoolNameCvPerIntroScF);
        dest.writeString(secondarySchoolNameCvPerIntroScF);

        dest.writeInt(higherSecondarySchoolYearCvPerIntroScF);
        dest.writeInt(secondarySchoolYearCvPerIntroScF);


        //CvPerIntroScPart2 Parcelable:
        dest.writeString(perLang1EditTvCvPerIntroSc);
        dest.writeString(perLang2EditTvCvPerIntroSc);
        dest.writeString(perLang3EditTvCvPerIntroSc);
        dest.writeString(perLang4EditTvCvPerIntroSc);

        dest.writeString(per1stHobbiesEditTvCvPerIntroSc);
        dest.writeString(per2ndHobbiesEditTvCvPerIntroSc);
        dest.writeString(per3rdHobbiesEditTvCvPerIntroSc);
        dest.writeString(per4thHobbiesEditTvCvPerIntroSc);
        dest.writeString(per5thHobbiesEditTvCvPerIntroSc);

        dest.writeString(per1SkillsEditTvCvPerIntroSc);
        dest.writeString(per2SkillsEditTvCvPerIntroSc);
        dest.writeString(per3SkillsEditTvCvPerIntroSc);
        dest.writeString(per4SkillsEditTvCvPerIntroSc);
        dest.writeString(per5SkillsEditTvCvPerIntroSc);


        //Cv3rdSc Parcelable:
        dest.writeString(per1CertAuthorityEditTvCv3rdSc);
        dest.writeString(per1stCertNameEditTvCv3rdSc);
        dest.writeString(per2ndCertAuthorityEditTvCv3rdSc);
        dest.writeString(per2ndCertNameEditTvCv3rdSc);
        dest.writeString(per3rdCertAuthorityEditTvCv3rdSc);
        dest.writeString(per3rdCertNameEditTvCv3rdSc);
        dest.writeString(per4CertAuthorityEditTvCv3rdSc);
        dest.writeString(per4stCertNameEditTvCv3rdSc);
        dest.writeString(per5thCertAuthorityEditTvCv3rdSc);
        dest.writeString(per5thCertNameEditTvCv3rdSc);

    }

    public static final Creator<CVPersonalDetails> CREATOR = new Creator<CVPersonalDetails>() {
        @Override
        public CVPersonalDetails createFromParcel(Parcel in) {
            return new CVPersonalDetails(in);
        }

        @Override
        public CVPersonalDetails[] newArray(int size) {
            return new CVPersonalDetails[size];
        }
    };


}//End Main
