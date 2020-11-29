package de.hda.fbi.db2.stud.impl;

import de.hda.fbi.db2.api.Lab01Data;
import de.hda.fbi.db2.stud.entity.Answer;
import de.hda.fbi.db2.stud.entity.Category;
import de.hda.fbi.db2.stud.entity.Question;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Lab01 extends Lab01Data {
  List<Question> questionsList = new ArrayList<>();
  List<Category> categoriesList = new ArrayList<>();

  @Override
  public List<Question> getQuestions() {
    return questionsList;
  }

  @Override
  public List<Category> getCategories() {
    return categoriesList;
  }

  @Override
  public void loadCsvFile(List<String[]> additionalCsvLines) {
    HashMap<String, Category> tempList = new HashMap<>();

    int size = additionalCsvLines.size();

    for (int i = 1; i < size; i++) {
      String[] line = additionalCsvLines.get(i);

      int id = Integer.parseInt(line[0]);
      String question = line[1];

      int solutionIndex = Integer.parseInt(line[6]);

      ArrayList<Answer> answersList = new ArrayList<>();
      for (int j = 2; j < 6; j++) {
        Answer answer = new Answer(line[j]);
        if (j - 1 == solutionIndex) {
          answer.setCorrect(true);
        }
        answersList.add(answer);
      }

      Question question1 = new Question(id, question, answersList);

      String categoryName = line[7];

      Category c;
      if (tempList.containsKey(categoryName)) {
        c = tempList.get(categoryName);
        c.addQuestion(question1);
      } else {
        c = new Category(categoryName);
        tempList.put(categoryName, c);
        c.addQuestion(question1);

        categoriesList.add(c);
      }

      question1.setCategory(c);
      questionsList.add(question1);
    }
  System.out.println("*");
  System.out.println("loaded " + categoriesList.size() + " categories");
  System.out.println("loaded " + questionsList.size() + " questions");
  System.out.println("*");

  for( Category i : categoriesList){
    System.out.println(i.getCategory());
  }
  System.out.println("*");

  for( Question i : questionsList){
    System.out.println(i.getQuestion() + " [" + i.getCategory() + "]");
    int tmp=-3;
    for(Answer a : i.getAnswersList()){
      System.out.println(i.getAnswersList().indexOf(a)+ ". " + a.getAnswer() );
      if(a.isCorrect()){
        tmp = i.getAnswersList().indexOf(a);
      }
    }
    System.out.println("solution index: " + tmp);
  }
  System.out.println("*");
  }
}
