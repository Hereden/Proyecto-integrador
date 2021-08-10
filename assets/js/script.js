const URLBACKEND="http://localhost:8080/";

let carrito={};

function registrarme() {
    localStorage.setItem('email', document.querySelector("#correo").value);
    localStorage.setItem('password', document.querySelector("#pass").value);
    localStorage.setItem('siniciada', 'FALSE');
}

function comprobarSesion() {
    if (localStorage.getItem("siniciada") == "TRUE") {
        document.querySelector(".Login").setAttribute("style", "visibility:hidden;");
    } else {
        document.querySelector(".Login").setAttribute("style", "visibility:block;");
    }
}


const formLogin = document.querySelector("#formLogin");
formLogin.addEventListener("submit", (e) => {

    e.preventDefault();
    const email = document.querySelector("#emailLogin");
    const password = document.querySelector("#passwordLogin");

    if (email.value == "") {
        email.placeholder = "Favor de ingresar un email";
    }

    if (password.value == "") {

    }

    if (email.value != "" && password.value != "" ) {
        let req = fetch(URLBACKEND+ "login", {
            method: 'POST',
            body: JSON.stringify({
                username: email.value,
                password: password.value
            }),
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(resp => {
                console.log(resp.status);
                token = resp.headers.get("Authorization");
                console.log(token);

                if (token && token.includes('Bearer')) {
                    console.log(token);
                    localStorage.setItem("token", token);
                    url = window.location;
                    console.log(url);
                    
                    /*const path = url.pathname.substring(0, url.pathname.lastIndexOf("/") + 1)
                    location.href = path + 'success.html';*/
                }
            })

    } else {
        localStorage.removeItem("token");
        email.textContent = "Usuario o contraseña incorrecto";
    }
});




/* const fs = require('fs') */

/* fs.readFile(filePath, function (error, content) {
    var data = JSON.parse(content);
    console.log(data.collection.length);
});

fs.readFile("/assets/texto/formato.txt"); */
/* 
$.getJSON("assets/texto/formato.json", function(json) {
    console.log(json); // this will show the info it in firebug console
    console.log("Hola");
}); */

