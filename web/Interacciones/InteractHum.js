const divs = document.querySelectorAll('.InformacionRegistro');

divs.forEach(div => {
    div.addEventListener('click', () => {
        console.log('Click en:', div.textContent);
        fetch('/JavaWebTienda22/EdicionHum')
            .then(response => response.json())
            .then(data => {
                console.log(data);
            })
            .catch(error => console.error('Error:', error));
    });
});
