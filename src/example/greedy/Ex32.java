package example.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Ex32 {
    public static void main(String[] arg) throws Exception {
        StringTokenizer st = getInputAsTokenizer();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Map<String, Integer> largestMap = getTwoLargestNumbers(N);

        int maxResult = calculateLargeNumberRule(largestMap.get("largest"), largestMap.get("second-largest"), M, K);

        printValue(maxResult);
    }

    private static int calculateLargeNumberRule(Integer largest, Integer secondLargest, int count, int maxRepeat) {
        if (largest == secondLargest) {
            return largest * count;
        } else {
            int secondLargestValueCount = count / (maxRepeat + 1);
            return secondLargestValueCount * secondLargest + largest * (count - secondLargestValueCount);
        }
    }

    private static void printValue(int result) {
        System.out.println(result);
    }

    private static StringTokenizer getInputAsTokenizer() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return new StringTokenizer(br.readLine());
    }

    private static Map<String, Integer> getTwoLargestNumbers(int count) throws Exception {
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        StringTokenizer st = getInputAsTokenizer();

        for (int i = 0; i < count; i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        map.put("largest", pq.poll());
        map.put("second-largest", pq.poll());

        return map;
    }
}
