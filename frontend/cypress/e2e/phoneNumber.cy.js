describe('Generate fake data', () => {
  it('generates a phone number', () => {
    cy.visit('http://localhost:5173')

    cy.get('#chkPartialOptions').click()
    
    cy.get('#cmbPartialOptions').select('phone')

    cy.get('input[type="submit"]').click()

    cy.get('#output').should('not.have.class', 'hidden')

    cy.get('.phoneNumberValue').should('not.be.empty')
  })
})
