interface In {
    void display();
}

class Prog3 {
    private class Inner implements In {
        public void display() {
            System.out.println("Hello World !!");
        }
    }

    Inner getRef() {
        return new Inner();
    }

}

class Prog3Test {
    public static void main(String[] args) {
        Prog3 p3 = new Prog3();
        In in = p3.getRef();
        in.display();
    }
}
