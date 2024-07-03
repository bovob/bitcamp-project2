package bitcamp.project2.command;

import bitcamp.project2.vo.Items;
import bitcamp.project2.vo.ToDoList;

public class CompleteCommand {
  public ToDoList toDoList;
  private Items items;

  public CompleteCommand(ToDoList toDoList, Items items) {
    this.toDoList = toDoList;
    this.items = items;
  }

  public void excuteCompleteCommand(String subTitle) {
    //    System.out.printf("[%s]\n", subTitle);
    switch (subTitle) {
      case "노지각":
        completeLate(subTitle);
        break;
      case "노졸음":
        completeSleep(subTitle);
        break;
      case "복습":
        completeStudy(subTitle);
        break;
      case "야자":
        completeNight(subTitle);
        break;
    }
  }

  void completeLate(String subTitle) {
    if (toDoList.isLate()) {
      System.out.printf("[%s]은(는) 이미 완료 했습니다.\n", subTitle);
    } else {
      toDoList.setLate(true);
      System.out.printf("[%s]을(를) 완료 했습니다.\n", subTitle);
      items.incrementGold(10);
      System.out.println("100 골드를 얻었습니다.");
    }
  }

  void completeSleep(String subTitle) {
    if (toDoList.isSleep()) {
      System.out.printf("[%s]은(는) 이미 완료 했습니다.\n", subTitle);
    } else {
      toDoList.setSleep(true);
      System.out.printf("[%s]을(를) 완료 했습니다.\n", subTitle);
      items.incrementGold(20);
      System.out.println("200 골드를 얻었습니다.");
    }
  }


  void completeStudy(String subTitle) {
    if (toDoList.isStudy()) {
      System.out.printf("[%s]은(는) 이미 완료 했습니다.\n", subTitle);
    } else {
      toDoList.setStudy(true);
      System.out.printf("[%s]을(를) 완료 했습니다.\n", subTitle);
      items.incrementGold(50);
      System.out.println("300 골드를 얻었습니다.");
    }
  }

  void completeNight(String subTitle) {
    if (toDoList.isNight()) {
      System.out.printf("[%s]은(는) 이미 완료 했습니다.\n", subTitle);
    } else {
      toDoList.setNight(true);
      System.out.printf("[%s]을(를) 완료 했습니다.\n", subTitle);
      items.incrementGold(100);
      System.out.println("500 골드를 얻었습니다.");
    }
  }
}
