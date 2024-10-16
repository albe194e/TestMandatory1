package com.example.testmandatory1.service;

import com.example.testmandatory1.model.Person;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

@Service
public class PersonService {

    Random random = new Random();

    private static final String[] ODD_NUMBERS = {"1", "3", "5", "7", "9"};
    private static final String[] EVEN_NUMBERS = {"0", "2", "4", "6", "8"};


    public LocalDate generateDob() {
        int year = 1900 + random.nextInt(121);
        int month = 1 + random.nextInt(12);
        YearMonth yearMonth = YearMonth.of(year, month);
        int day = 1 + random.nextInt(yearMonth.lengthOfMonth());

        return LocalDate.of(year, month, day);
    }

    public String generateCpr(String gender, LocalDate unformattedDOB) throws IllegalArgumentException {
        String cprGender = "";
        DateTimeFormatter formattedDOB = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String DateOfBirth = unformattedDOB.format(formattedDOB);

        if (gender.equalsIgnoreCase("female")) {
                int index = random.nextInt(EVEN_NUMBERS.length);
                cprGender = EVEN_NUMBERS[index];
            } else if (gender.equalsIgnoreCase("male")) {
                int index = random.nextInt(ODD_NUMBERS.length);
                cprGender = ODD_NUMBERS[index];
            } else {
            throw new IllegalArgumentException();
        }

        StringBuilder randomFillNumbers = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            randomFillNumbers.append(random.nextInt(10));
        }

        return DateOfBirth.substring(0, 2) + DateOfBirth.substring(3, 5) +
                DateOfBirth.substring(8, 10) + "-" + randomFillNumbers + cprGender;

    }
    /*
     * Loads a list of Person objects from a JSON file located in the classpath.
     * - ObjectMapper is used to parse the JSON file.
     * - ClassPathResource loads the file from the classpath.
     * - The file is read as an InputStream and then converted into a List of Person objects.
     * - JsonNode is used to access the "persons" node from the JSON structure.
     * - The persons node is mapped to a List of Person objects using convertValue.
     *
     * @return List of Person objects from the JSON file.
     * @throws IOException if there is an error reading the file.
     */
    public List<Person> loadPersonsFromFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("person/person-names.json");
        try (InputStream inputStream = resource.getInputStream();
             InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
            JsonNode rootNode = objectMapper.readTree(reader);
            JsonNode personsNode = rootNode.get("persons");
            return objectMapper.convertValue(personsNode, new TypeReference<>() {
            });
        }
    }

    public Person getRandomPerson() throws IOException {
        List<Person> persons = loadPersonsFromFile();
        Person randomPerson = persons.get(new Random().nextInt(persons.size()));
        randomPerson.setDob(generateDob());
        randomPerson.setCpr(generateCpr(randomPerson.getGender(), randomPerson.getDob()));
        return randomPerson;
    }


}
