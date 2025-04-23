package dx0423.stream;

import java.util.ArrayList;
import java.util.List;

class Student2 {
    private int id;
    private String name;

    public Student2(int id, String name) {
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

public class DistinctTest2 {
    public static void main(String[] args) {
        Student2 studentLee = new Student2(100, "이윤선");
        Student2 studentMoon = new Student2(200, "문찬욱");
        Student2 studentLee2 = new Student2(100, "이윤선");

        List<Student2> studentList = new ArrayList<>();
        studentList.add(studentLee);
        studentList.add(studentMoon);
        studentList.add(studentLee2);

        studentList.stream()
                // .map(Student::getName)
                .distinct()    // distinct()로 중복 요소를 제거
                .forEach(s -> System.out.println(s.getName()));    // s.getName() - 중복을 제거하고 객체 이름 출력
        /* map()을 제외시키고 실행해보기.
           결과를 보면 distinct()가 있음에도 같은 id와 일므을 가진 학생이 중복돼 출력된 것을 확인할 수 있다.
           그 이유는 물리적 메모리 상에서는 studentLee 와 studentLee2 로 서로 다른 객체이기 때문 */
    }
}
