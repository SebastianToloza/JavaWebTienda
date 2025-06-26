    const divs = document.querySelectorAll('#registroConHumedad .InformacionRegistro');
    const eliminar = document.querySelectorAll('#registroConHumedad .Eliminar');
    divs.forEach(div => {
        div.addEventListener('click', () => {
            console.log('Click en:', div.textContent);
            const idText = div.querySelector('p').textContent;
            const id = idText.split(':')[1].trim();
            console.log("esto es el ID: "+id);
            fetch(`/JavaWebTienda22/EdicionHum?id=${encodeURIComponent(id)}`)
                .then(response => response.json())  
                .then(data => {
                    
                    document.getElementById("id").value = data[0];
                    document.getElementById("entidad").value = data[1];
                    document.getElementById("nvHumedad").value = data[2];
                    document.getElementById("tipHumedad").value = data[3];
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
                        
                        document.querySelectorAll('.Eliminar').forEach(boton => {
                            boton.addEventListener('click', function () {
                                const contenedor = this.closest('.ContenerdExt');
                                contenedor.remove();
                            });
                        });
                    } else {
                        alert("Error al eliminar");
                    }

                })
                .catch(error => console.error('Error:', error));
    });
});
