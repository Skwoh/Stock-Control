document.addEventListener("DOMContentLoaded", function() {

    const b1 = document.getElementById("MEU_ARMAZÉM");
    const b2 = document.getElementById("CADASTRO");

            b1.addEventListener("click", function () {
                window.location.href = "/stock/MostrarArmazem";
            });

           b2.addEventListener("click", function () {
                window.location.href = "/stock/cadastro";
            });
        });