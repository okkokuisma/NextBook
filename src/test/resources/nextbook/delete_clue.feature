Feature: A clue can be deleted

    Scenario: deleting a book is successful
        Given book "Testi testi vol.3" with author "Testi Testinen" and with isbn "9784893588821", year "2012" and comment "testi" is created
        And command remove video is selected
        And   id "1" is selected for removing
        Then  system will response with "Removed successfully"  