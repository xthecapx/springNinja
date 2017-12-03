package com.udemy.service.impl;

import com.udemy.service.ExerciseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service("exerciseService")
public class ExcersiceServiceImpl implements ExerciseService {
    private static final Log LOGGER = LogFactory.getLog(ExcersiceServiceImpl.class);
    private static final String MESSAGE = "I'm at ExcersiceServiceImpl";

    @Override
    public String logger() {
        LOGGER.info(MESSAGE);
        return MESSAGE;
    }
}
