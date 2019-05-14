
public class Inventory {
		private static final int MAX_NUMBER = 100;
		private static Book[] books =new Book[MAX_NUMBER];
		private static Movie[] movies = new Movie[MAX_NUMBER];
		private static MusicDisc[] musics = new MusicDisc[MAX_NUMBER];
		private static int nbBooks;
		private static int nbMovies;
		private static int nbMusics;
		private static final int BOOK_TYPE=0;
		private static final int MUSIC_TYPE=1;
		private static final int MOVIE_TYPE=2;
		
		public Inventory() {};	
		public static Book[] getBooks() {
			return books;
		}
		public static void setBooks(Book[] books) {
			Inventory.books = books;
		}
		public static Movie[] getMovies() {
			return movies;
		}
		public static void setMovies(Movie[] movies) {
			Inventory.movies = movies;
		}
		public static MusicDisc[] getMusics() {
			return musics;
		}
		public static void setMusics(MusicDisc[] musics) {
			Inventory.musics = musics;
		}
		public static int getNbBooks() {
			return nbBooks;
		}
		public static void setNbBooks(int nbBooks) {
			Inventory.nbBooks = nbBooks;
		}
		public static int getNbMovies() {
			return nbMovies;
		}
		public static void setNbMovies(int nbMovies) {
			Inventory.nbMovies = nbMovies;
		}
		public static int getNbMusics() {
			return nbMusics;
		}
		public static void setNbMusics(int nbMusics) {
			Inventory.nbMusics = nbMusics;
		}
		public static int getMaxNumber() {
			return MAX_NUMBER;
		}
		public static void addNewBook(int ID, String title, int quantity, float buy_price, float sell_price, String authors, int published_year)
		{
			Book newbook =new Book(ID,title,quantity, buy_price,sell_price, published_year,authors);
			Inventory.books[nbBooks]= newbook;
			Inventory.nbBooks+=1;
		}
		
		public static void addNewMovie(int ID,String title,int quantity,float buy_price,float sell_price,String director,String actors,String categories) {
			Movie newmovie = new Movie(ID,title,quantity,buy_price,sell_price,director,actors,categories);
			Inventory.movies[nbMovies]= newmovie;
			Inventory.nbMovies+=1;
		}
		
		public static void addNewMusic(int ID,String title,int quantity,float buy_price,float sell_price,String singer,String genres)
		{
			MusicDisc newmusic = new MusicDisc(ID,title,quantity,buy_price,sell_price,singer,genres);
			Inventory.musics[nbMusics]= newmusic;
			Inventory.nbMusics+=1;
		}
		
		public static int checkMusic(int ID){
			int found =-1;
			for(int i =0;i<Inventory.nbMusics;i++)
				if(Inventory.musics[i].ID==ID)
					found= i;
			return found;
		}
		
		public static int checkBook(int ID){
			int found =-1;
			for(int i =0;i<Inventory.nbBooks;i++)
				if(Inventory.books[i].ID==ID)
					found= i;
			return found;
		}
		
		public static int checkMovie(int ID){
			int found =-1;
			for(int i =0;i<Inventory.nbMovies;i++)
				if(Inventory.movies[i].ID==ID)
					found= i;
			return found;
		}
		
		public static int checkItem(int id,int type) {
			int found =-1;
			switch(type) {
			case MUSIC_TYPE: found = checkMusic(id);
			break;
			case MOVIE_TYPE: found = checkMovie(id);
			break;
			case BOOK_TYPE: found = checkBook(id);
			break;
			default: System.out.println("Wrong item type!");
			return -1;
			}
			return found;
		}
		
		public static void deleteMusic(int ID) {
			int index = checkMusic(ID);
			if(index == -1) {
				System.out.println("No matching ID found!");
				return;
			}
			for(int j=index;j<(Inventory.nbMusics-1);j++){
				Inventory.musics[j]=Inventory.musics[j+1];
				}
				
			
			Inventory.nbMusics-=1;
			System.out.println("Sucessfully removed Music Disc ID:"+ ID);
		}
		
