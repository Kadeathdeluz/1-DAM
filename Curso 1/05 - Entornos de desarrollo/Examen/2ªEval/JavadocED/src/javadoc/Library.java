package javadoc;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una librería que contiene un catálogo de libros.
 *
 * @author <b>Raúl Palao</b> <i>feat.</i> <b>Roldán Sanchis Martínez</b>
 * @version 1.0 07-05-2024
 *
 */
public class Library {

    /**
     * Catálogo de libros
     */
    private List<Book> catalog;

    /**
     * Constructor vacío de la clase Library. Únicamente añade un catálogo vacío
     * de libros.
     */
    public Library() {
        this.catalog = new ArrayList<>();
    }

    /**
     * Añade un libro al catálogo de libros.
     *
     * @param book El libro que se va a añadir.
     */
    public void addBook(Book book) {
        catalog.add(book);
    }

    /**
     * Busca un libro en el catálogo de libros dado su título y lo devuelve.
     *
     * @param title Título del libro a buscar.
     * @return Devuelve un objeto de la clase Book dado un título. Si el título
     * no está entre los títulos de los libros devuelve NULL.
     */
    public Book findBookByTitle(String title) {
        for (Book book : catalog) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    /**
     * Busca un conjunto de libros por su autor y los retorna en forma de lista.
     *
     * @param author Nombre del autor de los libros a buscar.
     * @return Devuelve una List de Book con los libros del autor. Si no hay
     * libros de un autor devuelve una lista vacía.
     */
    public List<Book> findBooksByAuthor(String author) {
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : catalog) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }

    /**
     * Intenta prestar un libro a un usuario y dice si ha sido posible el
     * préstamo.
     *
     * @param book El libro a prestar.
     * @param borrower El nombre del usuario del préstamo.
     * @return Devuelve un booleano dependiendo de si ha sido posible o no el
     * préstamo:
     * <ul>
     * <li>True : Se ha realizado el préstamo correctamente. </li>
     * <li>False : El préstamo ya se había realizado (puede que a otro
     * usuario).</li>
     * </ul>
     */
    public boolean checkoutBook(Book book, String borrower) {
        if (book.isCheckedOut()) {
            return false; // Book is already checked out
        }
        book.setCheckedOut(true);
        book.setBorrower(borrower);
        return true;
    }

    /**
     * Intenta devolver un libro a la librería y dice si ha sido posible o no.
     *
     * @param book Libro a devolver.
     * @return Devuelve un booleano dependiendo de si se ha podido devolver o
     * no.
     * <ul>
     * <li>True : El libro se ha podido devolver correctamente. </li>
     * <li>False : el libro no se ha podido devolver (no estaba prestado).</li>
     * </ul>
     */
    public boolean returnBook(Book book) {
        if (!book.isCheckedOut()) {
            return false; // Book is not currently checked out
        }
        book.setCheckedOut(false);
        book.setBorrower(null);
        return true;
    }
}

/**
 * Clase que representa un libro que que contiene título, autor, si está
 * prestado o no y a quién (en caso de que sí).
 *
 * @author <b>Raúl Palao</b> <i>feat.</i> <b>Roldán Sanchis Martínez</b>
 * @version 1.0 07-05-2024
 */
class Book {

    /**
     * Título del libro
     */
    private String title;
    /**
     * Autor del libro
     */
    private String author;
    /**
     * Si el libro está prestado o no.
     */
    private boolean checkedOut;
    /**
     * Usuario del préstamo.
     */
    private String borrower;

    /**
     * Constructor de la clase Book con parámetros. Crea un libro con título y
     * autor, pero sin préstamo (checkedOut = false y borrower = null).
     */
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.checkedOut = false;
        this.borrower = null;
    }

    /**
     * Devuelve el título del libro.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Devuelve el autor del libro.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Dice si el libro está prestado o no.
     */
    public boolean isCheckedOut() {
        return checkedOut;
    }

    /**
     * Actualiza el valor de prestado:
     * <ul>
     * <li>True : está prestado.</li>
     * <li>False : no está prestado.</li>
     * </ul>
     */
    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    /**
     * Devuelve a quién se ha prestado el libro.
     */
    public String getBorrower() {
        return borrower;
    }

    /**
     * Actualiza el nombre del usuario del préstamo. Si es null quiere decir que
     * no está prestado.
     */
    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }
}
