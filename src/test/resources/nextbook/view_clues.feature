Feature: clues can be viewed
    
    Scenario: Viewing clues shows correct data
        Given book "Testi testi vol.3" with author "Testi Testinen" and with isbn "9784893588821", year "2012" and comment "testi" is created
        And command list is selected
        Then system will response with "Testi Testinen: Testi testi vol.3"