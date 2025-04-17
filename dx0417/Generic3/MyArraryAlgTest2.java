package dx0417.Generic3;

public class MyArraryAlgTest2 {
    public static void main(String[] args) {
        String[] language = {"C++", "C#", "JAVA"};
        MyArraryAlg.swap(language, 1, 2);
        for (String value : language)
            System.out.println(value);
    }
}
