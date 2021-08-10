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

