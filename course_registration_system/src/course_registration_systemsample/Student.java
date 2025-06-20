package course_registration_systemsample;

public class Student {
    private int id;
    private String name;
    private String email;
    private String department;

    // Constructors
    public Student(int id, String name, String email, String department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getDepartment() { return department; }
}
