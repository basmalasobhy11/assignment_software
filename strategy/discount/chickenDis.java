package strategy.discount;

public class chickenDis implements applydiscount {
    @Override
    public double apply(double price) {
        return price * 0.85; }
}
