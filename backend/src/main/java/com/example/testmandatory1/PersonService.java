package com.example.testmandatory1;

import com.example.testmandatory1.dto.CprNameGenderDobDto;
import com.example.testmandatory1.dto.CprNameGenderDto;
import com.example.testmandatory1.dto.NameGenderDto;
import com.example.testmandatory1.dto.NameGenderDobDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private PersonRepository repository;

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


    public NameGenderDto displayRandomPerson() throws IOException {
        Person randomPerson = getRandomPerson();
        return new NameGenderDto(randomPerson.getName(), randomPerson.getSurname(), randomPerson.getGender());
    }

    public NameGenderDobDto displayRandomPersonWithDob() throws IOException {
        Person randomPerson = getRandomPerson();
        return new NameGenderDobDto(randomPerson.getName(), randomPerson.getSurname(), randomPerson.getGender(), randomPerson.getDob());
    }

    public CprNameGenderDto displayRandomPersonWithCpr() throws IOException {
        Person randomPerson = getRandomPerson();
        return new CprNameGenderDto(randomPerson.getName(), randomPerson.getSurname(), randomPerson.getGender(), randomPerson.getCpr());
    }

    public CprNameGenderDobDto displayRandomPersonWithCprAndDob() throws IOException {
        Person randomPerson = getRandomPerson();
        return new CprNameGenderDobDto(randomPerson.getName(), randomPerson.getSurname(), randomPerson.getGender(), randomPerson.getCpr(), randomPerson.getDob());
    }

    public Person getRandomPerson() throws IOException {
        List<Person> persons = loadPersonsFromFile();
        Person randomPerson = persons.get(new Random().nextInt(persons.size()));
        return new Person(randomPerson.getName(), randomPerson.getSurname(), randomPerson.getGender());
    }
}
