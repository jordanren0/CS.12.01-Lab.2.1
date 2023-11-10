import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
public class StoreTester {
    @Test
    void addBookTest(){
        Store store = new Store();
        Book book = new Book();
        store.addBook(book);
        assertTrue(true);
    }

    @Test
    void addBookAndPhoneTest(){
        Store store = new Store();
        Book book = new Book();
        Phone phone = new Phone();
        store.addPhone(phone);
        store.addBook(book);
        assertTrue(true);
    }

    @Test
    void updatePhoneLocationGetAllPhones(){
        Store store = new Store();
        for(int i = 0; i < 20; i++){
            store.addPhone(new Phone());
        }
        store.updatePhonesLocation("Room 514");
        ArrayList<Phone> phone = store.getAllPhones();
        for(Phone p: phone){
            assertEquals(p.getLocation(), "Room 514");
        }
    }

    @Test
    void getItemTest(){
        Store store = new Store();
        for(int i = 0; i < 20; i++){
            store.addPhone(new Phone());
            store.addBook(new Book());
            store.addMagazine(new Magazine());
            store.addArduino(new Arduino());
        }

        //Check phone
        ArrayList<CISItem> phone = store.getItems("Phone");
        assertEquals(phone.size(), 20);
        for(CISItem item: phone) assertTrue(item instanceof Phone);

        //Check magazine
        ArrayList<CISItem> magazine = store.getItems("Magazine");
        assertEquals(magazine.size(), 20);
        for(CISItem item: magazine) assertTrue(item instanceof Magazine);

        //Check book
        ArrayList<CISItem> book = store.getItems("Book");
        assertEquals(book.size(), 20);
        for(CISItem item: book) assertTrue(item instanceof Book);

        //Check phone
        ArrayList<CISItem> arduino = store.getItems("Arduino");
        assertEquals(arduino.size(), 20);
        for(CISItem item: arduino) assertTrue(item instanceof Arduino);
    }

    @Test
    void updateItems(){
        Store store = new Store();
        for(int i = 0; i < 20; i++){
            store.addPhone(new Phone());
            store.addBook(new Book());
            store.addMagazine(new Magazine());
            store.addArduino(new Arduino());
        }

        //phone, location
        store.updateItems("phone", "location", "Room 222");
        ArrayList<CISItem> phone = store.getItems("phone");
        for(CISItem item : phone){
            assertEquals(item.getLocation(), "Room 222");
        }

        //magazine, date published
        store.updateItems("magazine", "datepublished", "March 21, 1967");
        ArrayList<CISItem> magazine = store.getItems("magazine");
        for(CISItem item : magazine){
            assertEquals(((Magazine) item).getDatePublished(), "March 21, 1967");
        }

        //book, title
        store.updateItems("book", "title", "The Visit");
        ArrayList<CISItem> book = store.getItems("book");
        for(CISItem item : book){
            assertEquals(((Book) item).getTitle(), "The Visit");
        }

        //arduino, version
        store.updateItems("arduino", "version", "10.1.2");
        ArrayList<CISItem> arduino = store.getItems("arduino");
        for(CISItem item : arduino){
            assertEquals(((Arduino) item).getVersion(), "10.1.2");
        }
    }

}
