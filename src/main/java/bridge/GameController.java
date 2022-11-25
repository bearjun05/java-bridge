package bridge;

import static bridge.InputView.QUIT;
import static bridge.OutputView.FINAL_RESULT;
import static bridge.OutputView.GAME_START;
import static bridge.OutputView.RETRY_OR_FINISH;
import static bridge.OutputView.SELECT_MOVING_SPACE;

import java.util.List;
import java.util.Stack;

public class GameController {
   private final InputView inputView;
   private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        run();
    }

    public void ready() {
    }

    public void start() {
    }

    public void retry() {
    }

    public void finish() {
    }

    public void run() {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        outputView.printMessage(GAME_START);
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        System.out.println(bridge);

        int cnt = -1;
        boolean flag = true;
        Stack<String> upstairs = new Stack<>();
        Stack<String> downstairs = new Stack<>();
        boolean flag2 = true;
        int cnt2 = 0;
        while (flag2) {
            cnt2++;
            upstairs.clear();
            downstairs.clear();
            flag = true;
            cnt = -1;
            while (flag && cnt <= 3) {
                cnt++;
                outputView.printMessage(SELECT_MOVING_SPACE);
                String movingSpace = inputView.readMoving();
                if (upstairs.isEmpty() && downstairs.isEmpty()) {
                    upstairs.add("[");
                    downstairs.add("[");
                } else if (!upstairs.isEmpty() && !downstairs.isEmpty()) {
                    upstairs.pop();
                    downstairs.pop();
                    upstairs.add("|");
                    downstairs.add("|");
                }
                if (bridge.get(cnt).equals(movingSpace)) {
                    if (movingSpace.equals("U")) {
                        upstairs.add(" O ");
                        downstairs.add("   ");
                    }
                    if (movingSpace.equals("D")) {
                        upstairs.add("   ");
                        downstairs.add(" O ");
                    }
                    upstairs.add("]");
                    downstairs.add("]");
                }
                if (!bridge.get(cnt).equals(movingSpace)) {
                    if (movingSpace.equals("U")) {
                        upstairs.add(" X ");
                        downstairs.add("   ");
                    }
                    if (movingSpace.equals("D")) {
                        upstairs.add("   ");
                        downstairs.add(" X ");
                    }
                    upstairs.add("]");
                    downstairs.add("]");
                    flag = false;
                }
                outputView.printMap(upstairs, downstairs);
                System.out.println(); //처음으로 돌아갔을때 띄어쓰기

                if(cnt + 1 == bridge.size() && flag == true) {
                    flag2 = false;
                    break;
                }

                if (flag == false) {
                    outputView.printMessage(RETRY_OR_FINISH);
                    String retry = inputView.readGameCommand();
                    if(retry.equals(QUIT)) {
                        flag2 = false;
                    }
                }
            }
        }
        outputView.printMessage(FINAL_RESULT);
        outputView.printMap(upstairs, downstairs);
        outputView.printResult(flag, cnt2);
    }
}