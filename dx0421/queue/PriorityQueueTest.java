package dx0421.queue;

import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(30);
        pq.add(80);
        pq.add(20);   // 넣을 때는 거꾸로 들어감.

        for (Integer o : pq) {
            System.out.println(o);   // 그래서 출력했을 때 20, 80, 30 으로 출력 됨.
        }
        System.out.println("원소 삭제");
        while (!pq.isEmpty()) {   // isEmpty : 큐(pq)가 비어 있는지를 검사하는 메서드
            System.out.println(pq.remove());
        }
    }
}
