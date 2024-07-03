package bitcamp.project2.command;

import bitcamp.project2.Prompt.Prompt;
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

      case "일별조회":
        viewDay(toDoList);
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
      System.out.printf("조회 기준일 : %s\n", toDoList.getDate());
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

  private void viewDay(ToDoList toDoList) {
    String line = "----------------------------------";
    LocalDate findDate = Prompt.inputDate("조회일(yyyy-MM-dd)?");
    System.out.println(line);
    Object obj = arr.getToDoList(findDate);
    System.out.println(line);
    ToDoList toDo = (ToDoList) obj;
    if (toDo != null) {
      System.out.printf("조 회 일 : %s\n", findDate);
      System.out.printf("%s노 지 각 :  %s%s\n", (toDo.isLate() ? "\033[94m" : "\033[31m"),
          (toDo.isLate() ? "완료" : "실패"), "\033[0m");
      System.out.printf("%s노 졸 음 :  %s%s\n", (toDo.isSleep() ? "\033[94m" : "\033[31m"),
          (toDo.isSleep() ? "완료" : "실패"), "\033[0m");
      System.out.printf("%s복    습 :  %s%s\n", (toDo.isStudy() ? "\033[94m" : "\033[31m"),
          (toDo.isStudy() ? "완료" : "실패"), "\033[0m");
      System.out.printf("%s야    자 :  %s%s\n", (toDo.isNight() ? "\033[94m" : "\033[31m"),
          (toDo.isNight() ? "완료" : "실패"), "\033[0m");
      System.out.println(line);
      System.out.printf("Today : %4.1f%%  \n", toDo.getTodayComplete());
      System.out.printf("Total : %4.1f%%  \n", toDo.getTotalComplete());

    } else {
      System.out.println("해당 날짜에는 공부를 안햇습니다.");
    }
    System.out.println(line);


  }

  private LocalDate[] getWeek(ToDoList toDoList) {
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
