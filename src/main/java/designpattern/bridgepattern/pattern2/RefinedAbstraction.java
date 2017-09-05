package designpattern.bridgepattern.pattern2;

/**
 * Created by bkc on 2017/7/27.
 */
public class RefinedAbstraction extends Abstraction {
    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }
    public void otherOperation() {
        //other operatuoin
    }

}
