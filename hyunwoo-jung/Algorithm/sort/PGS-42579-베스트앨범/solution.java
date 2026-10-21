import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 총 재생 수, 노래 목록
        Map<String, Integer> total = new HashMap<>();
        Map<String, List<Integer>> songs = new HashMap<>();
        for (int i = 0; i < genres.length; ++i) {
            total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);
            songs.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(i);
        }

        List<String> genreOrder = new ArrayList<>(total.keySet());
        genreOrder.sort((a, b) -> Integer.compare(total.get(b), total.get(a)));

        List<Integer> result = new ArrayList<>();
        for (String g : genreOrder) {
            List<Integer> list = songs.get(g);
            list.sort((a, b) -> {
                if (plays[a] != plays[b]) return Integer.compare(plays[b], plays[a]);
                return Integer.compare(a, b);
            });

            for (int i = 0; i < Math.min(2, list.size()); ++i) {
                result.add(list.get(i));
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}