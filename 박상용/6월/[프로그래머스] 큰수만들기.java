class psy_큰수만들기 {
	static int result, check,numsize;
	static String num;
	static boolean[] bool;

	public String  solution(String number, int k) {
		num = number;
		numsize = number.length();
		check = numsize-k;
		bool = new boolean[numsize];
		result = 0;
		comb(0,0);
	    return Integer.toString(result);
	}

	private void comb(int idx,int cnt) {
		if(cnt >= check) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0;i < numsize; i++) {
				if(bool[i]) {
					 sb.append(num.charAt(i));
				}
			}
			 int number = Integer.parseInt(sb.toString());
	         result = Math.max(result, number);
			return;
		}
		if(idx >= numsize) {
			return;
		}
		
		bool[idx] = true;
		comb(idx+1,cnt+1);
		bool[idx] = false;
		comb(idx+1,cnt);
	}
}