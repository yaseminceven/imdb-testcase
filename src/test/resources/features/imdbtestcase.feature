Feature: Imdb Page Compare Film Info
  Background:
    Given User open browser and open the IMDB Page

  Scenario Outline: Comparing film info between search and landing page results
    When User click on Menu button
    And User click on the link that contains text "Oscars" at Awards and Events List
    And User click on the link that contains text "1929" at Event History
    And User click on the link that contains text <movie_name> at Honory Award
    When User returns homepage
    And User search the movie <movie_name>
    Then User should see same information about the film and images should not be broken
    Examples:
      | movie_name |
      | "The Circus" |
      | "The Jazz Singer" |