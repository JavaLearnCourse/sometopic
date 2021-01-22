package pattern.creational.fabric;

public class FactoryB implements Factory {
    @Override
    public Product getProduct() {
        return new ProductB();
    }
}
