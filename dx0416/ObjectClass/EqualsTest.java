package dx0416.ObjectClass;

class Student {
    int studentID;
    String studentName;

    public Student(int studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
    }

    public String toString() {
        return studentID + "," + studentName;
    }

    @Override   // equals() 메서드 재정의
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student std = (Student)obj;
            if (this.studentID == std.studentID)    // 재정의한 equals() 메서드 학생의 학번이 같으면 true 반환
                return true;
            else return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return studentID;
    }
}

public class EqualsTest {
    public static void main(String[] args) {
        Student studentLee = new Student(100, "이상원");
        Student studentLee2 = studentLee;   // 주소 복사
        Student studentSang = new Student(100, "이상원");

/* 동일한 주소의 두 인스턴스 비교 */
        if (studentLee == studentLee2)
            System.out.println("studentLee와 studentLee2의 주소는 같습니다.");
        else
            System.out.println("studentLee와 studentLee2의 주소는 다릅니다.");

        if (studentLee.equals(studentLee2))
            System.out.println("studentLee와 studentLee2는 동일합니다.");
        else
            System.out.println("studentLee와 studentLee2는 동일하지 않습니다.");

        if (studentLee == studentSang)
            System.out.println("studentLee와 studentSang의 주소는 같습니다.");
        else
            System.out.println("studentLee와 studentSang의 주소는 다릅니다.");

        if (studentLee.equals(studentSang))
            System.out.println("studentLee와 studentSang은 동일합니다.");
        else
            System.out.println("studentLee와 studentSang은 동일하지 않습니다.");
    }
}
