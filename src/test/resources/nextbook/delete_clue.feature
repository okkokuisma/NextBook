Feature: A clue can be deleted

    Scenario: deleting a book is successful
        Given book "Testi testi vol.3" with author "Testi Testinen" and with isbn "9784893588821", year "2012" and comment "testi" is created
        And   command remove is selected
        And   id "1" is selected for removing
        Then  system will response with "Removed successfully" 

    Scenario: deleting a video is successful
        Given video "Testi" with link "https://www.youtube.com/" and time "30" is created
        And   command remove is selected
        And   id "1" is selected for removing
        Then  system will response with "Removed successfully" 

    Scenario: deleting a blog is successful
        Given blog "Testi" with author "Testi Testinen", link "https://www.hjkhkj.fi/" and comment "testi" is created
        And   command remove is selected
        And   id "1" is selected for removing
        Then  system will response with "Removed successfully"