import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class psy_과제진행하기 {

	class Hw {
		String subject;
		int start;
		int time;

		public Hw(String subject, int start, int time) {
			this.subject = subject;
			this.start = start;
			this.time = time;
		}

	}

    public List<String> solution(String[][] plans) {
        List<Hw> list = new ArrayList<>();
        Stack<Hw> stack = new Stack<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < plans.length; i++) {
            int hour = Integer.parseInt(plans[i][1].substring(0, 2)) * 60;
            int min = Integer.parseInt(plans[i][1].substring(3, 5));
            int time = Integer.parseInt(plans[i][2]);
            int starttime = hour + min;
            list.add(new Hw(plans[i][0], starttime, time));
        }

        Collections.sort(list, new Comparator<Hw>() {
            @Override
            public int compare(Hw o1, Hw o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });

        stack.add(list.get(0));
        int now = list.get(0).start;

        for (int i = 1; i < plans.length; i++) {
            String subject = stack.peek().subject;
            int start = stack.peek().start;
            int time = stack.peek().time;

            if (now + time > list.get(i).start) {
                stack.pop();
                stack.add(new Hw(subject, list.get(i).start, now + time - list.get(i).start));
                stack.add(list.get(i));
                now = list.get(i).start;
            } else {
                while (!stack.isEmpty()) {
                    String newsubject = stack.peek().subject;
                    int newstart = stack.peek().start;
                    int newtime = stack.pop().time;
                    if (now + newtime <= list.get(i).start) {
                        now += newtime;
                        result.add(newsubject);
                    } else {
                        stack.add(new Hw(newsubject, list.get(i).start, newtime - (list.get(i).start - now)));
                        break;
                    }
                }
                stack.add(list.get(i));
                now = list.get(i).start;
            }
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop().subject);
        }

        return result;
    }
}
