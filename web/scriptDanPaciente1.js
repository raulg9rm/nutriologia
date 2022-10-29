/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var xht;

function crearObjeto() {

    if (window.ActiveXObject) {
        xht = new ActiveXObject("Microsoft.XMLHttp");
    } else if ((window.ActiveXObject) || (typeof XMLHttpRequest) != undefined) {
        xht = new XMLHttpRequest();
    } else {
        alert("SU NAVEGADOR NO SOPORTA AJAX");
        return;
    }
}

function registraRYC()
{
    crearObjeto();
    registrarRYC();
}

function registrarRYC()
{
    xht.open("GET", "servRegistroRYC", true);
    xht.onreadystatechange = verificaDetalle1;
    xht.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xht.send(null);
}

function verificaDetalle1() {
    if (xht.readyState == 4) {
        document.getElementById("inicioNu").innerHTML = "<em>" + xht.responseText + "</em>";
    }
}

function RegresarValoresRYC()
{
    crearObjeto();
    RegresarValoresServ();

}

function RegresarValoresServ()
{
    //alert("que onda");
    estado1 = document.getElementById("receta").checked;
    estado2 = document.getElementById("consejo").checked;

    if (estado1) {

        var titulo = document.getElementById("titulo").value;
        var est = document.getElementById("receta").value;
        var descripcion = document.getElementById("descripcion").value; 
             
        xht.open("GET", "servRegistroRYC1?est=" + est + "&titulo=" + titulo
                + "&descripcion=" + descripcion, true);
        xht.onreadystatechange = verificaDetalle2;
        xht.send(null);
   
    } else {

        var titulo = document.getElementById("titulo").value;
        var est = document.getElementById("consejo").value;
        var descripcion = document.getElementById("descripcion").value;
        xht.open("GET", "servRegistroRYC1?est=" + est + "&titulo=" + titulo
                + "&descripcion=" + descripcion, true);
        xht.onreadystatechange = verificaDetalle2;
        xht.send(null);

    }
}
function verificaDetalle2() {
    if (xht.readyState == 4) {
        document.getElementById("registro").innerHTML = "<em>" + xht.responseText + "</em>";
    }
}

function registraHistoria() {
    crearObjeto();
    registrarHistoriasExito();
}

function registrarHistoriasExito()
{
    xht.open("GET", "servRegistroHistoriasExito", true);
    xht.onreadystatechange = verificaDetalle3;
    xht.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xht.send(null);
}

function verificaDetalle3() {
    if (xht.readyState == 4) {
        document.getElementById("inicioPa").innerHTML = "<em>" + xht.responseText + "</em>";
    }
}

function RegresarValoresHistoria()
{
    crearObjeto();
    RegresarValoresServHistoria();

}

function RegresarValoresServHistoria()
{
    //alert("que onda");

    var titulo = document.getElementById("titulo").value;
    var descripcion = document.getElementById("descripcion").value;
  //  alert(titulo + " " + descripcion);
    xht.open("GET", "servRegistroHistoriasExito1?titulo=" + titulo
            + "&descripcion=" + descripcion, true);
    xht.onreadystatechange = verificaDetalle4;
    xht.send(null);

}
function verificaDetalle4() {
    if (xht.readyState == 4) {
        document.getElementById("registroHistoria").innerHTML = "<em>" + xht.responseText + "</em>";
    }
}




function verNutriologos() {
    crearObjeto();
    verNutriologoServ();
}

function verNutriologoServ()
{
    xht.open("GET", "servVerPerfilNutriologos", true);
    xht.onreadystatechange = verificaDetalle7;
    xht.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xht.send(null);
}

function verificaDetalle7() {
    if (xht.readyState == 4) {
        document.getElementById("consulta").innerHTML = "<em>" + xht.responseText + "</em>";
    }
}








function enviarMensajes(){
    crearObjeto();
    enviarMensajesServ();
}

function enviarMensajesServ()
{
    xht.open("GET", "servEnviarMensaje", true);
    xht.onreadystatechange = verificaDetalle18;
    xht.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xht.send(null);
}

function verificaDetalle18() {
    if (xht.readyState == 4) {
        document.getElementById("mensajespaciente").innerHTML = "<em>" + xht.responseText + "</em>";
    }
}

function enviarMensajesServ1(id_paciente, cedula)
{
    crearObjeto();

    var asunto = document.getElementById("asunto").value;
    var mensaje = document.getElementById("mensaje").value;
    //alert("id= " + id_paciente + " ced= " + cedula + " asu= " + asunto + " men= " + mensaje);
    xht.open("GET", "servEnviarMensaje1?id_paciente=" + id_paciente 
            + "&cedula=" + cedula + "&asunto=" + asunto + "&mensaje=" + mensaje, true);
    xht.onreadystatechange = verificaDetalle19;
    xht.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xht.send(null);
}

function verificaDetalle19() {
    if (xht.readyState == 4) {
        document.getElementById("EnviarMensaje").innerHTML = "<em>" + xht.responseText + "</em>";
    }
}

function verMensajes(){
    crearObjeto();
    verMensajesServ();
}

function verMensajesServ()
{
    xht.open("GET", "servVerMensajesEnviados", true);
    xht.onreadystatechange = verificaDetalle20;
    xht.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xht.send(null);
}

