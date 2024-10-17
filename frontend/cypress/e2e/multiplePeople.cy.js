describe('Generate fake data', () => {
    
    it('generates multiple people', () => {
      cy.visit('http://localhost:5173')
  
      cy.get('#chkPerson').click()
  
      cy.get('#txtNumberPersons').clear().type('3')
  
      cy.get('input[type="submit"]').click()
  
      cy.get('#output').should('not.have.class', 'hidden')
  
      cy.get('.personCard').should('have.length', 3)
    })
  })
  