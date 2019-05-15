package com.decisionTree.wiki.dto;


public class QuestionDto {

  Integer root;
    Integer left;
    Integer right;
String question;
    Integer groupId;
String link;
    Integer idQuestions;

    public Integer getRoot() {
        return root;
    }

    public void setRoot(Integer root) {
        this.root = root;
    }

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public Integer getRight() {
        return right;
    }

    public void setRight(Integer right) {
        this.right = right;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getIdQuestions() {
        return idQuestions;
    }

    public void setIdQuestions(Integer idQuestions) {
        this.idQuestions = idQuestions;
    }
}
