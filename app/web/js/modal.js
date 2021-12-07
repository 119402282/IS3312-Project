let btn = document.getElementById('btn-login');
let btnCancel = document.getElementById('cancel');
let modal = document.getElementById('modal');

btn.onclick = () => {
    modal.classList.toggle('modalGrid');
    const current = document.querySelector('nav a[href="javascript:void"]');
    current.classList.toggle('current');
};

btnCancel.onclick= () => {
    modal.classList.toggle('modalGrid');
    const current = document.querySelector('nav a[href="javascript:void"]');
    current.classList.toggle('current');
};