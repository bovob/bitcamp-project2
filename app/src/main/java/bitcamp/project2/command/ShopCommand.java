package bitcamp.project2.command;

import bitcamp.project2.vo.Items;

public class ShopCommand {
    private Items items;

    public ShopCommand(Items items){
        this.items = items;
    }

    public static int priceLateCoupon = 500;
    public static int priceSleepCoupon = 1000;
    public static int priceStudyCoupon = 10000;
    public static int priceNightCoupon = 5000;

    public void executeShopCommand(String subTitle) {
        printItemList();

        switch (subTitle){
            case "지각방지":
                buyLateCoupon(subTitle);
                break;
            case "졸음방지":
                buySleepCoupon(subTitle);
                break;
            case "복습했다치기":
                buyStudyCoupon(subTitle);
                break;
            case "야자출튀":
                buyNightCoupon(subTitle);
                break;
        }
    }

    private void buyLateCoupon(String subTitle) {
        if (items.getGold() < 50) {
            System.out.println("골드가 부족합니다.");
        } else {
            items.incrementCoupon(subTitle);
            System.out.printf("[%s]를 구매했습니다.\n", subTitle);
            items.decrementGold(50);
        }
    }

    private void buySleepCoupon(String subTitle) {
        if (items.getGold() < 100) {
            System.out.println("골드가 부족합니다.");
        } else {
            items.incrementCoupon(subTitle);
            System.out.printf("[%s]를 구매했습니다.\n", subTitle);
            items.decrementGold(100);
        }
    }

    private void buyStudyCoupon(String subTitle) {
        if (items.getGold() < 50) {
            System.out.println("골드가 부족합니다.");
        } else {
            items.incrementCoupon(subTitle);
            System.out.printf("[%s]를 구매했습니다.\n", subTitle);
            items.decrementGold(50);
        }
    }

    private void buyNightCoupon(String subTitle) {
        if (items.getGold() < 200) {
            System.out.println("골드가 부족합니다.");
        } else {
            items.incrementCoupon(subTitle);
            System.out.printf("[%s]를 구매했습니다.\n", subTitle);
            items.decrementGold(200);
        }
    }

    public void printItemBuyList() {
        System.out.println("[아이템 가격]");
        System.out.printf("1.지각방지.......%d 골드\n", priceLateCoupon);
        System.out.printf("2.졸음방지.......%d 골드\n", priceSleepCoupon);
        System.out.printf("3.복습했다치기...%d 골드\n", priceStudyCoupon);
        System.out.printf("4.야자출튀.......%d 골드\n", priceNightCoupon);
    }

    public void printItemInventory() {
        System.out.println("[현재 아이템 리스트]");
        System.out.printf("1.지각방지.......%d 개\n", items.getLateCoupon());
        System.out.printf("2.졸음방지.......%d 개\n", items.getSleepCoupon());
        System.out.printf("3.복습했다치기...%d 개\n", items.getStudyCoupon());
        System.out.printf("4.야자출튀.......%d 개\n", items.getNightCoupon());
        printGold();
    }

    public void printGold(){
        String line = "----------------------------------";
        System.out.println(line);
        System.out.printf("현재 보유골드는 [ %d ] 입니다. \n", items.getGold());
    }

    public void printItemList(){
        String line = "----------------------------------";
        System.out.println(line);
        printItemBuyList();
        System.out.println(line);
        printItemInventory();
        System.out.println(line);
    }

}
