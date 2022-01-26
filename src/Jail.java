class Jail {}

class Hello extends Jail{
    public static void main(String[] args) {
        Jail  he = new Jail();
        Hello hello1 = new Hello();
        if(hello1 instanceof Jail ){
            System.out.println(1);
        }
    }
}


