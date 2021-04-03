public @interface DemoAnatation {

    String name();
}


class DemoClass{


    @DemoAnatation(name = "someName")
    public void someMethod(){

    }
}