package bitcamp.project2.command;

import static bitcamp.project2.App.toDoList;

import bitcamp.project2.vo.Items;
import bitcamp.project2.vo.ToDoList;

public class ItemCommand {

    private Items items;

    public ItemCommand(ToDoList toDoList, Items items) {
        this.items = items;
    }

    public void executeItemCommand(String subTitle) {

        System.out.printf("현재 소재골드는 [ %d ] 입니다.\n", items.getGold());

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

    private void useLateCoupon(String subTitle) {
        printItemInventory();
        if (toDoList.isLate()){
            System.out.println("이미 달성하여 사용할 수 없습니다.");
        } else {
            toDoList.setLate(true);
            items.decrementCoupon(subTitle);
            System.out.printf("[%s]을(를) 사용하였습니다.\n", subTitle);
        }
    }


    private void useSleepCoupon(String subTitle) {
        printItemInventory();
        if (toDoList.isSleep()){
            System.out.println("이미 달성하여 사용할 수 없습니다.");
        } else {
            toDoList.setSleep(true);
            items.decrementCoupon(subTitle);
            System.out.printf("[%s]을(를) 사용하였습니다.\n", subTitle);
        }
    }

    private void useStudyCoupon(String subTitle) {
        printItemInventory();
        if (toDoList.isStudy()){
            System.out.println("이미 달성하여 사용할 수 없습니다.");
        } else {
            toDoList.setStudy(true);
            items.decrementCoupon(subTitle);
            System.out.printf("[%s]을(를) 사용하였습니다.\n", subTitle);
        }
    }

    private void useNightCoupon(String subTitle) {
        printItemInventory();
        if (toDoList.isNight()){
            System.out.println("이미 달성하여 사용할 수 없습니다.");
        } else {
            toDoList.setNight(true);
            items.decrementCoupon(subTitle);
            System.out.printf("[%s]을(를) 사용하였습니다.\n", subTitle);
        }
    }

    private void printItemInventory() {
        System.out.println("현재 아이템 리스트");
        System.out.printf("지각 : %d \n", items.getLateCoupon());
        System.out.printf("졸음 : %d \n", items.getSleepCoupon());
        System.out.printf("복습 : %d \n", items.getStudyCoupon());
        System.out.printf("야자 : %d \n", items.getNightCoupon());
    }
}
