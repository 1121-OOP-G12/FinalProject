
public class DormService {
	private String dormName;
	private double AirConRV=0;
	private int dehumidifier; 
	//constructor 從宿舍建立者的角度來配置，冷氣卡要學生自己加值才會有錢用
	public DormService(String dormName,double AirConRV,int dehumidifier) {
		this.dormName=dormName;
		this.AirConRV=AirConRV;
		this.dehumidifier=dehumidifier;
	}
	//不知道會不會需要用到get
	public String getName() {
		return dormName;
	}
	
	//冷氣使用服務:使用扣殘值、儲值增殘值，殘值為負不可用，
	//一般宿舍使用費率rate設定一小時11元=1分鐘0.183元(google的數據)
	public void useAC(int min,Student a) {
		double rate=0.183;
		double cost=rate*min;
		if(AirConRV-cost<0) {
			System.out.printf("無法扣款!此費用已超出殘值%f元。%s的冷氣服務尚有:%.1f元餘額可用。%n",Math.abs(cost-AirConRV),a.getName(),AirConRV);
		}else {
			AirConRV=AirConRV-cost;
			System.out.printf("成功扣款%.1f元。%s的冷氣服務尚有:%.1f元餘額可用。%n",cost,a.getName(),AirConRV);
	}	
	}
	public void AddAirConRV(int fee,Student a) {
		AirConRV+=fee;
		System.out.printf("成功加值，%s的冷氣服務尚有:%.1f元餘額可用。%n",a.getName(),AirConRV);
	}
	
	//物品借用
	
	
	
	

}
