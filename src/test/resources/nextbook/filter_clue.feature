Feature: Clues can be filtered

    Scenario: filtering just books is successful
        Given book "Testi testi vol.3" with author "Testi Testinen" and with isbn "9784893588821", year "2012" and comment "testi" is created
        And   video "Testi" with link "https://www.youtube.com/" and time "30" is created
        And   blog "Testi" with author "Testi Testinen", link "https://www.hjkhkj.fi/" and comment "testi" is created
        And   command filter is selected
        When  type "b" is selected
        Then  system will response with "Testi Testinen: Testi testi vol.3, 9784893588821, 2012"
        And   system will not response with "Testi, https://www.youtube.com/&t=30"
        And   system will not response with "Testi Testinen: Testi, https://www.hjkhkj.fi/"

    Scenario: filtering just videos is successful
        Given book "Testi testi vol.3" with author "Testi Testinen" and with isbn "9784893588821", year "2012" and comment "testi" is created
        And   video "Testi" with link "https://www.youtube.com/" and time "30" is created
        And   blog "Testi" with author "Testi Testinen", link "https://www.hjkhkj.fi/" and comment "testi" is created
        And   command filter is selected
        When  type "v" is selected
        Then  system will response with "Testi, https://www.youtube.com/&t=30"
        And   system will not response with "Testi Testinen: Testi testi vol.3, 9784893588821, 2012"
        And   system will not response with "Testi Testinen: Testi, https://www.hjkhkj.fi/"

    Scenario: filtering just blogs is successful
        Given book "Testi testi vol.3" with author "Testi Testinen" and with isbn "9784893588821", year "2012" and comment "testi" is created
        And   video "Testi" with link "https://www.youtube.com/" and time "30" is created
        And   blog "Testi" with author "Testi Testinen", link "https://www.hjkhkj.fi/" and comment "testi" is created
        And   command filter is selected
        When  type "bp" is selected
        Then  system will response with "Testi Testinen: Testi, https://www.hjkhkj.fi/"
        And   system will not response with "Testi, https://www.youtube.com/&t=30"
        And   system will not response with "Testi Testinen: Testi testi vol.3, 9784893588821, 2012"