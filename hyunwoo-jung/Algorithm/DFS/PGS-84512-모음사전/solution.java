class Solution {
    static final char[] VOWELS = {'A', 'E', 'I', 'O', 'U'};
    int count = 0;
    int answer = 0;

    public int solution(String word) {
        dfs("", word);

        return answer;
    }

    private void dfs(String curr, String target) {
        if (answer != 0) return;

        if (!curr.isEmpty()) {
            count++;
            if (curr.equals(target)) {
                answer = count;
                return;
            }
        }

        if (curr.length() == 5) return;

        for (char v : VOWELS) {
            dfs(curr + v, target);
        }
    }
}