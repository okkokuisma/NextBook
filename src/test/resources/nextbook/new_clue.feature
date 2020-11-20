Feature: A new clue can be created

    Scenario: creation is successful with valid name and author
        Given command add is selected
        When  a valid name "Testi testi" and author "Testi Testinen" 
        Then  system will response with "New book added"


