package dx0416.ObjectClass;

class Book {
    int bookNumber;
    String bookTittle;
/* 1 */
    Book(int bookNumber, String bookTittle) {
        this.bookNumber = bookNumber;
        this.bookTittle = bookTittle;
    }
/* 3 */
    @Override   // toString() 메서드 재정의
    public String toString() {
        return bookTittle + "," + bookNumber;
    }
}
/* 2 */
public class ToStringEx {
    public static void main(String[] args) {
        Book book1 = new Book(200, "개미");

        System.out.println(book1);  // 인스턴스 정보(클래스 이름,주소값)을 출력
        System.out.println(book1.toString());   // toString() 메서드로 인스턴스 정보(클래스 이름.주소값)을 출력
    }
}
