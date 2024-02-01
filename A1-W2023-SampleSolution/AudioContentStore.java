import java.util.ArrayList;
import java.util.Scanner;

// Simulation of audio content in an online store
// The songs, podcasts, audiobooks listed here can be "downloaded" to your library

public class AudioContentStore
{
		private ArrayList<AudioContent> contents; 
		
		public AudioContentStore()
		{
			contents = new ArrayList<AudioContent>();
			Map<String, Integer> myMap = new HashMap<String , Integer>();
			Map<String, Integer> myMap2 = new HashMap<String , ArrayList>();
			Map<String, Integer> myMap3 = new HashMap<String , Arraylist>();
			
		  // Create some songs audiobooks and podcasts and to store
			String file = "Yesterday, all my troubles";
			contents.add(new Song("Yesterday", 1965, "123", Song.TYPENAME, file, 2, "The Beatles", "Paul McCartney", Song.Genre.POP, file));
			
			file = "I'm sorry if I seem uninterested\n"
					+ "Or I'm not listenin' or I'm indifferent\n"
					+ "Truly, I ain't got no business here\n"
					+ "But since my friends are here, I just came to kick it\n"
					+ "But really I would rather be at home all by myself not in this room\n"
					+ "With people who don't even care about my well being";
			contents.add(new Song("Here", 2015, "391", Song.TYPENAME, file, 3, "Alessia Cara", "Alessia Cara", Song.Genre.POP, file));
			
			file = "Yo, Big Shaq, the one and only\n"
					+ "Man's not hot, never hot\n"
					+ "Skrrat (GottiOnEm), skidi-kat-kat\n"
					+ "Boom\n"
					+ "Two plus two is four\n"
					+ "Minus one that's three, quick maths\n"
					+ "Everyday man's on the block\n"
					+ "Smoke trees (Ah)";
			contents.add(new Song("Man's Not Hot", 2017, "374", Song.TYPENAME, file, 2, "Michael Dapaah", "Michael Dapaah", Song.Genre.RAP, file));
			
			file = "The world was on fire and no one could save me but you\n"
					+ "It's strange what desire will make foolish people do\n"
					+ "I never dreamed that I'd meet somebody like you\n"
					+ "And I never dreamed that I'd lose somebody like you";
			contents.add(new Song("Wicked Game", 1989, "185", Song.TYPENAME, file, 4, "Chris Isaak", "Chris Isaak", Song.Genre.ROCK, file));
			
			file = "The lights go out and I can't be saved\n"
					+ "Tides that I tried to swim against\n"
					+ "Have brought me down upon my knees\n"
					+ "Oh, I beg, I beg and plead\n"
					+ "Singin' come out of things un said";
			contents.add(new Song("Clocks", 2002, "875", Song.TYPENAME, file, 5, "Coldplay", "Guy Berryman, Chris Martin", Song.Genre.ROCK, file));
			
			file = "She just wants to be, beautiful\n"
					+"She goes, unnoticed she knows, no limits\n"
					+"She craves, attention she praises, an image\n"
					+"She prays to be, sculpted by the sculptor";

			conetents.add(new Song("Scars To Your Beautiful", 2015, "222", Song.TYPENAME, file, 4,"Alessia Cara","Alessia Cara", Song.Genre.POP,file));

			file = "I'm waking up to ash and dust\n"
					+ "I wipe my brow and I sweat my rust\n"
					+ "I'm breathing in the chemicals";
			contents.add(new Song("Radioactive", 2012, "823", Song.TYPENAME, file, 3, "Imagine Dragons", "Josh Mosser, A. Grant, Dan Reynolds, Wayne Sermon, Ben McKee", Song.Genre.ROCK, file));
			
			file = "Birds flying high\n"
					+ "You know how I feel\n"
					+ "Sun in the sky\n"
					+ "You know how I feel\n"
					+ "Breeze driftin' on by\n"
					+ "You know how I feel\n"
					+ "It's a new dawn\n"
					+ "It's a new day\n"
					+ "It's a new life\n"
					+ "For me";
			contents.add(new Song("Feelin' Good", 1965, "875", Song.TYPENAME, file, 3, "Nina Simone", 
					"Anthony Newley, Leslie Bricusse",Song.Genre.JAZZ, file));
			
			file = "Find table spaces, say your social graces\n"
					+ "Bow your head, they're pious here\n"
					+ "But you and I, we're pioneers, we make our own rules\n"
					+ "Our own room, no bias here";
			contents.add(new Song("Wild Things", 2015, "443", Song.TYPENAME, file, 4, "Alessia Cara", "Alessia Cara", Song.Genre.POP, file));
			
			AudioBook book = new AudioBook("Harry Potter and the Goblet of Fire", 2015, "894", AudioBook.TYPENAME,  "", 1236,
					"J.K. Rowling", "Jim Dale", makeHPChapterTitles(), makeHPChapters());
			contents.add(book);
			
			book = new AudioBook("Moby Dick", 2018, "376", AudioBook.TYPENAME,  "", 1422,
					"Herman Melville", "Pete Cross", makeMDChapterTitles(), makeMDChapters());
			contents.add(book);
			
			book = new AudioBook("Shogun", 2018, "284", AudioBook.TYPENAME,  "", 3213,
					"James Clavel", "Ralph Lister", makeSHChapterTitles(), makeSHChapters());
			contents.add(book);
			
			Podcast podcast = new Podcast("The Secret Life of Canada", 2021, "865", Podcast.TYPENAME,  
					"Leah-Simone Bowen, Falen Johnson", makeSeasons());
			contents.add(podcast);
		}
		
		
		public AudioContent getContent(int index)
		{
			if (index < 1 || index > contents.size())
			{
				return null;
			}
			return contents.get(index-1);
		}
		
