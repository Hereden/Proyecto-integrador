const formLogin2 = document.querySelector("#formLogin");
formLogin2.addEventListener("submit", (e) => {

    e.preventDefault();
    const email = document.querySelector("#emailLogin");
    const password = document.querySelector("#passwordLogin");

    if (email.value == "") {
        email.placeholder = "Favor de ingresar un email";
    }

    if (password.value == "") {

    }

    if (email.value != "" && password.value != "") {
        let req = fetch(URLBACKEND + "login", {
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
                    localStorage.setItem("username", email.value);
                    url = window.location;
                    console.log(url);
                    logeame();
                    /*const path = url.pathname.substring(0, url.pathname.lastIndexOf("/") + 1)
                    location.href = path + 'success.html';*/
                }
            })

    } else {
        localStorage.removeItem("token");
        email.textContent = "Usuario o contraseña incorrecto";
    }
});

function logeame() {
    token = localStorage.getItem("token");

    if (token) {
        let Nomostrar = document.querySelector("#loginMenu");
        Nomostrar.setAttribute("style",
            "display:none;")
        let mostrar = document.querySelector("#perfilLogin");
        mostrar.setAttribute("style",
            "display:inherit");
    }
}

logeame();

function logOut() {
    localStorage.clear();
    url = window.location;
    console.log(url);
    const path = url.pathname.substring(0, url.pathname.lastIndexOf('/') + 1);
    location.href = path + 'index.html';
}