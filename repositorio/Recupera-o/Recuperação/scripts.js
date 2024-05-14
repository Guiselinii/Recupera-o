document.addEventListener('DOMContentLoaded', function() { //da prioridade 
    console.log('carregamento do DOM completo')
    const quadrado = document.getElementById('quadrado');
    const iniciar = document.getElementById('Iniciar');
    const parar = document.getElementById('Parar');
    const pausar = document.getElementById('Pausar');
    let animationId;
    let paused = false; 
    let currentPosition;

    iniciar.addEventListener('click', () => { //verifica se o botão foi precionado
        console.log('animação iniciada');
        quadrado.classList.add('animar'); 
        animationId = requestAnimationFrame(startAnimation);
    });

    parar.addEventListener('click', () => {
        console.log('parar animação');
        quadrado.classList.remove('animar');
        quadrado.style.animation = '';
    });

    function startAnimation() {
        console.log('iniciando animação');
        quadrado.style.animation = 'voltar 2s infinite alternate';
    }
    pausar.addEventListener('click', () => {
        console.log('pausar animação');
        
        quadrado.style.animationPlayState = 'paused';//utilizado para parar a animação sem perder sua posição atual 
    });
});