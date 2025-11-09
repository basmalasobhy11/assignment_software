package strategy.discount;

public class meetdis implements applydiscount {
    @Override
    public double apply(double price) {
        return price * 0.55; }
}
