package pattern.structure.abstructfabric.example;

public class FabricOne implements MyFabric {
    @Override
    public Car makeCar() {
        return  new Truck();
    }

    @Override
    public Product makeProduct() {
        return new Pizza();
    }
}
