package de.hda.fbi.db2.stud.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {
  @Id
  private String category;
  private List<Question> questionList;

  public Category(String category) {
    this.category = category;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public List<Question> getQuestionList() {
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
    return Objects.equals(category, category1.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(category);
  }
}
