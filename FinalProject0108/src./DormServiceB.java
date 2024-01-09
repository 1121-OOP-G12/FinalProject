public class DormServiceB extends DormService {
    private static boolean room1 = false;
    private static boolean room2 = false;
    private static String rentMark1;
    private static String rentMark2;

    public DormServiceB(Student student, double airConRV) {
        super(student, airConRV);
    }

    public static void bookDiscussionRoom(int roomNum, Student s) {
        if (roomNum == 1) {
            if (!room1) {
                room1 = true;
                if(rentMark1.equals(s.getName())) {
                	System.out.println("You are able to use discussion room 1."+s.getName());	
                }else {
                    System.out.println("Discussion room 1 is not available.");
                }   
                
            } else {
                System.out.println("Discussion room 1 is not available.");
            }
        } else if (roomNum == 2) {
            if (!room2) {
                room2 = true;
                rentMark2 = s.getName();
                System.out.println("You are able to use discussion room 2."+s.getName());
            } else {
                System.out.println("Discussion room 2 is not available.");
            }
        } else {
            System.out.println("Wrong number for booking discussion room.");
        }
    }

    public static void leaveDiscussionRoom(int roomNum, Student s) {
        if (roomNum == 1) {
            if (rentMark1 != null && rentMark1.equals(s.getName())) {
                room1 = false;
                rentMark1 = null;
                System.out.println("Discussion room 1 is now available to others.");
            } else {
                System.out.println("You can't access the unavailable discussion room 1.");
            }
        } else if (roomNum == 2) {
            if (rentMark2 != null && rentMark2.equals(s.getName())) {
                room2 = false;
                rentMark2 = null;
                System.out.println("Discussion room 2 is now available to others."+s.getName());
            } else {
                System.out.println("You can't access the unavailable discussion room 2.");
            }
        } else {
            System.out.println("Wrong number for leaving discussion room.");
        }
    }
}
