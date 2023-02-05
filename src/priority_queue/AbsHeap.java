package priority_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AbsHeap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new MyCompare());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int line = Integer.parseInt(br.readLine());
            if (line == 0) {
                if (pq.isEmpty())
                    sb.append("0\n");
                else sb.append(pq.poll()+"\n");
            } else {
                pq.offer(line);
            }
        }

        System.out.println(sb);
    }
}

class MyCompare implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        int a = (int) Math.abs(o1);
        int b = (int) Math.abs(o2);
        if (a == b)
            return o1 - o2;
        else
            return a - b;
    }
}