		public void listAll()
		{
			
			for (int i = 0; i < contents.size(); i++)
			{
				int index = i + 1;
				System.out.print(index + ". ");
				contents.get(i).printInfo();
				System.out.println();
			}
		}
		
		private ArrayList<String> makeHPChapterTitles()
		{
			ArrayList<String> titles = new ArrayList<String>();
			titles.add("The Riddle House");
			titles.add("The Scar");
			titles.add("The Invitation");
			titles.add("Back to The Burrow");
			return titles;
		}
		
		private ArrayList<String> makeHPChapters()
		{
			ArrayList<String> chapters = new ArrayList<String>();
			chapters.add("In which we learn of the mysterious murders\n"
					+ "in the Riddle House fifty years ago, \n"
					+ "how Frank Bryce was accused but released for lack of evidence, \n"
					+ "and how the Riddle House fell into disrepair. ");
			chapters.add("In which Harry awakens from a bad dream, \n"
					+ "his scar burning, we recap Harry�s previous adventures, \n"
					+ "and he writes a letter to his godfather.");
			chapters.add("In which Dudley and the rest of the Dursleys are on a diet,\n"
					+ "and the Dursleys get letter from Mrs. Weasley inviting Harry to stay\n"
					+ "with her family and attend the World Quidditch Cup finals.");
			chapters.add("In which Harry awaits the arrival of the Weasleys, \n"
					+ "who come by Floo Powder and get trapped in the blocked-off fireplace,\n"
					+ "blast it open, send Fred and George after Harry�s trunk,\n"
					+ "then Floo back to the Burrow. Just as Harry is about to leave, \n"
					+ "Dudley eats a magical toffee dropped by Fred and grows a huge purple tongue. ");
			return chapters;
		}
		
