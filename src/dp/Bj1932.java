package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bj1932 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<int[]> tree = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            tree.add(new int[i+1]);
        }

        int max = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                tree.get(i)[j] = Integer.parseInt(st.nextToken());
                if (i != 0) {
                    if(j==0)
                        tree.get(i)[0] += tree.get(i-1)[0];
                    else if(j==i)
                        tree.get(i)[j] += tree.get(i-1)[j-1];
                    else
                        tree.get(i)[j] += Math.max(tree.get(i-1)[j-1],tree.get(i-1)[j]);
                }
            }
            if (i == N - 1) {
                for (int j = 0; j < N; j++) {
                    if(max<tree.get(i)[j])
                        max = tree.get(i)[j];
                }
            }
        }
        System.out.println(max);
    }
}
