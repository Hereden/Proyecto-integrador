# Integrantes
 - César Eduardo Juárez Fonseca  <a href=https://www.linkedin.com/in/cesare-ar target="_blank"/>LinkedIn</a>
 - Gabriela Itsel Medrano Hernández <a href=https://www.linkedin.com/in/gabriela-mh target="_blank"/>LinkedIn</a>
 - Emmanuel Reyna Cruz <a href=https://www.linkedin.com/in/emmanuelreynac target="_blank"/>LinkedIn</a>
 - Mónica Tamara Morales Cano <a href=https://www.linkedin.com/in/tamara-mc target="_blank"/>LinkedIn</a>
 - Santiago García Arellano <a href=https://www.linkedin.com/in/santiago-garc%C3%ADa-766468213/ target="_blank"/>LinkedIn</a>
<br>
<p align="center">
 <a href="" target="_blank"><img src="assets/images/equipo/equipo.png" align="center" height="300" width="500"></a>

</p>
<br>

# Introducción

El proyecto comienza con la necesidad y el crecimiento de la comunidad de ciclismo, ejemlplo: ecobicis, ciclovias
nosotros pensamos en la comunidad y en donde hay una area de crecimiento como lo es en las Rodadas:
Las rodadas son rutas de un punto a otro, donde los ciclistas se reúnen, conviven y pasan un buen momento 
compartiendo sus gustos e intereses, estas pueden depender de la distancia o el lugar, ya sea ciudad, carretera o montañismo.
Justo entendiendo la complejidad y lo que esto indica, comenzamos con un e-commerce.


# Links

<a href=https://www.canva.com/design/DAEkO0-0KY4/Kq5z7wMLaiBtaz8LmcSX9w/edit>Presentación  </a>
<br>
<a href= https://hereden.github.io/Proyecto-integrador/>Página</a>

# Código interesante

## Rellenado dinámico del footer y del navbar

 - En el html
```HTML
<div id="nav-placeholder"></div>
<div id="footer"></div>
```
 - En el JavaScript
```JS
 jQuery.get("./navbar.html", function (data) {
  $("#nav-placeholder").replaceWith(data);
 });

 jQuery.get("./footer.html", function (data) {
  $("#footer").replaceWith(data);
 })
```

## Peticiones al Back para obtener los artículos

```JS
/* Buscamos cargar los articulos */
cargarArticulos();

/* Función para hacer la petición por medio de fetch
* en la url donde esta el backend y la ruta de articulos
* al finalizar guardamos la respuesta en la variable previamente declarada*/
function cargarArticulos() {
  fetch(URLBACKEND + 'articulos', {
      method: 'GET',
      headers: {
          "Content-Type": "application/json"
      }
  })
      .then(resp => resp.json()).then(data => {
          TODOS_LOS_ARTICULOS = data;
      });
}
```

## Repintado del div "precarga" para agilizar la funcionalidad de la página

```JS
/* Funcion para repintar el div de index y borrar los otros dos divs*/
function volverAlIndex() {
    let columnaIzquierda = document.querySelector("#columnaIzquierda").textContent = "";
    let columnaDerecha = document.querySelector("#columnaDerecha").textContent = "";
    jQuery.get("./precarga.html", function (data) {
        $("#precarga").replaceWith(data);
    });
}
```

## Rellenado dinámico de las cards

 - En el html
```HTML
<div class="col-9" id="columnaDerecha">
      </div>
```
 - En el JavaScript
