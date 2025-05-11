package utils;

import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScenarioContext {

    private String scenarioName;
    private String screenshotPath;
    private Response response;

}
