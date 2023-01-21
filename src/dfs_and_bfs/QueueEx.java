package dfs_and_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        /* 이때 LinkedList는 데이터가 연속된 위치에 저장되지 않고 데이터와 주소부분을 별도로 가짐.
         데이터는 포인터와 주소를 사용하여 연결 (데이터는 노드라고 불림), ArrayList보다 느리지만
         자주 삽입, 삭제가 이루어지는 경우 용이 */

        q.offer(5); // add와 같다. 삽입성공후 true,실패 후 IllegalStateExeption 발생시킴
        q.offer(3);
        q.offer(2);
        q.offer(10);
        System.out.println(q.peek()); // queue의 첫번째 값 참조

        q.poll(); // 첫번째 값을 반환하고 제거, 비어있다면 null
        q.remove(); // queue의 첫번째 값 제거
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
        q.add(12);
        q.clear(); // queue 초기화

    }
}
