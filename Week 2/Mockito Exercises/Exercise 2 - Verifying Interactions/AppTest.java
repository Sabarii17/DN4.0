package com.example;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

/**
 * Verifies that getData() is called on the mock.
 */
public class AppTest {

    @Test
    public void testVerifyInteraction() {
        // Create mock
        App.ExternalApi mockApi = mock(App.ExternalApi.class);

        // Inject mock into service
        App.MyService service = new App.MyService(mockApi);

        // Call method
        service.fetchData();

        // Verify interaction
        verify(mockApi).getData(); // Passes if getData() was called exactly once
    }
}
