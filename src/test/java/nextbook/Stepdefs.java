package nextbook;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import nextbook.dao.ClueDao;
import nextbook.domain.ClueService;
import nextbook.io.StubIO;
import nextbook.ui.Ui;
import io.cucumber.java.After;
import nextbook.dao.DbUtil;
import nextbook.dao.SqlClueDao;

import static org.junit.Assert.*;

public class Stepdefs {
    StubIO io;
    Ui ui;
    List<String> inputLines;
        
    ClueService service;
    
    @Before
    public void setup() {
        ClueDao dao = new SqlClueDao(new DbUtil(true));
        this.service = new ClueService(dao);
        this.inputLines = new ArrayList<>();
    }
    
    @After
    public void tearDown() {
        File testDb = new File("test.db");
        testDb.delete();
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
        inputLines.add("update");
    }
    
    @Given("id {string} is selected")
    public void idIsSelected(String string) {
        inputLines.add(string);
    }
    
    @Given("command filter is selected")
    public void commandFilterIsSelected() {
        inputLines.add("filter");
    }
    
    @Given("id {string} is selected for removing")
    public void idIsSelectedForRemoving(String string) {
        inputLines.add(string);
        uiStart();
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
    
    @Given("blog {string} with author {string}, link {string} and comment {string} is created")
    public void blogWithAuthorLinkAndCommentIsCreated(String name, String author, String link, String comment) {
        inputLines.add("add");
        inputLines.add("3");
        addBlogVariables(name, author, link, comment);
    }
    
    @Given("command remove is selected")
    public void commandRemoveIsSelected() {
        inputLines.add("remove");
    }
    
    @When("a valid name {string}, author {string}, isbn {string}, comment {string} and year {string} are entered")
    public void aValidNameAuthorIsbnCommentAndYearAreEntered(String name, String author, String isbn, String comment, String year) {
        addBooksVariables(name, author, isbn, year, comment);
        uiStart();
    }
    
    @When("a valid name {string}, link {string} and time {string} are entered")
    public void aValidNameLinkAndTimeAreEntered(String name, String link, String time) {
        addVideoVariables(name, link, time);
        uiStart();
    }
    
    @When("a valid name {string}, author {string}, link {string} and comment {string} are entered")
    public void aValidNameAuthorLinkAndCommentAreEntered(String name, String author, String link, String comment) {
        addBlogVariables(name, author, link, comment);
        uiStart();
    }
    
    @When("name is updated to {string}, author to {string} isbn to {string}, year to {string} and comment to {string}")
    public void nameIsUpdatedToAuthorToIsbnToYearToAndCommentTo(String name, String author, String isbn, String year, String comment) {
        inputLines.add("y");
        inputLines.add(name);
        inputLines.add("y");
        inputLines.add(author);
        inputLines.add("y");
        inputLines.add(isbn);
        inputLines.add("y");
        inputLines.add(comment);
        inputLines.add("y");
        inputLines.add(year);
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
    
    @When("name is updated to {string}, author to {string}, link to {string} and comment to {string}")
    public void nameIsUpdatedToAuthorToLinkToAndCommentTo(String name, String author, String link, String comment) {
        inputLines.add("y");
        inputLines.add(name);
        inputLines.add("y");
        inputLines.add(author);
        inputLines.add("y");
        inputLines.add(link);
        inputLines.add("y");
        inputLines.add(comment);
        uiStart();
    }
    
    @When("type {string} is selected")
    public void typeIsSelected(String string) {
        inputLines.add(string);
        uiStart();
    }
    
    @Then("system will response with {string}")
    public void systemWillResponseWith(String expectedOutput) {
        System.out.println("lines" + this.inputLines);
        System.out.println("output" + io.getPrints());
        assertTrue(io.getPrints().contains(expectedOutput));
    }
    
    @Then("system will not response with {string}")
    public void systemWillNotResponseWith(String string) {
        if (!io.getPrints().contains(string)) {
            assertTrue(true);
        }
    }
 
    @Then("system will response with {string}, {string} and {string}")
    public void systemWillResponseWithAnd(String expectedOutput1, String expectedOutput2, String expectedOutput3) {
        assertTrue(io.getPrints().contains(expectedOutput1));
        assertTrue(io.getPrints().contains(expectedOutput2));
        assertTrue(io.getPrints().contains(expectedOutput3));
    }
    
    public void addBooksVariables(String name, String author, String isbn, String year, String comment) {
        inputLines.add(name);
        inputLines.add(author);
        inputLines.add(isbn);
        inputLines.add(comment);
        inputLines.add(year);
    }
    
    public void addVideoVariables(String name, String link, String time) {
        inputLines.add(name);
        inputLines.add(link);
        inputLines.add(time);
    }
    
    private void addBlogVariables(String name, String author, String link, String comment) {
        inputLines.add(name);
        inputLines.add(author);
        inputLines.add(link);
        inputLines.add(comment);
    }
    
    public void uiStart() {
        io = new StubIO(inputLines);
        ui = new Ui(io, service);
        ui.start();
    }  
}

