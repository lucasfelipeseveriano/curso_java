
// executa apenas sepois de carregar todo html
document.addEventListener('DOMContentLoaded', () => {

    fetch('http://localhost:8080/CDI_JSP/restapi')

        // converta a resposta em formaro json
        .then((resp) => resp.json())

        // recebe os dados da resposta 
        .then((lista) => adicionarNaTabela(lista))

        .catch(() => alert('Erro ao consultar a lista de alunos via API Rest'))

})


// adicina todos os alunos dinamicamente na tabela
const adicionarNaTabela = (lista) => {

    const tbody = document.getElementsByClassName('tbody')[0];
    lista.forEach(aluno => {

        // calcula o número da linha atual
        const tamanhoTabela = tbody.ariaRowSpan.length
        // insere uma linha abaixo da última 
        const linha = tbody.insertRow(tamanhoTabela);

        // insere as celulas da linha 
        const id = linha.insertCell(0);
        const nome = linha.insertCell(1);
        const curso = linha.insertCell(2);
        const email = linha.insertCell(3);
        const data = linha.insertCell(4);

        // preenche as células da linha
        id.innerHTML = aluno.id
        nome.innerHTML = aluno.nome
        curso.innerHTML = aluno.curso
        email.innerHTML = aluno.email
        const objData = aluno.data
        // formata de data, retornando (split) apenas dia, mes e ano
        data.innerHTML = new Data(objData.year, objData.month, objData.day).toLocaleString('pt-BR').split(',')[0]
    })
}