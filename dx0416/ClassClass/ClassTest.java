package dx0416.ClassClass;

public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Person();
        Class pClass1 = person.getClass();
        System.out.println(pClass1.getName());

        Class pClass2 = Person.class;
        System.out.println(pClass2.getName());

        Class pClass3 = Person.class;
        System.out.println(pClass3.getName());
    }
}
