class Solution {
	public int solution(String s) {
		int answer = s.length();	//일단 최대길이로 초기화
		
		if (s.length() == 1) {			
			return 1;
		}
		
		for (int i = 1; i <= s.length() / 2; i++) {
			StringBuilder sb = new StringBuilder();
			String sub = s.substring(0, i); // 이전 단위 문자열 저장
			int count = 1; // 연속되는 개수, 0은 없으니까 1부터 시작
			// i개씩 문자열 확인
			for (int j = i; j < s.length(); j += i) {
				int end = j + i;
				if (end > s.length()) {
					end = s.length(); // 문자열 남은거 추가
				}
				String nextstr = s.substring(j, end); // sub랑 검사할 문자열
				// 다음꺼랑 저장해놓은거랑 같으면 count++
				if (sub.equals(nextstr)) {
					count++;
				}
				// 다르면
				else {
					if (count > 1) {
						sb.append(count);
					}
					sb.append(sub);
					sub = nextstr;
					count = 1;
				}
			}
			// 다 돌고 남은 문자열은 그냥 담기
			if(count > 1) {
				sb.append(count);
			}
			sb.append(sub);
			answer = Math.min(answer,sb.length());
		}
		return answer;
	}
}
