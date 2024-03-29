/*
 * Developed by Jan Misiorny
 * February A.D. 2019
 */

package com.decisionTree.wiki.services;

import com.decisionTree.wiki.controllers.QuestionsController;
import com.decisionTree.wiki.dao.QuestionGroupRepository;
import com.decisionTree.wiki.dao.QuestionsDomainRepository;
import com.decisionTree.wiki.dao.TreeRepository;
import com.decisionTree.wiki.domain.QuestionGroupDomain;
import com.decisionTree.wiki.domain.QuestionsDomain;
import com.decisionTree.wiki.domain.TreeDomain;
import com.decisionTree.wiki.dto.QuestionDto;
import com.decisionTree.wiki.dto.QuestionDtoWithTheMatcher;
import com.decisionTree.wiki.exceptions.IdNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
public class TreeLogicServiceImpl implements TreeLogicService {

    private QuestionsDomainRepository questionsDomainRepository;
    private TreeRepository treeRepository;
    private QuestionGroupRepository questionGroupRepository;
    private QuestionsController questionsController;

    @Autowired
    public TreeLogicServiceImpl(QuestionsDomainRepository questionsDomainRepository, TreeRepository treeRepository, QuestionGroupRepository questionGroupRepository) {
        this.questionsDomainRepository = questionsDomainRepository;
        this.treeRepository = treeRepository;
        this.questionGroupRepository = questionGroupRepository;
    }


//    public QuestionDto getQuestionFromTree(List<QuestionsDomain> radnomQuestionList) {
//
//
//
//        QuestionsDomain questionDomainParsed = questionsDomainRepository.findByNumber(radnomQuestionList.size());
//        TreeDomain treeDomainParsed = treeRepository.findByRoot(questionDomainParsed.getNumber());
//
//        QuestionDto questionDtoParsed = new QuestionDto();
//
//
//        questionDtoParsed.setQuestion(questionDomainParsed.getQuestion());
//        questionDtoParsed.setLeft(treeDomainParsed.getLeft());
//        questionDtoParsed.setRight(treeDomainParsed.getRight());
//        questionDtoParsed.setRoot(treeDomainParsed.getRoot());
//
//        return (questionDtoParsed);
//
//
//    }


    public List<QuestionsDomain> randomTreeQuestion(boolean singleOrMulti) {



        List<QuestionGroupDomain> allByQuestionHandlerIsActoveAndSingle = questionGroupRepository.findAllBySingleAndActive(true,true);
        List<QuestionGroupDomain> allByQuestionHandlerIsInactiveandMulti = questionGroupRepository.findAllBySingleAndActive(false,true);

        //takes out all active groups from GroupDomain
        if (singleOrMulti == true) {

            QuestionGroupDomain randomQuestionGroup = allByQuestionHandlerIsActoveAndSingle.get(new Random().nextInt(allByQuestionHandlerIsActoveAndSingle.size()));
            //random object
            List<QuestionsDomain> groupId = randomQuestionGroup.getGroupId();

            return groupId;

        } else {
            QuestionGroupDomain randomQuestionGroup2 = allByQuestionHandlerIsInactiveandMulti.get(new Random().nextInt(allByQuestionHandlerIsInactiveandMulti.size()));
            //random object
            List<QuestionsDomain> groupId2 = randomQuestionGroup2.getGroupId();


            return groupId2;
        }


    }

    public QuestionDto returnAllTreeQuestions (int id)  {

        for (int i = 0; i < 64; i++){
            try {
                QuestionDto questionDto = questionsController.returnNextRandomQuestion(i, id);
            } catch (IdNotFound idNotFound) {
                idNotFound.printStackTrace();
            }
        }

        QuestionDto questionDto = new QuestionDto();

        return questionDto;
    }

