package pmBackgroundStepDefinition;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/featureFile",
        glue = "pmBackgroundStepDefinition",
        //plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@DownloadLyrics",
        monochrome = true
)
public class PlayMusicRunner {
}
