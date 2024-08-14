package day_0813;
import java.util.*;
public class lt_502_ipo_hard {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Capital[] projects = new Capital[profits.length];
        for(int i=0; i<profits.length; i++) {
            projects[i] = new Capital(capital[i], profits[i]);
        }

        Arrays.sort(projects);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int index = 0;
        int answer = w;

        for(int i=0; i<k; i++) {
            while(index < profits.length && projects[index].capital <= answer) {
                pq.add(projects[index++].profit);
            }

            if(pq.isEmpty()) {
                break;
            }
            answer += pq.poll();
        }
        return answer;
    }

    static class Capital implements Comparable<Capital> {
        int capital;
        int profit;

        Capital(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }

        @Override
        public int compareTo(Capital c) {
            return this.capital - c.capital;
        }
    }
}
