package com.cydeo.bootstrap;

import com.cydeo.enums.Gender;
import com.cydeo.model.Mentor;

import java.util.Arrays;
import java.util.List;

public class DataGenerator {


    public static List<Mentor> mentorList = Arrays.asList(
            new Mentor("Mike", "Smith", 45, Gender.MALE),
            new Mentor("Tom", "Hanks", 65, Gender.MALE),
            new Mentor("Ammy", "Bryan", 25, Gender.FEMALE)

    );

}
