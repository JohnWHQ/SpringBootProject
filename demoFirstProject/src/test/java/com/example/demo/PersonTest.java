package com.example.demo;

import com.example.demo.domain.Person;
import com.example.demo.service.PersonService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PersonTest {
    @Autowired
    PersonService personService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testPersonSerice(){
        Person person = personService.findById(3);
        Assert.assertEquals("shenzhen", person.getAddress());

    }

    @Test
    public void apiTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/select"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
