const form = document.querySelector('#signupForm');
const submitButton = form.querySelector('button[type="submit"]');
const message = document.querySelector('#message');

submitButton.addEventListener('click', async (event) => {
    event.preventDefault();

    // Coletar dados do formulário
    const formData = new FormData(form);
    const email = formData.get('email');
    const nome = formData.get('username');
    const cargo = formData.get('cargouser');
    const tokem = formData.get('password');
    const confirmPassword = formData.get('confirmPassword');

    // Validar dados (opcional, mas recomendado)
    if (tokem !== confirmPassword) {
        message.textContent = 'Passwords do not match.';
        return;
    }

    // Criar a requisição
    try {
        const response = await fetch('http://localhost:8080/users', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                email: email,
                nome: nome,
                cargo: cargo,
                tokem: tokem,
            }),
        });

        // Tratar a resposta
        if (response.ok) {
            // Requisição bem-sucedida
            message.textContent = 'Cadastro realizado com sucesso!';
            // Redirecionar para outra página ou realizar outras ações
        } else {
            // Requisição falhou
            const error = await response.json();
            message.textContent = error.message || 'Cadastro falhou.';
        }
    } catch (error) {
        console.error('Erro ao enviar requisição:', error);
        message.textContent = 'Erro ao realizar cadastro.';
    }
});
