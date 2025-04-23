package dx0423.stream;

import java.util.ArrayList;
import java.util.List;

public class TravelTest {
    public static void main(String[] args) {
        TravelCustomer customerLee = new TravelCustomer("이순신", 40, 100);
        TravelCustomer customerKim = new TravelCustomer("김유신", 20, 100);
        TravelCustomer customerHong = new TravelCustomer("홍길동", 13, 50);

        List<TravelCustomer> customersList = new ArrayList<>();
        customersList.add(customerLee);
        customersList.add(customerKim);
        customersList.add(customerHong);


        System.out.println("== 고객 명단 추가된 순서대로 출력 ==");
        customersList.stream().map(c -> c.getName())
                .forEach(s -> System.out.println(s));

        int total = customersList.stream().mapToInt(c -> c.getPrice()).sum();
        System.out.println("총 여행 비용은: " + total + "만 원입니다.");

        System.out.println("== 20세 이상 고객 명단 정렬하여 출력 ==");
        customersList.stream().filter(c -> c.getAge() >= 20)
                .map(c -> c.getName())
                .sorted()
                .forEach(c -> System.out.println(c));

        /* mapToInt()
           map()은 연산의 결과로 Stream<T>타입의 스트림을 반환.
           스트림의 요소를 숫자로 반환하는 경우 IntStream 과 같은 기본형 스트림이 더 유용하다.
           mapToInt()를 사용해서 Stream<Integer>가 아닌
           IntStream 타입의 스트림을 생성하는 것이 더 효율적이다.
           성적을 더하거나 할 때 Integer 를 int 로 변환할 필요가 없기 때문이다.
           count()만 지원하는 Stream<T>와 달리 IntStream 과 같은 기본형 스트림은 아래와 같다.
           int              sum()           스트림의 모든 요소의 총합
           OptionalDouble   overage()       sum / (double)count
           OptionalInt      max()           스트림 요소 중 제일 큰 값
           OptionalInt      min()           스트림 요소 중 제일 작은 값 */
    }
}
