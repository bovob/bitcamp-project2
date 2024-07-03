package bitcamp.project2;

import bitcamp.project2.Prompt.Prompt;
import bitcamp.project2.command.*;
import bitcamp.project2.util.ArrayList;
import bitcamp.project2.vo.Items;
import bitcamp.project2.vo.ToDoList;

import java.time.LocalDate;

public class App {
  public static ArrayList arrList = new ArrayList();
  static String[] mainMenus = new String[] {"과업완료하기", "아이템사용", "상점가기", "업적조회", "일과종료", "포기하기"};
  public static String[][] subMenus = {{"노지각", "노졸음", "복습", "야자"}, // 과업완료하기
                                       {"지각방지", "졸음방지", "복습했다치기", "야자출튀"}, // 아이템사용
                                       {"지각방지", "졸음방지", "복습했다치기", "야자출튀"}, // 상점가기
                                       {"주별조회", "일별조회"}};// 업적조회
  static Items items = new Items();
  public ToDoList toDoList = new ToDoList(LocalDate.now());
  public CompleteCommand completeCommand = new CompleteCommand(items);
  public ItemCommand itemCommand = new ItemCommand(toDoList, items);
  public ShopCommand shopCommand = new ShopCommand(items);
  public ViewCommand viewCommand = new ViewCommand(arrList);
  public DayOverCommand dayOverCommand = new DayOverCommand(arrList);


  public static void main(String[] args) {
    Test test = new Test();
    test.addTest(arrList);
    App app = new App();
    app.execute();
  }

  static void printSubMenu(String menuTitle, String[] menus) {
    if (menuTitle.equals("아이템사용")|menuTitle.equals("상점가기"))
    {
      ItemCommand.printItemMenus(menuTitle, menus);
    } else {
      System.out.printf("[%s]\n", menuTitle);
      for (int i = 0; i < menus.length; i++) {
        System.out.printf("%d. %s\n", i + 1, menus[i]);
      }System.out.println("9. 이전");
    }
  }

  static boolean isValidateMenu(int menuNo, String[] menus) {
    return menuNo >= 1 && menuNo <= menus.length;
  }

  static String getMenuTitle(int menuNo, String[] menus) {
    return isValidateMenu(menuNo, menus) ? menus[menuNo - 1] : null;
  }

  public static void printGold() {
    System.out.printf("현재 보유골드는 [ %d ] 입니다. \n", items.getGold());
  }
  void printMainMenu() {
    String boldAnsi = "\033[1m";
    String redAnsi = "\033[31m";
    String resetAnsi = "\033[0m";
    String appTitle = "      [스파르타 전사키우기]";
    String line = "----------------------------------";
    System.out.println(boldAnsi + line + resetAnsi);
    System.out.println(boldAnsi + appTitle + resetAnsi);
    System.out.println(boldAnsi + line + resetAnsi);
    System.out.println(boldAnsi + "오늘 할일" + resetAnsi);
    System.out.println("노 지 각:  " + toDoList.isLate());
    System.out.println("노 졸 음:  " + toDoList.isSleep());
    System.out.println("복    습:  " + toDoList.isStudy());
    System.out.println("야    자:  " + toDoList.isNight());
    System.out.println(boldAnsi + line + resetAnsi);
    System.out.println(toDoList.getDate());
    System.out.println("Today : " + toDoList.getTodayComplete() + "%");
    toDoList.setTotalComplete(arrList.getAverage());
    System.out.println("Total : " + toDoList.getTotalComplete() + "%");
    System.out.println(boldAnsi + line + resetAnsi);

    // 오늘 할일 메소드 출력
    for (int i = 0; i < mainMenus.length; i++) {
      if (mainMenus[i].equals("종료")) {
        System.out.printf("%s%d. %s%s\n", (boldAnsi + redAnsi), (i + 1), mainMenus[i], resetAnsi);
      } else {
        System.out.printf("%d. %s\n", (i + 1), mainMenus[i]);
      }
    }
    System.out.println(boldAnsi + line + resetAnsi);
  }

  void execute() {
    String command;
    while (true) {
      printMainMenu();
      try {
        if (toDoList.getTotalComplete() < 20) {
          System.out.println("Game Over 당신은 훈련수당을 받을 수 없습니다.");
          break;
        }
        command = Prompt.input("메인> ");
        if (command.equals("menu")) {
          printMainMenu();
          continue;
        }
        int menuNo = Integer.parseInt(command);
        String menuTitle = getMenuTitle(menuNo, mainMenus);
        if (menuTitle == null) {
          System.out.println("유효한 메뉴 번호가 아닙니다.");
        } else if (menuTitle.equals("포기하기")) {
          System.out.println("Game Over 당신은 훈련수당을 받을 수 없습니다.");
          break;
        } else if (menuTitle.equals("일과종료")) {
          toDoList = dayOverCommand.excuteDayOverCommand(toDoList);
        } else {
          processSubMenu(menuTitle, subMenus[menuNo - 1]);
        }
      } catch (NumberFormatException ex) {
        System.out.println("숫자로 메뉴 번호를 입력하세요.");
      }
    }
    System.out.println("종료합니다.");
    Prompt.close();
  }

  void processSubMenu(String menuTitle, String[] menus) {
    printSubMenu(menuTitle, menus);
    while (true) {
      String command = Prompt.input(String.format("메인/%s> ", menuTitle));
      if (command.equals("menu")) {
        printSubMenu(menuTitle, menus);
        continue;
      } else if (command.equals("9")) {
        break;
      }
      try {
        int subMenuNo = Integer.parseInt(command);
        String subMenuTitle = getMenuTitle(subMenuNo, menus);
        if (subMenuTitle == null) {
          System.out.println("유효한 메뉴 번호가 아닙니다.");
        } else {
          switch (menuTitle) {
            case "과업완료하기":
              completeCommand.excuteCompleteCommand(subMenuTitle, toDoList);
              break;
            case "아이템사용":
              itemCommand.executeItemCommand(subMenuTitle);
              break;
            case "상점가기":
              shopCommand.executeShopCommand(subMenuTitle);
              break;
            case "업적조회":
              viewCommand.excuteViewCommand(subMenuTitle, toDoList);
              break;
          }
        }
      } catch (NumberFormatException ex) {
        System.out.println("숫자로 메뉴 번호를 입력하세요.");
      }
    }

  }

  public void printGraph(float total, String day) {
    String dotCode = "\u25AE";
    String redAnsi = "\033[31m";
    String resetAnsi = "\033[0m";
    String blueAnsi = "\033[94m";

    int barLength = 18;
    double ratio = total == 0 ? 0 : total / 100.0f;
    int filledLength = (int) (ratio * barLength);

    switch (day) {
      case "today":
        for (int i = 0; i < filledLength; i++) {
          System.out.printf("%s%s%s", blueAnsi, dotCode, resetAnsi);
        }
        break;
      case "total":
        for (int i = 0; i < filledLength; i++) {
          System.out.printf("%s%s%s", redAnsi, dotCode, resetAnsi);
        }
        break;
    }
    System.out.println();
  }
}


