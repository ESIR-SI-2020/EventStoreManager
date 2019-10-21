package com.jxc.eventstoremanager.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jxc.eventstoremanager.utils.Json;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.elasticsearch.search.DocValueFormat;
import org.springframework.data.elasticsearch.annotations.Document;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "eventstore", type = "user")
public class Event {

    private String id;
    private String type;
    private String metadata;
    private Date createdAt;

    public static Optional<Event> of(Object event) {
        try {
            return Optional.of(new Event(UUID.randomUUID().toString(), event.getClass().getSimpleName(), Json.MAPPER.writeValueAsString(event), new Date()));
        } catch (JsonProcessingException e) {
            // TODO handle the error precisely, maybe retry
            e.printStackTrace();
            return Optional.empty();
        }
    }

}

