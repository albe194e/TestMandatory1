const baseUrl = 'http://localhost:8080';

document.getElementById('frmGenerate').addEventListener('submit', function (event) {
  event.preventDefault();

  const isPartial = document.getElementById('chkPartialOptions').checked;
  const numberOfPersons = document.getElementById('txtNumberPersons').value;
  const partialOptions = document.getElementById('cmbPartialOptions').value;

  let endpoint;

  if (isPartial) {
    if (partialOptions === "address" || partialOptions === "phone") {
      endpoint = `/${partialOptions}`;
    } else {
      endpoint = "/person";
    }
  } else {
    if (numberOfPersons !== 1) {
      endpoint = "/detailed-person/" + numberOfPersons;
    } else {
      endpoint = "/detailed-person";
    }
  }

  console.log(`Fetching from: ${baseUrl + endpoint}`);

  fetch(baseUrl + endpoint)
    .then(response => response.json())
    .then(data => {
      console.log("Data fetched:", data);

      const persons = Array.isArray(data) ? data : [data];
      const outputSection = document.getElementById('output');
      outputSection.innerHTML = ''; 
      outputSection.classList.remove('hidden');

      if (partialOptions === 'address' && isPartial) {
        const address = data;
        const template = document.getElementById('personTemplate').content.cloneNode(true);

        template.querySelector('.address').classList.remove('hidden');
        template.querySelector('.streetValue').textContent = `${address.street} ${address.number}, Floor ${address.floor}, Door ${address.door}`;
        template.querySelector('.townValue').textContent = `${address.postalCode} ${address.city}`;

        outputSection.appendChild(template);
        return;
      }

      if (partialOptions === 'phone' && isPartial) {
        const phoneNumber = data;
        const template = document.getElementById('personTemplate').content.cloneNode(true);

        template.querySelector('.phoneNumber').classList.remove('hidden');
        template.querySelector('.phoneNumberValue').textContent = phoneNumber;

        outputSection.appendChild(template);
        return;
      }

      if (persons.length > 1) {
        persons.forEach(person => {
          console.log("Processing person:", person);

          const template = document.getElementById('personTemplate').content.cloneNode(true);

          template.querySelector('.cpr').classList.remove('hidden');
          template.querySelector('.cprValue').textContent = person.cpr;

          template.querySelector('.firstName').classList.remove('hidden');
          template.querySelector('.firstNameValue').textContent = person.name;

          template.querySelector('.lastName').classList.remove('hidden');
          template.querySelector('.lastNameValue').textContent = person.surname;

          template.querySelector('.gender').classList.remove('hidden');
          template.querySelector('.genderValue').textContent = person.gender.substring(0, 1).toUpperCase() + person.gender.substring(1);

          template.querySelector('.dob').classList.remove('hidden');
          template.querySelector('.dobValue').textContent = person.dob;

          if (person.address) {
            template.querySelector('.address').classList.remove('hidden');
            template.querySelector('.streetValue').textContent = `${person.address.street} ${person.address.number}, Floor ${person.address.floor}, Door ${person.address.door}`;
            template.querySelector('.townValue').textContent = `${person.address.postalCode} ${person.address.city}`;
          }

          if (person.phoneNumber) {
            template.querySelector('.phoneNumber').classList.remove('hidden');
            template.querySelector('.phoneNumberValue').textContent = person.phoneNumber;
          }

          // Append the filled template to the output section for each person
          outputSection.appendChild(template);
        });
      } else {
        // For a single person, handle based on partialOptions
        const person = persons[0]; // Access the first (and only) person
        const template = document.getElementById('personTemplate').content.cloneNode(true);

        if (partialOptions === 'cpr') {
          template.querySelector('.cpr').classList.remove('hidden');
          template.querySelector('.cprValue').textContent = person.cpr;
        }
        if (partialOptions === 'name-gender') {
          template.querySelector('.firstName').classList.remove('hidden');
          template.querySelector('.firstNameValue').textContent = person.name;
          template.querySelector('.lastName').classList.remove('hidden');
          template.querySelector('.lastNameValue').textContent = person.surname;
          template.querySelector('.gender').classList.remove('hidden');
          template.querySelector('.genderValue').textContent = person.gender.substring(0, 1).toUpperCase() + person.gender.substring(1);
        }
        if (partialOptions === 'name-gender-dob') {
          template.querySelector('.firstName').classList.remove('hidden');
          template.querySelector('.firstNameValue').textContent = person.name;
          template.querySelector('.lastName').classList.remove('hidden');
          template.querySelector('.lastNameValue').textContent = person.surname;
          template.querySelector('.gender').classList.remove('hidden');
          template.querySelector('.genderValue').textContent = person.gender.substring(0, 1).toUpperCase() + person.gender.substring(1);
          template.querySelector('.dob').classList.remove('hidden');
          template.querySelector('.dobValue').textContent = person.dob;
        }
        if (partialOptions === 'cpr-name-gender') {
          template.querySelector('.cpr').classList.remove('hidden');
          template.querySelector('.cprValue').textContent = person.cpr;
          template.querySelector('.firstName').classList.remove('hidden');
          template.querySelector('.firstNameValue').textContent = person.name;
          template.querySelector('.lastName').classList.remove('hidden');
          template.querySelector('.lastNameValue').textContent = person.surname;
          template.querySelector('.gender').classList.remove('hidden');
          template.querySelector('.genderValue').textContent = person.gender.substring(0, 1).toUpperCase() + person.gender.substring(1);
        }
        if (partialOptions === 'cpr-name-gender-dob') {
          template.querySelector('.cpr').classList.remove('hidden');
          template.querySelector('.cprValue').textContent = person.cpr;
          template.querySelector('.firstName').classList.remove('hidden');
          template.querySelector('.firstNameValue').textContent = person.name;
          template.querySelector('.lastName').classList.remove('hidden');
          template.querySelector('.lastNameValue').textContent = person.surname;
          template.querySelector('.gender').classList.remove('hidden');
          template.querySelector('.genderValue').textContent = person.gender.substring(0, 1).toUpperCase() + person.gender.substring(1);
          template.querySelector('.dob').classList.remove('hidden');
          template.querySelector('.dobValue').textContent = person.dob;
        }

        outputSection.appendChild(template);
      }
    })
    .catch(error => {
      console.error('Error:', error);
    });
});
