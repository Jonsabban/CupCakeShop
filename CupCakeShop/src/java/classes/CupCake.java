package classes;

public class CupCake {

    private String bottom;
    private String topping;
    private int quantity;
    private int cupCakePrice;

    public CupCake(String bottom, String topping, int quantity, int cupCakePrice) {
        this.bottom = bottom;
        this.topping = topping;
        this.quantity = quantity;
        this.cupCakePrice = cupCakePrice;
    }

    public String getBottom() {
        return bottom;
    }

    public String getTopping() {
        return topping;
    }

    public int getTotalPrice() {
        return cupCakePrice;
    }

    public int getQuantity() {
        return quantity;
    }

}
