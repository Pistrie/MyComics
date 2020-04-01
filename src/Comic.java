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
}
