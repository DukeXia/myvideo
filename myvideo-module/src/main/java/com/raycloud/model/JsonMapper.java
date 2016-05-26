package com.raycloud.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * json字符串装载封装，通过key来getValue获取值
 * Created by linjunjie on 2016/1/6 (linjunjie@raycloud.com).
 */
public class JsonMapper {

    private ObjectMapper objectMapper;

    private JsonNode jsonNode;

    public void setJson(String json){
        try {
            objectMapper.readTree(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key){
        return jsonNode.get(key).asText();
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

    public void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }
}
