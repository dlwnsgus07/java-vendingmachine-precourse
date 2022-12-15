package domain;

import vendingmachine.Coin;

import java.util.Arrays;
import java.util.HashMap;

public class Change {
    private HashMap<Integer, Integer> changeNumber;

    public Change(HashMap<Integer, Integer> coinNumber) {
        this.changeNumber = coinNumber;
    }

    public HashMap<Integer, Integer> CalcMinimumChangeNumber(int amount) {
        HashMap<Integer, Integer> minimumChange = new HashMap<>();
        Arrays.stream(Coin.values()).forEach(coin -> {
            int maxNumber = 0;
            while (amount != 0) {
                if (amount - coin.getAmount() * maxNumber >= 0) {
                    maxNumber += 1;
                } else {
                    break;
                }
                if (maxNumber != 0) {
                    minimumChange.put(coin.getAmount(), maxNumber);
                }
            }
        });
        return minimumChange;
    }
}
