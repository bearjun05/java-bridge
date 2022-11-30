package bridge;

import static bridge.OutputView.FINAL_RESULT;
import static bridge.OutputView.GAME_START;
import static bridge.OutputView.RETRY_OR_FINISH;
import static bridge.OutputView.SELECT_MOVING_SPACE;

import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private int indexCnt = -1;
    private int gameCnt = 1;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeGame = new BridgeGame();
        run();
    }

    public void run() {
        List<String> bridge = ready();
        boolean playResult = play(bridge);
        finish(playResult, gameCnt);
    }

    public List<String> ready() {
        outputView.printMessage(GAME_START);
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeGame.makeBridge(bridgeSize);
        return bridge;
    }

    public boolean play(List<String> bridge) {
        indexCnt++;
        outputView.printMessage(SELECT_MOVING_SPACE);
        String movingSpace = inputView.readMoving();
        boolean moveResult = bridgeGame.move(movingSpace, indexCnt);
        List<List<String>> stairs = bridgeGame.makeMap(moveResult, movingSpace);
        outputView.printMap(stairs);
        if (moveResult == false || indexCnt == bridge.size() - 1) {
            return playResult(bridge, moveResult, indexCnt);
        }
        return play(bridge);
    }

    public boolean retry(List<String> bridge) {
        gameCnt++;
        outputView.printMessage(RETRY_OR_FINISH);
        String gameCommand = inputView.readGameCommand();
        boolean isRetry = bridgeGame.retry(gameCommand);
        indexCnt = -1;
        if (!isRetry) {
            return false;
        }
        return play(bridge);
    }

    public void finish(boolean playResult, int gameCnt) {
        outputView.printMessage(FINAL_RESULT);
        outputView.printMap(bridgeGame.getStairs());
        outputView.printResult(playResult, gameCnt);
    }

    public boolean playResult(List<String> bridge, boolean moveResult, int indexCnt) {
        if (moveResult == false) {
            return retry(bridge);
        }
        if (indexCnt == bridge.size() - 1) {
            return true;
        }
        throw new IllegalArgumentException("[ERROR] playResult 에러가 발생 했습니다.");
    }
}