import java.util.Date;

public class Order {
	//private Inventory inventory= new Inventory();
	private int order_ID;
	private OrderItem[] ItemList = new OrderItem[100];
	private float cost;
	private Date purchase_date;
	private float original_price;
	private int item_count;
	
	public Order() {};
	public Order(OrderItem[] itemlist, int item_count) {
		this.ItemList=itemlist;
		this.item_count = item_count;
	}
	
	public int getOrder_ID() {
		return order_ID;
	}
	public void setOrder_ID(int order_ID) {
		this.order_ID = order_ID;
	}
	public OrderItem[] getItemList() {
		return ItemList;
	}
	public void setItemList(OrderItem[] itemList) {
		ItemList = itemList;
	}
	public float getCost() {
		return cost;
	}
	public void setCost() {
		float cost=0;
		for(int i =0;i< this.item_count;i++)
			cost+= this.ItemList[i].getSell_price();
		this.cost = cost;
	}
	public Date getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}
	public float getOriginal_price() {
		
		return original_price;
	}
	public void setOriginal_price() {
		float cost=0;
		for(int i =0;i< this.item_count;i++)
			cost+= this.ItemList[i].getBuy_price();
		this.original_price = cost;
	}
	
	public float getProfit() {
		float profit=0;
		for(int i =0 ; i<this.item_count;i++)
			profit += this.ItemList[i].getProfit();
		return profit;
	}
	public int getItem_count() {
		return item_count;
	}
	public void setItem_count(int item_count) {
		this.item_count = item_count;
	}
	
	
	public void addItem(OrderItem item) {
		this.ItemList[this.item_count]=item;
		item_count+=1;
	}
	
	public boolean addItemByID(int id, int type,int buy_quantity){
		int index =Inventory.checkItem(id, type);
		if(index != -1) {
			if(Inventory.checkItemAvailability(id, type, buy_quantity)==true) {
				ItemList[item_count] = Inventory.getItemByID(id,type,buy_quantity);
				this.item_count+=1;
				return true;	
			}
		}
		 return false;
	}
	
	public void deleteItem(int ID, int type) {
		boolean found = false;
		int i=0;
		for(i=0;i<this.item_count;i++) {
			if(this.ItemList[i].ID==ID && this.ItemList[i].getItem_type()==type) {
				found = true;
				for(int j=i;j<(this.item_count-1);j++){
					this.ItemList[j]=this.ItemList[j+1];
				}
			}
		}
		if(found) {
			System.out.println("Successfully removed Item " + ID);
		
		}
		else System.out.println("No item found!");
	}
	
	public void showOrder() {};
	
}
