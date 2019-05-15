package com.decisionTree.wiki.dao;

import com.decisionTree.wiki.domain.QuestionGroupDomain;
import com.decisionTree.wiki.domain.QuestionsDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsDomainRepository extends JpaRepository<QuestionsDomain, Integer> {

    QuestionsDomain findByNumber (Integer number);
    QuestionsDomain findByNumberAndQuestionHandler(Integer number, QuestionGroupDomain questionHandler);
    QuestionsDomain findByNumberAndQuestionHandler_IdQuestionGroup (Integer number, Integer idNumber);
    QuestionsDomain findByQuestionHandler (Integer number);
    QuestionsDomain findByImage (String image);
    QuestionsDomain findByIdQuestions (Integer id);
    QuestionsDomain findByIdQuestionsAndQuestionHandler (Integer number,QuestionGroupDomain questionHandler );




}
