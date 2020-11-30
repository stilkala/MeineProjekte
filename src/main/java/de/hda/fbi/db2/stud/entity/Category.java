package de.hda.fbi.db2.stud.entity;

import java.util.ArrayList;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Category {
  @Id
  @GeneratedValue
  private int id;
  @Column(unique = true)
  private String name;
  @OneToMany(mappedBy = "category")
  private ArrayList<Question> questionList;

  Category(){

  }

  public Category(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ArrayList<Question> getQuestionList() {
    return questionList;
  }

  /**
   * Adds a Question object to the questions list.
   *
   */
  public void addQuestion(Question question) {
    if (questionList == null) {
      questionList = new ArrayList<>();
    }
    this.questionList.add(question);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Category category1 = (Category) o;
    return Objects.equals(name, category1.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return name;
  }
}
