package dx0411.sangsog3;

public class VIPCustomer extends Customer{
    private int agentID;        // VIP 고객 담당 상담원 아이디
    double saleRatio;           // 할인율

//    public VIPCustomer() {
//        customerGrade = "VIP";  // 고객 등급 VIP
//        bonusRatio = 0.05;      // 보너스 적립률 5%
//        saleRatio = 0.1;        // 할인율 10%
//    }
//
//    public int getAgentID() {
//        return agentID;
//    }

    @Override   // 상위 클래스에 정의한 매서드가 하위 클래스에서 구현할 내용과 맞지 않을 경우
                // 하위 클래스에서 재정의 할 수 있다.
    public int calcPrice(int price) {
        bonusPoint += price * bonusRatio;   // 보너스 포인트 적립
        return price - (int)(price * saleRatio);    // 할인율을 적용한 가격 반환
    }
}
