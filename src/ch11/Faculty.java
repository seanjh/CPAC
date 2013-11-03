public class Faculty extends Employee {
    private char rank;
    private String officeHours;

    public Faculty() {
        this(new Employee(), 'L', "");
    }

    public Faculty(Employee e, char rank, String officeHours) {
        super(e.getName(), e.getAddress(), e.getPhone(), e.getEmail(), e.getOffice(),
                e.getSalary(), e.getDateHired());
        setRank(rank);
        setOfficeHours(officeHours);
    }

    public String getRank() {
        switch (rank) {
            case('L'):
                return "Lecturer";
            case ('T'):
                return "Assistant Professor";
            case ('C'):
                return "Associate Professor";
            case ('P'):
                return "Professor";
            default:
                return "ERROR";
        }
    }

    public void setRank(char rank) {
        switch (rank) {
            case ('L'): 
            case ('T'):
            case ('C'):
            case ('P'):
                this.rank = rank; break;
            default:
                System.out.println("ERROR: Invalid rank code. Defaulting to 'L' (Lecturer).");
                this.rank = 'L';
        }
    }

    public void setRank(String rank) {
        switch (rank.toLowerCase()) {
            case ("lecturer"):
                this.rank = 'L'; break;
            case ("assistant professor"):
                this.rank = 'T'; break;
            case ("associate professor"):
                this.rank = 'C'; break;
            case ("professor"):
                this.rank = 'P'; break;
            default:
                System.out.println("ERROR: Invalid rank. Defaulting to Lecturer");
                this.rank = 'L';
        }
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    @Override public String toString() {
        StringBuffer output = new StringBuffer();
        
        output.append(this.getClass().getName() + " Object\n");

        return output.toString();
    }
}
