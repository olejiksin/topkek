var webSocket;

function connect(id) {

    if (id !== null) {
        webSocket = new WebSocket('ws://localhost:8080/chat');
        webSocket.onmessage = function receiveMessage(response) {
            let data = response['data'];
            let json = JSON.parse(data);
            $('#messagesList').first().after("<li>" + json['from'] + " " + json['text'] + "</li>")
        };
    } else {
        alert("NO ID");
    }
    webSocket.onerror = function errorShow() {
        alert('Ошибка авторизации')
    }
}

function sendMessage(from, text,token) {
    let message = {
        "from": from,
        "text": text,
        "token":token
    };

    webSocket.send(JSON.stringify(message));
}