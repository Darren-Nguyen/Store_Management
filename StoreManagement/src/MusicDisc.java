
public class MusicDisc extends Items{
	private String Singer;
	private String Genres;
	public String getSinger() {
		return Singer;
	}
	public void setSinger(String singer) {
		Singer = singer;
	}
	public String getGenres() {
		return Genres;
	}
	public void setGenres(String genres) {
		Genres = genres;
	}
	
	public MusicDisc() {};
	public MusicDisc(int id, String title,int quantity, float buy_price,float sell_price,String Singer,String Genres)
	{
		this.ID =id;
		this.quantity=quantity;
		this.buy_price=buy_price;
		this.sell_price=sell_price;
		this.Singer=Singer;
		this.Genres=Genres;	
		}
 public String toString() {
  return this.ID + " " + this.quantity +" " + this.sell_price + " " + this.Singer + " " + this.Genres + " " ;
 }
}
