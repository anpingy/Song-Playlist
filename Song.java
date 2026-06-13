public class Song {
    private String title;
    private String artist;
    private String filePath; 

    // Constructor
    public Song(String title, String artist, String filePath) {
        this.title = title;
        this.artist = artist;
        this.filePath = filePath;
    }

    // Getters
    public String getTitle() { 
        return title; }
    public String getArtist() { 
        return artist; }
    public String getFilePath() { 
        return filePath; }
}
