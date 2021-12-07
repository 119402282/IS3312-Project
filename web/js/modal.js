let btn = document.getElementById('btn-login');
let btnCancel = document.getElementById('cancel');
let modal = document.getElementById('modal');

btn.onclick = () => {
    modal.classList.toggle('modalGrid');
}

btnCancel.onclick= () => {
    modal.classList.toggle('modalGrid');
}