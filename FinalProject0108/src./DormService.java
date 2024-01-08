
public class DormService {
	protected Student student;
    protected double airConRV;

    public DormService(Student student, double airConRV) {
    	this.student = student;
        this.airConRV = airConRV;
    }

    //冷氣使用服務:使用扣殘值、儲值增殘值，殘值為負不可用，
  	//一般宿舍使用費率rate設定一小時11元=1分鐘0.183元(google的數據)
    public void useAC(int min) {
        double rate = 0.183;
        double cost = rate * min;
        
        if (airConRV - cost < 0) {
            System.out.printf("無法扣款!此費用已超出殘值%f元。" +
                              "%s的冷氣服務尚有:%.1f元餘額可用。%n", Math.abs(cost - airConRV),
                              student.getName(), airConRV);
        } else {
            airConRV = airConRV - cost;
            System.out.printf("成功扣款%.1f元。%s的冷氣服務尚有:%.1f元餘額可用。%n",
                              cost, student.getName(), airConRV);
        }
    }

    public void addAirConRV(int fee) {
    	 airConRV += fee;
    	    System.out.printf("成功加值%.1f元，%s的冷氣服務尚有:%.1f元餘額可用。%n", fee,student.getName(),airConRV);
    }
    
    public void info() {
    	System.out.printf("%s 您好，目前您的冷氣卡尚有:%.1f元餘額可用。%n", student.getName(),airConRV);
    }

    public static void borrowItem(Item item) {
        item.borrow();
    }
    
    public static void giveItemback(Item item) {
        item.giveBack();
    }
}