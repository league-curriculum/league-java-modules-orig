package _00_JButtons_with_Lambdas.interfaces;

public interface NotAFunctionalInterface {
    /*
     * Because there are two abstract methods, this interface can't be used in a
     * lambda expression
     */
    void someMethod1();
    void someMethod2();
}
