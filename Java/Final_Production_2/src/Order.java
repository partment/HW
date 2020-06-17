import org.json.JSONObject;

import java.util.ArrayList;

import org.json.JSONArray;

public class Order extends Database {
    private JSONArray orderlist = new JSONArray();
    public Order() {}
    public boolean isCake(String name) {
    	//to check if a string contains substring "cake"
    	//use regular expression
        return name.matches("(.*)cake(.*)");
    }
    public void addOrderQuan(String name, String quan) {
    	JSONObject product = new JSONObject();
        product.put("name", name);
        product.put("amount", Integer.parseInt(quan));
        this.orderlist.put(product);
    }
    public void addOrderQuanCake(String name, String quan, String message) {
    	JSONObject product = new JSONObject();
        product.put("name", name);
        product.put("amount", Integer.parseInt(quan));
        product.put("message", message);
        this.orderlist.put(product);
    }
    public void addOrderWei(String name, String wei) {
    	JSONObject product = new JSONObject();
        product.put("name", name);
        product.put("weight", Integer.parseInt(wei));
        this.orderlist.put(product);
    }
    public void deleteOrder(int index) {
    	if(this.orderlist.length() > 0) {
            this.orderlist.remove(index);
        }
    }
    public String confirmOrder(String id) {
    	int subtotal = this.calcSubTotal();
        int total = 0;
        if(this.orderlist.length() > 0) {
            if(subtotal < 400) {
                return "Total value must have more than NTD400.";
            }
            if(subtotal >= 400 && subtotal < 1200) {
                total = subtotal + 200;
            }
            if(subtotal >= 1200) {
                total = subtotal;
            }
            String orderid = insertOrder(this.orderlist.toString(), id, total);
            return "Order has placed! Order id : "+orderid;
        }else {
            return "You haven't ordered anything yet.";
        }
    }
    public ArrayList<String> getOrder() {
    	ArrayList<String> listItems = new ArrayList<String>();
        for(int i = 0; i < this.orderlist.length(); i++) {
            JSONObject product = (JSONObject)this.orderlist.get(i);
            String temp = "";
            if(product.has("weight")) {
            	temp += (int)product.get("weight")+"kg of ";
            }else {
                temp += (int)product.get("amount")+" ";
            }
            String name = (String)product.get("name");
            if(this.isCake(name)) {
            	temp += name+" with message : "+product.get("message");
            }else {
            	temp += name;
            }
            listItems.add(temp);
        }
        return listItems;
    }
    public int calcSubTotal() {
        int subtotal = 0;
        for(int i = 0; i < this.orderlist.length(); i++) {
            JSONObject product = (JSONObject)this.orderlist.get(i);
            String name = (String)product.get("name");
            if(product.has("weight")) {
                subtotal = subtotal + (int)product.get("weight")*50;
            }else if(isCake(name)) {
                subtotal = subtotal + (int)product.get("amount")*300;
            }else {
                subtotal = subtotal + (int)product.get("amount")*10;
            }
        }
        return subtotal;
    }
    
    public int calcTotal() {
    	int subtotal = this.calcSubTotal();
        int total = 0;
        if(subtotal < 400) {
        	total = subtotal + 200;
        }
        if(subtotal >= 400 && subtotal < 1200) {
            total = subtotal + 200;
        }
        if(subtotal >= 1200) {
            total = subtotal;
        }
        return total;
    }
}