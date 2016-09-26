package com.alekseyorlov.luna.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.zjsonpatch.JsonPatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Component
public class JsonPatcher {

    @Autowired
    private ObjectMapper mapper;

    public <T> T patch(String diff, T object, Class<T> objectClass) throws IOException {
        JsonNode diffNode = mapper.readValue(diff, JsonNode.class);
        JsonNode objectNode  = mapper.convertValue(object, JsonNode.class);

        return mapper.treeToValue(JsonPatch.apply(diffNode, objectNode), objectClass);
    }
}
