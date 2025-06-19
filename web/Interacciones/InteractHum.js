    const divs = document.querySelectorAll('#registroConHumedad .InformacionRegistro');
    console.log("HOlaa");

    divs.forEach(div => {
        div.addEventListener('click', () => {
            console.log("hola");
            console.log('Click en:', div.textContent);
            const idText = div.querySelector('p').textContent;
            const id = idText.split(':')[1].trim();
            console.log("esto"+id);
            fetch(`/JavaWebTienda22/EdicionHum?id=${encodeURIComponent(id)}`)
                .then(response => response.json())
                .then(data => {
                    console.log(data);
                })
                .catch(error => console.error('Error:', error));
        });
    });
