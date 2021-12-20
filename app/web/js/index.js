let id = 'login';
let urlPattern = 'loginServlet';
let toast = document.getElementById('toast-output');
let alertA = document.getElementsByClassName('alert')[0];
const app = (input) => {
    let {email, type} = input;
    if(type){
        type = type === 'registeredUser'? 'user': 'admin';
        let output = `Hi ${email}!\nYou are currently logged in as an ${type}. \nWe are redirecting you to ${type === 'user'? 'the product page.': 'your admin homepage.'}`;
        toast.innerHTML = output;
        alertA.classList.toggle('show');
        setTimeout(function() {
            alertA.classList.toggle('show');
            window.location.replace(type=="user"? "./boots.jsp":"./admin.jsp");
        }, 2300);
    } else {
        let output = 'Incorrect login details.';
        toast.innerHTML = output;
        alertA.classList.toggle('show');
        setTimeout(function() {
            alertA.classList.toggle('show');
        }, 3000);
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

