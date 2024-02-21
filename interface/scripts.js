function enviarCadastroAluno() {
    // Recupera os dados do formulário de cadastro de aluno
    var matricula = document.getElementById('matricula').value;
    var nome = document.getElementById('nome').value;
    var cpf = document.getElementById('cpf').value;
    var endereco = document.getElementById('endereco').value;

    // Cria um objeto com os dados do aluno
    var aluno = {
        matricula: matricula,
        nome: nome,
        cpf: cpf,
        endereco: endereco
    };

    // Envia os dados do aluno para o endpoint localhost:8080/aluno via POST
    fetch('http://localhost:8080/aluno', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(aluno)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Erro ao cadastrar aluno');
        }
        console.log('Aluno cadastrado com sucesso!');
        mostrarAlerta('Aluno cadastrado com sucesso!');
        // Limpar o formulário após o cadastro bem-sucedido, se necessário
    })
    .catch(error => {
        console.error('Erro:', error);
        // Tratar o erro, exibir uma mensagem para o usuário, etc.
    });
}

function enviarCadastroLivro() {
    // Recupera os dados do formulário de cadastro de livro
    var isbn = document.getElementById('isbn').value;
    var disponivel = document.getElementById('disponivel').value;
    var exemplar = document.getElementById('exemplar').value;

    // Cria um objeto com os dados do livro
    var livro = {
        isbn: isbn,
        disponivel: disponivel,
        exemplar: exemplar
    };

    // Envia os dados do livro para o endpoint localhost:8080/livro via POST
    fetch('http://localhost:8080/livro', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(livro)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Erro ao cadastrar livro');
        }
        console.log('Livro cadastrado com sucesso!');
        mostrarAlerta('Livro cadastrado com sucesso!');
        // Limpar o formulário após o cadastro bem-sucedido, se necessário
    })
    .catch(error => {
        console.error('Erro:', error);
        // Tratar o erro, exibir uma mensagem para o usuário, etc.
    });
}

function mostrarAlerta(mensagem) {
    alert(mensagem);
}
function listarAlunos() {
    fetch('http://localhost:8080/aluno')
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro ao listar alunos');
            }
            return response.json();
        })
        .then(data => {
            console.log('Lista de alunos:', data);
            exibirDados(data);
        })
        .catch(error => {
            console.error('Erro:', error);
            // Tratar o erro, exibir uma mensagem para o usuário, etc.
        });
}

function listarLivros() {
    fetch('http://localhost:8080/livro')
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro ao listar livros');
            }
            return response.json();
        })
        .then(data => {
            console.log('Lista de livros:', data);
            exibirDados(data);
        })
        .catch(error => {
            console.error('Erro:', error);
            // Tratar o erro, exibir uma mensagem para o usuário, etc.
        });
}

function exibirDados(data) {
    let html = '<table>';
    // Verifica se há dados a serem exibidos
    if (data.length > 0) {
        // Cabeçalho da tabela
        html += '<tr>';
        for (let key in data[0]) {
            html += '<th>' + key + '</th>';
        }
        html += '</tr>';
        // Linhas da tabela
        data.forEach(item => {
            html += '<tr>';
            for (let key in item) {
                html += '<td>' + item[key] + '</td>';
            }
            html += '</tr>';
        });
        document.getElementById('limparBtn').style.display = 'block'; // Mostra o botão de limpar
    } else {
        // Se não houver dados, exibe uma mensagem na tabela
        html += '<tr><td colspan="100%">Nenhum dado disponível</td></tr>';
        document.getElementById('limparBtn').style.display = 'none'; // Oculta o botão de limpar
    }
    html += '</table>';
    document.getElementById('dados').innerHTML = html;
}

function limparTabela() {
    document.getElementById('dados').innerHTML = ''; // Limpa o conteúdo da tabela
    document.getElementById('limparBtn').style.display = 'none'; // Oculta o botão de limpar
}
