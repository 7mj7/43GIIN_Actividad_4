import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.actividad4_pruebas.Book;
import com.actividad4_pruebas.InMemoryBookRepository;
import com.actividad4_pruebas.InMemoryUserRepository;
import com.actividad4_pruebas.SimpleLoanService;
import com.actividad4_pruebas.User;

public class LibraryManagementSystemTest {

    private InMemoryBookRepository bookRepository;
    private InMemoryUserRepository userRepository;
    private SimpleLoanService loanService;

    @Before
    public void setUp() {
        // Inicializar los repositorios y el servicio de préstamos antes de cada prueba
        bookRepository = new InMemoryBookRepository();
        userRepository = new InMemoryUserRepository();
        loanService = new SimpleLoanService(bookRepository, userRepository);

        // Agregar algunos libros y usuarios para las pruebas
        bookRepository.addBook(new Book(1, "Java Programming", "John Doe"));
        bookRepository.addBook(new Book(2, "Clean Code", "Robert C. Martin"));
        userRepository.addUser(new User(1, "user1", "password", false));
        userRepository.addUser(new User(2, "admin", "admin123", true));
    }

    @Test
    public void testBorrowBook() {
        // Realizar un préstamo válido
        loanService.borrowBook(1, 1);

        // Verificar que el libro fue prestado correctamente
        assertFalse(bookRepository.getBookById(1).isAvailable());
    }

    @Test
    public void testReturnBook() {
        // Realizar un préstamo
        loanService.borrowBook(1, 1);

        // Devolver el libro
        loanService.returnBook(1, 1);

        // Verificar que el libro está disponible después de la devolución
        assertTrue(bookRepository.getBookById(1).isAvailable());
    }

    @Test
    public void testGetLoansByUser() {
        // Realizar préstamos a un usuario
        loanService.borrowBook(1, 1);
        loanService.borrowBook(1, 2);

        // Obtener préstamos del usuario
        assertEquals(2, loanService.getLoansByUser(1).size());
    }

    @Test
    public void testGetLoansByBook() {
        // Realizar préstamos de un libro
        loanService.borrowBook(1, 1);
        loanService.borrowBook(2, 1);

        // Obtener préstamos del libro
        assertEquals(1, loanService.getLoansByBook(1).size());
    }
}
