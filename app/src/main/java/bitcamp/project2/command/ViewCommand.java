package bitcamp.project2.command;

import bitcamp.project2.util.ArrayList;
import bitcamp.project2.vo.ToDoList;

import java.util.Calendar;
import java.util.Date;

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
      for (Object obj : arr.toArray()) {
        ToDoList toDDo = (ToDoList) obj;
        System.out.println(toDDo.getDate());
      }
      //      Date[] week = getWeek();
      //      for (int i = 0; i < week.length; i++) {
      //        Object obj = arr.getToDoList(week[i]);
      //        ToDoList toDo = (ToDoList) obj;
      //        if (toDo != null) {
      //          System.out.print("       yes       |");
      //        } else {
      //          System.out.print("      00-00      |");
      //        }
      //      }
      //      System.out.println();
    }
  }

  private Date[] getWeek() {
    Date[] week = new Date[7];
    Date today = toDoList.getDate();
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(today);
    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
    calendar.add(Calendar.DAY_OF_MONTH, Calendar.SUNDAY - dayOfWeek);
    for (int i = 0; i < 7; i++) {
      week[i] = calendar.getTime();
      System.out.printf("%1$8tm-%1$-8td|", week[i]);
      calendar.add(Calendar.DAY_OF_MONTH, 1);
    }
    System.out.println();
    return week;
  }

}
