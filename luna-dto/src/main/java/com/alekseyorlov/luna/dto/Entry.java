package com.alekseyorlov.luna.dto;

import java.time.Instant;
import java.util.List;
import java.util.Map;

public class Entry {

    private String status;

    private String title;

    private String slug;

    private String type;

    private List<String> tags;

    private Map<String, Map<String, String>> elements;

    private Instant publishedAt;

    private Instant depublishedAt;
}
