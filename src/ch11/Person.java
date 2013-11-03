public class Person {
    private String name;
    private String address;
    private String phone;
    private String email;

    public Person() {
        this("", "", "", "");
    }

    public Person(String name, String address, String phone, String email) {
        setName(name);
        setAddress(address);
        setPhone(phone);
        setEmail(email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(this.getClass().getName() + " Object\n");
        output.append(" Name: " + name + "\n");
        output.append(" Address: " + address + "\n");
        output.append(" Phone: " + phone + "\n");
        output.append(" Email: " + email + "\n");
        
        return output.toString();
    }
}
