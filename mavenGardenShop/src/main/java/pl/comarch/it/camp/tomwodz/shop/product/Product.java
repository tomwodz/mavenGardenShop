package pl.comarch.it.camp.tomwodz.shop.product;

public class Product implements Writable{

    private String code;
    private String name;
    private String category;
    private double pricePerItem;
    private int quantity;

    public Product(String  code, String name, String category, double pricePerItem, int quantity) {
        this.code = code;
        this.name = name;
        this.category = category;
        this.pricePerItem = pricePerItem;
        this.quantity = quantity;
    }
    public Product(String[] vars) {
        this(vars[0], vars[1], vars[2],  Double.parseDouble(vars[3]), Integer.parseInt(vars[4]));
    }

    public Product() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Kod: ")
                .append(getCode())
                .append(" Kat.: ")
                .append(getCategory())
                .append(" Name: ")
                .append(getName())
                .append(" Cena PLN/szt: ")
                .append(getPricePerItem())
                .append(" Ilosc: ")
                .append(getQuantity())
                .toString();
    }

    @Override
    public String toCSV() {
        return new StringBuilder()
                .append(getClass().getSimpleName())
                .append(";")
                .append(getCode())
                .append(";")
                .append(getCategory())
                .append(";")
                .append(getName())
                .append(";")
                .append(getPricePerItem())
                .append(";")
                .append(getQuantity())
                .toString();
    }
}
