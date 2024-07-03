package bitcamp.project2.command;

import bitcamp.project2.util.ArrayList;
import bitcamp.project2.vo.ToDoList;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ViewCommand {
  public ArrayList arr;

  public ViewCommand(ArrayList arr) {
    this.arr = arr;
  }

  public void excuteViewCommand(String subTitle, ToDoList toDoList) {
    //        System.out.printf("[%s]\n", subTitle);
    switch (subTitle) {
      case "주별조회":
        viewWeek(toDoList);
        break;
    }
  }

  private void viewWeek(ToDoList toDoList) {
    String boldAnsi = "\033[1m";
    String redAnsi = "\033[31m";
    String resetAnsi = "\033[0m";
    String line = "----------------------------------------------------------------------";
    System.out.println(boldAnsi + line + resetAnsi);

    if (arr.size() != 0) {

      LocalDate[] week = getWeek(toDoList);
      System.out.print("| 날      짜 |");
      for (int i = 0; i < week.length; i++) {
        System.out.printf(" %1$tm-%1$td |", week[i]);
      }
      System.out.println();
      System.out.print("| 당일달성률 |");
      for (int i = 0; i < week.length; i++) {
        Object obj = arr.getToDoList(week[i]);
        ToDoList toDDo = (ToDoList) obj;
        if (toDDo != null) {
          System.out.printf(" %5.1f |", toDDo.getTodayComplete());
        } else {
          System.out.print("       |");
        }
      }
      System.out.println();
      System.out.print("| 누적달성률 |");
      for (int i = 0; i < week.length; i++) {
        Object obj = arr.getToDoList(week[i]);
        ToDoList toDDo = (ToDoList) obj;
        if (toDDo != null) {
          System.out.printf(" %5.1f |", toDDo.getTotalComplete());
        } else {
          System.out.print("       |");
        }
      }
      System.out.println();
    }
    System.out.println(boldAnsi + line + resetAnsi);

  }

  private LocalDate[] getWeek(ToDoList toDoList) {
    LocalDate[] week = new LocalDate[7];
    LocalDate today = toDoList.getDate();
    System.out.println(today);

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
