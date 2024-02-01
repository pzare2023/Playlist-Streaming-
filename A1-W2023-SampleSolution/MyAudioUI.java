import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.text.AbstractDocument.Content;


// Simulation of a Simple Text-based Music App (like Apple Music)

public class MyAudioUI
{
	public static void main(String[] args)
	{
		// Simulation of audio content in an online store
		// The songs, podcasts, audiobooks in the store can be downloaded to your library
		AudioContentStore store = new AudioContentStore();
		ArrayList<AudioContent> contents = AudioContentStore.contents;
		
		// Create my music library
		Library library = new Library();

		Scanner scanner = new Scanner(System.in);
		System.out.print(">");

		// Process keyboard actions
		while (scanner.hasNextLine())
		{
			String action = scanner.nextLine();

			if (action == null || action.equals("")) 
			{
				System.out.print("\n>");
				continue;
			}
			else if (action.equalsIgnoreCase("Q") || action.equalsIgnoreCase("QUIT"))
				return;
			
			else if (action.equalsIgnoreCase("STORE"))	// List all songs
			{
				store.listAll(); 
			}
			else if (action.equalsIgnoreCase("SONGS"))	// List all songs
			{
				library.listAllSongs(); 
			}
			else if (action.equalsIgnoreCase("BOOKS"))	// List all songs
			{
				library.listAllAudioBooks(); 
			}
			else if (action.equalsIgnoreCase("PODCASTS"))	// List all songs
			{
				library.listAllPodcasts(); 
			}
			else if (action.equalsIgnoreCase("ARTISTS"))	// List all songs
			{
				library.listAllArtists(); 
			}
			else if (action.equalsIgnoreCase("PLAYLISTS"))	// List all play lists
			{
				library.listAllPlaylists(); 

				int fromIndex = 0;
				int toIndex=0;
			}
			else if (action.equalsIgnoreCase("DOWNLOAD")) 
			{
				
				int fromIndex=0;
				int toIndex=0;
				System.out.print("Store Content from #: ");
				
				if (scanner.hasNextInt())
				{
					fromIndex = scanner.nextInt();
					scanner.nextLine(); // consume nl
				}
				System.out.print("Store Content to #: ");
				
				if (scanner.hasNextInt())
				{
					toIndex = scanner.nextInt();
					scanner.nextLine(); // consume nl
				}
				for (int i=fromIndex; i<=toIndex;i++){
				AudioContent content = store.getContent(i);
				if (content == null)
					System.out.println("Content Not Found in Store");
				
				else{ 
					library.download(content);

				}
			}
									
			}
			else if (action.equalsIgnoreCase("DOWNLOADA")) 
			{
				
				String artist="";
				System.out.print("artist : ");
				
				if (scanner.hasNextLine())
				{
					artist = scanner.nextLine();
					scanner.nextLine(); // consume nl
				}
				
				try{
					AudioContentStore.downloada(artist);
				}
				catch(FileNotFoundException g){
					System.out.println("No match for "+artist);
				}
									
			}
			else if (action.equalsIgnoreCase("DOWNLOADG")) 
			{
				
				String genre="";
				System.out.print("genre : ");
				
				if (scanner.hasNextLine())
				{
					genre = scanner.nextLine();
					scanner.nextLine(); // consume nl
				}
				
				try{
					AudioContentStore.downloadg(genre);
				}
				catch(FileNotFoundException g){
					System.out.println("No match for "+genre);
				}
									
			}
			else if (action.equalsIgnoreCase("PLAYSONG")) 
			{
				int index = 0;

				System.out.print("Song Number: ");
				if (scanner.hasNextInt())
				{
					index = scanner.nextInt();
				// consume the nl character since nextInt() does not
					scanner.nextLine(); 
				}
				if (!library.playSong(index))
					System.out.println(library.getErrorMessage());	
			}
			else if (action.equalsIgnoreCase("BOOKTOC")) 
			{
				int index = 0;

				System.out.print("Audio Book Number: ");
				if (scanner.hasNextInt())
				{
					index = scanner.nextInt();
					scanner.nextLine();
				}
				if (!library.printAudioBookTOC(index))
					System.out.println(library.getErrorMessage());	
			}
			else if (action.equalsIgnoreCase("PLAYBOOK")) 
			{
				int index = 0;

				System.out.print("Audio Book Number: ");
				if (scanner.hasNextInt())
				{
					index = scanner.nextInt();
				}
				int chapter = 0;
				System.out.print("Chapter: ");
				if (scanner.hasNextInt())
				{
					chapter = scanner.nextInt();
					scanner.nextLine();
				}
				if (!library.playAudioBook(index, chapter))
					System.out.println(library.getErrorMessage());	
			}
			
			else if (action.equalsIgnoreCase("PODTOC")) 
			{
				int index = 0;
				int season = 0;
				
				System.out.print("Podcast Number: ");
				if (scanner.hasNextInt())
				{
					index = scanner.nextInt();
				}
				System.out.print("Season: ");
				if (scanner.hasNextInt())
				{
					season = scanner.nextInt();
					scanner.nextLine();
				}
				if (!library.printPodcastEpisodes(index, season))
					System.out.println(library.getErrorMessage());	
			}
			else if (action.equalsIgnoreCase("PLAYPOD")) 
			{
				int index = 0;

				System.out.print("Podcast Number: ");
				if (scanner.hasNextInt())
				{
					index = scanner.nextInt();
					scanner.nextLine();
				}
				int season = 0;
				System.out.print("Season: ");
				if (scanner.hasNextInt())
				{
					season = scanner.nextInt();
					scanner.nextLine();
				}
				int episode = 0;
				System.out.print("Episode: ");
				if (scanner.hasNextInt())
				{
					episode = scanner.nextInt();
					scanner.nextLine();
				}
				if (!library.playPodcast(index, season, episode))
					System.out.println(library.getErrorMessage());	
			}
			else if (action.equalsIgnoreCase("PLAYALLPL")) 
			{
				String title = "";

				System.out.print("Playlist Title: ");
				if (scanner.hasNextLine())
				{
					title = scanner.nextLine();
				}
				if (!library.playPlaylist(title))
					System.out.println(library.getErrorMessage());	
			}
			else if (action.equalsIgnoreCase("PLAYPL")) 
			{
				String title = "";
        int index = 0;
        
				System.out.print("Playlist Title: ");
				if (scanner.hasNextLine())
				{
					title = scanner.nextLine();
				}
				System.out.print("Content Number: ");
				if (scanner.hasNextInt())
				{
					index = scanner.nextInt();
					scanner.nextLine();
				}
				if (!library.playPlaylist(title, index))
					System.out.println(library.getErrorMessage());	
			}
			// Delete a song from the library and any play lists it belongs to
			else if (action.equalsIgnoreCase("DELSONG")) 
			{
				int songNum = 0;

				System.out.print("Library Song #: ");
				if (scanner.hasNextInt())
				{
					songNum = scanner.nextInt();
					scanner.nextLine();
				}
				
				if (!library.deleteSong(songNum))
					System.out.println(library.getErrorMessage());	
			}
			else if (action.equalsIgnoreCase("MAKEPL")) 
			{
				String title = "";

				System.out.print("Playlist Title: ");
				if (scanner.hasNextLine())
				{
					title = scanner.nextLine();
				}
				if (!library.makePlaylist(title))
					System.out.println(library.getErrorMessage());	
			}
			else if (action.equalsIgnoreCase("PRINTPL"))	// print playlist content
			{
				String title = "";

				System.out.print("Playlist Title: ");
				if (scanner.hasNextLine())
					title = scanner.nextLine();

				if (!library.printPlaylist(title))
					System.out.println(library.getErrorMessage());
			}
			// Add content from library (via index) to a playlist
			else if (action.equalsIgnoreCase("ADDTOPL")) 
			{
				int contentIndex = 0;
				String contentType = "";
				String playlist = "";
				
				System.out.print("Playlist Title: ");
				if (scanner.hasNextLine())
					playlist = scanner.nextLine();
        
				System.out.print("Content Type [SONG, PODCAST, AUDIOBOOK]: ");
				if (scanner.hasNextLine())
					contentType = scanner.nextLine();
				
				System.out.print("Library Content #: ");
				if (scanner.hasNextInt())
				{
					contentIndex = scanner.nextInt();
					scanner.nextLine(); // consume nl
				}
				
				if (!library.addContentToPlaylist(contentType, contentIndex, playlist))
					System.out.println(library.getErrorMessage());	
			}
			// Delete content from play list
			else if (action.equalsIgnoreCase("DELFROMPL")) 
			{
				int contentIndex = 0;
				String playlist = "";

				System.out.print("Playlist Title: ");
				if (scanner.hasNextLine())
					playlist = scanner.nextLine();
				
				System.out.print("Playlist Content #: ");
				if (scanner.hasNextInt())
				{
					contentIndex = scanner.nextInt();
					scanner.nextLine(); // consume nl
				}
				if (!library.delContentFromPlaylist(contentIndex, playlist))
					System.out.println(library.getErrorMessage());	
			}
			else if (action.equalsIgnoreCase("SORTBYYEAR")) // sort songs by year
			{
				library.sortSongsByYear();
			}
			else if (action.equalsIgnoreCase("SORTBYNAME")) // sort songs by name (alphabetic)
			{
				library.sortSongsByName();
			}
			else if (action.equalsIgnoreCase("SORTBYLENGTH")) // sort songs by length
			{
				library.sortSongsByLength();
			}

			else if (action.equalsIgnoreCase("SEARCH"))	
			{
				String title = "";

				System.out.print("Title: ");
				

				try{

					if (scanner.hasNextLine()){
					title = scanner.nextLine();
					AudioContentStore.search(title);
					}
				}	
				catch(FileNotFoundException f){
							System.out.println("No matches for "+title);
						
					}
				
			}
			else if (action.equalsIgnoreCase("SEARCHA"))	
			{
				String artist = "";

				System.out.print("Artist: ");

				try{
					if (scanner.hasNextLine()){

					artist=scanner.nextLine();
					AudioContentStore.searcha(artist);

					}
				

				}
				catch (FileNotFoundException h){
					System.out.println("No matches for "+artist);
				}
				

				
			}
			else if (action.equalsIgnoreCase("SEARCHG"))	
			{
				String genre = "";

				System.out.print("Genre: ");

				try{
					if (scanner.hasNextLine()){

					genre=scanner.nextLine();
					AudioContentStore.searchg(genre);

					}
				}

				
				catch(FileNotFoundException h){
					System.out.println("No matches for "+genre);
					}
					

				
			}
			else if (action.equalsIgnoreCase("DOWNLOADA"))	
			{
				String artist = "";

				System.out.print("Artist: ");

				try{
					if (scanner.hasNextLine()){

					artist=scanner.nextLine();
					AudioContentStore.downloada(artist);

					}
				}

				
				catch(FileNotFoundException h){
					System.out.println("No matches for "+artist);
					}
				
			}
			else if (action.equalsIgnoreCase("DOWNLOADG"))	
			{
				String genre = "";

				System.out.print("Genre: ");

				try{
					if (scanner.hasNextLine()){

					genre=scanner.nextLine();
					AudioContentStore.downloadg(genre);

					}
				}

				
				catch(FileNotFoundException h){
					System.out.println("No matches for "+genre);
					}
				
			}
			

			System.out.print("\n>");
		}
	}
}
