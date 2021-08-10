
const formLogin = document.querySelector("#formR");



formLogin.addEventListener("submit", (e) => {

    e.preventDefault();
    const email = document.querySelector("#emailR");
    const password = document.querySelector("#passR");
    const nombre = document.querySelector("#nombreR");
    const alias = document.querySelector("#aliasR");
    const apellidos = document.querySelector("#apellidosR");
    const direccion = document.querySelector("#direccionR");
    const telefono = document.querySelector("#telefonoR");
    const genero = document.querySelector("#generoR");
    
    //const username;

    /*const emailError = document.querySelector("#emailError");
    const passwordError = document.querySelector("#passwordError");
    emailError.textContent = "";
    passwordError.textContent = "";
    */
    if (nombre.value == "") {
        nombre.placeholder = "Favor de ingresar un nombre";
    }
    if (email.value == "") {
        email.placeholder = "Favor de ingresar un email";
    }
    if (password.value == "") {

    }
    if (alias.value == "") {
        alias.placeholder = "Favor de ingresar un alias";
    }
    if (apellidos.value == "") {
        apellidos.placeholder = "Favor de ingresar un apellidos";
    }
    if (direccion.value == "") {
        direccion.placeholder = "Favor de ingresar un direccion";
    }
    if (telefono.value == "") {

    }
    if (genero.value == "") {
        
    }

    console.log(email.value);
    console.log(password.value);
    console.log(nombre.value);
    console.log(email.value);
    console.log(alias.value);
    console.log(apellidos.value);
    console.log(direccion.value);
    console.log(telefono.value);
    console.log(genero.value);
    if (nombre.value != "" && email.value != "" && password.value != "" && alias.value != "" && apellidos.value != "" && direccion.value != "" && telefono.value != "" && genero.value != "") {
        console.log("Holi");
        let genero2=0;
        if(genero=="Hombre"){
            genero2=0;
        }else if(genero=="Mujer"){
            genero2=1;
        }else{
            genero2=2;
        }
        let req = fetch(URLBACKEND+ "usuarios/", {
            method: 'POST',
            body: JSON.stringify({
                username: email.value,
                password: password.value,
                name: nombre.value,
                email: email.value,
                alias: alias.value,
                apellidos: apellidos.value,
                direccion: direccion.value,
                telefono: telefono.value,
                genero: genero2
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
