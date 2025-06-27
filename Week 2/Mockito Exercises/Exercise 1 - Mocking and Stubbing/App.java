package com.example;

/**
 * Main App class containing the ExternalApi interface and MyService class.
 */
public class App{

    // External API interface
    public interface ExternalApi {
        String getData();
    }

    // Service class depending on ExternalApi
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

