package microservices;

import io.restassured.http.Method;
import io.restassured.response.Response;
import utils.RestClient;

import java.util.Map;

public class HumanResourcesAPI extends RestClient {

    private String baseURL;

    public HumanResourcesAPI(String baseURL) {
        this.baseURL = baseURL;
    }

    public Response createEmployee(String basePath, Map<String, String> headers, String body) {
        headers.putAll(getJSONContentTypeHeader());
        return setConfig(baseURL, basePath).setHeaders(headers).setBody(body).submitRequest(Method.POST);
    }

}
