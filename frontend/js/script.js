const baseUrl = 'http://localhost/8080';

document.getElementById('frmGenerate').addEventListener('submit', function (event) {
  event.preventDefault();

  const isPartial = document.getElementById('chkPartialOptions').checked;
  const numberOfPersons = document.getElementById('txtNumberOfPersons').value;
  const partialOptions = document.getElementById('cmbPartialOptions').value;

  let endpoint = '/';

  alert('isPartial: ' + isPartial + ' numberOfPersons: ' + numberOfPersons + ' partialOptions: ' + partialOptions);
});