function verificaDetalle20() {
    if (xht.readyState == 4) {
        document.getElementById("mensajespaciente").innerHTML = "<em>" + xht.responseText + "</em>";
    }
}

function verMensajesServ1(id_mensaje)
{
    crearObjeto();
    //alert(id_mensaje);
    xht.open("GET", "servVerMensajesEnviados1?id_mensaje=" + id_mensaje, true);
    xht.onreadystatechange = verificaDetalle21;
    xht.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xht.send(null);
}

function verificaDetalle21() {
    if (xht.readyState == 4) {
        document.getElementById("mensajespaciente").innerHTML = "<em>" + xht.responseText + "</em>";
    }
   
}






function verMensajesRecibidosPaciente(){
    crearObjeto();
    verMensajesRecibidosPacienteServ();
}

function verMensajesRecibidosPacienteServ()
{
    //alert("buu");
    xht.open("GET", "servVerMensajesRecibidosPaciente", true);
    xht.onreadystatechange = verificaDetalle31;
    xht.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xht.send(null);
}

function verificaDetalle31() {
    if (xht.readyState == 4) {
        document.getElementById("mensajespaciente").innerHTML = "<em>" + xht.responseText + "</em>";
    }
}

function verMensajesRecibidosPacienteServ1()
{
    crearObjeto();
    //alert("buu");
    xht.open("GET", "servVerMensajesRecibidosPaciente1", true);
    xht.onreadystatechange = verificaDetalle32;
    xht.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xht.send(null);
}

function verificaDetalle32() {
    if (xht.readyState == 4) {
        document.getElementById("MensajeRecibidosPaciente").innerHTML = "<em>" + xht.responseText + "</em>";
    }
}

function verMensajesRecibidosPacienteServ2(id_mensaje)
{
    crearObjeto();
    //alert(id_mensaje);
    xht.open("GET", "servVerMensajesRecibidosPaciente2?id_mensaje=" + id_mensaje, true);
    xht.onreadystatechange = verificaDetalle33;
    xht.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xht.send(null);
}

function verificaDetalle33() {
    if (xht.readyState == 4) {
        document.getElementById("mensajespaciente").innerHTML = "<em>" + xht.responseText + "</em>";
    }
}

function verMensajesRecibidosPacienteServ3()
{
    //alert("buu");
    xht.open("GET", "servVerMensajesRecibidosPaciente3", true);
    xht.onreadystatechange = verificaDetalle34;
    xht.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xht.send(null);
}

function verificaDetalle34() {
    if (xht.readyState == 4) {
        document.getElementById("MensajeRecibidosPaciente").innerHTML = "<em>" + xht.responseText + "</em>";
    }
}

function recomendarAmigo(){
    crearObjeto();
    recomendarAmigoServ();
}

function recomendarAmigoServ()
{
    //alert("buu");
    xht.open("GET", "servRecomandarAmigo", true);
    xht.onreadystatechange = verificaDetalle35;
    xht.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xht.send(null);
}

function verificaDetalle35() {
    if (xht.readyState == 4) {
        document.getElementById("consulta").innerHTML = "<em>" + xht.responseText + "</em>";
    }
}

function recomendarAmigoServ1()
{
    //alert("buu");
    var  para = document.getElementById("para").value;
    var  asunto = document.getElementById("asunto").value;
    var  mensaje = document.getElementById("mensaje").value;
    alert(para + asunto + mensaje);
    xht.open("GET", "servRecomandarAmigo1?para=" + para + "&asunto="+ asunto + "&mensaje=" + mensaje, true);
    xht.onreadystatechange = verificaDetalle36;
    xht.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xht.send(null);
}

function verificaDetalle36() {
    if (xht.readyState == 4) {
        document.getElementById("consulta").innerHTML = "<em>" + xht.responseText + "</em>";
    }
}

function boletinP()
{
    crearObjeto();
    boletinServ();
}

function boletinServ()
{
    xht.open("GET", "ServBoletinP", true);
    xht.onreadystatechange = verificaDetalleDan1;
    xht.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xht.send(null);
}

function verificaDetalleDan1() {
    if (xht.readyState == 4) {
        document.getElementById("inicioPa").innerHTML = "<em>" + xht.responseText + "</em>";
    }
}

function recomendarAmigoPA()
{
    crearObjeto();
    recomendarAmigoServDan();
}

function recomendarAmigoServDan()
{
 
    xht.open("GET", "serRecomendarAmigo", true);
    xht.onreadystatechange = verificaDetalled3;
    xht.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xht.send(null);
}

function verificaDetalled3() {
    if (xht.readyState == 4) {
        document.getElementById("inicioPa").innerHTML = "<em>" + xht.responseText + "</em>";
    }   
}

function recomendarAmigo1()
{
    crearObjeto();
    recomendarAmigoServDan1();
}

function recomendarAmigoServDan1()
{
    crearObjeto();
    var correoA = document.getElementById("correoA").value;
    xht.open("GET", "serRecomendarAmigo1?correoA=" + correoA, true);
    xht.onreadystatechange = verificaDetalled4;
    xht.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xht.send(null);
}

function verificaDetalled4() {
    if (xht.readyState == 4) {
        document.getElementById("consulta").innerHTML = "<em>" + xht.responseText + "</em>";
    }
}