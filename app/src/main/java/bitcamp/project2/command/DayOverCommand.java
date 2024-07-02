package bitcamp.project2.command;

import bitcamp.project2.Prompt.Prompt;
import bitcamp.project2.util.ArrayList;
import bitcamp.project2.vo.ToDoList;

import java.util.Calendar;
import java.util.Date;

public class DayOverCommand {
  public ToDoList toDoList;
  public ArrayList arr;

  public DayOverCommand() {
  }

  public DayOverCommand(ToDoList toDoList, ArrayList arr) {
    this.toDoList = toDoList;
    this.arr = arr;
  }

  public void excuteDayOverCommand() {
    while (true) {
      String command = Prompt.input("하루일과를 종료 하시겠습니까?(Y/N)");
      if (command.equalsIgnoreCase("Y")) {
        //ArrayList 추가
        ToDoList newToDoList = new ToDoList();
        newToDoList.setDate(Calendar.getInstance().getTime());
        arr.add(toDoList);
        //toDoList 초기화
        Date today = toDoList.getDate();
        Calendar originalCalendar = Calendar.getInstance();
        Calendar clonedCalendar = (Calendar) originalCalendar.clone();
        clonedCalendar.setTime(today);
        clonedCalendar.add(Calendar.DAY_OF_MONTH, 1);
        Date tomorrow = clonedCalendar.getTime();
        toDoList.setDate(new Date(tomorrow.getTime()));
        toDoList.setLate(false);
        toDoList.setSleep(false);
        toDoList.setStudy(false);
        toDoList.setNight(false);
        System.out.println("저장 완료.");
        System.out.printf("%s로 넘어갑니다.\n", toDoList.getDate());
        return;
      } else if (command.equalsIgnoreCase("N")) {
        System.out.println("메인 메뉴로 돌아 갑니다.");
        return;
      } else {
        System.out.println("Y 나 N를 입력하세요");
      }
    }
  }

  public ArrayList getArray() {
    return this.arr;
  }
}
