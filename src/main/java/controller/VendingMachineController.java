package controller;

import generator.CoinGenerator;
import service.VendingMachineService;
import view.InputView;

public class VendingMachineController {
    private final CoinGenerator coinGenerator;

    public VendingMachineController() {
        this.coinGenerator = new CoinGenerator();
    }

    public void init() {
        String basicMoney = InputView.getBasicMoney();
        basicMoneyValidation(basicMoney);
        VendingMachineService vendingMachineService
                = new VendingMachineService(coinGenerator.makeCoinNumberGenerator(Integer.parseInt(basicMoney)));
    }

    private void basicMoneyValidation(String basicMoney) {
        try {
            Integer.parseInt(basicMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("자판기의 보유 금액은 숫자만 입력하셔야 합니다.");
        }
    }
}
