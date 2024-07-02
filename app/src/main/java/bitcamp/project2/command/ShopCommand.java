package bitcamp.project2.command;

import bitcamp.project2.vo.Items;

public class ShopCommand {
    private Items items;

    public ShopCommand(Items items){
        this.items = items;
    }

    public void executeShopCommand(String subTitle) {

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
        }System.out.printf("입장 소재골드는 [ %d ] 입니다.\n", items.getGold());
    }

    private void buyLateCoupon(String subTitle) {
        items.incrementCoupon(subTitle);
        System.out.printf("현재 [%s]는 [%d]개 입니다.\n", subTitle, items.getLateCoupon());
        items.decrementGold(1);
        System.out.printf("현재 소재골드는 [ %d ] 입니다.\n", items.getGold());
    }

    private void buySleepCoupon(String subTitle) {
        items.incrementCoupon(subTitle);
        System.out.printf("현재 [%s]는 [%d]개 입니다.\n", subTitle, items.getSleepCoupon());
        items.decrementGold(10);
        System.out.printf("현재 소재골드는 [ %d ] 입니다.\n", items.getGold());
    }

    private void buyStudyCoupon(String subTitle) {
        items.incrementCoupon(subTitle);
        System.out.printf("현재 [%s]는 [%d]개 입니다.\n", subTitle, items.getStudyCoupon());
        items.decrementGold(100);
        System.out.printf("현재 소재골드는 [ %d ] 입니다.\n", items.getGold());
    }

    private void buyNightCoupon(String subTitle) {
        items.incrementCoupon(subTitle);
        System.out.printf("현재 [%s]는 [%d]개 입니다.\n", subTitle, items.getNightCoupon());
        items.decrementGold(1000);
        System.out.printf("현재 소재골드는 [ %d ] 입니다.\n", items.getGold());
    }

}
