import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.*;

class Solution {
    public String[] solution(String[][] plans) throws IOException {
        
        Arrays.sort(plans, new Comparator<String[]>() {
           @Override
            public int compare(String[] s1, String[] s2) {
                return LocalTime.parse(s1[1]).compareTo(LocalTime.parse(s2[1]));
            }
        });
        
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
        Stack<String[]> table = new Stack<>();
        String[] now = plans[0];
        LocalTime realTime = LocalTime.parse(now[1], format);
        List<String> ans = new ArrayList<>();
        
        for (int i = 1; i < plans.length; i++) {
        	try {
        		LocalTime nowTime = LocalTime.parse(now[1], format);
        		LocalTime newTime = LocalTime.parse(plans[i][1], format);
        		LocalTime plusNowTime = nowTime.plusMinutes(Long.parseLong(now[2]));
        		Duration duration = Duration.between(plusNowTime, newTime);
        		long diff = duration.toMinutes();
        		
        		while (true) {
        			if (now == null)
        				break;
        			
        			if (diff < 0) {
        				if (!now[1].equals(plans[i][1])) {
        					LocalTime updatedNowTime = plusNowTime.minusMinutes(Math.abs(diff));
        					now[1] = updatedNowTime.toString();
        					now[2] = String.valueOf(Long.parseLong(now[2]) - (Long.parseLong(now[2]) + diff));
        					table.add(now);
        					now = plans[i];
        				}
        				break;
        			} else { // 과제 하나가 다 끝난 경우
        				ans.add(now[0]);
        				diff = diff - Long.parseLong(now[2]);
        				if (!table.isEmpty()) {
        					now = table.pop();
        				} else {
        					now = null;
        				}
        			}
        		}
                
                if (now == null) {
        			now = plans[i];
        		}
        		
			} catch (Exception e) {
			}
        }
        
        if (now != null) {
        	ans.add(now[0]);
        }
        
        while (!table.isEmpty()) {
        	ans.add(table.pop()[0]);
        }
        
        for (String s : ans) {
        	System.out.println(s);
        }
        
        String[] answer = new String[plans.length];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}