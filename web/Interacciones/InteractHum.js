document.addEventListener('DOMContentLoaded', function() {
    
    const divsAutollenado = document.querySelectorAll('#registroConCorralesHuertos .InformacionRegistro');
    const eliminar = document.querySelectorAll('#registroConCorralesHuertos .Eliminar');
    console.log("hola JS");
    divsAutollenado.forEach(div => {
        div.addEventListener('click', () => {
            console.log('Click en:', div.textContent);
            const idText = div.querySelector('p').textContent;
            const id = idText.split(':')[1].trim();
            console.log("esto es el ID: "+id);
            fetch(`/JavaWebTienda22/EdicionHum?id=${encodeURIComponent(id)}`)
                .then(response => response.json())  
                .then(data => {
                        document.getElementById("id").value = data[0];
                        document.getElementById("animales").value = data[1];
                        document.getElementById("Cantidad").value = data[2];
                        document.getElementById("estado").value = data[3];
                        document.getElementById("fecha").value = data[4];
                })
                .catch(error => console.error('Error:', error));
        });
    });

    eliminar.forEach(eliminares => {
        eliminares.addEventListener('click', () => {
            const contenedor = eliminares.closest('.ContenerdExt');
            const info = contenedor.querySelector('.InformacionRegistro p').textContent;
            const id = info.split(':')[1].trim();
            console.log("esto es el ID: " + id);
            fetch(`/JavaWebTienda22/EliminarHum?id=${encodeURIComponent(id)}`)
                .then(response => response.text())
                .then(data => {
                    console.log("Decicion: "+data);
                    if (data == "ok") {
                        alert("Se elimino el objeto");
                        contenedor.remove();  // Remueve directamente el contenedor
                    } else {
                        alert("Error al eliminar");
                    }
                })
                .catch(error => console.error('Error:', error));
        });
    });

    // ------------------Buscador
    const buscador = document.getElementById('barraBuscador');
    if (buscador) {
        buscador.addEventListener('input', function () {
            const textoBuscado = this.value.trim().toLowerCase();
            const divsBuscar = document.querySelectorAll('.ContenerdExt');

            divsBuscar.forEach(div => {
                const elimDiv= div.querySelector('.InformacionRegistro');
                const p = div.querySelector('.InformacionRegistro p');

                if (p) {
                    const contenido = p.textContent.trim().toLowerCase();

                    if (contenido.includes(textoBuscado)) {
                        div.style.display = '';
                    } else {
                        div.style.display = 'none';
                    }
                }
            });
        });
    } else {
        console.error('No se encontró el input #barraBuscador');
    }
});

    
