package pattern.creational.abstructfabric.example;

public class Pasta implements Product {
    @Override
    public void make() {
        System.out.println("Делаем пасту");
    }
}
