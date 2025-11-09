package strategy.discount;

public class pizzaDis implements applydiscount {
    @Override
    public double apply(double price) {
        return price * 0.85; }
}
