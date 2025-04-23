package dx0423.stream;

import java.util.ArrayList;
import java.util.List;

class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

public class DistinctTest {
    public static void main(String[] args) {
        Student studentLee = new Student(100, "이윤선");
        Student studentMoon = new Student(200, "문찬욱");
        Student studentLee2 = new Student(100, "이윤선");

        List<Student> studentList = new ArrayList<>();
        studentList.add(studentLee);
        studentList.add(studentMoon);
        studentList.add(studentLee2);

        studentList.stream()
                .map(Student::getName)    // map() 연산으로 조건에 맞는 요소를 찾고 그 중에서 동일한 이름을 제외하고 출력
                .distinct()
                .forEach(s -> System.out.println(s));
    }
}
