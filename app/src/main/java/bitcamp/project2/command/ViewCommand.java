package bitcamp.project2.command;

import bitcamp.project2.util.ArrayList;
import bitcamp.project2.vo.ToDoList;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ViewCommand {
  public ToDoList toDoList;
  public ArrayList arr;

  public ViewCommand(ToDoList toDoList, ArrayList arr) {
    this.toDoList = toDoList;
    this.arr = arr;
  }

  public void excuteViewCommand(String subTitle) {
    //        System.out.printf("[%s]\n", subTitle);
    switch (subTitle) {
      case "주별조회":
        viewWeek();
        break;
    }
  }

  private void viewWeek() {
    if (arr.size() != 0) {

      LocalDate[] week = getWeek();
      for (int i = 0; i < week.length; i++) {
        System.out.printf("   %1$tm-%1$td   |", week[i]);
      }
      System.out.println();
      for (int i = 0; i < week.length; i++) {
        Object obj = arr.getToDoList(week[i]);
        ToDoList toDDo = (ToDoList) obj;
        if (toDDo != null) {
          System.out.print("    yes    |");
        } else {
          System.out.print("     no    |");
        }
      }
      System.out.println();
    }
  }
  //            System.out.print("    yes    |");
  //            System.out.print("     no    |");

  private LocalDate[] getWeek() {
    LocalDate[] week = new LocalDate[7];
    LocalDate today = toDoList.getDate();

    LocalDate startOfWeek = today.with(DayOfWeek.MONDAY);
    LocalDate endOfWeek = today.with(DayOfWeek.SUNDAY);

    LocalDate current = startOfWeek;
    int index = 0;
    while (!current.isAfter(endOfWeek)) {
      week[index++] = current;
      current = current.plusDays(1);
    }
    return week;
  }
}
