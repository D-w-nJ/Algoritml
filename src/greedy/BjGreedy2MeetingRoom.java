package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BjGreedy2MeetingRoom {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] array = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }

//        Arrays.sort(array, new Comparator<>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[1] == o2[1])
//                    return o1[0] - o2[0];
//                return o1[1] - o2[1];
//            }
//        });
        Arrays.sort(array, (o1, o2) -> {
            if (o1[1] == o2[1])
                return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        int tmp = 0;
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (array[i][0] >= tmp) {
                tmp = array[i][1];
                result++;
            }
        }

        System.out.println(result);
    }
}
