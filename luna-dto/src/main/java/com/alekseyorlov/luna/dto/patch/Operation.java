package com.alekseyorlov.luna.dto.patch;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class Operation {

    public enum Type {
        ADD("add"),
        REMOVE("remove"),
        REPLACE("replace"),
        MOVE("move");

        private String name;

        Type(String name) {
            this.name = name;
        }

        @JsonCreator
        public static Type fromName(String type) {
            return Type.valueOf(type.toUpperCase());
        }

        @JsonValue
        public String getName() {
            return name;
        }
    }

    @JsonProperty("op")
    private Type type;

    private String path;

    private Object value;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
