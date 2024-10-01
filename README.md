# Test Mandatory 1




# Design test cases
## White-Box Test Cases:
### Test Case 1: Validate CPR Generation Logic
* **Purpose:** Ensure CPR is generated correctly, with valid date encoding and correct gender-based last digit.
* **Input:** Call the method responsible for CPR generation with:
  * A specific gender (male or female).
  * A fixed date of birth (e.g. 08/03/1985).
* **Expected Behavior:**
  * The first six digits of the CPR represent the correct date of birth.
  * If gender is male, the last digit is odd.
  * If gender is female, the last digit is even.
* **Paths Tested:** Code branches responsible for checking gender and constructing the last digit based on the CPR format.

### Test Case 2: Address Generation Logic
* **Purpose:** Test the random address generation for streets, house numbers, floors, and doors.
* **Input:** Call the address generation method multiple times.
* **Test Variations:**
  * Provide different street names and formats.
  * Ensure correct boundaries for house numbers (1-999).
  * Test random generation of floor and door numbers/letters.
* **Expected Behavior:**
  * Generated addresses follow the expected format with street names being alphabetic, house numbers between 1 and 999, and optional floor/door values matching specifications.
* **Paths Tested:** Loops and conditions that handle random generation for street names, numbers, floor, and door formats.

### Test Case 3: Phone Number Generation Logic
* **Purpose:** Validate the random generation of mobile phone numbers with valid prefixes.
* **Input:** Call the phone number generation function multiple times.
* **Test Variations:**
  * Generate phone numbers and check if they start with one of the valid prefixes.
  * Test behavior with a limited set of prefixes and edge cases.
* **Expected Behavior:**
  * Each generated phone number starts with a valid prefix and has exactly 8 digits.
* **Paths Tested:** Prefix selection logic, length checking, and number formatting logic.

### Test Case 4: Bulk Generation Loop Logic
* **Purpose:** Test bulk generation logic to ensure the correct number of fake people are generated in a loop.
* **Input:** Request 100 fake people.
* **Expected Behavior:**
  * The system generates exactly 100 fake people, with each person having valid data for name, CPR, address, phone number, etc.
  * Ensure no off-by-one errors in the loop.
* **Paths Tested:** Loop structure responsible for generating multiple people, ensuring that the iteration matches the requested number.

### Test Case 5: Date of Birth Consistency with CPR
* **Purpose:** Ensure that the date of birth in the generated data matches the date encoded in the CPR.
* **Input:** Generate fake people with various dates of birth.
* **Expected Behavior:**
  * The date of birth in the generated person's profile should match the first six digits of the CPR number.
* **Paths Tested:** Date encoding logic within CPR generation and the function returning person profiles.

### Test Case 6: Validate CPR Last Digit Calculation
* **Purpose:** Directly test the logic that determines the last digit of the CPR based on gender.
* **Input:** Provide multiple gender inputs to the CPR generation function.
* **Expected Behavior:**
  * For males, the last digit should always be odd.
  * For females, the last digit should always be even.
* **Paths Tested:** Conditional logic for gender-based last digit calculation.

## Black-Box Test Cases:
### Test Case 1: Generate a valid fake CPR number
* **Input:** Request a fake CPR number from the API.
* **Expected Output:** A 10-digit CPR number with the first six digits representing a valid date (ddMMyy format), and the last four digits correctly indicating gender (odd for male, even for female).

### Test Case 2: Generate a fake name and gender
* **Input:** Request a fake name and gender from the API.
* **Expected Output:** A valid first name, last name, and gender (male or female) extracted from the “person-names.json” file.

### Test Case 3: Generate a fake name, gender, and date of birth
* **Input:*** Request a fake first name, last name, gender, and date of birth.
* **Expected Output:** Valid name, gender, and a date of birth that matches the date portion of the generated CPR.

### Test Case 4: Generate a fake address
* **Input:** Request a fake address from the API.
* **Expected Output:** A valid address with:
  * A street name composed of alphabetic characters.
  * A number (1-999), optionally followed by an uppercase letter.
  * A valid floor number or “st”.
  * A valid door specification.
  * A valid postal code and town from the “addresses.sql” database.

### Test Case 5: Generate a valid mobile phone number
* **Input:** Request a fake mobile phone number from the API.
* **Expected Output:** An 8-digit number starting with one of the valid digit combinations outlined in the specifications.

### Test Case 6: Generate all information for a fake person
* **Input:** Request all information (CPR, name, gender, date of birth, address, phone number) for a fake person.
* **Expected Output:** All fields returned, with a consistent date of birth between the CPR and date of birth, a valid phone number, and a well-formed address.

### Test Case 7: Bulk generation of fake people
* **Input:** Request fake person information for 10 people.
* **Expected Output:** The API returns data for 10 people, with all fields properly populated for each individual (e.g., valid CPR, names, addresses, and phone numbers for each person).

### Test Case 8: Stress test for bulk generation
* **Input:** Request fake person information for the upper limit (100 people) and lower limit (2 people).
* **Expected Output:** The API should handle the request without timing out, and all generated people should have valid fields.


## White-box test cases
