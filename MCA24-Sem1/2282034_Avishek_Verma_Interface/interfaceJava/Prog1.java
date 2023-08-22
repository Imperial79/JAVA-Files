interface In1 {
    void fun1();

    void fun2();
}

interface In2 {
    void fun3();

    void fun4();
}

interface In3 {
    void fun5();

    void fun6();
}

interface In4 extends In1, In2, In3 {
    void fun7();
}

class ConcreteClass {
    void display() {
        System.out.println("This is a concrete class");
    }
}

public class Prog1 extends ConcreteClass implements In4 {

    @Override
    public void fun1() {
        System.out.println("This is function 1");

    }

    @Override
    public void fun2() {
        System.out.println("This is function 2");

    }

    @Override
    public void fun3() {
        System.out.println("This is function 3");

    }

    @Override
    public void fun4() {
        System.out.println("This is function 4");

    }

    @Override
    public void fun5() {
        System.out.println("This is function 5");

    }

    @Override
    public void fun6() {
        System.out.println("This is function 6");

    }

    @Override
    public void fun7() {
        System.out.println("This is function 7");

    }

    void meth1(In1 obj) {
        obj.fun1();
        obj.fun2();
    }

    void meth2(In2 obj) {
        obj.fun3();
        obj.fun4();
    }

    void meth3(In3 obj) {
        obj.fun5();
        obj.fun6();
    }

    void meth4(In4 obj) {
        obj.fun7();
    }
}

class Prog1Test extends ConcreteClass {
    public static void main(String[] args) {
        Prog1 p1 = new Prog1();
        p1.meth1(p1);
        p1.meth2(p1);
        p1.meth3(p1);
        p1.meth4(p1);
    }
}