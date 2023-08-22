public class Prog2Pack3 extends Prog2 {

    public Inter1Prog2 getObj() {
        Prog2 p2 = new Prog2();
        return p2.new InnerProg2();
    }

}
