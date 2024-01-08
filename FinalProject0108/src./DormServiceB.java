public class DormServiceB extends DormService {
	private boolean room1,room2,rentMark1,rentMark2=false;
	
	public DormServiceB(Student student, double airConRV) {	
		super(student, airConRV);
	}
	
	
	public void bookDiscussionRoom(int roomNum) {
		if(roomNum==1) {
			if(!room1) {
				room1=true;
				rentMark1=true;
				System.out.println("you are able to use discussion room 1.");
			}else {
				System.out.println("discussion room 1 is not available.");
			}
			
		}else if(roomNum==2) {
				if(!room2) {
					room2=true;
					rentMark2=true;
					System.out.println("you are able to use discussion room 2.");
				}else {
					System.out.println("discussion room 2 is not available.");
				}
			}else{
				System.out.println("Wrong number for booking discussion room.");
			}
		}
		
	public void leaveDiscussionRoom(int roomNum) {
       if (roomNum == 1) {
           if (rentMark1) {
               room1 = false;
               rentMark1 = false; // Clear the rentMark when leaving
               System.out.println("Discussion room 1 is now available to others.");
           } else {
               System.out.println("You can't access the unavailable discussion room 1.");
           }
       } else if (roomNum == 2) {
           if (rentMark2) {
               room2 = false;
               rentMark2 = false; // Clear the rentMark when leaving
               System.out.println("Discussion room 2 is now available to others.");
           } else {
               System.out.println("You can't access the unavailable discussion room 2.");
           }
       } else {
           System.out.println("Wrong number for leaving discussion room.");
       }
		}
	}
	
