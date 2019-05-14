
public class Book extends Items{
	private int published_year;
	private String Author;
	public int getPublished_year() {
		return published_year;
	}
	public void setPublished_year(int published_year) {
		this.published_year = published_year;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	
	public Book() {};
	public Book(int id, String title,int quantity, float buy_price,float sell_price,int published_year,String Author)
	{
		this.ID =id;
		this.quantity=quantity;
		this.buy_price=buy_price;
		this.sell_price=sell_price;
		this.published_year=published_year;
		this.Author=Author;
	}
	
	public String toString() {
		return "BookID: " +this.ID + "Quantity: "+ this.quantity + " Price: " +  this.sell_price+ " Author: " + this.Author + " Published Year: "+ this.published_year;
	}
}