		public static void deleteMovie(int ID) {
			int index = checkMovie(ID);
			if(index == -1) {
				System.out.println("No matching ID found!");
				return;
			}
			
					for(int j =index;j<(Inventory.nbMovies-1);j++){
						Inventory.movies[j]=Inventory.movies[j+1];
					
			}
			Inventory.nbMovies-=1;
			System.out.println("Sucessfully removed Movie ID:"+ ID);
		}
		
		public static void deleteBook(int ID) {
			int index = checkBook(ID);
			if(index == -1) {
				System.out.println("No matching ID found!");
				return;
			}
			
					for(int j =index;j<(Inventory.nbBooks-1);j++){
						Inventory.books[j]=Inventory.books[j+1];
			
			}
			Inventory.nbBooks-=1;
			System.out.println("Sucessfully removed Book ID:"+ ID);
		}
		
		public static boolean checkBookAvailability(int id,int count) {
			int index = checkBook(id);
			if(index==-1) {
				System.out.println("No Book with ID" +id + "found.");
				return false;
			}
			if(Inventory.books[index].getQuantity()>=count)
				return true;
			else return false;
		}
		
		public static boolean checkMusicAvailability(int id,int count) {
			int index = checkMusic(id);
			if(index==-1) {
				System.out.println("No Music Disc with ID " +id + "found.");
				return false;
			}
			if(Inventory.musics[index].getQuantity()>=count)
				return true;
			else return false;
		}
		
		public static boolean checkMovieAvailability(int id,int count) {
			int index = checkMovie(id);
			if(index==-1) {
				System.out.println("No Movie with ID" +id + "found.");
				return false;
			}
			if(Inventory.movies[index].getQuantity()>=count)
				return true;
			else return false;
		}
		
		public static boolean checkItemAvailability(int id,int type,int count){
			boolean avai=false;
			switch(type) {
			case BOOK_TYPE: avai= checkBookAvailability(id,count);
			case MUSIC_TYPE: avai = checkMusicAvailability(id,count);
			case MOVIE_TYPE: avai = checkMovieAvailability(id,count);
			default: System.out.println("Wrong item type!");
			break;
			}
			return avai;
		}
		public String getTitleByID(int id,int type)
		{
			int index = Inventory.checkItem(id, type);
			String title = null;
			switch(type) {
			case BOOK_TYPE:  title = Inventory.books[index].getTitle();
			case MUSIC_TYPE: title =  Inventory.musics[index].getTitle();
			case MOVIE_TYPE: title = Inventory.movies[index].getTitle();
			}
			return title;
		}
		
		public static OrderItem getItemByID(int id,int type,int quantity) {
			OrderItem item = new OrderItem();
			int index= Inventory.checkItem(id, type);
			if(index!=-1) {
			switch(type) {
			case BOOK_TYPE: item.setID(id);
			item.setTitle(Inventory.books[index].getTitle());
			item.setQuantity(quantity);
			item.setSell_price(Inventory.books[index].getSell_price());
			item.setBuy_price(Inventory.books[index].getBuy_price());
			item.setItem_type(type);
			break;
			case MOVIE_TYPE: item.setID(id);
			item.setTitle(Inventory.movies[index].getTitle());
			item.setQuantity(quantity);
			item.setSell_price(Inventory.movies[index].getSell_price());
			item.setBuy_price(Inventory.movies[index].getBuy_price());
			item.setItem_type(type);
			break;
			
			case MUSIC_TYPE: item.setID(id);
			item.setTitle(Inventory.musics[index].getTitle());
			item.setQuantity(quantity);
			item.setSell_price(Inventory.musics[index].getSell_price());
			item.setBuy_price(Inventory.musics[index].getBuy_price());
			item.setItem_type(type);
			break;
			}
			return item;
		}
		
		else return null;
}
		
}
