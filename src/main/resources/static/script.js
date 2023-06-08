var loginbtn = document.getElementById("iniciar-sesion-btn");
var signupbtn = document.getElementById("crear-cuenta-btn");

var loginForm = document.getElementById("iniciar-sesion");
var signupForm = document.getElementById("crear-cuenta");

function signup() {
    signupForm.style.display = "block";
	loginForm.style.display = "none";
}

function login() {
    loginForm.style.display = "block";
	signupForm.style.display = "none";
}
  