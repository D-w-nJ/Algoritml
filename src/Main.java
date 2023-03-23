import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            String lNode = st.nextToken();
            if (!lNode.equals("."))
                list.get(tmp.charAt(0) - 'A').add(lNode.charAt(0) - 'A');
            String rNode = st.nextToken();
            if (!rNode.equals("."))
                list.get(tmp.charAt(0) - 'A').add(rNode.charAt(0) - 'A');
        }

        dfs1(0);
        sb.append("\n");
        dfs3(0);
        sb.append("\n");
        dfs2(0);
        System.out.println(sb);
    }

    static void dfs1(int node) {
        sb.append((char) ('A' + node));
        for (int i : list.get(node)) {
            dfs1(i);
        }
    }

    static void dfs2(int node) {
        for (int i : list.get(node)) {
            dfs2(i);
        }
        sb.append((char) ('A' + node));
    }

    static void dfs3(int node) {
        boolean flag = false;
        for (int i : list.get(node)) {
            dfs3(i);
            if (!flag) {
                sb.append((char) ('A' + node));
                flag = true;
            }
        }
        if (!flag) {
            sb.append((char) ('A' + node));
        }
    }
}
