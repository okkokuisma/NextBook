package nextbook;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import nextbook.dao.ClueDao;
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
   
    @Given("command add is selected")
    public void commandAddIsSelected() {
        inputLines.add("add");
    }
    
    @Given("command {string} is selected")
    public void commandIsSelected(String type) {
        inputLines.add(type);
    }
    
    @Given("command list is selected")
    public void commandListIsSelected() {
        inputLines.add("list");
        uiStart();
    }
    
    @Given("command update is selected")
    public void commandUpdateIsSelected() {
        System.out.println("update");
        inputLines.add("update");
    }
    
    @Given("id {string} is selected")
    public void idIsSelected(String string) {
        inputLines.add(string);
    }
    
    @Given("book {string} with author {string} and with isbn {string}, year {string} and comment {string} is created")
    public void bookWithAuthorAndWithIsbnYearAndCommentIsCreated(String name, String author, String isbn, String year, String comment) {
        inputLines.add("add");
        inputLines.add("1");
        addBooksVariables(name, author, isbn, year, comment);
    }
    
    @Given("video {string} with link {string} and time {string} is created")
    public void videoWithLinkAndTimeIsCreated(String name, String link, String time) {
        inputLines.add("add");
        inputLines.add("2");
        addVideoVariables(name, link, time);
    }
    
    @When("a valid name {string}, author {string}, isbn {string}, year {string} and comment {string} are entered")
    public void aValidNameAuthorIsbnYearAndCommentAreEntered(String name, String author, String isbn, String year, String comment) {
        addBooksVariables(name, author, isbn, year, comment);
        System.out.println("mmmm" + this.inputLines);
        io = new StubIO(inputLines);
        ui = new Ui(io, service);
        ui.start();
    }
    
    @When("a valid name {string}, link {string} and time {string} are entered")
    public void aValidNameLinkAndTimeAreEntered(String name, String link, String time) {
        addVideoVariables(name, link, time);
        uiStart();
    }
    
    @When("name is updated to {string} and author to {string}")
    public void nameIsUpdatedToAndAuthorTo(String name, String author) {
        inputLines.add("y");
        inputLines.add(name);
        inputLines.add("y");
        inputLines.add(author);
        uiStart();
    }
    
    @When("name is updated to {string} and link to {string} and time to {string}")
    public void nameIsUpdatedToAndLinkToAndTimeTo(String name, String link, String time) {
        inputLines.add("y");
        inputLines.add(name);
        inputLines.add("y");
        inputLines.add(link);
        inputLines.add("y");
        inputLines.add(time);
        uiStart();
    }
    
    @Then("system will response with {string}")
    public void systemWillResponseWith(String expectedOutput) {
        System.out.println("lines" + this.inputLines);
        System.out.println("output" + io.getPrints());
        assertTrue(io.getPrints().contains(expectedOutput));
    }
    
    @Then("system will response with {string} and {string}")
    public void systemWillResponseWithAnd(String expectedOutput1, String expectedOutput2) {
        assertTrue(io.getPrints().contains(expectedOutput1));
        assertTrue(io.getPrints().contains(expectedOutput2));
    }
    
    public void addBooksVariables(String name, String author, String isbn, String year, String comment) {
        inputLines.add(name);
        inputLines.add(author);
        inputLines.add(isbn);
        inputLines.add(year);
        inputLines.add(comment);
    }
    
    public void addVideoVariables(String name, String link, String time) {
        inputLines.add(name);
        inputLines.add(link);
        inputLines.add(time);
    }
    
    public void uiStart() {
        io = new StubIO(inputLines);
        ui = new Ui(io, service);
        ui.start();
    }  
}

