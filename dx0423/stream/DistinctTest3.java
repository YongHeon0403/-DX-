package dx0423.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Student3 {
    private int id;
    private String name;

    public Student3(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student3 student = (Student3) obj;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

public class DistinctTest3 {
    public static void main(String[] args) {
        Student3 studentLee = new Student3(100, "이윤선");
        Student3 studentMoon = new Student3(200, "문찬욱");
        Student3 studentLee2 = new Student3(100, "이윤선");

        List<Student3> studentList = new ArrayList<>();
        studentList.add(studentLee);
        studentList.add(studentMoon);
        studentList.add(studentLee2);

        studentList.stream()
                .distinct()
                .forEach(s -> System.out.println(s.getName()));

        studentList.stream()
                .distinct()
                .forEach(s -> System.out.println(s.getName() + "님 안녕하세요."));
    }
}

