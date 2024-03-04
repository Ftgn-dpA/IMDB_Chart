package qst.bean;

public class MovieBean {
    private String month;
    private String genres;
    private float popularity;

    public MovieBean() {
    }

    public MovieBean(String month, String genres, float popularity) {
        this.month = month;
        this.genres = genres;
        this.popularity = popularity;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public String getMonth() {
        return month;
    }

    public String getGenres() {
        return genres;
    }

    public float getPopularity() {
        return popularity;
    }

    @Override
    public String toString() {
        return String.format("[%s,%s,%.2f]", month, genres, popularity);
    }

}