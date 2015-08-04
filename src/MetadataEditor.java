import java.io.File;
import java.io.IOException;
import java.net.URI;

import org.jaudiotagger.*;
import org.jaudiotagger.audio.*;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.*;


public class MetadataEditor {
	
	File dir;
	File[] directoryListing;
	AudioFile src;
	Tag tag;
	Browser b;

	public MetadataEditor() throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException{
		dir = new File("C:\\Users\\Gabriel\\Music\\iTunes\\iTunesMedia\\Music");
		directoryListing = dir.listFiles();
		src = AudioFileIO.read(new File("C:\\Users\\Gabriel\\Music\\iTunes\\iTunesMedia\\Music\\18+\\Trust\\02 Midnight Lucy.mp3"));
		tag = src.getTag();
		b = new Browser();
	}
	
	//searches the computer's directory for mp3 files
	public void homeBrowser() throws KeyNotFoundException, CannotWriteException, CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException{
		int counter =0;
		for (File artistFolder: directoryListing){
			if (artistFolder.isDirectory()){
				File artistFolderDir = new File(artistFolder.toURI());
				File[] artistFolderContents = artistFolderDir.listFiles();
				for (File albumFolder: artistFolderContents){
					if (albumFolder.isDirectory()){
					File albumFolderDir = new File(albumFolder.toURI());
					File[] albumFolderContents = albumFolderDir.listFiles();
						for (File track : albumFolderContents){ 
							genreSetter(track.toURI());
							System.out.println(track);
						}
				
					}
				}
			}
		}
		System.out.println(counter);
	}
	
	public void genreSetter(URI trackURI) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException, CannotWriteException{
		AudioFile track = AudioFileIO.read(new File(trackURI));
		Tag tag = track.getTag();
		String artist = tag.getFirst(FieldKey.ARTIST);
		String album = tag.getFirst(FieldKey.ALBUM);
		String title = tag.getFirst(FieldKey.TITLE);
		String genreTags = "";
		b.getGenre(artist, album, track);
		//Commented out so that all tags are not changed during testing
		//tag.setField(FieldKey.ARTIST, genreTags);
		track.commit();
	}
}
