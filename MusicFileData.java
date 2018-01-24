public class MusicFileData {
    String title;
    String artist;
    String composer;
    String genre;
    String album;

    public MusicFileData(String title, String artist, String composer, String genre, String album) {
        this.title = title;
        this.artist = artist;
        this.composer = composer;
        this.genre = genre;
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getComposer() {
        return composer;
    }

    public String getGenre() {
        return genre;
    }

    public String getAlbum() {
        return album;
    }
}