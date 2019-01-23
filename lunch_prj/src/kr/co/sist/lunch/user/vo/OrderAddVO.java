package kr.co.sist.lunch.user.vo;

public class OrderAddVO {
	private String orderName, phone, ipAddress, lunchCode,orderRequest;
	private int quan;
	public OrderAddVO(String orderName, String phone, String ipAddress, String lunchCode,
			int quan,String orderRequest) {
		super();
		this.orderName = orderName;
		this.phone = phone;
		this.ipAddress = ipAddress;
		this.lunchCode = lunchCode;
		this.orderRequest = orderRequest;
		this.quan = quan;
	}
	public String getOrderName() {
		return orderName;
	}
	public String getPhone() {
		return phone;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public String getLunchCode() {
		return lunchCode;
	}
	public String getOrderRequest() {
		return orderRequest;
	}
	public int getQuan() {
		return quan;
	}
	
	
}
