package com.example;

/**
 * External API interface and service class using it.
 */
public class App {

    // External API interface
    public interface ExternalApi {
        String getData();
    }

    // Service that depends on ExternalApi
    public static class MyService {
        private ExternalApi api;

        public MyService(ExternalApi api) {
            this.api = api;
        }

        public String fetchData() {
            return api.getData();
        }
    }
}

