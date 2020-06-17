import java.util.ArrayList;

public class OrderManagement extends Database {
	public OrderManagement() {};
	public ArrayList<String> getOrders() {
		return getOrderAll();
	}
	public String getOrderByID(String id) {
		return getOrderDetail(id);
	}
}
