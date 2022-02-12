let id = 'login';
let urlPattern = 'loginServlet';
let toast = document.getElementById('toast-output');
let alertA = document.getElementsByClassName('alert')[1];
const app = (input) => {
    let {correct, email, name, type} = input;
    if(correct){
        let output = `Hi ${name==="null"? email : name}!\nYou are currently logged in as an ${type.toLowerCase()}. \nWe are redirecting you to ${type === 'USER'? 'the product page.': 'your admin homepage.'}`;
        toast.innerHTML = output;
        alertA.classList.toggle('show');
        setTimeout(function() {
            alertA.classList.toggle('show');
            window.location.replace(type==="USER"? "./boots.jsp": type ==="ADMIN" ? "./admin.jsp": "./error-page.jsp");
        }, 1500);
    } else {
        let output = 'Incorrect login details.';
        toast.innerHTML = output;
        alertA.classList.toggle('show');
        setTimeout(function() {
            alertA.classList.toggle('show');
        }, 2300);
    }
}

const form = document.getElementById(id);

form.onreset = (event) => {
    event.preventDefault();
};


form.onsubmit = (event) => {
    event.preventDefault();
    let data = new FormData(form);
    postHTTP(data, urlPattern).then( message => {
        app(message);
    });
};
    
const postHTTP = async (content, urlPattern) => {
    const response = await fetch(`./${urlPattern}`, {
            method: 'POST', // or 'PUT'
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: encodeURI(content)
        });
    const message = await response.json();
    return message;
};

const encodeURI = (message) => new URLSearchParams(message).toString();

