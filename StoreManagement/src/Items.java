
public abstract class Items {
	protected int ID;
	protected String Title;
	protected int quantity;
	protected float buy_price;
	protected float sell_price;
	
	public String getTitle() {
		return this.Title;
	}
	
	public void setTitle(String title) {
		this.Title = title;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getBuy_price() {
		return buy_price;
	}

	public void setBuy_price(float buy_price) {
		this.buy_price = buy_price;
	}

	public float getSell_price() {
		return sell_price;
	}

	public void setSell_price(float sell_price) {
		this.sell_price = sell_price;
	}
	
	public float getProfit() {
		return this.sell_price - this.buy_price;
	}
	
	abstract public String toString();
	
}
