package pmBackgroundStepDefinition;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.interactions.Actions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PlayMusicStepDefinition extends setup{

    //static ExtentReports reports;
    //static ExtentTest tets;
    //public String artistName;
    public static WebDriver DRIVER = setup();

    @Given("User navigates to the website {string}")
    public void user_navigates_to_the_website(String webPage) {     DRIVER.get(webPage);     }

    @When("user enters the {string} and {string} and hits enter")
    public void userEntersTheAndAndHitsEnter(String songName, String artistName) {
        String searchBarXpath = "//input[@aria-owns='site-search']";
        DRIVER.findElement(new By.ByXPath(searchBarXpath)).click();
        DRIVER.findElement(new By.ByXPath(searchBarXpath)).sendKeys(songName);
        DRIVER.findElement(new By.ByXPath(searchBarXpath)).click();
        DRIVER.findElement(new By.ByXPath(searchBarXpath)).sendKeys(Keys.ENTER);
        DRIVER.findElement(new By.ByXPath(searchBarXpath)).sendKeys(Keys.ENTER);
    }
    /* Commenting to incorporate Scenario Outline changes
    @When("user enters the song name and artist and hits enter")
    public void user_enters_the_song_name_and_artist_and_hits_enter(DataTable table) throws Throwable{
        List<String> songDetails = table.transpose().asList();
        String songName = songDetails.get(0);
        //artistName = songDetails.get(1);
        String searchBarXpath = "//input[@aria-owns='site-search']";
        DRIVER.findElement(new By.ByXPath(searchBarXpath)).click();
        DRIVER.findElement(new By.ByXPath(searchBarXpath)).sendKeys(songName);
        DRIVER.findElement(new By.ByXPath(searchBarXpath)).click();
        DRIVER.findElement(new By.ByXPath(searchBarXpath)).sendKeys(Keys.ENTER);
        //DRIVER.findElement(new By.ByXPath(searchBarXpath)).sendKeys(Keys.ENTER);
    }
    */
    @Then("the selected song is played from the list")
    public void the_selected_song_is_played_from_the_list() {
        String selectedSong = "//ol[contains(@class,'o-list-bare')]//li[1]//div[@class='c-drag']//div[@class='o-flag__img']";
        DRIVER.findElement(new By.ByXPath(selectedSong)).click();
        /*int counter = 0;
        List<WebElement> songListElements = DRIVER.findElements(new By.ByXPath("//div[@class='c-drag']//a[@screen_name='artist_screen']"));
        int listSize = songListElements.size();
        for(WebElement songElement : songListElements){
            String songArtistName = songElement.getAttribute("text");
            if(counter > listSize){
                if(songArtistName.equalsIgnoreCase(artistName)){
                    String selectedSong = "//div[@class='c-drag' and @tabindex='"+counter+"']";
                    DRIVER.findElement(new By.ByXPath(selectedSong)).click();
                }else{
                    counter++;
                }
            }else{
                throw new ElementNotVisibleException("No element found");
            }
        }*/
    }

    @And("increase default volume to maximum")
    public void increaseDefaultVolumeToMaximum() {
        //String volumeSliderXpath = "//span[@id='player_volume']/parent::span[@class='c-slider']";
        JavascriptExecutor js = (JavascriptExecutor) DRIVER;
        js.executeScript("document.getElementsByClassName('c-slider__level')[0].setAttribute('style','height: 100%')");

    }

    @Then("the selected song is viewed in detail")
    public void theSelectedSongIsViewedInDetail() {
        Actions action = new Actions(DRIVER);
        WebElement selectedSong = DRIVER.findElement(new By.ByXPath("//ol[contains(@class,'o-list-bare')]//li[1]//div[@class='c-drag']//div[@class='o-flag__img']"));
        action.contextClick(selectedSong).perform();
        DRIVER.findElement(new By.ByXPath("//a[contains(text(),'Song Details & Lyrics')]")).click();
    }

    @And("lyrics is viewed and saved in a text format")
    public void lyricsIsViewedAndSavedInATextFormat() {
        DRIVER.findElement(new By.ByXPath("//a[@title='Song Lyrics']")).click();
        //DRIVER.findElement(new By.ByXPath("//strong[text()='Read More']/parent::a")).click();
        String songLyrics = DRIVER.findElement(new By.ByXPath("//p[@class='u-margin-bottom-none@sm']")).getText();

        String TestFile = "D:/Projects/LinkedInTests/PlayMusic/src/test/resources/test-results/lyricsFile.txt";
        File FC = new File(TestFile);
        try {
            FC.createNewFile();
            FileWriter FW = new FileWriter(TestFile);
            BufferedWriter BW = new BufferedWriter(FW);
            BW.write(songLyrics);
            BW.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //System.out.print(songLyrics);
    }


    /*
    @AfterAll
    public static void closeBrowserOperations(){
        DRIVER.quit();
    }
    */


}
