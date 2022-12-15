package generator;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Change;
import vendingmachine.Coin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CoinGenerator {
    public static Change makeCoinNumberGenerator(int change){
        List<Integer> coins = new ArrayList<>();
        HashMap<Integer, Integer> coinNumber = new HashMap<>();
        Arrays.stream(Coin.values()).forEach(coin -> {
            coins.add(coin.getAmount());
            coinNumber.put(coin.getAmount(), 0);
        }
        );
        while(change != 0){
            int coin = Randoms.pickNumberInList(coins);
            if(change - coin >= 0){
                coinNumber.put(coin, coinNumber.get(coin) + 1);
                change -= coin;
            }
            if(change - coin < 0){
                coins.remove(coin);
            }
        }
        return new Change(coinNumber);
    }
}
