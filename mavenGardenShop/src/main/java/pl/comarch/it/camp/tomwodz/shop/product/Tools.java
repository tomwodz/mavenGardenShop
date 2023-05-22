package pl.comarch.it.camp.tomwodz.shop.product;

public class Tools extends Product{
    String brand;

    public Tools(String code, String name, String category, double pricePerItem, int quantity, String brand) {
        super(code, name, category, pricePerItem, quantity);
        this.brand = brand;
    }

    public Tools(String[] vars) {
        this(vars[0], vars[1], vars[2], Double.parseDouble(vars[3]), Integer.parseInt(vars[4]), vars[5]);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Kod: ")
                .append(getCode())
                .append(" Kat.: ")
                .append(getCategory())
                .append(" Producent: ")
                .append(getBrand())
                .append(" Nazwa: ")
                .append(getName())
                .append(" Cena PLN/szt: ")
                .append(getPricePerItem())
                .append(" Ilosc: ")
                .append(getQuantity())
                .toString();
    }

    @Override
    public String toCSV() {
        return new StringBuilder(super.toCSV())
                .append(";")
                .append(getBrand())
                .toString();
    }
}
