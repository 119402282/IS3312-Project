let id = 'login';
let urlPattern = 'fetchme';

const app = (inputs) => {
    alert(inputs);

}

const form = document.getElementById(id);

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
    const {message} = await response.json();
    return message;
};

const encodeURI = (message) => new URLSearchParams(message).toString();

