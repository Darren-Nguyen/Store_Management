
public class OrderItem extends Items {
	private int Item_type ;
	public int getItem_type() {
		return Item_type;
	}
	public void setItem_type(int item_type) {
		Item_type = item_type;
	}
		
	public float getItemCost() {
		return this.sell_price * this.quantity;
	}
	public OrderItem() {};
	public OrderItem(int id,String title,int buy_price,int sell_price,int quantity,int type) {
		this.ID=id;
		this.Title=title;
		this.buy_price=buy_price;
		this.sell_price=sell_price;
		this.quantity=quantity;
		this.Item_type=type;
	}
	public String toString() {
		return this.ID + " " +this.Title + " " +this.quantity + " " + this.getItemCost();
	}
}
