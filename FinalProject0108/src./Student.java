
public class Student {
    private String name;
    private int ID;
    private String dorm;

    public Student(int ID, String name, String dorm) {
        this.name = name;
        this.ID = ID;
        this.dorm = dorm;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public String getDorm() {
        return dorm;
    }
}