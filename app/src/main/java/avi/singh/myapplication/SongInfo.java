package avi.singh.myapplication;

public class SongInfo {
    private String Songname;
    private String Artistname;
    private String SongUrl;
    private String Album;

    public SongInfo() {
    }

    public SongInfo(String songname, String artistname, String songUrl, String album) {
        Songname = songname;
        Artistname = artistname;
        SongUrl = songUrl;
        Album = album;
    }

    public String getSongname() {
        return Songname;
    }

    public void setSongname(String songname) {
        Songname = songname;
    }

    public String getArtistname() {
        return Artistname;
    }

    public void setArtistname(String artistname) {
        Artistname = artistname;
    }

    public String getSongUrl() {
        return SongUrl;
    }

    public void setSongUrl(String songUrl) {
        SongUrl = songUrl;
    }


    public String getAlbum() {
        return Album;
    }


    public void setAlbum(String album) {
         Album = album;
    }
}
