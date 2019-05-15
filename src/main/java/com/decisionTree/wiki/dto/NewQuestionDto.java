package com.decisionTree.wiki.dto;

import com.decisionTree.wiki.domain.QuestionGroupDomain;

import java.util.List;

public class NewQuestionDto {



    String question;
    Integer number;
    Integer  questionHandler;
    String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getQuestionHandler() {
        return questionHandler;
    }

    public void setQuestionHandler(Integer questionHandler) {
        this.questionHandler = questionHandler;
    }


}
