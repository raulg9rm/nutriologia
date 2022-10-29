/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



var divInicial="inicioUs";

    function DinamicoDiv(divActual){
        document.getElementById(divActual).style.display= 'block';
        
        if(divInicial != divActual){
            document.getElementById(divInicial).style.display='none';
        }
        divInicial = divActual;
        
    }


var xhr;


    function creartObjeto(){
        if(window.ActiveXObject){
            xhr=new ActiveXObject("Microsoft.XMLHttp");
        }
        else if((window.XMLHttpRequest) || (typeof XMLHttpRequest)!= undefined){
            xhr=new XMLHttpRequest();
        }
        else{
            alert("Su navegador no soporta AJAX");
            return;
        }
    }



function buscarOpcionMUsuWebCita() {
    creartObjeto();
    MUsuWebCita();
}
function MUsuWebCita() {
    //alert("aqui si");
    xhr.open("get", "MUsuVerNutriAgendar?", true);
    xhr.onreadystatechange = verificaDetalle4m;
    xhr.send(null);
}


function buscarOpcionMUsuWebCitaa(cedula) {
    //alert(cedula);
    creartObjeto();
    MUsuWebCita2m(cedula);
}
function MUsuWebCita2m(cedula) {
    //alert("aqui no");
    xhr.open("get", "MUsuWebCita?cedula="+cedula, true);
    xhr.onreadystatechange = verificaDetalle4m;
    xhr.send(null);
}


function buscarOpcionMUsuWebCita1() {
    creartObjeto();
    MUsuWebCita1();
}
function MUsuWebCita1() {
    var fecha = document.getElementById("fecha").value;
    var hora = document.getElementById("hora").value;
    var ced = document.getElementById("ced").value;
    xhr.open("post", "MUsuWebCita1?fecha=" + fecha + "&hora=" + hora+"&ced="+ced, true);
    xhr.onreadystatechange = verificaDetalle4m;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send("fecha="+fecha+"&hora="+hora+"&ced=" + ced);
    //alert("fecha=  "+fecha+" hora= "+hora+" ced= " + ced);
}


function buscarOpcionMUsuWebCitaAceptar() {
    creartObjeto();
    MUsuWebCitaA();
}
function MUsuWebCitaA() {
    xhr.open("get", "MUsuVerNutriAgendar?", true);
    xhr.onreadystatechange = verificaDetalle4m;
    xhr.send(null);
}

function buscarOpcionMUsuWebCitaCancelar() {
    creartObjeto();
    MUsuWebCita2();
}
function MUsuWebCita2() {
    xhr.open("get", "MUsuWebCitaCancelar?", true);
    xhr.onreadystatechange = verificaDetalle4m;
    xhr.send(null);
}

function buscarOpcionMUsuWebCitaRegresar() {
    creartObjeto();
    MUsuWebCitaR();
}
function MUsuWebCitaR() {
    xhr.open("get", "MUsuVerNutriAgendar?", true);
    xhr.onreadystatechange = verificaDetalle4m;
    xhr.send(null);
}


function buscarOpcionMUsuWebCancelarCita(){
    creartObjeto();
    MUsuWebCancelarCita();
}
function MUsuWebCancelarCita(){
    xhr.open("get", "MUsuWebCancelarCita?", true);
    xhr.onreadystatechange = verificaDetalle4m;
    xhr.send(null);
}


function buscarOpcionMUsuWebCancelarCita1() {
    creartObjeto();
    MUsuWebCancelarCita1();
}
function MUsuWebCancelarCita1(){
    xhr.open("get", "MUsuWebCancelarCita1?", true);
    xhr.onreadystatechange = verificaDetalle4m;
    xhr.send(null);
}


