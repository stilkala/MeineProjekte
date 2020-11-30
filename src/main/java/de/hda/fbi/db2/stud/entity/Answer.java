package de.hda.fbi.db2.stud.entity;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answer {
  @Id
  @GeneratedValue
  private int id;
  private String answer;
  private boolean isCorrect;
  @ManyToOne
  private Question question;

  Answer(){

  }

  public Answer(String answer) {
    this.answer = answer;
    this.isCorrect = false;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  public boolean isCorrect() {
    return isCorrect;
  }

  public void setCorrect(boolean correct) {
    isCorrect = correct;
  }

  public Question getQuestion() {
    return question;
  }

  public void setQuestion(Question question) {
    this.question = question;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Answer answer1 = (Answer) o;
    return answer.equals(answer1.answer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(answer);
  }
}
