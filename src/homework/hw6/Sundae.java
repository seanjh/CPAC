public class Sundae extends IceCream {
    public int centsCostTopping;

    public Sundae() {
        this("", 1);
    }

    public Sundae(String name, int cents) {
        super(name)
