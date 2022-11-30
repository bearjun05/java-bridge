package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeMaker bridgeMaker;
    private final MapMaker mapMaker;
    private List<String> bridge;

    public BridgeGame() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        mapMaker = new MapMaker();
        bridge = new ArrayList<>();
    }

    public List<String> makeBridge(int bridgeSize) {
        bridge = bridgeMaker.makeBridge(bridgeSize);
        System.out.println(bridge);
        return bridge;
    }

    public List<List<String>> makeMap(boolean moveResult, String movingSpace) {
        List<String> selectedStair = mapMaker.decideUpOrDown(movingSpace);
        mapMaker.putComponent(selectedStair, moveResult);
        mapMaker.putBlank(selectedStair);
        return mapMaker.bindStairs();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String movingSpace, int indexCnt) {
        if (bridge.get(indexCnt).equals(movingSpace)) {
            return true;
        }
        if (!bridge.get(indexCnt).equals(movingSpace)) {
            return false;
        }
        throw new IllegalArgumentException("[ERROR] move 에러가 발생했습니다");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        if (gameCommand.equals("R")) {
            mapMaker.init();
            return true;
        }
        if (gameCommand.equals("Q")) {
            return false;
        }
        throw new IllegalArgumentException("[ERROR] retry 에러가 발생했습니다.");
    }

    public List<List<String>> getStairs() {
        return mapMaker.bindStairs();
    }
}
