import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();

        catalog.addLoanHistory("The Great Gatsby", "John Doe", LocalDate.of(2024, 1, 10), LocalDate.of(2024, 2, 10));
        catalog.addLoanHistory("Moby Dick", "Jane Smith", LocalDate.of(2024, 3, 15), LocalDate.of(2024, 4, 15));
        catalog.addLoanHistory("To Kill a Mockingbird", "Alice Johnson", LocalDate.of(2024, 5, 1), LocalDate.of(2024, 6, 1));
        catalog.addLoanHistory("Pride and Prejudice", "Bob Brown", LocalDate.of(2024, 2, 20), LocalDate.of(2024, 3, 20));
        catalog.addLoanHistory("War and Peace", "Carol White", LocalDate.of(2024, 4, 5), LocalDate.of(2024, 5, 5));
        catalog.addLoanHistory("1984", "David Black", LocalDate.of(2024, 6, 12), LocalDate.of(2024, 7, 12));
        catalog.addLoanHistory("Crime and Punishment", "Emily Green", LocalDate.of(2024, 7, 22), LocalDate.of(2024, 8, 22));
        catalog.addLoanHistory("The Catcher in the Rye", "Frank Miller", LocalDate.of(2024, 8, 18), LocalDate.of(2024, 9, 18));
        catalog.addLoanHistory("The Hobbit", "Grace Thompson", LocalDate.of(2024, 9, 25), LocalDate.of(2024, 10, 25));
        catalog.addLoanHistory("Les Misérables", "Henry Wilson", LocalDate.of(2024, 10, 30), LocalDate.of(2024, 11, 30));
        catalog.addLoanHistory("Brave New World", "Ivy Clark", LocalDate.of(2024, 11, 15), LocalDate.of(2024, 12, 15));
        catalog.addLoanHistory("Anna Karenina", "Jack Adams", LocalDate.of(2024, 12, 5), LocalDate.of(2025, 1, 5));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер месяца (1-12), чтобы найти книги, взятые в этом месяце: ");
        int month = scanner.nextInt();

        catalog.showLoansByMonth(month);
    }
}
