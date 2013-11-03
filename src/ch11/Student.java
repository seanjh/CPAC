public class Student extends Person {
    private char status;

    public Student() {
        this("", "", "", "", 'F');
    }

    public Student(Person p, char status) {
        this(p.getName(), p.getAddress(), p.getPhone(), p.getEmail(),
                status);
    } 

    public Student(String name, String address, String phone, String email,
                    char status) {
        super(name, address, phone, email);
        setStatus(status);
    }

    public String getStatus() {
        switch(status) {
            case('F'): 
                return "Freshman";
            case('S'): 
                return "Sophmore";
            case('J'): 
                return "Junior";
            case('R'): 
                return "Senior";
            default:
                return "ERROR";
        }
    }

    public void setStatus(char status) {
        switch(status) {
            case('F'): 
                this.status = status; break;
            case('S'): 
                this.status = status; break;
            case('J'): 
                this.status = status; break;
            case('R'): 
                this.status = status; break;
            default:   
                System.out.println("ERROR: Bad status code. Defaulting to 'F'.");
                this.status = 'F'; break;
            }
    }

    public void setStatus(String status) {
        switch(status.toLowerCase()) {
            case("freshman"): 
                this.status = 'F'; break;
            case("sophmore"):
                this.status = 'S'; break;
            case("junior"):
                this.status = 'J'; break;
            case("senior"):
                this.status = 'R'; break;
            default:
                System.out.println("ERROR: Invalid status. Defaulting to 'F' (Freshman)");
                this.status = 'F'; break;
        }
    }

    @Override public String toString() {
        StringBuilder output = new StringBuilder();

        output.append(this.getClass().getName() + " Object\n");
        output.append(" Name: " + getName() + "\n");
        output.append(" Address: " + getAddress() + "\n");
        output.append(" Phone: " + getPhone() + "\n");
        output.append(" Email: "  + getEmail() + "\n");
        output.append(" Status: " + getStatus() + "\n");

        return output.toString();
    }

}
