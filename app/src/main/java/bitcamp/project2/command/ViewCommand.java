package bitcamp.project2.command;

import bitcamp.project2.util.SearchCalendar;
import bitcamp.project2.vo.ToDoList;

import java.sql.Date;
import java.util.Calendar;

public class ViewCommand {
  public ToDoList toDoList;

  public ViewCommand(ToDoList toDoList) {
    this.toDoList = toDoList;
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
    Date today = toDoList.getDate();
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(today);
    SearchCalendar.printWeekCalendar(calendar);
    

  }

}
