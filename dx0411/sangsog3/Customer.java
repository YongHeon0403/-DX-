package dx0411.sangsog3;

public class Customer {
    protected int customerID;
    protected String customerName;
    protected String customerGrade;
    int bonusPoint;
    double bonusRatio;              // 적립 비율

    public Customer (String customerGrade) {
        this.customerGrade = customerGrade;
    }

    public Customer() {
        customerGrade = "SILVER";   // 기본 고객 등급
        bonusRatio = 0.01;          // 보너스 포인트 기본 적립 비율
    }

    public int calcPrice(int price) {
        bonusPoint += price*bonusRatio;     // 보너스 포인트 계산
        return price;
    }

    public String showCustomerInfo() {
        return customerName + " 님의 등급은 " + customerGrade + "이며, 보너스 포인트는 " + bonusPoint + "입니다.";
    }

    public int getCustomerID() {
        return customerID;
    }
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerGrade() {
        return customerGrade;
    }
    public void setCustomerGrade(String customerGrade) {
        this.customerGrade = customerGrade;
    }
}