		private ArrayList<String> makeMDChapterTitles()
		{
			ArrayList<String> titles = new ArrayList<String>();
			titles.add("Loomings.");
			titles.add("The Carpet-Bag.");
			titles.add("The Spouter-Inn.");
			return titles;
		}
		private ArrayList<String> makeMDChapters()
		{
			ArrayList<String> chapters = new ArrayList<String>();
			chapters.add("Call me Ishmael. Some years ago�never mind how long precisely�having little\n"
					+ "or no money in my purse, and nothing particular to interest me on shore,\n"
					+ "I thought I would sail about a little and see the watery part of the world.");
			chapters.add("stuffed a shirt or two into my old carpet-bag, tucked it under my arm, \n"
					+ "and started for Cape Horn and the Pacific. Quitting the good city of old Manhatto, \n"
					+ "I duly arrived in New Bedford. It was a Saturday night in December.");
			chapters.add("Entering that gable-ended Spouter-Inn, you found yourself in a wide, \n"
					+ "low, straggling entry with old-fashioned wainscots, \n"
					+ "reminding one of the bulwarks of some condemned old craft.");
			return chapters;
		}
		
		private ArrayList<String> makeSHChapterTitles()
		{
			ArrayList<String> titles = new ArrayList<String>();
			titles.add("");
			titles.add("");
			titles.add("");
			titles.add("");
			return titles;
		}
		
		private ArrayList<String> makeSHChapters()
		{
			ArrayList<String> chapters = new ArrayList<String>();
			chapters.add("The gale tore at him and he felt its bite deep within\n"
					+ "and he knew that if they did not make landfall in three days they would all be dead");
			chapters.add("Blackthorne was suddenly awake. For a moment he thought he was dreaming\n"
					+ "because he was ashore and the room unbelieveable");
			chapters.add("The daimyo, Kasigi Yabu, Lord of Izu, wants to know who you are,\n"
					+ "where you come from, how ou got here, and what acts of piracy you have committed.");
			chapters.add("Yabu lay in the hot bath, more content, more confident than he had ever been in his life.");
			return chapters;
		}
		
		// Podcast Seasons
		private ArrayList<Season> makeSeasons()
		{
			ArrayList<Season> seasons = new ArrayList<Season>();
		  Season s1 = new Season();
		  s1.episodeTitles.add("Bay Blanket");
		  s1.episodeTitles.add("You Don't Want to Sleep Here");
		  s1.episodeTitles.add("The Gold Rush");
		  s1.episodeFiles.add("The Bay Blanket. These warm blankets are as iconic as Mariah Carey's \n"
		  		+ "lip-syncing, but some people believe they were used to spread\n"
		  		+ "smallpox and decimate entire Indigenous communities. \n"
		  		+ "We dive into the history of The Hudson's Bay Company and unpack the\n"
		  		+ "very complicated story of the iconic striped blanket.");
		  s1.episodeFiles.add("There is no doubt that the Klondike Gold Rush was an iconic event. \n"
		  		+ "But what did the mining industry cost the original people of the territory? \n"
		  		+ "And what was left when all the gold was gone? And what is a sour toe cocktail?");
		  s1.episodeFiles.add("here is no doubt that the Klondike Gold Rush was an iconic event. \n"
		  		+ "But what did the mining industry cost the original people of the territory? \n"
		  		+ "And what was left when all the gold was gone? And what is a sour toe cocktail?");
		  s1.episodeLengths.add(31);
		  s1.episodeLengths.add(32);
		  s1.episodeLengths.add(45);
		  seasons.add(s1);
		  Season s2 = new Season();
		  s2.episodeTitles.add("Toronto vs Everyone");
		  s2.episodeTitles.add("Water");
		  s2.episodeFiles.add("There is no doubt that the Klondike Gold Rush was an iconic event. \n"
		  		+ "But what did the mining industry cost the original people of the territory? \n"
		  		+ "And what was left when all the gold was gone? And what is a sour toe cocktail?");
		  s2.episodeFiles.add("Can the foundation of Canada be traced back to Indigenous trade routes?\n"
		  		+ "In this episode Falen and Leah take a trip across the Great Lakes, they talk corn\n"
		  		+ "and vampires, and discuss some big concerns currently facing Canada's water."); 
		  s2.episodeLengths.add(45);
		  s2.episodeLengths.add(50);
		 
		  seasons.add(s2);
		  return seasons;
		}
}
