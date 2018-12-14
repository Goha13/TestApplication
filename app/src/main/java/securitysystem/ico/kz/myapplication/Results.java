package securitysystem.ico.kz.myapplication;

import java.util.List;

public class Results {
    private Integer vote_count;

    private Integer id;

    private Boolean video;

    private Double vote_average;

    private String title;

    private Double popularity;

    private String poster_path;

    private String original_language;

    private String original_title;

    private List<Integer> genre_ids ;

    private String backdrop_path;

    private Boolean adult;

    private String overview;

    private String release_date;

    public String getTitle() {
        return title;
    }

    public Double getPopularity() {
        return popularity;
    }

    public Boolean getVideo() {
        return video;
    }

    public Boolean getAdult() {
        return adult;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public Integer getId() {
        return id;
    }

    public Integer getVote_count() {
        return vote_count;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getOverview() {
        return overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setGenre_ids(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    public void setVote_count(Integer vote_count) {
        this.vote_count = vote_count;
    }
}
