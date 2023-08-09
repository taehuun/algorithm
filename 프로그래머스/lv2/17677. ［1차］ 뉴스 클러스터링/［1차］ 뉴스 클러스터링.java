import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
		int answer = 0;
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();
		int str1_len = str1.length();
		int str2_len = str2.length();
		List<String> set1 = new ArrayList<>();
		List<String> set2 = new ArrayList<>();

		for (int i = 0; i < str1_len - 1; i++) {
			char c1 = str1.charAt(i);
			char c2 = str1.charAt(i + 1);
			if (c1 >= 'A' && c1 <= 'Z' && c2 >= 'A' && c2 <= 'Z') {
				set1.add(c1 + "" + c2);
			}
		}
		for (int i = 0; i < str2_len - 1; i++) {
			char c1 = str2.charAt(i);
			char c2 = str2.charAt(i + 1);
			if (c1 >= 'A' && c1 <= 'Z' && c2 >= 'A' && c2 <= 'Z') {
				set2.add(c1 + "" + c2);
			}
		}
		if (set1.isEmpty() && set2.isEmpty()) {
			return 65536;
		}
		Set<String> sum = new HashSet<>(set1);
		sum.addAll(set2);

		int sum_count = 0;
		int gyo_count = 0;
		for (String s : sum) {
	        int count1 = Collections.frequency(set1, s);
	        int count2 = Collections.frequency(set2, s);
	        gyo_count += Math.min(count1, count2);
	    }
		sum_count = set1.size() + set2.size() -gyo_count;
		double d = (double) gyo_count / (double) sum_count;
		answer = (int) (d * 65536);
		return answer;
	}
}