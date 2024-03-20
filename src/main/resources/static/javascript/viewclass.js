const form = document.querySelector('#loginForm');
const usernameInput = document.querySelector('#username');
const passwordInput = document.querySelector('#password');
const submitButton = document.querySelector('#loginForm button');
const errorMessage = document.querySelector('#message');

// Animação de entrada
form.classList.add('animated', 'fadeInUp');

// Efeitos de foco
usernameInput.addEventListener('focus', () => {
    usernameInput.classList.add('focused');
});

usernameInput.addEventListener('blur', () => {
    usernameInput.classList.remove('focused');
});

passwordInput.addEventListener('focus', () => {
    passwordInput.classList.add('focused');
});

passwordInput.addEventListener('blur', () => {
    passwordInput.classList.remove('focused');
});

// Validação dinâmica
usernameInput.addEventListener('input', () => {
    if (usernameInput.validity.valid) {
        errorMessage.textContent = '';
    } else {
        errorMessage.textContent = 'Invalid username';
    }
});

passwordInput.addEventListener('input', () => {
    if (passwordInput.validity.valid) {
        errorMessage.textContent = '';
    } else {
        errorMessage.textContent = 'Invalid password';
    }
});

// Botão de login com pulsação
submitButton.addEventListener('click', () => {
    submitButton.classList.add('pulsating');

    // Simular requisição de login
    setTimeout(() => {
        submitButton.classList.remove('pulsating');

        if (usernameInput.value === 'user' && passwordInput.value === 'password') {
            // Login successful
            // Redirecionar para a página inicial
        } else {
            // Login failed
            errorMessage.textContent = 'Login failed';
        }
    }, 1000);
});

// Exibição de senha
const showPasswordButton = document.querySelector('#showPassword');

showPasswordButton.addEventListener('click', () => {
    if (passwordInput.type === 'password') {
        passwordInput.type = 'text';
        showPasswordButton.textContent = 'Hide password';
    } else {
        passwordInput.type = 'password';
        showPasswordButton.textContent = 'Show password';
    }
});
