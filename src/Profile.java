

public class Profile {
    private Integer age;
    private String address;
    private PaymentMethod paymentMethod;
    public enum PaymentMethod {
        CARD,
        UPI,
        NETBANKING
    }
    public Profile(Integer age, String address, PaymentMethod paymentMethod) {
        this.age = age;
        this.address = address;
        this.paymentMethod = paymentMethod;
    }

    public void getProfileDetails() {
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Preferred Payment Method: " + paymentMethod);
    }
}
