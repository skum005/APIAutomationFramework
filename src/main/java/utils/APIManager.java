package utils;

import microservices.CatFactsAPI;

public class APIManager {

    private CatFactsAPI catFactsAPI;

    public CatFactsAPI getCatFactsAPI(String baseURL) {
        return catFactsAPI = catFactsAPI == null ? new CatFactsAPI(baseURL) : catFactsAPI;
    }

}
