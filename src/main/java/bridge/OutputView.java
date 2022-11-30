package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static final String GAME_START = "다리 건너기 게임을 시작합니다.\n"
            + "\n다리의 길이를 입력해주세요.";
    public static final String SELECT_MOVING_SPACE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String RETRY_OR_FINISH = "게임을 다시 시도할지 여부를 입력해주세요. 재시도: R, 종료: Q";
    public static final String FINAL_RESULT = "\n최종 게임 결과";
    public static final String IS_SUCCESS = "\n게임 성공 여부: ";
    public static final String TOTAL_ATTEMPTING_CNT = "총 시도한 횟수: ";
    public static final String OPENING_BRACKET = "[";
    public static final String CLOSING_BRACKET = "]";
    public static final String DIVING_LINE = "|";
    public static final String GAME_RESULT_SUCCESS = "성공";
    public static final String GAME_RESULT_FAILURE = "실패";

    public void printMap(List<List<String>> stairs) {
        for (List<String> stair : stairs) {
            System.out.print(OPENING_BRACKET);
            for (int i = 0; i < stair.size(); i++) {
                System.out.print(stair.get(i));
                addDividingLine(i, stair);
            }
            System.out.println(CLOSING_BRACKET);
            System.out.println();
        }
    }

    public void addDividingLine(int index, List<String> stair) {
        if (stair.size()-1 != index) {
            System.out.print(DIVING_LINE);
        }
    }

    public void printResult(boolean isSuccess, int totalAttemptingCnt) {
        String success = GAME_RESULT_SUCCESS;
        if (isSuccess == true) {
            success = GAME_RESULT_SUCCESS;
        }
        if (isSuccess == false) {
            success = GAME_RESULT_FAILURE;
        }
        printMessage("\n" + IS_SUCCESS + success);
        printMessage(TOTAL_ATTEMPTING_CNT + totalAttemptingCnt);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
