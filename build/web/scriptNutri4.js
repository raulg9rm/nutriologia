/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



var xhr;
function creartObjeto() {
    if (window.ActiveXObject) {
        xhr = new ActiveXObject("Microsoft.XMLHttp");
    } else if ((window.XMLHttpRequest) || (typeof XMLHttpRequest) != undefined) {
        xhr = new XMLHttpRequest();
    } else {
        alert("Su navegador no soporta AJAX");
        return;
    }
}
var divInicial="inicioNu";

    function DinamicoDiv(divActual){
        document.getElementById(divActual).style.display= 'block';
        
        if(divInicial != divActual){
            document.getElementById(divInicial).style.display='none';
        }
        divInicial = divActual;
        
    }
    
    function calcularIMC(){
        creartObjeto();
        enviapeticion();
        
    }
    
    function enviapeticion(){
        var kg=document.getElementById("kilos").value;
        var mt=document.getElementById("metros").value;
        
        xhr.open("get","ServRCalcularIMC?kil="+kg+"&metr="+mt,true);
        xhr.onreadystatechange=verificaDetalleimc;
        xhr.send(null);
    }

    
    function verificaDetalleimc(){
        if(xhr.readyState==4){
            document.getElementById("indice").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    function buscarOpcionMNutri() {
    creartObjeto();
    MNutriPlanDieta();
}
function MNutriPlanDieta() {
    xhr.open("get", "MNutriPlanDieta?", true);
    xhr.onreadystatechange = verificaDetalle2m;
    xhr.send(null);
}


function buscarOpcionMNutri1() {
    creartObjeto();
   MNutri1();
}
function MNutri1() {
    var nom = document.getElementById("nom").value;
    //var desc = document.getElementById("foto").value;
    var tipo = document.getElementById("tipoD");
    var tipoD = tipo.options[tipo.selectedIndex].value;
    var desc = document.getElementById("desc").value;
    var dura = document.getElementById("dura").value;
    var cos = document.getElementById("cos").value;
    xhr.open("post", "MNutriPlanDieta1?nom=" + nom +"&tipoD="+tipoD+ "&desc=" + desc + "&dura=" + dura + "&cos="+cos, true);
    xhr.onreadystatechange = verificaDetalle1m;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send("nom=" + nom + "&desc=" + desc + "&dura=" + dura + "&cos=" + cos);
}


function buscarOpcionMNutriEditarPlanDieta() {
    creartObjeto();
    MNutriEditarPlanDieta();
}
function MNutriEditarPlanDieta() {
    xhr.open("get", "MNutriEditarPlanDieta", true);
    xhr.onreadystatechange = verificaDetalle2m;
    xhr.send(null);
}

function buscarOpcionMNutriEditarPlanDieta2(edi) {
    creartObjeto();
   MNutriEditarPlanDieta2(edi);
}
function MNutriEditarPlanDieta2(edi) {
    xhr.open("post", "MNutriEditarPlanDieta2?edi=" + edi, true);
    xhr.onreadystatechange = verificaDetalle2m;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send("edi=" + edi);
}


function buscarOpcionMNutriEditarPlanDieta3() {
    creartObjeto();
   MNutriEditarPlanDieta3();
}
function MNutriEditarPlanDieta3() {
    var idDieta = document.getElementById("idDieta").value;
    var nom = document.getElementById("nom").value;
    //var foto= document.getElementById("foto").value;
    var tipo = document.getElementById("tipoD");
    var tipoD = tipo.options[tipo.selectedIndex].value;
    var desc = document.getElementById("desc").value;
    var dura = document.getElementById("dura").value;
    var cos = document.getElementById("cos").value;
    xhr.open("post", "MNutriEditarPlanDieta3?idDieta="+idDieta+"&nom=" + nom +"&tipoD="+tipoD+ "&desc=" + desc + "&dura=" + dura + "&cos="+cos, true);
    xhr.onreadystatechange = verificaDetalle1m;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send("idDieta="+idDieta+"&nom=" + nom + "&desc=" + desc + "&dura=" + dura + "&cos=" + cos);
}



function buscarOpcionMNutriVerHis() {
    creartObjeto();
    MNutriVerHis();
}
function MNutriVerHis() {
    xhr.open("get", "MNutriVerHist", true);
    xhr.onreadystatechange = verificaDetalleM1;
    xhr.send(null);
}

function verificaDetalleM1() {
    if (xhr.readyState == 4) {
        document.getElementById("men").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}


function buscarOpcionMNutriVerHis2(id) {
    creartObjeto();
   MNutriVerHis2(id);
}
function MNutriVerHis2(id) {
    //alert(id);
    xhr.open("post", "MNutriVerHis2?idNot=" + id, true);
    xhr.onreadystatechange = verificaDetalleMk1;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send("idNot=" + id);
}

function verificaDetalleMk1() {
    if (xhr.readyState == 4) {
        document.getElementById("men").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}


function buscarOpcionMNutriComprarPlan() {
    creartObjeto();
    MNutriComprarPlan();
}
function MNutriComprarPlan() {
    xhr.open("get", "MNutriComprarPlan", true);
    xhr.onreadystatechange = verificaDetalle2m;
    xhr.send(null);
}


function buscarOpcionMNutriComprarPlan2(com) {
    creartObjeto();
    MNutriComprarPlan2(com);
}
function MNutriComprarPlan2(com) {
    xhr.open("get", "MNutriComprarPlan2?com="+com, true);
    xhr.onreadystatechange = verificaDetalle2m;
    xhr.send(null);
}

function buscarOpcionMNutriComprarPlan3(com) {
    creartObjeto();
    MNutriComprarPlan3(com);
}
function MNutriComprarPlan3(com) {
    
    xhr.open("get","MNutriComprarPlan3?com="+com, true);
    xhr.onreadystatechange = verificaDetalleCm;
    xhr.send(null);
}
function verificaDetalleCm() {
    if (xhr.readyState == 4) {
        document.getElementById("mens").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}


function buscarOpcionMNutriComprarPlan4(id) {
    creartObjeto();
    MNutriComprarPlan4(id);
}
function MNutriComprarPlan4(id) {
    xhr.open("get", "MNutriComprarPlan4?id="+id, true);
    xhr.onreadystatechange = verificaDetalleC11m;
    xhr.send(null);
}
function verificaDetalleC11m() {
    if (xhr.readyState == 4) {
        document.getElementById("m").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function buscarOpcionMNutriEnviarApoyo() {
    creartObjeto();
    MNutriEnviarApoyo();
}
function MNutriEnviarApoyo() {
    xhr.open("get", "MNutriEnviarApoyo", true);
    xhr.onreadystatechange = verificaDetalle2m;
    xhr.send(null);
}


function buscarOpcionMNutriEnviarApoyo2(nombreP) {
    creartObjeto();
    MNutriEnviarApoyo2(nombreP);
}
function MNutriEnviarApoyo2(nombreP) {
    xhr.open("get", "MNutriEnviarApoyo2?usuarioPaciente="+nombreP, true);
    xhr.onreadystatechange = verificaDetalle112m;
    xhr.send(null);
}


function buscarOpcionMNutriEnviarApoyo3(id,ced) {
    creartObjeto();
    MNutriEnviarApoyo3(id,ced);
}
function MNutriEnviarApoyo3(id,ced) {
    var mensaje = document.getElementById("men").value;
    xhr.open("get", "MNutriEnviarApoyo3?id="+id+"&ced="+ced+"&mensaje="+mensaje, true);
    xhr.onreadystatechange = verificaDetalle111m;
    xhr.send(null);
}


function buscarOpcionMNutriEnviarApoyo4(id,ced) {
    creartObjeto();
    MNutriEnviarApoyo4(id,ced);
}
function MNutriEnviarApoyo4(id,ced) {
    var mensaje = document.getElementById("men").value;
    xhr.open("get", "MNutriEnviarApoyo4?id="+id+"&ced="+ced+"&mensaje="+mensaje, true);
    xhr.onreadystatechange = verificaDetalle111m;
    xhr.send(null);
}


function verMensajesApoyo()
{
    xhr.open("GET", "verMensajesApoyo", true);
    xhr.onreadystatechange = verificaDetalle34m;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalle34m() {
    if (xhr.readyState == 4) {
        document.getElementById("MensajeRecibidosPaciente").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}


function buscarOpcionMUsuRecordarCita()
{
    xhr.open("GET", "MUsuRecordarCita", true);
    xhr.onreadystatechange = verificaDetalle34m;
    xhr.send(null);
}

function buscarOpcionMNutriSubirDieta(idNot) {
    creartObjeto();
   MNutriSubirDieta(idNot);
}
function MNutriSubirDieta(idNot) {
    xhr.open("get", "MNutriSubirDieta?idNot="+idNot, true);
    xhr.onreadystatechange = verificaDetalleMM1;
    xhr.send(null);
}
function verificaDetalleMM1() {
    if (xhr.readyState == 4) {
        document.getElementById("mm").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}


function buscarOpcionMNutriSubirDieta2(idNot,idDi) {
    creartObjeto();
   MNutriSubirDieta2(idNot,idDi);
}
function MNutriSubirDieta2(idNot,idDi) {
    var tipo2 = document.getElementById("tipoc");
    var tipoc = tipo2.options[tipo2.selectedIndex].value;
    var tipo1 = document.getElementById("cat1");
    var cat1 = tipo1.options[tipo1.selectedIndex].value;
    xhr.open("get", "MNutriSubirDieta2?idDi="+idDi+"&tipoc="+tipoc+"&cat1="+cat1+"&idNot="+idNot, true);
    xhr.onreadystatechange = verificaDetalle1m;
    xhr.send(null);
}


function buscarOpcionMNutriSubirDieta3(idNot,idDi,tipoc) {
    creartObjeto();
   MNutriSubirDieta3(idNot,idDi,tipoc);
}
function MNutriSubirDieta3(idNot,idDi,tipoc) {
    creartObjeto();
    alert(idNot+" "+idDi+" "+tipoc);
    var fecha = document.getElementById("fecha").value;
    var tipo1 = document.getElementById("alim1");
    var alim1 = tipo1.options[tipo1.selectedIndex].value;
    xhr.open("get", "MNutriSubirDieta3?idNot="+idNot+"&idDi="+idDi+"&tipoc="+tipoc+"&alim1="+alim1+"&fecha="+fecha, true);
    xhr.onreadystatechange = verificaDetalleM2m;
    xhr.send(null);
}
function verificaDetalleM2m() {
    if (xhr.readyState == 4) {
        document.getElementById("me").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}


function buscarOpcionMNutriSubirDieta4() {
    creartObjeto();
   MNutriSubirDieta4();
}
function MNutriSubirDieta4() {
    var dieta = document.getElementById("dieta").value;
    var tipoc = document.getElementById("tipoc").value;
    var tipo1 = document.getElementById("alim1");
    var alim1 = tipo1.options[tipo1.selectedIndex].value;
    xhr.open("get", "MNutriSubirDieta4?dieta="+dieta+"&tipoc="+tipoc+"&alim1="+alim1, true);
    xhr.onreadystatechange = verificaDetalle2m;
    xhr.send(null);
}

function buscarOpcionMNutriSubirDieta5(dieta) {
    creartObjeto();
   MNutriSubirDieta5(dieta);
}
function MNutriSubirDieta5(dieta) {
    var fi = document.getElementById("fi").value;
    var ft = document.getElementById("ft").value;
    xhr.open("get", "MNutriSubirDieta5?fi="+fi+"&ft="+ft+"&dieta="+dieta, true);
    xhr.onreadystatechange = verificaDetalle1m;
    xhr.send(null);
}


function buscarOpcionMNutriGanancias() {
    creartObjeto();
    MNutriGanancias();
}
function MNutriGanancias() {
    xhr.open("get","MNutriGanancias", true);
    xhr.onreadystatechange = verificaDetalle2m;
    xhr.send(null);
}

function verificaDetallem() {
    if (xhr.readyState == 4) {
        document.getElementById("detalle").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function verificaDetalle1m() {
    if (xhr.readyState == 4) {
        document.getElementById("mensaje").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function verificaDetalle11m() {
    if (xhr.readyState == 4) {
        document.getElementById("mensaje1").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}
function verificaDetalle112m() {
    if (xhr.readyState == 4) {
        document.getElementById("mensajes").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}


function verificaDetalle111m() {
    if (xhr.readyState == 4) {
        document.getElementById("mensaje11").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}
function verificaDetalle1111m() {
    if (xhr.readyState == 4) {
        document.getElementById("mensaje111").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function verificaDetalle2m() {
    if (xhr.readyState == 4) {
        document.getElementById("inicioNu").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function verificaDetalle3m() {
    if (xhr.readyState == 4) {
        document.getElementById("detalle2").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function verificaDetalle4m() {
    if (xhr.readyState == 4) {
        document.getElementById("detalle3").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}


function registraRYC()
{
    creartObjeto();
    registrarRYC();
}

function registrarRYC()
{
    xhr.open("GET", "servRegistroRYC", true);
    xhr.onreadystatechange = verificaDetalle1;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalle1() {
    if (xhr.readyState == 4) {
        document.getElementById("inicioNu").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function RegresarValoresRYC()
{
    creartObjeto();
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
             
        xhr.open("GET", "servRegistroRYC1?est=" + est + "&titulo=" + titulo
                + "&descripcion=" + descripcion, true);
        xhr.onreadystatechange = verificaDetalle2;
        xhr.send(null);
   
    } else {

        var titulo = document.getElementById("titulo").value;
        var est = document.getElementById("consejo").value;
        var descripcion = document.getElementById("descripcion").value;
        xhr.open("GET", "servRegistroRYC1?est=" + est + "&titulo=" + titulo
                + "&descripcion=" + descripcion, true);
        xhr.onreadystatechange = verificaDetalle2;
        xhr.send(null);

    }
}
function verificaDetalle2() {
    if (xhr.readyState == 4) {
        document.getElementById("registro").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}


function RegresarValoresHistoria()
{
    creartObjeto();
    RegresarValoresServHistoria();

}

function RegresarValoresServHistoria()
{
    //alert("que onda");

    var titulo = document.getElementById("titulo").value;
    var descripcion = document.getElementById("descripcion").value;
  //  alert(titulo + " " + descripcion);
    xhr.open("GET", "servRegistroHistoriasExito1?titulo=" + titulo
            + "&descripcion=" + descripcion, true);
    xhr.onreadystatechange = verificaDetalle4;
    xhr.send(null);

}
function verificaDetalle4() {
    if (xhr.readyState == 4) {
        document.getElementById("registroHistoria").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}




function verNutriologos() {
    creartObjeto();
    verNutriologoServ();
}

function verNutriologoServ()
{
    xhr.open("GET", "servVerPerfilNutriologos", true);
    xhr.onreadystatechange = verificaDetalle7;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalle7() {
    if (xhr.readyState == 4) {
        document.getElementById("consulta").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}






function enviarMensajes(){
    creartObjeto();
    enviarMensajesServ();
}

function enviarMensajesServ()
{
    xhr.open("GET", "servEnviarMensaje", true);
    xhr.onreadystatechange = verificaDetalle18;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalle18() {
    if (xhr.readyState == 4) {
        document.getElementById("mensajespaciente").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function enviarMensajesServ1(id_paciente, cedula)
{
    creartObjeto();

    var asunto = document.getElementById("asunto").value;
    var mensaje = document.getElementById("mensaje").value;
    //alert("id= " + id_paciente + " ced= " + cedula + " asu= " + asunto + " men= " + mensaje);
    xhr.open("GET", "servEnviarMensaje1?id_paciente=" + id_paciente 
            + "&cedula=" + cedula + "&asunto=" + asunto + "&mensaje=" + mensaje, true);
    xhr.onreadystatechange = verificaDetalle19;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalle19() {
    if (xhr.readyState == 4) {
        document.getElementById("EnviarMensaje").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}



function verMensajesServ1(id_mensaje)
{
    creartObjeto();
    //alert(id_mensaje);
    xhr.open("GET", "servVerMensajesEnviados1?id_mensaje=" + id_mensaje, true);
    xhr.onreadystatechange = verificaDetalle21;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalle21() {
    if (xhr.readyState == 4) {
        document.getElementById("consulta").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
   
}

function enviarMensajesNutrio(){
    creartObjeto();
    enviarMensajesNutrioServ();
}

function enviarMensajesNutrioServ()
{
    xhr.open("GET", "servEnviarMensajeNutrio", true);
    xhr.onreadystatechange = verificaDetalle22;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalle22() {
    if (xhr.readyState == 4) {
        document.getElementById("mensajes").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function enviarMensajesNutrioServ1()
{
    creartObjeto();
    var usuario = document.getElementById("usuarioPaciente");
    var usuarioPaciente = usuario.options[usuario.selectedIndex].value;
    xhr.open("GET", "ServBotonesMnesajeNutri?usuarioPaciente=" + usuarioPaciente, true);
    xhr.onreadystatechange = verificaDetalle23;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
    
}

function verificaDetalle23() {
    if (xhr.readyState == 4) {
        document.getElementById("MensajeNutrio").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function enviarMensajesNormal(usupa)
{
    creartObjeto();
    
    
    xhr.open("GET", "servEnviarMensajeNutrio1?usuarioPaciente=" + usupa, true);
    xhr.onreadystatechange = verificaDetalle233;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalle233() {
    if (xhr.readyState == 4) {
        document.getElementById("mensajes").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function enviarMensajesNutrioServ2(id_paciente, cedula)
{
    creartObjeto();
    var asunto = document.getElementById("asunto").value;
    var mensaje = document.getElementById("mensaje").value;
    //alert("id= " + id_paciente + " ced= " + cedula + " asu= " + asunto + " men= " + mensaje);
    xhr.open("GET", "servEnviarMensajeNutrio2?id_paciente=" + id_paciente 
            + "&cedula=" + cedula + "&asunto=" + asunto + "&mensaje=" + mensaje, true);
    xhr.onreadystatechange = verificaDetalle24;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalle24() {
    if (xhr.readyState == 4) {
        document.getElementById("EnviarMensajeNutrio").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function verMensajesNutrio(){
    creartObjeto();
    verMensajesNutrioServ();
}

function verMensajesNutrioServ()
{
    xhr.open("GET", "servVerMensajesEnviadosNutrio", true);
    xhr.onreadystatechange = verificaDetalle25;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalle25() {
    if (xhr.readyState == 4) {
        document.getElementById("mensajes").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function verMensajesServNutrio1(id_mensaje)
{
    creartObjeto();
    //alert(id_mensaje);
    xhr.open("GET", "servVerMensajesEnviadosNutrio1?id_mensaje=" + id_mensaje, true);
    xhr.onreadystatechange = verificaDetalle26;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalle26() {
    if (xhr.readyState == 4) {
        document.getElementById("mensajes").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function verMensajesRecibidosNutrio(){
    creartObjeto();
    verMensajesRecibidosNutrioServ();
}

function verMensajesRecibidosNutrioServ()
{
    //alert("buu");
    xhr.open("GET", "servVerMensajesRecibidosNutriologo", true);
    xhr.onreadystatechange = verificaDetalle27;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalle27() {
    if (xhr.readyState == 4) {
        document.getElementById("mensajes").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function verMensajesRecibidosNutrioServ1()
{
    //alert("buu");
    xhr.open("GET", "servVerMensajesRecividosNutrio", true);
    xhr.onreadystatechange = verificaDetalle28;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalle28() {
    if (xhr.readyState == 4) {
        document.getElementById("MensajeRecibidosNutriologo").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function verMensajesRecibidosNutrioServ2(id_mensaje)
{
    creartObjeto();
    //alert(id_mensaje);
    xhr.open("GET", "servVerMensajesRecividosNutrio1?id_mensaje=" + id_mensaje, true);
    xhr.onreadystatechange = verificaDetalle29;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalle29() {
    if (xhr.readyState == 4) {
        document.getElementById("mensajes").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function verMensajesRecibidosNutrioServ3()
{
    //alert("buu");
    xhr.open("GET", "servVerMensajesRecibidosNutrio2", true);
    xhr.onreadystatechange = verificaDetalle30;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalle30() {
    if (xhr.readyState == 4) {
        document.getElementById("MensajeRecibidosNutriologo").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}



function recomendarAmigo(){
    creartObjeto();
    recomendarAmigoServ();
}

function recomendarAmigoServ()
{
    //alert("buu");
    xhr.open("GET", "servRecomandarAmigo", true);
    xhr.onreadystatechange = verificaDetalle35;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalle35() {
    if (xhr.readyState == 4) {
        document.getElementById("consulta").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function recomendarAmigoServ1()
{
    //alert("buu");
    var  para = document.getElementById("para").value;
    var  asunto = document.getElementById("asunto").value;
    var  mensaje = document.getElementById("mensaje").value;
    alert(para + asunto + mensaje);
    xhr.open("GET", "servRecomandarAmigo1?para=" + para + "&asunto="+ asunto + "&mensaje=" + mensaje, true);
    xhr.onreadystatechange = verificaDetalle36;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalle36() {
    if (xhr.readyState == 4) {
        document.getElementById("consulta").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}




function buscarNotificaciones() {
    creartObjeto();
    //alert();
    peticionNotificaciones();
}
function peticionNotificaciones() {
    xhr.open("get", "ServNotificacionesNutri", true);
    xhr.onreadystatechange = verificaDetalleNotificaciones;
    xhr.send(null);
}

function verificaDetalleNotificaciones() {
    if (xhr.readyState == 4) {
        document.getElementById("mensajes").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}


function verNotificacionesNutri(id) {
    creartObjeto();
    //alert(id);
    peticionNotificacionesNutri(id);
}
function peticionNotificacionesNutri(id) {
    xhr.open("get", "ServNotificacionesNutri2?not=" + id, true);
    xhr.onreadystatechange = verificaDetalleNotificacionesNutri;
    xhr.send(null);
}

function verificaDetalleNotificacionesNutri() {
    if (xhr.readyState == 4) {
        document.getElementById("notleida").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}



function actPerfilNutri() {
    creartObjeto();
    //alert();
    peticionactPerfilNutri();
}
function peticionactPerfilNutri() {
    xhr.open("get", "ServActRDatosNutriologo", true);
    xhr.onreadystatechange = verificaDetalleactPerfilNutri;
    xhr.send(null);
}

function verificaDetalleactPerfilNutri() {
    if (xhr.readyState == 4) {
        document.getElementById("inicioNu").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}



function actPerfilNutri2() {
    creartObjeto();
    //alert();
    peticionactPerfilNutri2();
}
function peticionactPerfilNutri2() {
    var cuenta=document.getElementById("tar").value;
            
            var colonia=document.getElementById("col10").value;
            var calle=document.getElementById("call10").value;
            var casa=document.getElementById("cas10").value;
            var descrip=document.getElementById("desc10").value;
            
            var phot=document.getElementById("fileFoto10").value;
    
    xhr.open("get", "ServActRDatosNutriologo2?cuenta="+cuenta+"&fileFoto="+phot+"&col="+colonia+"&calle="+calle+"&cas="+casa+"&desc="+descrip,true);
    xhr.onreadystatechange = verificaDetalleactPerfilNutri2;
    xhr.send(null);
}

function verificaDetalleactPerfilNutri2() {
    if (xhr.readyState == 4) {
        document.getElementById("actuNutri").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}



function actPerfilNutriStatus() {
    creartObjeto();
    //alert();
    peticionactPerfilNutriStatus();
}
function peticionactPerfilNutriStatus() {
    xhr.open("get", "ServActRDatosNutriologo", true);
    xhr.onreadystatechange = verificaDetalleactPerfilNutriStatus;
    xhr.send(null);
}

function verificaDetalleactPerfilNutriStatus() {
    if (xhr.readyState == 4) {
        document.getElementById("inicioNu").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}


function boletinN()
{
    creartObjeto();
    boletinServ();
}

function boletinServ()
{
    xhr.open("GET", "servBoletin", true);
    xhr.onreadystatechange = verificaDetalleDan1;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalleDan1() {
    if (xhr.readyState == 4) {
        document.getElementById("inicioNu").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}











