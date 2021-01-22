package pattern.creational.fabric;

public class FactoryA implements  Factory {
    @Override
    public Product getProduct() {

        return new ProductA();
    }
}
