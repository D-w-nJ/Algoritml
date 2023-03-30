package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj1043 {
    static ArrayList<HashSet<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++)
            graph.add(new HashSet<>());

        st = new StringTokenizer(br.readLine());
        int[] known = new int[Integer.parseInt(st.nextToken())];
        for (int i = 0; i < known.length; i++)
            known[i] = Integer.parseInt(st.nextToken());

        int num;
        int[] tmp;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            tmp = new int[num];
            list.add(new ArrayList<>());
            for (int j = 0; j < num; j++){
                tmp[j] = Integer.parseInt(st.nextToken());
                list.get(i).add(tmp[j]);
            }
            for (int j : tmp) {
                for (int k : tmp) {
                    if (j != k)
                        graph.get(j).add(k);
                }
            }
        }


        boolean[] flag = new boolean[N + 1];
        for (int i = 0; i < known.length; i++) {
            int temp = known[i];
            flag[temp] = true;
            Queue<Integer> q = new LinkedList<>();
            q.offer(temp);
            while (!q.isEmpty()) {
                temp = q.poll();
                for (int j : graph.get(temp)) {
                    if (!flag[j]) {
                        flag[j] = true;
                        q.offer(j);
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < M; i++) {
            for(int j : list.get(i)){
                if(!flag[j]){
                    result++;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
