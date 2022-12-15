package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    static final String GET_BASIC_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    static final String GET_NEW_PRODUCT = "상품명과 가격, 수량을 입력해 주세요.";
    static final String GET_USER_MONEY = "투입 금액을 입력해 주세요.";
    static final String GET_PURCHASE_PRODUCT_NAME = "구매할 상품명을 입력해 주세요.";


    public static String getBasicMoney(){
        System.out.println(GET_BASIC_MONEY);
        return Console.readLine();
    }

    public static String getNewProduct(){
        System.out.println(GET_NEW_PRODUCT);
        return Console.readLine();
    }

    public static String getUserMoney(){
        System.out.println(GET_USER_MONEY);
        return Console.readLine();
    }

    public static String getPurchaseProductName(){
        System.out.println(GET_PURCHASE_PRODUCT_NAME);
        return Console.readLine();
    }
}
