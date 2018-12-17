package com.sportevent.main;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sportevent.main.domain.Category;
import com.sportevent.main.domain.Event;
import com.sportevent.main.domain.EventRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class EventRepositoryTest {
    @Autowired
    private EventRepository repository;

    @Test
    public void findByLocationShouldReturnEvent() {
        List<Event> events = repository.findByLocation("Solent Stadium");
        
        assertThat(events).hasSize(1);
        assertThat(events.get(0).getLocation()).isEqualTo("Solent Stadium");
    }
    
    @Test
    public void createNewStudent() {
    	Event event = new Event("Stadium3", "13.02.2018", "11:45", new Category("Skiing"));
    	repository.save(event);
    	assertThat(event.getId()).isNotNull();
    }  
}