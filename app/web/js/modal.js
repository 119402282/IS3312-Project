let btn = document.getElementById('btn-login');
let btnCancel = document.getElementById('cancel');
let modal = document.getElementById('modal');
let email = document.getElementById('email');
let pass = document.getElementById('password');
const overlay = document.getElementById('loginOver');

const toggleLoginModal = () => {
    modal.classList.toggle('modalGrid');
    overlay.classList.toggle('show-over');
    btn.classList.toggle('current');
    email.value = "";
    pass.value="";
    
}

btn.onclick =()=> toggleLoginModal();
btnCancel.onclick =()=> toggleLoginModal();
