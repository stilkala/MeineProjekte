package de.hda.fbi.db2.stud.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Question {

  @Id
  private int id;
  private String question;
  @OneToMany(mappedBy = "question", cascade = CascadeType.PERSIST)
  private List<Answer> answersList;

  @ManyToOne
  private Category category;

  Question(){

  }

  /**
   * Constructor for the Questions Class.
   *
   */
  public Question(int id, String question, ArrayList<Answer> answersList) {
    this.id = id;
    this.question = question;
    this.answersList = answersList;
    for (Answer i: answersList) {
      i.setQuestion(this);
    }
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public List<Answer> getAnswersList() {
    return answersList;
  }

  public void setAnswersList(ArrayList<Answer> answersList) {
    this.answersList = answersList;
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
      + ", category='" + category + '\''
      + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Question question = (Question) o;
    return id == question.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