        public QuestionDto mappingTheQuestionsForTheTreeAlgorythm (Integer questionId,Integer questionGroupId ) throws IdNotFound {

        Optional <QuestionsDomain> byNumberAndQuestionHandler_idQuestionGroup = Optional.ofNullable(questionsDomainRepository.findByNumberAndQuestionHandler_IdQuestionGroup(questionId, questionGroupId));

        Optional <TreeDomain> treeRootNumber = Optional.ofNullable(treeRepository.findByRoot(questionId));

        if (!byNumberAndQuestionHandler_idQuestionGroup.isPresent()&&treeRootNumber.isPresent()){throw new IdNotFound();}
        QuestionDto questionDto = new QuestionDto();

        questionDto.setQuestion(byNumberAndQuestionHandler_idQuestionGroup.get().getQuestion());
        questionDto.setGroupId(byNumberAndQuestionHandler_idQuestionGroup.get().getQuestionHandler().getIdQuestionGroup());
        questionDto.setIdQuestions(byNumberAndQuestionHandler_idQuestionGroup.get().getIdQuestions());
        questionDto.setLink(byNumberAndQuestionHandler_idQuestionGroup.get().getLink());
        questionDto.setRoot(treeRootNumber.get().getRoot());
        questionDto.setRight(treeRootNumber.get().getRighty());
        questionDto.setLeft(treeRootNumber.get().getLefty());

        return questionDto;


    }

    @Override
    public QuestionDtoWithTheMatcher mappingTheQuestionsForTheTreeAlgorythmWithTheMatcher(int questionId, int questionGroupId, int matcher) throws IdNotFound {


        Optional <QuestionsDomain> byNumberAndQuestionHandler_idQuestionGroup = Optional.ofNullable(questionsDomainRepository.findByNumberAndQuestionHandler_IdQuestionGroup(questionId, questionGroupId));

        Optional <TreeDomain> treeRootNumber = Optional.ofNullable(treeRepository.findByRoot(questionId));

        if (!byNumberAndQuestionHandler_idQuestionGroup.isPresent()&&treeRootNumber.isPresent()){throw new IdNotFound();}
        QuestionDtoWithTheMatcher questionDtoWithTheMatcher = new QuestionDtoWithTheMatcher();

        questionDtoWithTheMatcher.setQuestion(byNumberAndQuestionHandler_idQuestionGroup.get().getQuestion());
        questionDtoWithTheMatcher.setGroupId(byNumberAndQuestionHandler_idQuestionGroup.get().getQuestionHandler().getIdQuestionGroup());
        questionDtoWithTheMatcher.setIdQuestions(byNumberAndQuestionHandler_idQuestionGroup.get().getIdQuestions());
        questionDtoWithTheMatcher.setLink(byNumberAndQuestionHandler_idQuestionGroup.get().getLink());
        questionDtoWithTheMatcher.setRoot(treeRootNumber.get().getRoot());
        questionDtoWithTheMatcher.setRight(treeRootNumber.get().getRighty());
        questionDtoWithTheMatcher.setLeft(treeRootNumber.get().getLefty());
        questionDtoWithTheMatcher.setMatcher(matcher);


        return questionDtoWithTheMatcher;

    }

    public List<String> returnListOfStringsContainingTags (List<QuestionGroupDomain> treeBody){

        List<String> objects = new ArrayList<>();

        for (QuestionGroupDomain tags:treeBody){
            String tag = tags.getTag();
            objects.add(tag);
        }


        String tags = String.join(",",objects);
        String[] split = tags.split(",");
        List<String> collect = Arrays.stream(split).distinct().collect(Collectors.toList());


        return collect;


    }


    public Integer returnTheNextQuestionNumberInsideTheTree (Integer tree){

        QuestionGroupDomain byIdQuestionGroup = questionGroupRepository.findByIdQuestionGroup(tree);
        List<QuestionsDomain> groupId = byIdQuestionGroup.getGroupId();
        List<Integer> listofQuestionNumbers = new ArrayList<>();
        for (QuestionsDomain listofNumbers : groupId){
            Integer number = listofNumbers.getNumber();
            listofQuestionNumbers.add(number);
        }


        int lastNumber = listofQuestionNumbers.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);

        int lastNumberPlusOne = lastNumber + 1;

        return lastNumberPlusOne;
    }




}
