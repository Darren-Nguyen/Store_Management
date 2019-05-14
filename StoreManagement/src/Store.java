import java.text.DateFormat;
import java.util.Date;

public class Store {
	private static final int MAX_NUMBER = 100;
	private Order[] OrderList = new Order[MAX_NUMBER];
	private int nbOrder;
	
	public Order[] getOrderList() {
		return OrderList;
	}
	public void setOrderList(Order[] orderList) {
		OrderList = orderList;
	}
	public int getNbOrder() {
		return nbOrder;
	}
	public void setNbOrder(int nbOrder) {
		this.nbOrder = nbOrder;
	}
	public Inventory getInventory() {
		return inventory;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	public static int getMaxNumber() {
		return MAX_NUMBER;
	}

	private Inventory inventory = new Inventory();
	
	public void addNewOrder(Order new_order) {
		this.OrderList[nbOrder]= new_order;
		this.nbOrder+=1;
	}
	
	public int getOrderByID(int id) {
		int index=-1;
		for(int i=0;i<this.nbOrder;i++) {
			if(this.OrderList[i].getOrder_ID()==id) {
				index=i;
			}
	}
		return index;
	}
	
	public boolean deleteOrderByID(int id) {
		int index= getOrderByID(id);
		if(index==-1) {
			System.out.println("No match order with ID: " + id + " is found!");
			return false;
		}
		else {
			for(int i=index;i<(this.nbOrder-1);i++) {
				this.OrderList[i]=this.OrderList[i+1];
			}
		
		this.nbOrder -=1;
		return true;
		}
	}
	
}
