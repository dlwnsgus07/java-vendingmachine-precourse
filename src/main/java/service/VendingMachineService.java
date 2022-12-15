package service;

import domain.Change;
import domain.Menu;
import domain.VendingMachine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VendingMachineService {
    private final VendingMachine vendingMachine;

    public VendingMachineService(Change change) {
        this.vendingMachine = new VendingMachine(change);
    }

    public void addMenu(String menuList ){
        splitValidation(menuList);
        String[] menuInfo = menuList.split(";");
        for(String info : menuInfo){
            List<String> menu = Arrays.stream(info.split(",")).collect(Collectors.toList());
            vendingMachine.addMenu(new Menu(menu.get(0), Integer.parseInt(menu.get(1)), Integer.parseInt(menu.get(2))));
        }
    }

    private void splitValidation(String menuList) {
        String[] splitString = menuList.split(";");
        for (String menuInfo: splitString) {
            if(!menuInfo.matches("^[$]")){
                throw new IllegalArgumentException("각 메뉴는 []를 통해 감싸져 있어야 합니다.");
            }
            infoValidation(menuInfo);
        }
    }

    private void infoValidation(String menuInfo) {
        List<String> collect = Arrays.stream(menuInfo.split(",")).collect(Collectors.toList());
        if(collect.size() != 3){
            throw new IllegalArgumentException("[상품명, 가격, 수량] 3개만 입력이 가능합니다.");
        }
        for(int i=1;i<collect.size();i++){
            try {
                Integer.parseInt(collect.get(i));
            }
            catch (NumberFormatException e){
                throw new IllegalArgumentException("가격과 수량에는 숫자만 입력이 가능합니다.");
            }
        }
    }
}
