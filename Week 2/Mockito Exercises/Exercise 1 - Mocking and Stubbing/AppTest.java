package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Unit test for App.MyService using Mockito to mock ExternalApi.
 */
public class AppTest{

    @Test
    public void testExternalApi() {
        // Step 1: Create mock for ExternalApi
        App.ExternalApi mockApi = mock(App.ExternalApi.class);

        // Step 2: Stub method
        when(mockApi.getData()).thenReturn("Mock Data");

        // Step 3: Inject mock into service
        App.MyService service = new App.MyService(mockApi);

        // Step 4: Fetch data and assert
        String result = service.fetchData();
        assertEquals("Mock Data", result);
    }
}

