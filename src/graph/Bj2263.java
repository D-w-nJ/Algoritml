package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bj2263 {
    static ArrayList<int[]> tree = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++)
            tree.add(new int[2]);

        ArrayList<Integer> inOrder = new ArrayList<>();
        ArrayList<Integer> postOrder = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            inOrder.add(Integer.parseInt(st.nextToken()));


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            postOrder.add(Integer.parseInt(st.nextToken()));

        if (postOrder.size() == 1) {
            System.out.println(inOrder.get(0));
            return;
        }

        if (postOrder.size() == 2) {
            System.out.println(inOrder.get(1) + " " + inOrder.get(0));
            return;
        }

        func(inOrder, postOrder);
        preOrder(postOrder.get(postOrder.size() - 1));

        System.out.println(sb);
    }

    static void preOrder(int N) {
        sb.append(N).append(" ");
        if (tree.get(N)[0] != 0)
            preOrder(tree.get(N)[0]);
        if (tree.get(N)[1] != 0)
            preOrder(tree.get(N)[1]);
    }

    static int func(ArrayList<Integer> inOrder, ArrayList<Integer> postOrder) {
        int root = inOrder.get(0);
        if (inOrder.size() == 1)
            return root;
        boolean[] flag = new boolean[inOrder.size()];
        for (int i = 1; i < inOrder.size(); i++) {
            if (!flag[i]) {
                int left = root;
                root = inOrder.get(i);
                tree.get(root)[0] = left;
                ArrayList<Integer> in = new ArrayList<>();
                ArrayList<Integer> post = new ArrayList<>();
                int tmp = i;
                while (true) {
                    if (root == postOrder.get(tmp))
                        break;
                    else {
                        in.add(inOrder.get(tmp + 1));
                        post.add(postOrder.get(tmp));
                        flag[tmp + 1] = true;
                        tmp++;
                    }
                }
                if(in.size()!=0)
                    tree.get(root)[1] = func(in, post);
            }
        }
        return root;
    }
}
