import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Catalog {
    private List<LoanHistoryEntry> loanHistoryEntries;

    public Catalog() {
        loanHistoryEntries = new ArrayList<>();
    }

    // Метод для добавления записи о выдаче книги
    public void addLoanHistory(String bookTitle, String readerName, LocalDate loanDate, LocalDate returnDate) {
        LoanHistoryEntry entry = new LoanHistoryEntry(bookTitle, readerName, loanDate, returnDate);
        loanHistoryEntries.add(entry);
    }

    // Метод для отображения всей истории выдач
    public void showLoanHistory() {
        for (LoanHistoryEntry entry : loanHistoryEntries) {
            System.out.println(entry);
        }
    }

    // Метод для поиска книг, взятых в определенном месяце
    public void showLoansByMonth(int month) {
        boolean found = false; // Флаг для проверки, если найдены записи
        System.out.println("Книги, взятые в месяц " + month + ":");

        for (LoanHistoryEntry entry : loanHistoryEntries) {
            if (entry.getLoanDate().getMonthValue() == month) {
                System.out.println(entry);
                found = true; // Устанавливаем флаг, если найдена хотя бы одна запись
            }
        }

        if (!found) { // Если флаг не был установлен, значит записи не найдены
            System.out.println("Нет записей о выдаче книг в указанный месяц.");
        }
    }

    // Внутренний класс для хранения информации о выдаче книги
    public class LoanHistoryEntry {
        private String bookTitle;
        private String readerName;
        private LocalDate loanDate;
        private LocalDate returnDate;

        public LoanHistoryEntry(String bookTitle, String readerName, LocalDate loanDate, LocalDate returnDate) {
            this.bookTitle = bookTitle;
            this.readerName = readerName;
            this.loanDate = loanDate;
            this.returnDate = returnDate;
        }

        public LocalDate getLoanDate() {
            return loanDate;
        }

        @Override
        public String toString() {
            return "Book Title: " + bookTitle + ", Reader: " + readerName +
                    ", Loan Date: " + loanDate + ", Return Date: " + returnDate;
        }
    }
}
