const baseUrl = 'http://localhost:8080';

document.getElementById('frmGenerate').addEventListener('submit', function (event) {
  event.preventDefault();

  const isPartial = document.getElementById('chkPartialOptions').checked;
  const numberOfPersons = document.getElementById('txtNumberPersons').value;
  const partialOptions = document.getElementById('cmbPartialOptions').value;

  let endpoint = '';

  alert('isPartial: ' + isPartial + ' numberOfPersons: ' + numberOfPersons + ' partialOptions: ' + partialOptions);

  if (isPartial) {
    if (partialOptions === "address" || partialOptions === "phone") {
      endpoint = `/${partialOptions}`
    } else {
      endpoint = "/person"
    }
    
  } else {
    if (numberOfPersons !== 1) {
      endpoint = "/detailed-person/" + numberOfPersons
    } else {
      endpoint = "/detailed-person"
    }
  }
  console.log(baseUrl + endpoint)
  fetch(baseUrl + endpoint)
});


