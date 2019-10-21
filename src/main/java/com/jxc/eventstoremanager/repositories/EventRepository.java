package com.jxc.eventstoremanager.repositories;

import com.jxc.eventstoremanager.models.Event;

import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends ElasticsearchRepository<Event, String> {

    Page<Event> findAll();

}
