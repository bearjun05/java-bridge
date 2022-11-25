package bridge;

import java.util.Stack;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static final String GAME_START = "다리 건너기 게임을 시작합니다."
            + "\n다리의 길이를 입력해주세요.";
    public static final String SELECT_MOVING_SPACE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String RETRY_OR_FINISH = "게임을 다시 시도할지 여부를 입력해주세요. 재시도: R, 종료: Q";
    public static final String FINAL_RESULT = "\n최종 게임 결과";
    public static final String IS_SUCCESS = "\n게임 성공 여부: ";
    public static final String TOTAL_ATTEMPTING_CNT = "총 시도한 횟수: ";

    public void printMap(Stack<String> upstairs, Stack<String> downstairs) {
        for (String upStair : upstairs) {
            System.out.print(upStair);
        }
        System.out.println();
        for (String downStair : downstairs) {
            System.out.print(downStair);
        }
    }

    public void printResult(boolean isSuccess, int totalAttemptingCnt) {
        String success = "성공";
        if(isSuccess == true) {
            success = "성공";
        }
        if(isSuccess == false) {
            success = "실패";
        }
        printMessage("\n" + IS_SUCCESS + success);
        printMessage(TOTAL_ATTEMPTING_CNT + totalAttemptingCnt);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
