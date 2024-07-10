package pmBackgroundStepDefinition;

public class reportConfiguration {
    public String getReportConfigPath(){
        String reportConfigPath = "src/test/resources/test-results";
        if(reportConfigPath!= null)
            return reportConfigPath;
        else
            throw new RuntimeException("Report Config Path mentioned doesn't exists");
    }
}
