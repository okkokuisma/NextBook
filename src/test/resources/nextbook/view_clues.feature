Feature: clues can be viewed
    
    Scenario: Viewing clues shows correct data
        Given clue "Testi testi vol.3" with author "Testi Testinen" is created
        And command list is selected
        Then correct data can be seen 