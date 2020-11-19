package nextbook;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.*;

public class Stepdefs {

    @Given("empty")
    public void empty() {
        assertTrue(true);
    }

}

