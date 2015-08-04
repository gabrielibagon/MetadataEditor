import java.io.File;
import java.io.IOException;

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

	public MetadataEditor() throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException{
		dir = new File("C:\\Users\\Gabriel\\Music\\iTunes\\iTunesMedia\\Music");
		directoryListing = dir.listFiles();
		src = AudioFileIO.read(new File("C:\\Users\\Gabriel\\Music\\iTunes\\iTunesMedia\\Music\\18+\\Trust\\02 Midnight Lucy.mp3"));
		tag = src.getTag();
		
	}
	
	public void genreSetter() throws KeyNotFoundException, CannotWriteException{
		for (File artistFolder: directoryListing){
			if (artistFolder.isDirectory()){
				File artistFolderDir = new File(artistFolder.toURI());
				File[] artistFolderContents = artistFolderDir.listFiles();
				for (File albumFolder: artistFolderContents){
					if (albumFolder.isDirectory()){
					File albumFolderDir = new File(albumFolder.toURI());
					File[] albumFolderContents = albumFolderDir.listFiles();
						for (File track : albumFolderContents){ 
	
							System.out.println(track);
						}
				
					}
				}
			}
		}
		try {
			tag.setField(FieldKey.GENRE,"Electronic, Dance");
		} catch (FieldDataInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		src.commit();
		System.out.println("helloworld");
	}
}
