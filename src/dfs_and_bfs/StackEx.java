package dfs_and_bfs;

import java.util.*;

public class StackEx {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(5);
        stack.push(1);
        stack.push(19);


        while (!stack.empty())
            System.out.println(stack.pop());

        stack.push(10);
        System.out.println(stack.peek());
    }
}
