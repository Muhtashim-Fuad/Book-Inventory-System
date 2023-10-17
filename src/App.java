import java.util.Scanner;

public class App
{
    
    public static void main(String[] args) throws Exception 
    {
        
        Scanner scanner = new Scanner(System.in);
        
        while(true) 
        {
            System.out.print
            ("Enter Action (1 for New Entry, 2 for Displaying List, 3 to Remove Entry, 4 to Change Available Amount): ");
            
            int userChoice = scanner.nextInt();
            scanner.nextLine();
            
            switch (userChoice) {
                case 0:
                    scanner.close();
                    return;
                case 1: 
                    registerBook(scanner);
                    break;
                case 2: 
                    displayBookList();
                    break;
                case 3:
                    unregisterBook(scanner);
                    break;
                case 4:
                    modifyBookAmount(scanner);
                default:
                    System.out.println("Invalid Input!");
            }
        }
    }

    private static void modifyBookAmount(Scanner scanner)
    {
        System.out.print("Enter Book ID: ");
        int bookIsbnId = scanner.nextInt();
        System.out.print("Enter Modify Amount: ");
        int changeAmount = scanner.nextInt();

        Book.inventory.getBookFromID(bookIsbnId).changeAmountBy(changeAmount);
        scanner.nextLine(); // Consume the newline character
    }

    private static void unregisterBook(Scanner scanner)
    {
        System.out.print("Enter Book ID: ");
        int bookIsbnId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Book.inventory.unregisterItem(bookIsbnId);
    }

    private static void registerBook(Scanner scanner)
    {
        System.out.print("Enter Book Title: ");
        String bookTitle = scanner.nextLine();

        System.out.print("Enter Author Name: ");
        String bookAuthor = scanner.nextLine();

        System.out.print("Enter Book ID: ");
        int bookIsbnId = scanner.nextInt();

        System.out.print("Enter Available Amount: ");
        int bookAmount = scanner.nextInt();

        scanner.nextLine(); // Consume the newline character

        Book newBook;

        if (bookAmount <= 0) newBook = new Book(bookTitle, bookAuthor, bookIsbnId);
        else newBook = new Book(bookTitle, bookAuthor, bookIsbnId, bookAmount);

        Book.inventory.registerItem(newBook);
    }
    private static void displayBookList()
    {
        System.out.println("List of Currently Available Books in the Inventory:");
        System.out.println("---------------------------------------------------");
        
        for (Book book : Book.inventory.getBookList())
        {
            System.out.println
            ("# \"" + 
                book.getTitle() + "\" by " +
                book.getAuthor() + " ISBN: " +
                book.getId() + " (Currently Available: " +
                book.getAvailableAmount() + ")");
        }

        System.out.println("---------------------------------------------------");
    }
}
