package designpattern.bridgepattern.pattern2;

/**
 * Created by bkc on 2017/7/27.
 */
public class BridgePattern {
    public static void main(String[] args) {
        Implementor implementor = new ConcreteImplementorA();

        RefinedAbstraction abstraction = new RefinedAbstraction(implementor);

        abstraction.operation();
        abstraction.otherOperation();
    }
}
