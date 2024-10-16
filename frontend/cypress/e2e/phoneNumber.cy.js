describe('generate phoneNumber', () => {
  it('passes', () => {
    cy.visit('http://127.0.0.1:5173')

    cy.get('#cmbPartialOptions').select('phone')

    cy.get('#chkPartialOptions').check()

    // Click the submit button
    cy.get("input").contains("Generate").click()
  })
})
