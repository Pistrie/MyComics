package Comic;

public class Comic {
    private String title;
    private int publication_number;
    private String genre;
    private int publication_year;
    private String publisher;
    private int isbn;

    public Comic(String title, int publication_number, String genre, int publication_year, String publisher, int isbn) {
        this.title = title;
        this.publication_number = publication_number;
        this.genre = genre;
        this.publication_year = publication_year;
        this.publisher = publisher;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getPublication_number() {
        return publication_number;
    }

    public String getGenre() {
        return genre;
    }

    public int getPublication_year() {
        return publication_year;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getIsbn() {
        return isbn;
    }
}
