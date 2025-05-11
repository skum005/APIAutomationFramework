package utils;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestClient {

    public RequestSpecification requestSpecification;

    public RestClient setConfig(String baseURL, String basePath) {
        try {
            requestSpecification =  given().baseUri(baseURL).basePath(basePath).log().all();
            return this;
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new RuntimeException("Error occurred while generating request spec with baseURL and basePath");
        }
    }

    public RestClient setQueryParams(Map<String, String> params) {
        try {
            requestSpecification.params(params);
            return this;
        } catch (Exception exception) {
            throw new RuntimeException("Error occurred while generating request spec with query parameters");
        }
    }

    public RestClient setHeaders(Map<String, String> headers) {
        try {
            requestSpecification.headers(headers);
            return this;
        } catch (Exception exception) {
            throw new RuntimeException("Error occurred while generating request spec with headers");
        }
    }

    public RestClient setBody(String body) {
        try {
            requestSpecification.body(body);
            return this;
        } catch (Exception exception) {
            throw new RuntimeException("Error occurred while generating request spec with headers");
        }
    }

    public RestClient setBasicAuth(String username, String password) {
        try {
            requestSpecification.auth().basic(username, password);
            return this;
        } catch (Exception exception) {
            throw new RuntimeException("Error occurred while generating request spec with basic authentication");
        }
    }

    public Response submitRequest(Method method) {
        try {
            return requestSpecification.request(method);
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new RuntimeException("Error occurred while submitting the request");
        }
    }

    public Map<String, String> getJSONContentTypeHeader() {
        return new HashMap<>(Map.of(
                "Content-Type", "application/json"
        ));
    }

}
