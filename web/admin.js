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

var divInicial = "administrador";
function DinamicoDiv(divActual) {
    document.getElementById(divActual).style.display = 'block';
    if (divInicial != divActual) {
        document.getElementById(divInicial).style.display = 'none';
    }
    divInicial = divActual;
}

function buscarOpcionMAdministrador() {
    creartObjeto();
    MAdministradorPlanNut();
}
function MAdministradorPlanNut() {
    xhr.open("get", "MAdminRegistrarPlanNut?", true);
    xhr.onreadystatechange = verificaDetallem;
    xhr.send(null);
}



function buscarOpcionMAdministrador1() {
    creartObjeto();
    MAdministradorPlanNut1();
}
function MAdministradorPlanNut1() {
    var nom = document.getElementById("nom").value;
    var desc = document.getElementById("desc").value;
    var dura = document.getElementById("dura").value;
    var cos = document.getElementById("cos").value;
    xhr.open("POST", "MAdminGuardaPlanNut?nom=" + nom + "&desc=" + desc + "&dura=" + dura + "&cos=" + cos, true);
    xhr.onreadystatechange = verificaDetalle1m;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send("nom=" + nom + "&desc=" + desc + "&dura=" + dura + "&cos=" + cos);
}


function buscarOpcionMAdministrador2() {
    creartObjeto();
    MAdministradorPlanNut2();
}
function MAdministradorPlanNut2() {
    xhr.open("get", "MAdminVerPlanNut?", true);
    xhr.onreadystatechange = verificaDetallem;
    xhr.send(null);
}


function buscarOpcionMAdministrador3(edi) {
    creartObjeto();
    MAdministradorPlanNut3(edi);
}
function MAdministradorPlanNut3(edi) {
    xhr.open("get", "MAdminActialiPlanNut?edi="+edi, true);
    xhr.onreadystatechange = verificaDetallem;
    xhr.send(null);
}


function buscarOpcionMAdministrador4() {
    creartObjeto();
    MAdministradorPlanNut4();
}
function MAdministradorPlanNut4() {
    var idPlanN = document.getElementById("idPlanN").value;
    var nom = document.getElementById("nom").value;
    var desc = document.getElementById("desc").value;
    var dura = document.getElementById("dura").value;
    var cos = document.getElementById("cos").value;
    xhr.open("POST", "MAdminActualizarPlanNut?idPlanN=" + idPlanN + "&nom=" + nom + "&desc=" + desc + "&dura=" + dura + "&cos=" + cos, true);
    xhr.onreadystatechange = verificaDetalle1m;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send("nom=" + nom + "&desc=" + desc + "&dura=" + dura + "&cos=" + cos);
}


function buscarOpcionMAdministradorSub() {
    creartObjeto();
    MAdministradorSubirArch();
}
function MAdministradorSubirArch() {
    xhr.open("get", "MAdminSubirArchivosAlim?", true);
    xhr.onreadystatechange = verificaDetallem;
    xhr.send(null);
}


function buscarOpcionMAdministradorSub1() {
    creartObjeto();
    MAdministradorSubirArch1();
}
function MAdministradorSubirArch1() {
    xhr.open("get", "MAdminSubirArchivosAlim2?", true);
    xhr.onreadystatechange = verificaDetalle1m;
    xhr.send(null);
}
function buscarOpcionMAdministradorSub2() {
    creartObjeto();
    MAdministradorSubirArch2();
}
function MAdministradorSubirArch2() {
    xhr.open("get", "MAdminSubirArchivosAlim22?", true);
    xhr.onreadystatechange = verificaDetalle1m;
    xhr.send(null);
}



function buscarOpcionMAdministradorSub3() {
    creartObjeto();
    MAdministradorSubirArch3();
}
function MAdministradorSubirArch3() {
    var cat = document.getElementById("cat").value;
    var alim = document.getElementById("alim").value;
    var gram = document.getElementById("gram").value;
    var calo = document.getElementById("calo").value;
    xhr.open("get", "MAdminSubirArchivosAlim3?cat=" + cat + "&alim=" + alim + "&gram=" + gram + "&calo=" + calo, true);
    xhr.onreadystatechange = verificaDetalle11m;
    xhr.send(null);
}


function buscarOpcionMAdministradorSub33() {
    creartObjeto();
    MAdministradorSubirArch33();
}
function MAdministradorSubirArch33() {
    var cat = document.getElementById("cat").value;
    var alim = document.getElementById("alim").value;
    var gram = document.getElementById("gram").value;
    var calo = document.getElementById("calo").value;
    xhr.open("post", "MAdminSubirArchivosAlim33?cat=" + cat + "&alim=" + alim + "&gram=" + gram + "&calo=" + calo, true);
    xhr.onreadystatechange = verificaDetalle11m;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send("cat=" + cat + "&alim=" + alim + "&gram=" + gram + "&calo=" + calo);
}


function buscarOpcionMAdministradorSubNuevaCat() {
    creartObjeto();
    MAdministradorSubNuevaCat();
}
function MAdministradorSubNuevaCat() {
    var cat = document.getElementById("cat").value;
    xhr.open("POST", "MAdminSubNuevaCat?cat=" + cat, true);
    xhr.onreadystatechange = verificaDetalle1m;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send("cat=" + cat);
}


function buscarOpcionMAdminGanancias() {
    creartObjeto();
    MAdministradorGanancias();
}
function MAdministradorGanancias() {
    xhr.open("get", "MAdminVerGananciasA?", true);
    xhr.onreadystatechange = verificaDetallem;
    xhr.send(null);
}




function verificaDetallem() {
    if (xhr.readyState == 4) {
        document.getElementById("inicioAd").innerHTML = "<em>" + xhr.responseText + "</em>";
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

function verificaDetalle111m() {
    if (xhr.readyState == 4) {
        document.getElementById("mensaje11").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function verificaDetalle2m() {
    if (xhr.readyState == 4) {
        document.getElementById("detalle1").innerHTML = "<em>" + xhr.responseText + "</em>";
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


