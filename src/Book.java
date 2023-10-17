import java.io.Serializable;

public class Book implements Serializable {

    public static Inventory inventory = new Inventory();

    private String title;
    private String author;
    private int id;
    private int availableAmount;

    public Book(String title, String author, int id)
    {
        this.title = title;
        this.author = author;
        this.id = id;
        this.availableAmount = 5;
    }

    public Book(String title, String author, int id, int availableAmount)
    {
        this.title = title;
        this.author = author;
        this.id = id;
        this.availableAmount = availableAmount;
    }

    public void changeAmountBy(int amount) { availableAmount += amount; }

    
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getId() { return id; }
    public int getAvailableAmount() { return availableAmount; }
}
