import java.util.ArrayList;

public class DormServiceA extends DormService {
	 private static ArrayList<Student> groups = new ArrayList<>();

	    public DormServiceA(Student student, double airConRV) {
	        super(student, airConRV);
	    }

	    public void enroll(Student student) {
	        groups.add(student);
	    }
	    
	    public void drop(Student student) {
	    	groups.remove(student);
	    }
	    
	    public void addAirConRV(int fee) {
	    	 airConRV += (1.05 * fee);
	    	    System.out.printf("成功加值%.1f元，%s的冷氣服務尚有:%.1f元餘額可用。%n", (1.05 * fee),student.getName(),airConRV);
	    }

	    public static ArrayList<Student> getGroups() {
	        return groups;
	    }

}
