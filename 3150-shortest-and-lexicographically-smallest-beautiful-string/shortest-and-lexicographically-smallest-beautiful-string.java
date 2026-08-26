class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0;
        int count = 0;

        String answer = "";

        for (int right = 0; right < s.length(); right++) {

            if (s.charAt(right) == '1') {
                count++;
            }

            while (count > k) {
                if (s.charAt(left) == '1') {
                    count--;
                }
                left++;
            }

            if (count == k) {
                while (left < right && s.charAt(left) == '0') {
                    left++;
                }

                String candidate = s.substring(left, right + 1);

                if (answer.equals("")
                        || candidate.length() < answer.length()
                        || (candidate.length() == answer.length()
                            && candidate.compareTo(answer) < 0)) {
                    answer = candidate;
                }
            }
        }

        return answer;
    }
}