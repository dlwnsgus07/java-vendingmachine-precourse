package domain;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private final List<Menu> menuList = new ArrayList<>();
    private final Change change;

    public VendingMachine(Change change) {
        this.change = change;
    }

    public void addMenu(Menu menu){
        menuList.add(menu);
    }
}
