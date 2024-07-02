package bitcamp.project2.vo;

import java.time.LocalDate;

public class ToDoList {
  private static int size;
  private LocalDate date;
  private boolean late;
  private boolean sleep;
  private boolean study;
  private boolean night;

  public ToDoList() {
  }

  public ToDoList(LocalDate date) {
    this.date = date;
  }

  public static int getNextSize() {
    return ++size;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public boolean isLate() {
    return late;
  }

  public void setLate(boolean late) {
    this.late = late;
  }

  public boolean isSleep() {
    return sleep;
  }

  public void setSleep(boolean sleep) {
    this.sleep = sleep;
  }

  public boolean isStudy() {
    return study;
  }

  public void setStudy(boolean study) {
    this.study = study;
  }

  public boolean isNight() {
    return night;
  }

  public void setNight(boolean night) {
    this.night = night;
  }
}
