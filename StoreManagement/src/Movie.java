
public class Movie extends Items{
	private String Director;
	private String Actors;
	private String Categories;
	public String getDirector() {
		return Director;
	}
	public void setDirector(String director) {
		Director = director;
	}
	public String getActors() {
		return Actors;
	}
	public void setActors(String actors) {
		Actors = actors;
	}
	public String getCategories() {
		return Categories;
	}
	public void setCategories(String categories) {
		Categories = categories;
	}
	
	public Movie() {};
	
	public Movie(int id, String title,int quantity, float buy_price,float sell_price,String director,String Actors, String categories) {
		this.ID =id;
		this.quantity=quantity;
		this.buy_price=buy_price;
		this.sell_price=sell_price;
		this.Director=director;
		this.Actors=Actors;	
		this.Categories=categories;
	}
	
	public String toString() {
		return this.ID + " "  +this.quantity + " " + this.sell_price + " " + this.Director +" " + this.Actors + " " + this.Categories;
	}
	
}
