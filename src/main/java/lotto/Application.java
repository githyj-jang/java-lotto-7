package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int numberOfLottos = LottoConstants.getLottoNums();
        List<Lotto> lottos = lottoIssuance(numberOfLottos);

    }

    private static List<Lotto> lottoIssuance(int numberOfLottos) {
        System.out.println(numberOfLottos+"개를 구매했습니다.");
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            Lotto loto = Lotto.generateRandomLotto();
            System.out.println(loto.getNumbers());
            lottos.add(loto);
        }
        return lottos;
    }

}

enum LottoConstants {
    LOTTO_PRICE(1000);

    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static int getLottoNums() {
        System.out.println("구입금액을 입력해 주세요.");
        int inputMoney = Integer.parseInt(Console.readLine());
        if (inputMoney % LottoConstants.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException("[ERROR] 입력된 금액이 " + LottoConstants.LOTTO_PRICE.getValue() + "원 단위로 나누어 떨어지지 않습니다.");
        }
        int numberOfLottos = inputMoney / LottoConstants.LOTTO_PRICE.getValue();
        return numberOfLottos;
    }
}