```JS
function generarCardsDinamicamente(numeroCategoria) {
  /*Obtenemos div de columna derecha*/
  var columnaDerecha = document.querySelector("#columnaDerecha");
  columnaDerecha.textContent = "";
  /*Generamos la fila donde iran todos los articulos de la página*/
  let row1 = document.createElement("div");
  row1.className += "row";
  /*Generamos otra fila donde separamos en 3 articulos por fila*/
  let row2 = document.createElement("div");
  row2.className += "row row-cols-3 row-cols-md-3 m-2";
  /*Agarramos nuestro Array con lista de json*/
  /*Por cada elemento vamos a*/
  TODOS_LOS_ARTICULOS.forEach((element) => {
      if (element.categoria == numeroCategoria) {
          /*Generar el marco de la card*/
          let marcoCard = document.createElement("div");
          marcoCard.className += "col mb-4";
          /*Generamos la card con fondo negro*/
          let card = document.createElement("div");
          card.className += "card bg-dark";
          /*Generamos la forma de la card*/
          let cardLayout = document.createElement("div");
          cardLayout.className += "card-body";
          /*Generamos en donde va a ponerse la imagen*/
          let imagenCard = document.createElement("img");
          imagenCard.className += "card-img-top";
          /*Generamos donde se va a poner el titulo del articulo*/
          let tituloCard = document.createElement("h5");
          tituloCard.className += "card-title texto_white font_footer_text text-overflow-cards-1";
          /*Generamos donde se va poner la descripcion del articulo*/
          let descCard = document.createElement("p");
          descCard.className +=
              "card-text text-overflow-cards texto_white texto_50 font_footer";
          /*Generamos donde se va a poner el precio*/
          let precioCard = document.createElement("p");
          precioCard.className +=
              "texto_white font_footer_text align-self-center";
          precioCard.setAttribute("style",
              "font-size:23px;text-align: center;");
          /*Generamos el boton de compra*/
          let botonCard = document.createElement("button");
          botonCard.className += "font_footer_text"
          botonCard.setAttribute(
              "style",
              "border-color: #FFD103;background-color: black;color: #FFD103;border: 1px;width=100%;font-size:20px"
          );
          /*Generamos el div donde se pondrian las tallas*/
          let tallas1 = document.createElement("div");
          tallas1.className += "";

          /*Obtenemos el url del json para la imagen*/
          imagenCard.src = element.url;
          /*Obtenemos el titulo para el texto alternativo*/
          imagenCard.alt = element.nombre;
          /*Obtenemos el titulo del json*/
          tituloCard.appendChild(document.createTextNode(element.nombre));
          /*Obtenemos la descripcion del json*/
          descCard.appendChild(document.createTextNode(element.descripcion));
          /*Obtenemos el precio del json*/
          precioCard.appendChild(document.createTextNode(`$ ${Intl.NumberFormat().format(element.precio)}`));
          /*Terminamos de generar el texto del boton para comprar*/
          botonCard.appendChild(document.createTextNode(`Comprar`));
          /*Aqui agregaremos funcionalidad del boton comprar*/
          botonCard.addEventListener("click", function () {
              console.log(element);
              let carrito = localStorage.getItem("carrito");
              if (carrito) {
                  let carrito2 = [];
                  carrito2 = JSON.parse(carrito);
                  let agregarCarrito = true;
                  carrito2.forEach(function (task) {
                      if (task.nombre == element.nombre) {
                          agregarCarrito = false;
                      }
                  });
                  if (agregarCarrito) {
                      carrito2.push(element);
                  }
                  localStorage.setItem("carrito", JSON.stringify(carrito2));
              } else {
                  let carrito = [];
                  carrito.push(element);
                  localStorage.setItem("carrito", JSON.stringify(carrito));
              }

          });

          /*Agregamos las tallas, el boton de compra, titulo y descripcion 
          * al layout que es la parte que veremos cuando nos posicionemos 
          * encima de la card*/
          cardLayout.appendChild(tituloCard);

          /*Agregamos a la card la imagen, el precio y la parte de encima de la card*/
          card.appendChild(imagenCard);
          card.appendChild(cardLayout);
          card.appendChild(precioCard);
          card.appendChild(tallas1);
          card.appendChild(botonCard);

          /*Agregar la card al marco*/
          marcoCard.appendChild(card);
          /*Agregar el marco a nuestra filas de cards*/
          row2.appendChild(marcoCard);
      }
  });
  /*Agregamos nuestra segunda fila a la primera*/
  row1.appendChild(row2);
  /*Agregamos la primer fila a nuestra columna derecha*/
  columnaDerecha.appendChild(row1);
}
```

