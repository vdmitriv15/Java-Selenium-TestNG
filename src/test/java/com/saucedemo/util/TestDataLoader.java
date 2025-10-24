package com.saucedemo.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * Utility for loading test data from the JSON resource used across tests.
 */
public final class TestDataLoader {

    private static final String RESOURCE_PATH = "testdata.json";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final JsonNode ROOT_NODE = readRootNode();

    private TestDataLoader() {
        // Utility class
    }

    private static JsonNode readRootNode() {
        try (InputStream inputStream = TestDataLoader.class.getClassLoader().getResourceAsStream(RESOURCE_PATH)) {
            if (Objects.isNull(inputStream)) {
                throw new IllegalStateException("Unable to locate test data resource: " + RESOURCE_PATH);
            }
            return OBJECT_MAPPER.readTree(inputStream);
        } catch (IOException e) {
            throw new IllegalStateException("Unable to load test data from " + RESOURCE_PATH, e);
        }
    }

    public static Credentials getCredentials(String key) {
        JsonNode credentialNode = ROOT_NODE.path(key);
        if (credentialNode.isMissingNode()) {
            throw new IllegalArgumentException("No credentials found for key: " + key);
        }
        return new Credentials(
                credentialNode.path("username").asText(),
                credentialNode.path("password").asText()
        );
    }

    public static Credentials getValidCredentials() {
        return getCredentials("validCredentials");
    }

    public static final class Credentials {
        private final String username;
        private final String password;

        private Credentials(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }
}
