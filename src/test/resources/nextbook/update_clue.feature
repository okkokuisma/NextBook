Feature: A clue can be updated

    Scenario: updating a book is successful
        Given book "Testi testi vol.3" with author "Testi Testinen" and with isbn "9784893588821", year "2012" and comment "testi" is created
        And   command update is selected
        And   id "1" is selected
        When  name is updated to "Keksi", author to "Keksi Keksinen" isbn to "9784893588838", year to "2016" and comment to "update test"
        Then  system will response with "Updated successfully"

    Scenario: updating a video is successful
        Given video "Testi" with link "https://www.youtube.com/" and time "30" is created
        And   command update is selected
        And   id "1" is selected
        When  name is updated to "Keksi" and link to "https://www.youtube.com/" and time to "32"
        Then  system will response with "Updated successfully"

    Scenario: updating a blog is successful
        Given blog "Testi" with author "Testi Testinen", link "https://www.hjkhkj.fi/" and comment "testi" is created
        And   command update is selected
        And   id "1" is selected
        When  name is updated to "Keksi", author to "Keksi Keksinen", link to "https://www.hjkkhkj.fi/" and comment to "update test"
        Then  system will response with "Updated successfully"

    Scenario: cannot update non-existing clue
        Given command update is selected
        And   id "1" is selected for removing
        Then  system will response with "Invalid index"

    Scenario: cannot give index out of boundary
        Given blog "Testi" with author "Testi Testinen", link "https://www.hjkhkj.fi/" and comment "testi" is created
        And   command update is selected
        And   id "0" is selected for removing
        Then  system will response with "Invalid index"

    Scenario: not everything needs to updated updating a book
        Given book "Testi testi vol.3" with author "Testi Testinen" and with isbn "9784893588821", year "2012" and comment "testi" is created
        And   command update is selected
        And   id "1" is selected
        When  nothing is updated
        Then  system will response with "Updated successfully"

    Scenario: not everything needs to updated updating a video
        Given video "Testi" with link "https://www.youtube.com/" and time "30" is created
        And   command update is selected
        And   id "1" is selected
        When  nothing is updated
        Then  system will response with "Updated successfully"

    Scenario: not everything needs to updated updating a blog
        Given blog "Testi" with author "Testi Testinen", link "https://www.hjkhkj.fi/" and comment "testi" is created
        And   command update is selected
        And   id "1" is selected
        When  nothing is updated
        Then  system will response with "Updated successfully"