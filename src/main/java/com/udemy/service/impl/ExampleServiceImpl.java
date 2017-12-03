package com.udemy.service.impl;

import com.udemy.model.Person;
import com.udemy.service.ExampleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

    private static final Log LOGGER = LogFactory.getLog(ExampleServiceImpl.class);

    @Override
    public List<Person> getListPeople() {
        List<Person> people = new ArrayList<>();

        people.add(new Person("John", 23));
        people.add(new Person("Cristian", 28));
        people.add(new Person("Mike", 20));
        people.add(new Person("Peter", 50));
        LOGGER.info("HELLO FROM SERVICE");

        return people;
    }
}
