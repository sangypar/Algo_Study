import java.util.*;

class Solution {
    
    static class Task {
        private String name;
        private int start;
        private int playtime;
        
        public Task(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
        
        public Task(String name, int playtime) {
            this.name = name;
            this.playtime = playtime;
        }
    }
    
    public List<String> solution(String[][] plans) {
    	
        List<String> answer = new ArrayList<>();
        
      
        PriorityQueue<Task> pq = new PriorityQueue<>( //큐 정렬 기준 설정 start기준 정렬 
            (o1, o2) -> (o1.start - o2.start)
        );
        
        for(int i = 0; i < plans.length; i++) {
            String name = plans[i][0]; 
            
            String[] str = plans[i][1].split(":");
            int h = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            int start = (h * 60) + m; //타임테이블 분으로 기준 
            
            int time = Integer.parseInt(plans[i][2]);
            
            pq.add(new Task(name, start, time)); //pq 삽입 
        }
        
    
        Stack<Task> remainingTasks = new Stack<>(); //남은 과제는 스택 방식으로 
        
        while(!pq.isEmpty()) {
            Task currentTask = pq.poll(); //먼저 해결할 문제 
            
            String curName = currentTask.name; 
            int curStart = currentTask.start;
            int curPlaytime = currentTask.playtime;
            
           
            int currentTime = curStart; //현재 시간 저장 
            
            
            if(!pq.isEmpty()) {
                Task nextTask = pq.peek();
                
                
                if(currentTime + curPlaytime < nextTask.start) {
                	//과제 끝내고도 시간남으면 결과 list에 저장하고 시간 추가 
                    answer.add(curName);
                    currentTime += curPlaytime;
                    
                    
                    while(!remainingTasks.isEmpty()) {
                    	//남은 과제 있을경우 
                        Task remaining = remainingTasks.pop();
                        
                        // 다음 새로운 과제 시작전까지 다 끝낼수 있는 경우 결과 리스트에 저장 
                        if(currentTime + remaining.playtime <= nextTask.start) {
                            currentTime += remaining.playtime;
                            answer.add(remaining.name);
                            continue;
                        } 
                        // 다음 새로운 과제 시작전까지 못 끝내는 경우
                        else {
                            int t = remaining.playtime - (nextTask.start - currentTime);
                            // 추가로 한 시간만 빼서 멈춘 과제 목록에 다시 추가
                            remainingTasks.push(new Task(remaining.name, t));
                            break;
                        }
                    }
                }
                // 지금 과제 끝내면 새로운 과제 시작할 시간인 경우
                else if(curStart + curPlaytime == nextTask.start) {
                    answer.add(curName);
                    continue;
                }
                // 새로운 과제 시작전까지 지금 과제를 못 끝내는 경우
                else {
                    int t = (nextTask.start - currentTime);
                    remainingTasks.push(new Task(curName, curPlaytime - t));
                }
                
            }
            
            // 더 이상 남아있는 새로운 과제가 없는 경우
            else {
                // 남아있는 과제(잠시 멈춘 과제)도 없는 경우
                if(remainingTasks.isEmpty()) {
                    currentTime += curPlaytime;
                    answer.add(curName);
                }
                // 남아있는 과제는 있는 경우
                else {
                    answer.add(curName); // 새로운 과제부터 먼저 해결
                    
                    // 남아있는 과제들을 정해진 순서대로 끝내면 됨
                    while(!remainingTasks.isEmpty()) {
                        Task rem = remainingTasks.pop();
                        answer.add(rem.name);
                    }
                }
            }
        }
        
        return answer;
    }
}