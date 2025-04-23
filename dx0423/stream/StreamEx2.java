package dx0423.stream;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Students {
    String name;
    int ban;
    int totalScore;

    Students(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return String.format("[%s, %d, %d]", name, ban, totalScore).toString();
    }

    String getName() { return name; }
    int getBan() { return  ban; }
    int getTotalScore() { return  totalScore; }

    public int compareTo(Students s) {
        return s.totalScore - this.totalScore;
    }
}

public class StreamEx2 {
    public static void main(String[] args) {
        Students[] stuArr = {
                new Students("이자바", 3, 300),
                new Students("김자바", 1, 200),
                new Students("안자바", 2, 100),
                new Students("이자바", 2, 150),
                new Students("이자바", 1, 200),
                new Students("이자바", 3, 290),
                new Students("이자바", 3, 180)
        };

        Stream<Students> stuStream = Stream.of(stuArr);    // 스트림을 만든다.
        IntStream stuScoreStream = stuStream.mapToInt(Students::getTotalScore);
        // sum 과 avg 같은 최종 연산을 모두 호출해야 할 때 사용한다.
        IntSummaryStatistics stat = stuScoreStream.summaryStatistics();

        System.out.println("count= " + stat.getCount());
        System.out.println("sum= " + stat.getSum());
        System.out.println("average=%.2f%n" + stat.getAverage());
        System.out.println("min= " + stat.getMin());
        System.out.println("max= " + stat.getMax());
    }
}
