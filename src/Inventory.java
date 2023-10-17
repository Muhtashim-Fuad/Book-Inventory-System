import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Inventory 
{
    private final String saveLocation = "H:\\bookInventory.dat";
    private Dictionary<Integer, Book> bookDictionary = new Hashtable<>();

    public ArrayList<Book> getBookList()
    {
        this.readData();
        return Collections.list(bookDictionary.elements());
    }

    public void registerItem(Book book)
    {
        bookDictionary.put(book.getId(), book);
        this.writeData();
    }

    public void unregisterItem(Book book)
    {
        bookDictionary.remove(book.getId());
        this.writeData();
    }
        
    public void unregisterItem(int id)
    {
        bookDictionary.remove(id);
        this.writeData();
    }

    public Book getBookFromID(int bookId) 
    {
        return bookDictionary.get(bookId); 
    }

    private void readData()
    {
        try
        {
            FileInputStream fileInputStream = new FileInputStream(saveLocation);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            bookDictionary = (Dictionary<Integer, Book>) objectInputStream.readObject();

            objectInputStream.close();
        }

        catch (Exception exception)
        {
            System.out.println("There was a problem accessing the file: " + saveLocation);
            exception.printStackTrace();
        }
    }

    private void writeData()
    {
        try
        {
            FileOutputStream fileOutputStream = new FileOutputStream(saveLocation);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this.bookDictionary);
            objectOutputStream.close();
        }

        catch (IOException exception)
        {
            System.out.println("There was a problem accessing the file: " + saveLocation);
            exception.printStackTrace();
        }
    }

}
