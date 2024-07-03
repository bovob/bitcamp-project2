package bitcamp.project2.command;

import bitcamp.project2.vo.Items;
import bitcamp.project2.vo.ToDoList;


public class ItemCommand {

    private ToDoList toDoList;
    private Items items;

    public ItemCommand(ToDoList toDoList, Items items) {
        this.toDoList = toDoList;
        this.items = items;
    }

    public void executeItemCommand(String subTitle) {

        switch (subTitle){
            case "지각방지":
                useLateCoupon(subTitle);
                break;
            case "졸음방지":
                useSleepCoupon(subTitle);
                break;
            case "복습했다치기":
                useStudyCoupon(subTitle);
                break;
            case "야자출튀":
                useNightCoupon(subTitle);
                break;
        }

    }

    public void checkItem(String subTitle){
        switch (subTitle){
            case "지각방지":
                if(items.getLateCoupon() == 0) {
                    System.out.println("아이템이 없습니다.");
                    break;
                }else {
                    items.decrementCoupon(subTitle);
                    System.out.printf("[%s]을(를) 사용하였습니다.\n", subTitle);
                }
                break;
            case "졸음방지":
                if(items.getSleepCoupon() == 0) {
                    System.out.println("아이템이 없습니다.");
                    break;
                }else {
                    items.decrementCoupon(subTitle);
                    System.out.printf("[%s]을(를) 사용하였습니다.\n", subTitle);
                }
                break;
            case "복습했다치기":
                if(items.getStudyCoupon() == 0) {
                    System.out.println("아이템이 없습니다.");
                    break;
                }else {
                    items.decrementCoupon(subTitle);
                    System.out.printf("[%s]을(를) 사용하였습니다.\n", subTitle);
                }
                break;
            case "야자출튀":
                if(items.getNightCoupon() == 0) {
                    System.out.println("아이템이 없습니다.");
                    break;
                }else {
                    items.decrementCoupon(subTitle);
                    System.out.printf("[%s]을(를) 사용하였습니다.\n", subTitle);
                }
                break;
        }
    }

    private void useLateCoupon(String subTitle) {
        if (toDoList.isLate()){
            System.out.println("이미 달성하여 사용할 수 없습니다.");
        } else {
            toDoList.setLate(true);
            checkItem(subTitle);
        }
    }


    private void useSleepCoupon(String subTitle) {
        if (toDoList.isSleep()){
            System.out.println("이미 달성하여 사용할 수 없습니다.");
        } else {
            toDoList.setSleep(true);
            checkItem(subTitle);
        }
    }

    private void useStudyCoupon(String subTitle) {
        if (toDoList.isStudy()){
            System.out.println("이미 달성하여 사용할 수 없습니다.");
        } else {
            toDoList.setStudy(true);
            checkItem(subTitle);
        }
    }

    private void useNightCoupon(String subTitle) {
        if (toDoList.isNight()){
            System.out.println("이미 달성하여 사용할 수 없습니다.");
        } else {
            toDoList.setNight(true);
            checkItem(subTitle);
        }
    }

    public void printItemInventory() {
        System.out.println("[현재 아이템 리스트]");
        System.out.printf("지각방지.......%d 개\n", items.getLateCoupon());
        System.out.printf("졸음방지.......%d 개\n", items.getSleepCoupon());
        System.out.printf("복습했다치기...%d 개\n", items.getStudyCoupon());
        System.out.printf("야자출튀.......%d 개\n", items.getNightCoupon());
        printGold();
    }

    public void printGold(){
        System.out.printf("현재 보유골드는 [ %d ] 입니다. \n", items.getGold());
    }

    public void printItemList(){
        String line = "----------------------------------";

        System.out.println(line);
        System.out.println("현재 할일 현황");
        System.out.printf("노지각 : %s  노졸음 : %s\n", toDoList.isLate(), toDoList.isSleep());
        System.out.printf("복  습 : %s  야  자 : %s\n", toDoList.isStudy(), toDoList.isNight());
        System.out.println(line);
        printItemInventory();
        System.out.println(line);
    }
}
