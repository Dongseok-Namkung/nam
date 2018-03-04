package com.nam.batch;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<User, User> {

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public User process(final User person) throws Exception {
        final String stfno = person.getStfno().toUpperCase();
        final String nm = person.getNm().toUpperCase();

        final User transformedPerson = new User(stfno, nm);

        log.info("Converting (" + person + ") into (" + transformedPerson + ")");

        return transformedPerson;
    }

	

}
