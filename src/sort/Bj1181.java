package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }
        Comparator<String> comp = (o1, o2) -> {
            if (o1.length() == o2.length()) {
                for (int i = 0; i < o1.length(); i++) {
                    if (o1.charAt(i) != o2.charAt(i))
                        return o1.charAt(i) - o2.charAt(i);
                }
            }
            return o1.length() - o2.length();
        };

        Collections.sort(list, comp);
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0)+"\n");
        for (int i = 1; i < N; i++) {
            if (!list.get(i).equals(list.get(i - 1)))
                sb.append(list.get(i) + "\n");
        }


        System.out.println(sb);
    }
}
