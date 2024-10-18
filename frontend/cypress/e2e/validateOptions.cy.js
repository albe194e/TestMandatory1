describe('Generate data with different options', () => {
    const options = [
      { value: 'cpr', label: 'CPR' },
      { value: 'name-gender', label: 'Name and gender' },
      { value: 'name-gender-dob', label: 'Name, gender and birthdate' },
      { value: 'cpr-name-gender', label: 'CPR, name and gender' },
      { value: 'cpr-name-gender-dob', label: 'CPR, name, gender, birthdate' },
      { value: 'address', label: 'Address' },
      { value: 'phone', label: 'Phone number' }
    ];
  
    options.forEach(option => {
      it(`generates data for ${option.label}`, () => {
        cy.visit('http://localhost:5173')
  
        // Select the partial generation option based on the current option in the loop
        cy.get('#chkPartialOptions').click()
        cy.get('#cmbPartialOptions').select(option.value)
  
        // Click the generate button to submit the form
        cy.get('input[type="submit"]').click()
  
        // Ensure the output section is visible after generation
        cy.get('#output').should('not.have.class', 'hidden')
  
        // Verify based on the selected option what should appear in the output
        switch (option.value) {
          case 'cpr':
            cy.get('.cpr').should('not.have.class', 'hidden')
            cy.get('.cprValue').should('not.be.empty')
            break
          case 'name-gender':
            cy.get('.firstName').should('not.have.class', 'hidden')
            cy.get('.lastName').should('not.have.class', 'hidden')
            cy.get('.gender').should('not.have.class', 'hidden')
            cy.get('.firstNameValue').should('not.be.empty')
            cy.get('.lastNameValue').should('not.be.empty')
            cy.get('.genderValue').should('not.be.empty')
            break
          case 'name-gender-dob':
            cy.get('.firstName').should('not.have.class', 'hidden')
            cy.get('.lastName').should('not.have.class', 'hidden')
            cy.get('.gender').should('not.have.class', 'hidden')
            cy.get('.dob').should('not.have.class', 'hidden')
            cy.get('.firstNameValue').should('not.be.empty')
            cy.get('.lastNameValue').should('not.be.empty')
            cy.get('.genderValue').should('not.be.empty')
            cy.get('.dobValue').should('not.be.empty')
            break
          case 'cpr-name-gender':
            cy.get('.cpr').should('not.have.class', 'hidden')
            cy.get('.firstName').should('not.have.class', 'hidden')
            cy.get('.lastName').should('not.have.class', 'hidden')
            cy.get('.gender').should('not.have.class', 'hidden')
            cy.get('.cprValue').should('not.be.empty')
            cy.get('.firstNameValue').should('not.be.empty')
            cy.get('.lastNameValue').should('not.be.empty')
            cy.get('.genderValue').should('not.be.empty')
            break
          case 'cpr-name-gender-dob':
            cy.get('.cpr').should('not.have.class', 'hidden')
            cy.get('.firstName').should('not.have.class', 'hidden')
            cy.get('.lastName').should('not.have.class', 'hidden')
            cy.get('.gender').should('not.have.class', 'hidden')
            cy.get('.dob').should('not.have.class', 'hidden')
            cy.get('.cprValue').should('not.be.empty')
            cy.get('.firstNameValue').should('not.be.empty')
            cy.get('.lastNameValue').should('not.be.empty')
            cy.get('.genderValue').should('not.be.empty')
            cy.get('.dobValue').should('not.be.empty')
            break
          case 'address':
            cy.get('.address').should('not.have.class', 'hidden')
            cy.get('.streetValue').should('not.be.empty')
            cy.get('.townValue').should('not.be.empty')
            break
          case 'phone':
            cy.get('.phoneNumber').should('not.have.class', 'hidden')
            cy.get('.phoneNumberValue').should('not.be.empty')
            break
        }
      })
    })
  })
  