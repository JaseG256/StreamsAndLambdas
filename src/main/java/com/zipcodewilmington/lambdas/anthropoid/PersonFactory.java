package com.zipcodewilmington.lambdas.anthropoid;

import com.zipcodewilmington.lambdas.tools.RandomUtils;
import com.zipcodewilmington.lambdas.tools.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/1/17.
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from using loops of any sort within the definition of this class.
 */
public final class PersonFactory {
    private PersonFactory() {
        /** this class is not to be instantiated */
    }

    /**
     * @return a new instance of a person with randomized fields
     */
    public static Person createRandomPerson() {
        String name = StringUtils.capitalizeFirstChar(RandomUtils.createString('a', 'z', 10));
        String[] aliases = RandomUtils.createStrings('a', 'z', 10, 100);
        int age = RandomUtils.createInteger(0, 99);
        boolean isMale = RandomUtils.createBoolean(50);
        long personalId = System.nanoTime();
        Date birthDate = RandomUtils.createDate(1950, 2010);


        Person randomPerson = new Person(name, age, isMale, personalId, birthDate, aliases);
        return randomPerson;
    }

    /**
     * @param personCount - number of Person objects to create
     * @return - ArrayList of Person objects
     */ // TODO
    public static List<Person> createPersonList(int personCount) {
        return createPersonStream(personCount).collect(Collectors.toList());
    }


    /**
     * @param personCount - number of Person objects to create
     * @return - Array of Person objects
     */ // TODO
    public static Person[] createPersonArray(int personCount) {
        return createPersonStream(personCount).toArray(Person[]::new);
    }


    /**
     * @param personCount - number of Person objects to create
     * @return - Stream representation of collection of Person objects
     */ // TODO
    public static Stream<Person> createPersonStream(int personCount) {
        return Stream.generate(PersonFactory::createRandomPerson).limit(personCount);
    }
}
