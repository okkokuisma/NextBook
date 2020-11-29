package nextbook;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import nextbook.dao.ClueDao;
import nextbook.domain.Book;
import nextbook.domain.Clue;
import nextbook.domain.ClueService;
import nextbook.io.StubIO;
import nextbook.ui.Ui;

import static org.junit.Assert.*;

public class Stepdefs {
    ClueDao dao = new ClueDaoForTests();
    StubIO io;
    Ui ui;
    List<String> inputLines;
        
    ClueService service;
    
    @Before
    public void setup() {
        this.service = new ClueService(dao);
        this.inputLines = new ArrayList<>();
    }
   

    @Given("command add book is selected")
    public void commandAddBookIsSelected() {
        inputLines.add("add book");
    }
    
    @Given("command add video is selected")
    public void commandAddVideoIsSelected() {
        inputLines.add("add video");
    }
    
    @Given("command list is selected")
    public void commandListIsSelected() {
        inputLines.add("list");
        io = new StubIO(inputLines);
        ui = new Ui(io, service);
        ui.start();
    }
    
    @Given("clue {string} with author {string} is created")
    public void clueWithAuthorIsCreated(String name, String author) {
        service.createClue(new Book(name, author));
    }
    
    @Given("book {string} with author {string} and with isbn {string}, year {string} and comment {string} is created")
    public void bookWithAuthorAndWithIsbnYearAndCommentIsCreated(String name, String author, String isbn, String year, String comment) {
        inputLines.add("add book");
        addBooksVariables(name, author, isbn, year, comment);
    }
    
    
    @When("a valid name {string}, author {string}, isbn {string}, year {string} and comment {string} are entered")
    public void aValidNameAuthorIsbnYearAndCommentAreEntered(String name, String author, String isbn, String year, String comment) {
        addBooksVariables(name, author, isbn, year, comment);
        
        uiStart();
    }
    
    @When("a valid name {string}, link {string} and time {string} are entered")
    public void aValidNameLinkAndTimeAreEntered(String name, String link, String time) {
        inputLines.add(name);
        inputLines.add(link);
        inputLines.add(time);
        
        uiStart();
    }
    
    @Then("system will response with {string}")
    public void systemWillResponseWith(String expectedOutput) {
        System.out.println("hhhhh" + io.getPrints());
        assertTrue(io.getPrints().contains(expectedOutput));
    }
    
    @Then("correct data can be seen")
    public void correctDataCanBeSeen() {
        ArrayList<Clue> clues = service.readClues();
        
        assertTrue(clues.size() == 1);
        
    }
    
    public void addBooksVariables(String name, String author, String isbn, String year, String comment) {
        inputLines.add(name);
        inputLines.add(author);
        inputLines.add(isbn);
        inputLines.add(year);
        inputLines.add(comment);
    }
    
    public void uiStart() {
        io = new StubIO(inputLines);
        ui = new Ui(io, service);
        ui.start();
    }  
}

