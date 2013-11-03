public class Employee extends Person {
    private String office;
    private double salary;
    private java.util.Date dateHired;

    public Employee() {
        this(new Person("","","",""), "", 0, new java.util.Date());
    }

    public Employee(Person p, String office, double salary, java.util.Date dateHired) {
        this(p.getName(), p.getAddress(), p.getPhone(), p.getEmail(), 
                office, salary, dateHired);
    }

    public Employee(String name, String address, String phone, String email) {
        this(name, address, phone, email, "", 0, new java.util.Date());
    }
    
    public Employee(String name, String address, String phone, String email,
            String office, double salary, java.util.Date dateHired) {
        super(name, address, phone, email);
        setOffice(office);
        setSalary(salary);
        this.dateHired = dateHired;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("ERROR: Salary is < 0. Defaulting to 0.");
            this.salary = 0;
        }
    }

    public java.util.Date getDateHired() {
        return dateHired;
    }

    public void setDateHired(java.util.Date dateHired) {
        this.dateHired = dateHired;
    }

    @Override public String toString() {
        super.toString();
        StringBuilder output = new StringBuilder();

        java.text.DecimalFormat moneyOut = new java.text.DecimalFormat("$###,##0.00");
        
        output.append(this.getClass().getName() + "Object \n");
        output.append(" Office: " + office + "\n");
        output.append(" Salary: " + moneyOut.format(salary) + "\n");
        output.append(" Hire Date: " + dateHired + "\n");

        return output.toString();
    }
}
