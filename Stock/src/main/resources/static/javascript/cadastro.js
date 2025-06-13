document.addEventListener("DOMContentLoaded", function () {
  const registrarBtn = document.getElementById("REGISTRAR");

  registrarBtn.addEventListener("click", function () {
    // Capturar os valores dos inputs
    const nome = document.getElementById("nome-novo").value.trim();
    const categoria = document.getElementById("categoria-nova").value.trim();
    const quantidade = parseInt(document.getElementById("quantidade-nova").value);

    // Verificar se todos os campos foram preenchidos
    if (!nome || !categoria || isNaN(quantidade)) {
      alert("Por favor, preencha todos os campos corretamente.");
      return;
    }

    // Montar o objeto para envio
    const produto = {
      nome: nome,
      categoria: categoria,
      quantidade: quantidade
    };

    // Enviar via POST para a API do Spring
    fetch("/stock/postar", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(produto)
    })
      .then(response => {
        if (!response.ok) {
          throw new Error("Erro ao cadastrar o produto");
        }
        return response.json();
      })
      .then(data => {
        document.getElementById("resposta").textContent = `Produto cadastrado:\n${JSON.stringify(data, null, 2)}`;
        document.getElementById("nome-novo").value = "";
        document.getElementById("categoria-nova").value = "";
        document.getElementById("quantidade-nova").value = "";
      })
      .catch(error => {
        document.getElementById("resposta").textContent = `Erro: ${error.message}`;
      });
  });
});
