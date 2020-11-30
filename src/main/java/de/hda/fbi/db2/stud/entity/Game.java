package de.hda.fbi.db2.stud.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



public class Game {
  @Id
  @GeneratedValue
  private int id;

  @OneToOne
  private Player player;

  private Date gameStart;
  private Date gameEnd;

  @OneToMany
  private ArrayList<Category> selectedCategories;

  @OneToMany
  private Map<Question, Integer> questionList;

  public Game(Player player, Date gameStart) {
    this.player = player;
    this.gameStart = new Date(gameStart.getTime());
  }

  public int getId() {
    return id;
  }

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  public Date getGameStart() {
    return new Date(gameStart.getTime());
  }

  public void setGameStart(Date gameStart) {
    this.gameStart = new Date(gameStart.getTime());
  }

  public Date getGameEnd() {
    return new Date(gameEnd.getTime());
  }

  public void setGameEnd(Date gameEnd) {
    this.gameEnd = new Date(gameEnd.getTime());
  }

  public ArrayList<Category> getSelectedCategories() {
    return selectedCategories;
  }

  public void setSelectedCategories(ArrayList<Category> selectedCategories) {
    this.selectedCategories = selectedCategories;
  }

  public Map<Question, Integer> getQuestionList() {
    return questionList;
  }

  public void setQuestionList(Map<Question, Integer> questionList) {
    this.questionList = questionList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Game game = (Game) o;
    return id == game.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
