// API base URL
const apiBaseUrl = 'http://localhost:9090/api/accounts';

// Handle account creation
document.getElementById('createAccountForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const name = document.getElementById('accountHolderName').value;
    const amount = document.getElementById('initialDeposit').value;

    fetch(apiBaseUrl, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            accountHolderName: name,
            balance: amount
        })
    })
    .then(response => response.json())
    .then(data => {
        alert('Account Created: ' + JSON.stringify(data));
    })
    .catch(error => console.error('Error:', error));
});

// Handle deposit
document.getElementById('depositForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const accountNumber = document.getElementById('depositAccountNumber').value;
    const amount = document.getElementById('depositAmount').value;

    fetch(`${apiBaseUrl}/${accountNumber}/deposit?amount=${amount}`, {
        method: 'PUT'
    })
    .then(response => response.json())
    .then(data => {
        alert('Deposit Success: ' + JSON.stringify(data));
    })
    .catch(error => console.error('Error:', error));
});

// Handle withdrawal
document.getElementById('withdrawForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const accountNumber = document.getElementById('withdrawAccountNumber').value;
    const amount = document.getElementById('withdrawAmount').value;

    fetch(`${apiBaseUrl}/${accountNumber}/withdraw?amount=${amount}`, {
        method: 'PUT'
    })
    .then(response => response.json())
    .then(data => {
        alert('Withdrawal Success: ' + JSON.stringify(data));
    })
    .catch(error => console.error('Error:', error));
});

// Handle account closure
document.getElementById('closeAccountForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const accountNumber = document.getElementById('deleteAccountNumber').value;

    fetch(`${apiBaseUrl}/${accountNumber}`, {
        method: 'DELETE'
    })
    .then(response => response.text())
    .then(data => {
        alert('Account Closed: ' + data);
    })
    .catch(error => console.error('Error:', error));
});

// Handle fetching account details
document.getElementById('getAccountForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const accountNumber = document.getElementById('accountNumber').value;

    fetch(`${apiBaseUrl}/${accountNumber}`)
        .then(response => response.json())
        .then(data => {
            document.getElementById('accountDetails').innerHTML = `
                <h4>Account Details:</h4>
                <p><strong>Account Number:</strong> ${data.accountNumber}</p>
                <p><strong>Account Holder:</strong> ${data.accountHolderName}</p>
                <p><strong>Balance:</strong> ${data.balance}</p>
            `;
        })
        .catch(error => console.error('Error:', error));
});
