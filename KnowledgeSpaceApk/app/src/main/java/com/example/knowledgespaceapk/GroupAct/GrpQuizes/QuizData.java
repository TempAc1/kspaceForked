package com.example.knowledgespaceapk.GroupAct.GrpQuizes;

public class QuizData {
    String quizTime,quizTotalQues;

    public QuizData() {
    }

    public QuizData(String quizTime, String quizTotalQues) {
        this.quizTime = quizTime;
        this.quizTotalQues = quizTotalQues;
    }

    public String getQuizTime() {
        return quizTime;
    }

    public void setQuizTime(String quizTime) {
        this.quizTime = quizTime;
    }

    public String getQuizTotalQues() {
        return quizTotalQues;
    }

    public void setQuizTotalQues(String quizTotalQues) {
        this.quizTotalQues = quizTotalQues;
    }
}
