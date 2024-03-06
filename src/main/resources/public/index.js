function loadGetMsgSin() {
    let x = document.getElementById("x").value;
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("getrespmsg").innerHTML = this.responseText;
        }
    };
    xhttp.open("GET", "http://localhost:4567/sin?id=" + x, true);
    xhttp.send();
}

function loadGetMsgCos() {
    let x = document.getElementById("y").value;
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("getrespmsg2").innerHTML = this.responseText;
        }
    };
    xhttp.open("GET", "http://localhost:4567/cos?id=" + x, true);
    xhttp.send();
}

function loadGetMsgPalindrome() {
    let x = document.getElementById("z").value;
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("getrespmsg3").innerHTML = this.responseText;
        }
    };
    xhttp.open("GET", "http://localhost:4567/palindromo?word=" + x, true);
    xhttp.send();
}

function loadGetMsgMagnitud() {
    let nameVar1 = document.getElementById("x3").value;
    let nameVar2 = document.getElementById("y3").value;
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("getrespmsg4").innerHTML = this.responseText;
        }
    };
    xhttp.open("GET", "http://localhost:4567/magnitud?x=" + nameVar1 + "&y=" + nameVar2, true);
    xhttp.send();
}