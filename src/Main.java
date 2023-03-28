import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> largest = new ArrayList<>();
        largest.add(0);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        int max = 0;
        boolean flag;

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            flag = false;
            for (int j = 0; j < largest.size(); j++) {
                if (largest.get(j) < tmp) {
                    largest.set(j, tmp);
                    list.set(j, list.get(j) + 1);
                    flag = true;
                    if (max < list.get(j))
                        max = list.get(j);
                }
            }
            if (!flag) {
                list.add(1);
                largest.add(tmp);
            }
        }

        System.out.println(max);
    }
}
