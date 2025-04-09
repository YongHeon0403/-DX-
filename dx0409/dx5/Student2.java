package dx0409.dx5;

public class Student2 {
    private static int serialNum = 1000;
    int studentID;
    String studentName;
    int grade;
    String address;
    
    public Student2() {
        serialNum++;
        studentID = serialNum;
    }
    
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String name) {
        this. studentName = name;
    }
    
    public static int getSerialNum() {
        int i = 10;          // 지역 변수는 사용할 수 있다.
        // studentName = "aaa"; 클래스 메서드(스태틱 메서드)는 인스턴스를 사용 못함
        return serialNum;
    }
    public static void setSerialNum(int serialNum) {
        Student2.serialNum = serialNum;         // 질문하기
    }
}
