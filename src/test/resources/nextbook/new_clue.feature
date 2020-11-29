Feature: A new clue can be created

    Scenario: creation is successful with valid book information
        Given command add is selected
        And   command "1" is selected
        When  a valid name "Testi testi", author "Testi Testinen", isbn "9784893588821", year "2012" and comment "testi" are entered
        Then  system will response with "New book added"

    Scenario: creation is successful with valid video information
        Given command add is selected
        And   command "2" is selected
        When  a valid name "Testi testi", link "https://www.youtube.com/" and time "30" are entered
        Then  system will response with "New video added" 


