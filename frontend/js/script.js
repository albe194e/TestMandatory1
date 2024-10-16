import { baseUrl } from "./info";

document.querySelector('#frmGenerate').addEventListener('submit', (e) => {
  e.preventDefault();

  let endpoint = '/';

  if (e.target.chkPerson.checked) {
    endpoint += 'person';
    const numPersons = parseInt(e.target.txtNumberPersons.value);
    if (numPersons > 0) {
        endpoint += '?numPersons=' + numPersons;
    }
  } else {
    endpoint += 'e.target.cmbPartialOptions.value';
  }

  fetch(baseUrl + endpoint)
    .then(response => {
      if (response.ok) {
        return response.json();
      } else {
        throw new Error('Error: ' + response.status);
      }
    })
  .then(handleData)
  .catch(handleError);
});

const handleData = (data) => {
  const output = document.querySelector('#output');
  output.innerHTML = '';

  if (data.length > 0) {
    data = [data]; // Convert to array
  }

  data.forEach(item => {
    const personCard = document.importNode(document.getElementById('personTemplate').content, true);
    if (item.CPR !== undefined) {
      const cprValue = personCard.querySelector('.cprValue');
      cprValue.innerText = item.CPR;
      cprValue.classList.remove('hidden');
      personCard.querySelector('.cpr').classList.remove('hidden');
    }
    if (item.firstName !== undefined) {
      const firstNameValue = personCard.querySelector('.firstNameValue');
      firstNameValue.innerText = item.firstName;
      firstNameValue.classList.remove('hidden');
      const lastNameValue = personCard.querySelector('.lastNameValue');
      lastNameValue.innerText = item.lastName;
      lastNameValue.classList.remove('hidden');
      personCard.querySelector('.firstName').classList.remove('hidden');
      personCard.querySelector('.lastName').classList.remove('hidden');
    }
    if (item.gender !== undefined) {
      const genderValue = personCard.querySelector('.genderValue');
      genderValue.innerText = item.gender;
      genderValue.classList.remove('hidden');
      personCard.querySelector('.gender').classList.remove('hidden');
    }
    if (item.birthDate !== undefined) {
      const dobValue = personCard.querySelector('.dobValue');
      dobValue.innerText = item.birthDate;
      dobValue.classList.remove('hidden');
      personCard.querySelector('.dob').classList.remove('hidden');
    }
    if (item.address !== undefined) {
      const streetValue = personCard.querySelector('.streetValue');
      streetValue.innerText = `${item.address.street} ${item.address.number}, ${item.address.floor}.${item.address.door}`;
      streetValue.classList.remove('hidden');
      const townValue = personCard.querySelector('.townValue');
      townValue.innerText = `${item.address.postal_code} ${item.address.town_name}`;
      townValue.classList.remove('hidden');
      personCard.querySelector('.address').classList.remove('hidden');
    }
    if (item.phoneNumber !== undefined) {
      const phoneNumberValue = personCard.querySelector('.phoneNumberValue');
      phoneNumberValue.innerText = item.phoneNumber;
      phoneNumberValue.classList.remove('hidden');
      personCard.querySelector('.phoneNumber').classList.remove('hidden');
    }

    output.appendChild(personCard);
  });

  output.classList.remove('hidden');
}
