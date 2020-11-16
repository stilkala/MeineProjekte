package de.hda.fbi.db2.stud.impl;

import de.hda.fbi.db2.api.Lab01Data;
import de.hda.fbi.db2.stud.entity.Category;
import de.hda.fbi.db2.stud.entity.Question;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
      List<String> answersList = Arrays.asList(line[2], line[3], line[4], line[5]);
      int solutionIndex = Integer.parseInt(line[6]);

      Question question1 = new Question(id, question, answersList, solutionIndex);

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
  }
}
