package bitcamp.project2;

import bitcamp.project2.util.ArrayList;
import bitcamp.project2.vo.ToDoList;

import java.time.LocalDate;

public class Test {

  public void addTest(ArrayList arrayList) {
    ToDoList toDoList1 = new ToDoList();
    toDoList1.setDate(LocalDate.parse("2024-07-01"));
    toDoList1.setLate(true);
    toDoList1.setSleep(true);
    toDoList1.setStudy(true);
    toDoList1.setNight(true);
    toDoList1.setTodayComplete();
    toDoList1.setTodayComplete();
    toDoList1.setTotalComplete(arrayList.getAverage());
    arrayList.add(toDoList1);

    ToDoList toDoList2 = new ToDoList();
    toDoList2.setDate(LocalDate.parse("2024-07-02"));
    toDoList2.setLate(false);
    toDoList2.setSleep(true);
    toDoList2.setStudy(true);
    toDoList2.setNight(false);
    toDoList2.setTodayComplete();
    toDoList2.setTodayComplete();
    toDoList2.setTotalComplete(arrayList.getAverage());
    arrayList.add(toDoList2);

    //    ToDoList toDoList3 = new ToDoList();
    //    toDoList3.setDate(LocalDate.parse("2024-07-02"));
    //    toDoList3.setLate(false);
    //    toDoList3.setSleep(true);
    //    toDoList3.setStudy(true);
    //    toDoList3.setNight(false);
    //    toDoList3.setTodayComplete();
    //    toDoList3.setTodayComplete();
    //    toDoList3.setTotalComplete(arrayList.getAverage());
    //    arrayList.add(toDoList3);
  }
}
