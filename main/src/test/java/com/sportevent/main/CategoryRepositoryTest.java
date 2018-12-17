package com.sportevent.main;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sportevent.main.domain.Category;
import com.sportevent.main.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository repository;

    @Test
    public void findByNameShouldReturnCategory() {
    List<Category> categories = repository.findByName("Football");
        
    assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("Jogging");
    }
    
    @Test
    public void createNewCategory() {
    Category category = new Category("Walk");
    	repository.save(category);
    	assertThat(category.getName()).isNotNull();
    } 
}
