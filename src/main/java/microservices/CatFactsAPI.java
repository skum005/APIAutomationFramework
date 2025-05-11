package microservices;

import io.restassured.http.Method;
import io.restassured.response.Response;
import utils.RestClient;

import java.util.Map;

public class CatFactsAPI extends RestClient {

    private String baseURL;

    public CatFactsAPI(String baseURL) {
        this.baseURL = baseURL;
    }

    public Response getCatFact(String basePath, Map<String, String> params) {
        return setConfig(baseURL, basePath)
                .setQueryParams(params)
                .setHeaders(getJSONContentTypeHeader())
                .submitRequest(Method.GET);
    }

    public Response getBreeds(String basePath, Map<String, String> params) {
        return setConfig(baseURL, basePath)
                .setQueryParams(params)
                .setHeaders(getJSONContentTypeHeader())
                .submitRequest(Method.GET);
    }

}
