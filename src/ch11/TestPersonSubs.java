public class TestPersonSubs {
    public static void main(String[] args) {
        Person p = new Person("Sean", "Kent Street", "347-XYX-1234",
                                "seanherman@gmail.com");

        System.out.println(p);

        Student s = new Student("Mary", "Franklin Street", "305-XYZ-1234",
                                "mexyx@gmail.com", 'F');

        System.out.println();
        System.out.println(s);
        
        Faculty f = new Faculty(new Employee(), 'P', "N/A");
        System.out.println(f);
    }
}
