package nextbook;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import nextbook.dao.ClueDao;
import nextbook.domain.Book;
import nextbook.domain.Clue;
import nextbook.domain.ClueService;

import static org.junit.Assert.*;

public class Stepdefs {
    ClueDao dao = new ClueDaoForTests();
        
    ClueService service;
    
    @Before
    public void setup() {
        this.service = new ClueService(dao);
    }
   

    @Given("command add is selected")
    public void commandAddIsSelected() {
        //kun io luotu
        assertTrue(true);
    }
    
    @Given("clue {string} with author {string} is created")
    public void clueWithAuthorIsCreated(String name, String author) {
        service.createClue(new Book(name, author));
    }
    
    @Given("command list is selected")
    public void commandListIsSelected() {
        //kun io luotu
        assertTrue(true);
    }
    
    @When("a valid name {string} and author {string}")
    public void aValidNameAndAuthor(String name, String author) {
        service.createClue(new Book(name, author));
    }
    
    @Then("system will response with {string}")
    public void systemWillResponseWith(String expectedOutput) {
        //kun io luotu
        assertTrue(true);
    }
    
    @Then("correct data can be seen")
    public void correctDataCanBeSeen() {
        ArrayList<Clue> clues = service.readClues();
        
        assertTrue(clues.size() == 1);
        
    }
    
}

