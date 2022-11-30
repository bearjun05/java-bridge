package bridge;

import java.util.ArrayList;
import java.util.List;

public class MapMaker {
    private final List<String> upstairs;
    private final List<String> downstairs;

    public MapMaker() {
        upstairs = new ArrayList<>();
        downstairs = new ArrayList<>();
    }

    public List<String> putBlank(List<String> selectedStair) {
        if (selectedStair == upstairs) {
            downstairs.add("   ");
            return downstairs;
        }
        if (selectedStair == downstairs) {
            upstairs.add("   ");
            return upstairs;
        }
        throw new IllegalArgumentException("[ERROR] putBlack 오류가 발생했습니다.");
    }

    public List<String> decideUpOrDown(String movingSpace) {
        if (movingSpace.equals("U")) {
            return upstairs;
        }
        if (movingSpace.equals("D")) {
            return downstairs;
        }
        throw new IllegalArgumentException("[ERROR] decideUpOrDown 오류가 발생했습니다");
    }

    public void putComponent(List<String> stair, boolean moveResult) {
        if (moveResult == true) {
            stair.add(" O ");
        }
        if (moveResult == false) {
            stair.add(" X ");
        }
    }

    public List<List<String>> bindStairs() {
        List<List<String>> stairs = new ArrayList<>();
        stairs.add(upstairs);
        stairs.add(downstairs);
        return stairs;
    }

    public void init() {
        upstairs.clear();
        downstairs.clear();
    }
}