function buscarOpcionMUsuaRecordadCita(){
    creartObjeto();
    MUsuaRecordadCita();
}
function MUsuaRecordadCita(){
    xhr.open("get", "MUsuaRecordadCita?", true);
    xhr.onreadystatechange = verificaDetalle4m;
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
        document.getElementById("inicioUs").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function calcularIMC(){
        creartObjeto();
        enviapeticion();
        
    }
    
    function enviapeticion(){
        var kg=document.getElementById("kilos").value;
        var mt=document.getElementById("metros").value;
        
        xhr.open("get","ServRCalcularIMC?kil="+kg+"&metr="+mt,true);
        xhr.onreadystatechange=verificaDetalle;
        xhr.send(null);
    }

    
    function verificaDetalle(){
        if(xhr.readyState==4){
            document.getElementById("indice").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    function contarCalorias() {
    creartObjeto();
    contarCaloriasServ();
}


function contarCaloriasServ()
{
    xhr.open("GET", "servContarCalorias", true);
    xhr.onreadystatechange = verificaDetalle8;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalle8() {
    if (xhr.readyState == 4) {
        document.getElementById("inicioUs").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function contarCaloriasServ1()
{

    var tipo = document.getElementById("tipoComida");
    var tipoComida = tipo.options[tipo.selectedIndex].value;
    //alert(tipoComida);
    xhr.open("GET", "servContarCalorias1?tipoComida=" + tipoComida, true);
    xhr.onreadystatechange = verificaDetalle9;
    xhr.send(null);

}

function verificaDetalle9() {
    if (xhr.readyState == 4) {
        document.getElementById("categoriaServ").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function contarCaloriasServ2()
{
   
    var cat = document.getElementById("categoria");
    var categoria = cat.options[cat.selectedIndex].value;
    //alert(categoria);
    xhr.open("GET", "servContarCalorias2?categoria=" + categoria, true);
    xhr.onreadystatechange = verificaDetalle10;
    xhr.send(null);
}

function verificaDetalle10() {
    if (xhr.readyState == 4) {
        document.getElementById("AlimentoServ").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function contarCaloriasServ3()
{
   
    var ali = document.getElementById("alimento");
    var alimento = ali.options[ali.selectedIndex].value;
    var categoria = document.getElementById("categoria").value;
    var gramos = document.getElementById("gramos").value;
    var tipoComida =  document.getElementById("tipoComida").value;
    //alert(alimento + " " + categoria + " " + gramos+ " " +tipoComida);
    xhr.open("GET", "servContarCalorias4?alimento=" + alimento + "&categoria=" + categoria + "&gramos="
            + gramos + "&tipoComida=" + tipoComida, true);
    xhr.onreadystatechange = verificaDetalle11;
    xhr.send(null);
}

function verificaDetalle11() {
    if (xhr.readyState == 4) {
        document.getElementById("AlimentoServ2").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}


function registrarregiEjercicio() {
    creartObjeto();
    registrarregiEjercicio1();
}

function registrarregiEjercicio1()
{
    //alert("que onda bebe");
    xhr.open("GET", "ServRegistrarEjercicio", true);
    xhr.onreadystatechange = verificaDetalle12;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalle12() {
    if (xhr.readyState == 4) {
        document.getElementById("inicioUs").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function registrarregiEjercicio2()
{
    creartObjeto();
    var id=document.getElementById("id_tipo");
    var id_tipo=id.options[id.selectedIndex].value;
    //alert("que onda bebe " + id_tipo);
    xhr.open("GET", "ServRegistrarEjercicio1?id_tipo=" + id_tipo, true);
    xhr.onreadystatechange = verificaDetalle13;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}
function verificaDetalle13() {
    if (xhr.readyState == 4) {
        document.getElementById("mensajeTipo").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function registrarregiEjercicio3()
{
    creartObjeto();
    var id=document.getElementById("id_ej");
    var id_ej=id.options[id.selectedIndex].value;
    var tiempo=document.getElementById("tiempo").value;
   // alert("id: " + id_ej + "  tiempo: " + tiempo );
    xhr.open("GET", "ServRegistrarEjercicio2?id_ej=" + id_ej + "&tiempo=" + tiempo, true);
    xhr.onreadystatechange = verificaDetalle14;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}
function verificaDetalle14() {
    if (xhr.readyState == 4) {
        document.getElementById("mensajeEjer").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}



function reporteSemanalCalorias(){
    creartObjeto();
    reporteSemanalCaloriasServ();
}

function reporteSemanalCaloriasServ()
{
    xhr.open("GET", "servReporteCalorias", true);
    xhr.onreadystatechange = verificaDetalle15;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalle15() {
    if (xhr.readyState == 4) {
        document.getElementById("inicioUs").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function reporteSemanalCaloriasServ1()
{
    var fecha = document.getElementById("fecha").value;
    //alert(fecha);
    xhr.open("GET", "servReporteCalorias1?fecha=" + fecha, true);
    xhr.onreadystatechange = verificaDetalle16;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalle16() {
    if (xhr.readyState == 4) {
        document.getElementById("Reporte").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function reporteSemanalCaloriasServ2()
{
    //var fecha = document.getElementById("fecha").value;
    //alert(fecha);
    xhr.open("GET", "servReporteCalorias2", true);
    xhr.onreadystatechange = verificaDetalle17;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalle17() {
    if (xhr.readyState == 4) {
        document.getElementById("Reporte").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}



function actualizarUsuarioWeb(){
    creartObjeto();
    enviapeticionActUsuWeb();
}

function enviapeticionActUsuWeb()
{
    xhr.open("GET", "ServActRDatosUsuarioWeb", true);
    xhr.onreadystatechange = verificaDetalleActUsuarioWeb;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalleActUsuarioWeb() {
    if (xhr.readyState == 4) {
        document.getElementById("inicioUs").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}



function actualizarUsuarioWeb2(){
    creartObjeto();
    enviapeticionActUsuWeb2();
}

function enviapeticionActUsuWeb2()
{
    var correo = document.getElementById("cor").value;
    
    xhr.open("GET", "ServActRDatosUsuarioWeb2?cor="+correo, true);
    xhr.onreadystatechange = verificaDetalleActUsuarioWeb2;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalleActUsuarioWeb2() {
    if (xhr.readyState == 4) {
        document.getElementById("respuActUsu").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function boletinUW()
{
    creartObjeto();
    boletinServ();
}

function boletinServ()
{
    xhr.open("GET", "ServBoletinUW", true);
    xhr.onreadystatechange = verificaDetalleDan1;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalleDan1() {
    if (xhr.readyState == 4) {
        document.getElementById("inicioUs").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}


