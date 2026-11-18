import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        Map<String, Integer> inTime = new HashMap<>();
        Map<String, Integer> total = new TreeMap<>();

        for (String record : records) {
            String[] info = record.split(" ");
            String time = info[0];
            String key = info[1];
            String state = info[2];

            if (state.equals("IN")) {
                inTime.put(key, timeToInt(time));
            } else {
                int duration = timeToInt(time) - inTime.get(key);
                total.put(key, total.getOrDefault(key, 0) + duration);
                inTime.remove(key);
            }
        }

        for (String key : inTime.keySet()) {
            total.put(key, total.getOrDefault(key, 0) + 1439 - inTime.get(key));
        }

        answer = new int[total.size()];
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        int i = 1;
        for (String key : total.keySet()) {
            answer[i++ - 1] = calFee(total.get(key), defaultTime, defaultFee, unitTime, unitFee);
        }

        return answer;
    }

    private static int calFee(int val, int defaultTime, int defaultFee,
                              int unitTime, int unitFee) {
        if (val <= defaultTime) return defaultFee;
        int extra = val - defaultTime;

        return defaultFee + (extra + unitTime - 1) / unitTime * unitFee;
    }

    private static int timeToInt(String time) {
        String[] t = time.split(":");

        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}