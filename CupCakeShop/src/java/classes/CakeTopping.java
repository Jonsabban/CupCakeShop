package classes;

public class CakeTopping {
    
    private int tID;
    private String top;
    private int price;

    public CakeTopping(int tID, String top, int price) {
        this.tID = tID;
        this.top = top;
        this.price = price;
    }

    public int getbID() {
        return tID;
    }

    public String getTop() {
        return top;
    }

    public int getPrice() {
        return price;
    }
    
}
