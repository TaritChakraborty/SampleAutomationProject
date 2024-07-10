Feature: Test Scenarios for executing User Operations in JioSaavn Website
  Background:
    Given User navigates to the website "https://www.jiosaavn.com/"

  @PlayMusic
  Scenario Outline: User plays a song on JioSaavn
    When user enters the "<song name>" and "<artist>" and hits enter
    Then the selected song is played from the list
    And increase default volume to maximum
    Examples:
      | song name | artist           |
      #| dotara    | Gaurav Dagaonkar |
      #| 9:45      | Prabh Singh      |
      |Bholenath (A Love Story)|Kaka WRLD|
    #And play song in repeat mode depending on option
    #  | repeat never  |
    #  | repeat always |
    #  | repeat once   |
    # design step definition for this
  @DownloadLyrics
  Scenario Outline: User wants to download the lyrics from JioSaavn
    When user enters the "<song name>" and "<artist>" and hits enter
    Then the selected song is viewed in detail
    And lyrics is viewed and saved in a text format
    Examples:
      | song name | artist           |
      | kalaastar | Gaurav Dagaonkar |