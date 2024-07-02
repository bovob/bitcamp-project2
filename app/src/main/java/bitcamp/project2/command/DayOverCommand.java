package bitcamp.project2.command;

import bitcamp.project2.Prompt.Prompt;
import bitcamp.project2.util.ArrayList;
import bitcamp.project2.vo.ToDoList;

import java.sql.Date;
import java.util.Calendar;

public class DayOverCommand {
  public ToDoList toDoList;
  public ArrayList arr = new ArrayList();

  public DayOverCommand(ToDoList toDoList) {
    this.toDoList = toDoList;
  }

  public void excuteDayOverCommand() {
    while (true) {
      String command = Prompt.input("하루일과를 종료 하시겠습니까?(Y/N)");
      if (command.equalsIgnoreCase("Y")) {
        //ArrayList 추가
        arr.add(toDoList);
        //toDoList 초기화
        Date today = toDoList.getDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        java.util.Date nextDate = calendar.getTime();
        Date tomorrow = new Date(nextDate.getTime());
        toDoList.setDate(tomorrow);
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
