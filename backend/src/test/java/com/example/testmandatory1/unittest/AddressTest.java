package com.example.testmandatory1.unittest;
import com.example.testmandatory1.model.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.testmandatory1.ValidationException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AddressTest {

    private Address address;

    @BeforeEach
    void setUp() {
        address = new Address();
    }

    // ===========================
    // Street Validation Tests
    // ===========================

    // Valid street names
    @ParameterizedTest
    @CsvSource({
            "Aaa",
            "Bbb",
            "Ååå",
            "Øøø",
            "MainStreet",
            "BakerStreet",
            "Østre",
            "Christianshavn"
    })
    void testValidStreetChars(String street) {
        assertDoesNotThrow(() -> address.setStreet(street));
        assertEquals(street, address.getStreet());
    }

    // Valid street lengths (3-30 characters)
    @ParameterizedTest
    @CsvSource({
            "Hel",
            "Hels",
            "Helsingørrrrrrrrrrrrrrrrrrrrrr",
            "Helsingørrrrrrrrrrrrrrrrrrrrr",
    })
    void testValidStreetLength(String street) {
        assertDoesNotThrow(() -> address.setStreet(street));
        assertEquals(street, address.getStreet());
    }

    // Invalid street lengths (<3 or >30 characters)
    @ParameterizedTest
    @CsvSource({
            "A",
            "Aa",            
            "", //0 length
            "Helsingørrrrrrrrrrrrrrrrrrrrrrr",
            "Helsingørrrrrrrrrrrrrrrrrrrrrrrr",           
    })
    void testInvalidStreetLength(String street) {
        assertThrows(ValidationException.class, () -> address.setStreet(street));
    }

    // Invalid street characters (numbers and special characters)
    @ParameterizedTest
    @CsvSource({
            "Aa1",
            "Aa2",
            "Aa8",
            "Aa9",
            "Aa5",
            "Aa!",
            "Aa”",
            "Aa¤",
            "Aa("
    })
    void testInvalidStreetChars(String street) {
        assertThrows(ValidationException.class, () -> address.setStreet(street));
    }

    // Null street
    @Test
    void testNullStreet() {
        assertThrows(ValidationException.class, () -> address.setStreet(null));
    }

    // ===========================
    // Number Validation Tests
    // ===========================

    // Valid numbers (1-999) and (1-999 + single uppercase letter)
    @ParameterizedTest
    @CsvSource({
            "1",
            "2",
            "999",
            "998",
            "35",
            "1A",
            "1B",
            "1Z",
            "1X",
            "35G"
    })
    void testValidNumber(String number) {
        assertDoesNotThrow(() -> address.setNumber(number));
        assertEquals(number, address.getNumber());
    }

    // Invalid numbers (<1 or >999)
    @ParameterizedTest
    @CsvSource({
            "0",
            "1000",
            "-1",
            "1001",
            "1500"
    })
    void testInvalidNumberRange(String number) {
        assertThrows(ValidationException.class, () -> address.setNumber(number));
    }

    // Invalid number formats (multiple letters)
    @ParameterizedTest
    @CsvSource({
            "1AA",
            "1AB",
            "1ZZ",
            "1XX",
            "35AB"
    })
    void testInvalidNumberFormatMultipleLetters(String number) {
        assertThrows(ValidationException.class, () -> address.setNumber(number));
    }

    // Invalid number formats (special characters)
    @ParameterizedTest
    @CsvSource({
            "12@",
            "99#",
            "1!",
            "500$"
    })
    void testInvalidNumberFormatSpecialChars(String number) {
        assertThrows(ValidationException.class, () -> address.setNumber(number));
    }

    // Empty and null numbers
    @Test
    void testEmptyNumber() {
        assertThrows(ValidationException.class, () -> address.setNumber(""));
    }

    @Test
    void testNullNumber() {
        assertThrows(ValidationException.class, () -> address.setNumber(null));
    }

    // ===========================
    // Floor Validation Tests
    // ===========================

    // Valid floors ("st" or 1-99)
    @ParameterizedTest
    @CsvSource({
            "st",
            "1",
            "2",
            "50",
            "99",
            "98"
    })
    void testValidFloor(String floor) {
        assertDoesNotThrow(() -> address.setFloor(floor));
        assertEquals(floor, address.getFloor());
    }

    // Invalid floors (<1 or >99)
    @ParameterizedTest
    @CsvSource({
            "0",
            "100",
            "-5",
            "150"
    })
    void testInvalidFloorRange(String floor) {
        assertThrows(ValidationException.class, () -> address.setFloor(floor));
    }

    // Invalid floor formats
    @ParameterizedTest
    @CsvSource({
            "1st",
            "ground",
            "first",
            "2nd"
    })
    void testInvalidFloorFormat(String floor) {
        assertThrows(ValidationException.class, () -> address.setFloor(floor));
    }

    // Empty and null floors
    @Test
    void testEmptyFloor() {
        assertThrows(ValidationException.class, () -> address.setFloor(""));
    }

    @Test
    void testNullFloor() {
        assertThrows(ValidationException.class, () -> address.setFloor(null));
    }

    // ===========================
    // Door Validation Tests
    // ===========================

    // Valid doors ("th", "mf", "tv", 1-50, lowercase letters, letters with optional dash and 1-3 digits)
    @ParameterizedTest
    @CsvSource({
            "th",
            "mf",
            "tv",
            "1",
            "2",
            "50",
            "49",
            "25",
            "a",
            "b",
            "z",
            "x",
            "a-1",
            "a-2",
            "a-999",
            "a-998",
            "a-500",
            "a1",
            "a2",
            "a999",
            "a998",
            "a500",
    })
    void testValidDoor(String door) {
        assertDoesNotThrow(() -> address.setDoor(door));
        assertEquals(door, address.getDoor());
    }

    // Invalid doors (numbers <1 or >50)
    @ParameterizedTest
    @CsvSource({
            "0",
            "51",
            "52",
            "100",
            "-1"
    })
    void testInvalidDoorNumberRange(String door) {
        assertThrows(ValidationException.class, () -> address.setDoor(door));
    }

    // Invalid doors (uppercase letters)
    @ParameterizedTest
    @CsvSource({
            "A",
            "Z",
            "A-1",
            "B-12",
            "C999"
    })
    void testInvalidDoorUppercaseLetters(String door) {
        assertThrows(ValidationException.class, () -> address.setDoor(door));
    }

    // Invalid doors (multiple letters)
    @ParameterizedTest
    @CsvSource({
            "aAA",
            "bAB",
            "cABC"
    })
    void testInvalidDoorMultipleLetters(String door) {
        assertThrows(ValidationException.class, () -> address.setDoor(door));
    }

    // Invalid doors (numbers with letters beyond single)
    @ParameterizedTest
    @CsvSource({
            "a1000",
            "b1001",
            "c-1000"
    })
    void testInvalidDoorNumberWithLetters(String door) {
        assertThrows(ValidationException.class, () -> address.setDoor(door));
    }

    // Invalid doors (special characters)
    @ParameterizedTest
    @CsvSource({
            "a@",
            "b#",
            "c!",
            "d$"
    })
    void testInvalidDoorSpecialCharacters(String door) {
        assertThrows(ValidationException.class, () -> address.setDoor(door));
    }

    // Empty and null doors
    @Test
    void testEmptyDoor() {
        assertThrows(ValidationException.class, () -> address.setDoor(""));
    }

    @Test
    void testNullDoor() {
        assertThrows(ValidationException.class, () -> address.setDoor(null));
    }
}
