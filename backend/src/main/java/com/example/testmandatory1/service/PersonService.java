package com.example.testmandatory1.service;

import com.example.testmandatory1.model.Person;
import com.example.testmandatory1.dto.PersonDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class PersonService {

    Random random = new Random();

    private static final List<String> VALID_PREFIXES = Arrays.asList(
            "2", "30", "31", "40", "41", "42", "50", "51", "52", "53", "60", "61",
            "71", "81", "91", "92", "93", "342", "344", "345", "346", "347", "348", "349",
            "356", "357", "359", "362", "365", "366", "389", "398", "431", "441", "462",
            "466", "468", "472", "474", "476", "478", "485", "486", "488", "489", "493",
            "494", "495", "496", "498", "499", "542", "543", "545", "551", "552", "556",
            "571", "572", "573", "574", "577", "579", "584", "586", "587", "589", "597",
            "598", "627", "629", "641", "649", "658", "662", "663", "664", "665", "667",
            "692", "693", "694", "697", "771", "772", "782", "783", "785", "786", "788",
            "789", "826", "827", "829"
    );

    private static final String[] ODD_NUMBERS = {"1", "3", "5", "7", "9"};
    private static final String[] EVEN_NUMBERS = {"0", "2", "4", "6", "8"};

    public String generatePhoneNumber() {


        String prefix = VALID_PREFIXES.get(random.nextInt(VALID_PREFIXES.size()));

        int remainingDigits = 8 - prefix.length();

        StringBuilder phoneNumber = new StringBuilder(prefix);
        for (int i = 0; i < remainingDigits; i++) {
            phoneNumber.append(random.nextInt(10));
        }

        return phoneNumber.toString();
    }

    public String generateDob() {
        int year = 1900 + random.nextInt(121);
        int month = 1 + random.nextInt(12);
        int day = 1 + random.nextInt(31);

        return String.format("%02d-%02d-%04d", day, month, year);
    }

    public String generateCpr(String gender, String DateOfBirth) {
        String cprGender = "";

        if (gender.charAt(0) == 'M') {
                int index = random.nextInt(EVEN_NUMBERS.length);
                cprGender = EVEN_NUMBERS[index];
            } else if (gender.charAt(0) == 'F') {
                int index = random.nextInt(ODD_NUMBERS.length);
                cprGender = ODD_NUMBERS[index];
            }

        StringBuilder randomFillnumbers = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            randomFillnumbers.append(random.nextInt(10));
        }

        return DateOfBirth.substring(0, 4) + DateOfBirth.substring(6, 8) + randomFillnumbers + cprGender;

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

    public PersonDto getRandomPerson() throws IOException {
        List<Person> persons = loadPersonsFromFile();
        Person randomPerson = persons.get(new Random().nextInt(persons.size()));
        randomPerson.setDob(generateDob());
        randomPerson.setCpr(generateCpr(randomPerson.getGender(), randomPerson.getDob()));
        return new PersonDto(randomPerson);
    }

}
