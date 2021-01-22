package pattern.creational.abstructfabric.example;

public class Pizza implements Product {
    @Override
    public void make() {
        System.out.println("Делаем пиццу");
    }
}
