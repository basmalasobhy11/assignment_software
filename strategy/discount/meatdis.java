package strategy.discount;

public class meatdis implements applydiscount {
    @Override
    public double apply(double price) {
        return price * 0.55; }
}
