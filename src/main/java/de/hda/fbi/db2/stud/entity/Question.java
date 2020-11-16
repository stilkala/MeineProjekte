package de.hda.fbi.db2.stud.entity;

import java.util.List;
import java.util.UUID;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Question {

  @Id
  @GeneratedValue
  private int id;
  private String question;
  private List<String> answersList;
  private int solutionIndex;

  @ManyToOne
  private Category category;

  /**
   * Constructor for the Questions Class.
   *
   */
  public Question(int id, String question, List<String> answersList, int solutionIndex) {
    this.id = id;
    this.question = question;
    this.answersList = answersList;
    this.solutionIndex = solutionIndex;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public List<String> getAnswersList() {
    return answersList;
  }

  public void setAnswersList(List<String> answersList) {
    this.answersList = answersList;
  }

  public int getSolutionIndex() {
    return solutionIndex;
  }

  public void setSolutionIndex(int solutionIndex) {
    this.solutionIndex = solutionIndex;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  @Override
  public String toString() {
    return "Question{"
      + "id=" + id
      + ", question='" + question + '\''
      + ", answersList=" + answersList
      + ", solutionIndex=" + solutionIndex
      + ", category='" + category + '\''
      + '}';
  }
}
