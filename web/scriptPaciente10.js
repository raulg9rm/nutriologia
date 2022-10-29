/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var divInicial="inicioPa";

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
    
    //verNutriologos
    function buscarNutriologos(){
        creartObjeto();
        //alert();
        enviapeticionBuscarNutri();
    }
    
    function enviapeticionBuscarNutri(){
        xhr.open("get","ServDPerfilNutriologo",true);
        xhr.onreadystatechange=verificaDetalleBuscarNutri;
        xhr.send(null);
    }
    
    function verificaDetalleBuscarNutri(){
        if(xhr.readyState==4){
            document.getElementById("inicioPa").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    //BuscarDietas
    function buscarDietas(ced){
        creartObjeto();
        enviapeticionbuscarDietas(ced);
       // alert("");
    }
    
    function enviapeticionbuscarDietas(ced){
        
        xhr.open("get","ServRBuscarDietas?id="+ced,true);
        xhr.onreadystatechange=verificaDetalleBuscarDietas;
        xhr.send(null);
    }
    
    function verificaDetalleBuscarDietas(){
        if(xhr.readyState==4){
            document.getElementById("inicioPa").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    //Comprar dieta
    function comprarDieta(dieta,ced,cost){
        creartObjeto();
        enviapeticioncomprarDietas(dieta,ced,cost);
       // alert("");
    }
    
    function enviapeticioncomprarDietas(dieta,ced,cost){
       /* var tar=document.getElementById("tarjeta").value;
        var tar=document.getElementById("tarjeta").value;
        var tar=document.getElementById("tarjeta").value;
        var tar=document.getElementById("tarjeta").value;*/
        
        xhr.open("get","ServRComprarDietas?die="+dieta+"&cedu="+ced+"&costo="+cost,true);
        xhr.onreadystatechange=verificaDetalleComprarDietas;
        xhr.send(null);
    }
    
    function verificaDetalleComprarDietas(){
        if(xhr.readyState==4){
            document.getElementById("detalleDieta").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    //Consultar saldo
    function consultarSaldo(){
        creartObjeto();
        enviapeticionbuscarSaldo();
       // alert("");
    }
    
    function enviapeticionbuscarSaldo(){
        var tar=document.getElementById("tarjeta").value;
        var cot=document.getElementById("costo1").value;
        
        xhr.open("get","ServRBuscarSaldo?tarjet="+tar+"&prec="+cot,true);
        xhr.onreadystatechange=verificaDetalleBuscarSaldo;
        xhr.send(null);
    }
    
    function verificaDetalleBuscarSaldo(){
        if(xhr.readyState==4){
            document.getElementById("detalleTarjeta").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    
    //Comprar dieta2
    function comprarDieta2(){
        creartObjeto();
        var usuario=document.getElementById("user1").value;
        var tar=document.getElementById("tarjeta").value;
        var dieta=document.getElementById("dieta1").value;
        var ced=document.getElementById("cedula1").value;
        var cos=document.getElementById("costo1").value;
        
        //alert("Usuario:"+usuario+"tarjeta:"+tar+"dieta:"+dieta+"cedula:"+ced+"costo:"+cos);
        enviapeticioncomprarDietas2(usuario, dieta, ced, tar, cos);
       
    }
    
    function enviapeticioncomprarDietas2(usuario, dieta, ced, tar, cos){
        
        
        xhr.open("get","ServRComprarDietas2?user="+usuario+"&diet="+dieta+"&cedu="+ced+"&card="+tar+"&costoo="+cos,true);
        xhr.onreadystatechange=verificaDetalleComprarDietas2;
        xhr.send(null);
    }
    
    function verificaDetalleComprarDietas2(){
        if(xhr.readyState==4){
            document.getElementById("inicioPa").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    //ConfirmarCompra
    
    function confirmarDieta(){
        
        
        creartObjeto();
        enviapeticionConfirmarDieta();
       // alert("");
    }
    
    function enviapeticionConfirmarDieta(){
        var usuario=document.getElementById("user1").value;
        var tar=document.getElementById("tarjeta").value;
        var dieta=document.getElementById("dieta1").value;
        var ced=document.getElementById("cedula1").value;
        var cos=document.getElementById("costo1").value;
        
        
        xhr.open("get","ServRComprarDietasRadios?user="+usuario+"&diet="+dieta+"&cedu="+ced+"&card="+tar+"&costoo="+cos,true);
        xhr.onreadystatechange=verificaDetalleComnfirmarDieta;
        xhr.send(null);
    }
    
    function verificaDetalleComnfirmarDieta(){
        if(xhr.readyState==4){
            document.getElementById("confirmarDieta").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    
    //CancelarCompra
    function cancelarCompra(){
        creartObjeto();
        
        enviapeticionCancelarCompra();
    }
    
    function enviapeticionCancelarCompra(){
        
        
        xhr.open("get","ServCompraNo",true);
        xhr.onreadystatechange=verificaDetalleCancelarCompra;
        xhr.send(null);
    }
    
    function verificaDetalleCancelarCompra(){
        if(xhr.readyState==4){
            document.getElementById("confirmarDieta").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    
    
    //BuscarCompras
    function buscarCompras(){
        creartObjeto();
        enviapeticionbuscarCompras();
       // alert("");
    }
    
    function enviapeticionbuscarCompras(){
        
        xhr.open("get","ServRBuscarCompras",true);
        xhr.onreadystatechange=verificaDetalleBuscarCompras;
        xhr.send(null);
    }
    
    function verificaDetalleBuscarCompras(){
        if(xhr.readyState==4){
            document.getElementById("inicioPa").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    
    //Registrar Peso
    function registrarPeso(){
        creartObjeto();
        enviapeticionregistarPeso();
       // alert("");
    }
    
    function enviapeticionregistarPeso(){
        
        var pes=document.getElementById("pesoI").value;
        
        xhr.open("get","ServRRegistrarPeso?peso="+pes,true);
        xhr.onreadystatechange=verificaDetalleregistrarPeso;
        xhr.send(null);
    }
    
    function verificaDetalleregistrarPeso(){
        if(xhr.readyState==4){
            document.getElementById("peso").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    //RegistrarExpediente
    function registrarExpediente(){
        creartObjeto();
        enviapeticionregistrarExpediente();
      //alert("");
    }
    
    function enviapeticionregistrarExpediente(){
        var altura=document.getElementById("altu").value;
        var sexoF=document.getElementById("gen1").value;
        var sexoM=document.getElementById("gen2").value;
        var edad=document.getElementById("edad").value;
        var enfermedad=document.getElementById("enfer").value;
        var alergia=document.getElementById("aler").value;
        var inicio=document.getElementById("pesoPrin").value;
        var fin=document.getElementById("pesoM").value;
        //alert(edad+enfermedad+alergia);
        
        var sexoFCH=document.getElementById("gen1").checked;
        var sexoMCH=document.getElementById("gen2").checked;
        
        if(sexoFCH){
            xhr.open("get","ServRRegistrarExpediente?alt="+altura+"&sexo=femenino&ini="+inicio+"&fin="+fin+"&edad="+edad+"&enf="+enfermedad+"&alerg="+alergia,true);
            xhr.onreadystatechange=verificaDetalleregistrarExpediente;
            xhr.send(null);
        } else if (sexoMCH){
            xhr.open("get","ServRRegistrarExpediente?alt="+altura+"&sexo=masculino&ini="+inicio+"&fin="+fin+"&edad="+edad+"&enf="+enfermedad+"&alerg="+alergia,true);
            xhr.onreadystatechange=verificaDetalleregistrarExpediente;
            xhr.send(null);
        }
        
        
    }
    
    function verificaDetalleregistrarExpediente(){
        if(xhr.readyState==4){
            document.getElementById("confirExp").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    //VerExpediente
    function verExpediente(){
        creartObjeto();
        enviapeticionverExpediente();
       // alert("");
    }
    
    function enviapeticionverExpediente(){
        
        xhr.open("get","ServRVerExpediente",true);
        xhr.onreadystatechange=verificaDetalleverExpediente;
        xhr.send(null);
    }
    
    function verificaDetalleverExpediente(){
        if(xhr.readyState==4){
            document.getElementById("menuexpediente").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    //EditarExpediente
    function editarExpediente(){
        creartObjeto();
        enviapeticioneditarExpediente();
       // alert("");
    }
    
    function enviapeticioneditarExpediente(){
        
        xhr.open("get","ServREditarExpediente",true);
        xhr.onreadystatechange=verificaDetalleeditarExpediente;
        xhr.send(null);
    }
    
    function verificaDetalleeditarExpediente(){
        if(xhr.readyState==4){
            document.getElementById("menuexpediente").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    //Actualizar Peso
    function editarPeso(){
        creartObjeto();
        enviapeticionEditarPeso();
       // alert("");
    }
    
    function enviapeticionEditarPeso(){
        
        var pes=document.getElementById("pesoN").value;
        
        xhr.open("get","ServREditarPeso?peso="+pes,true);
        xhr.onreadystatechange=verificaDetallerEditarPeso;
        xhr.send(null);
    }
    
    function verificaDetallerEditarPeso(){
        if(xhr.readyState==4){
            document.getElementById("newpeso").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    
    
    //EditarExpediente
    function editaExpediente2(){
        creartObjeto();
        enviapeticionrEditarExpediente2();
      //alert("");
    }
    
    function enviapeticionrEditarExpediente2(){
        var altura=document.getElementById("altu2").value;
        var sexoF=document.getElementById("gen12").value;
        var sexoM=document.getElementById("gen22").value;
        var edad=document.getElementById("edad2").value;
        var enfermedad=document.getElementById("enfer2").value;
        var alergia=document.getElementById("aler2").value;
        
        var fin=document.getElementById("pesoM2").value;
        //alert(edad+enfermedad+alergia+altura);
        
        var sexoFCH=document.getElementById("gen12").checked;
        var sexoMCH=document.getElementById("gen22").checked;
        
        if(sexoFCH){
            xhr.open("get","ServREditarExpediente2?alt="+altura+"&sexo=femenino&fin="+fin+"&edad="+edad+"&enf="+enfermedad+"&alerg="+alergia,true);
            xhr.onreadystatechange=verificaDetallerEditarExpediente2;
            xhr.send(null);
        } else if (sexoMCH){
            xhr.open("get","ServREditarExpediente2?alt="+altura+"&sexo=masculino&fin="+fin+"&edad="+edad+"&enf="+enfermedad+"&alerg="+alergia,true);
            xhr.onreadystatechange=verificaDetallerEditarExpediente2;
            xhr.send(null);
        }
        
        
    }
    
    function verificaDetallerEditarExpediente2(){
        if(xhr.readyState==4){
            document.getElementById("confirExp2").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }



//BuscarCompras
    function CancelarDieta(){
        creartObjeto();
        enviapeticionCancelarDieta();
       // alert("");
    }
    
    function enviapeticionCancelarDieta(){
        
        xhr.open("get","ServRCancelarPlan",true);
        xhr.onreadystatechange=verificaDetalleCancelarDieta;
        xhr.send(null);
    }
    
    function verificaDetalleCancelarDieta(){
        if(xhr.readyState==4){
            document.getElementById("inicioPa").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    
    //CancelarDietaRadios
    function cancelarPlanRadios(id){
        creartObjeto();
        //alert(id);
        enviapeticionCancelarDietaRadios(id);
       // alert("");
    }
    
    function enviapeticionCancelarDietaRadios(id){
        
        xhr.open("get","ServRCancelarPlanRadios?dieta="+id,true);
        xhr.onreadystatechange=verificaDetalleCancelarDietaRadios;
        xhr.send(null);
    }
    
    function verificaDetalleCancelarDietaRadios(){
        if(xhr.readyState==4){
            document.getElementById("radios").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    //CancelarDietaRadios
    function cancelarPlanSi(id){
        creartObjeto();
        enviapeticionCancelarDietaSi(id);
      //alert(id);
    }
    
    function enviapeticionCancelarDietaSi(id){
        
        xhr.open("get","ServRCancelarPlanSi?dieta="+id,true);
        xhr.onreadystatechange=verificaDetalleCancelarDietaSi;
        xhr.send(null);
    }
    
    function verificaDetalleCancelarDietaSi(){
        if(xhr.readyState==4){
            document.getElementById("inicioPa").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    //CancelarDietaRadios
    function cancelarPlanNo(){
        creartObjeto();
        enviapeticionCancelarDietaNo();
       // alert("");
    }
    
    function enviapeticionCancelarDietaNo(){
        
        xhr.open("get","ServRCancelarPlanNo",true);
        xhr.onreadystatechange=verificaDetalleCancelarDietaNo;
        xhr.send(null);
    }
    
    function verificaDetalleCancelarDietaNo(){
        if(xhr.readyState==4){
            document.getElementById("cancelacion").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    
    //Generar comprobante
    function generarComprobante(){
        creartObjeto();
        enviapeticiongenerarComprobante();
      
    }
    
    function enviapeticiongenerarComprobante(){
        var di=document.getElementById("dietaa").value;
        var us=document.getElementById("usuarioo").value;
        var ta=document.getElementById("tarjetaa").value;
        var co=document.getElementById("costooo").value;
        
        //alert("dieta: "+di+" usuario: "+us+" tarjeta: "+ta+" costo: "+co);
        
        xhr.open("get","ServRGenerarComprobante?dieta="+di+"&usuario="+us+"&tarjeta="+ta+"&compra="+co,true);
        xhr.onreadystatechange=verificaDetalleComp;
        xhr.send(null);
    }
    
    function verificaDetalleComp(){
        if(xhr.readyState==4){
            document.getElementById("comprobante").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    function reportePacientes(){
    creartObjeto();
    //alert("");
    reportePacientesServ();
}

function reportePacientesServ()
{
    //alert("buu");
    xhr.open("GET", "servReportePacientes", true);
    xhr.onreadystatechange = verificaDetalle37;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalle37() {
    if (xhr.readyState == 4) {
        document.getElementById("inicioPa").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}


function verRecetas1() {
    creartObjeto();
    verRecetasServ1();
    //alert();
}

function verRecetasServ1()
{
    xhr.open("GET", "servVerPublicacionRecetas", true);
    xhr.onreadystatechange = verificaDetalle5e;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalle5e() {
    if (xhr.readyState == 4) {
        document.getElementById("inicioPa").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}
function verConsejos1() {
    creartObjeto();
    verConsejosServ1();
}

function verConsejosServ1()
{
    xhr.open("GET", "servVerPublicacionConsejos", true);
    xhr.onreadystatechange = verificaDetalle6e;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalle6e() {
    if (xhr.readyState == 4) {
        document.getElementById("inicioPa").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}


function buscarOpcionMPacienEvaluar() {
    creartObjeto();
    MPacienEvaluar();
}
function MPacienEvaluar() {
    xhr.open("get", "MPacienEvaluar?", true);
    xhr.onreadystatechange = verificaDetalle3m;
    xhr.send(null);
}


function buscarOpcionMPacienteMensajeApoyo() {
    creartObjeto();
    MPacienteMensajeApoyo();
}
function MPacienteMensajeApoyo() {
    xhr.open("get", "MPacienteMensajeApoyo?", true);
    xhr.onreadystatechange = verificaDetalle3m;
    xhr.send(null);
}


function buscarOpcionMPacienEvaluar1(cedula) {
    creartObjeto();
   MPacienEvaluar1(cedula);
}
function MPacienEvaluar1(cedula) {
    //alert(cedula);
    var com = document.getElementById("com").value;
    var r1=document.getElementById("radio1");
    var r2=document.getElementById("radio2");
    var r3=document.getElementById("radio3");
    var r4=document.getElementById("radio4");
    var r5=document.getElementById("radio5");
    if(r1.checked){
        var ev=document.getElementById("radio1").value;
    }else if(r2.checked){
        var ev=document.getElementById("radio2").value;
    }else if(r3.checked){
        var ev=document.getElementById("radio3").value;
    }else if(r4.checked){
        var ev=document.getElementById("radio4").value;
    }else if(r5.checked){
        var ev=document.getElementById("radio5").value;
    }
    xhr.open("post", "MPacienEvaluar1?ced="+cedula+"&ev="+ev+"&com="+com, true);
    xhr.onreadystatechange = verificaDetalle1m;
    //alert("ced="+cedula+"&ev="+ev+"&com=" + com);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send("ced="+cedula+"&ev="+ev+"&com=" + com);
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
        document.getElementById("inicioPa").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function verificaDetalle4m() {
    if (xhr.readyState == 4) {
        document.getElementById("detalle3").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}



//BuscarDietas
    function buscarMisDietas(){
        creartObjeto();
        enviapeticionbuscarMisDietas();
        //alert("");
    }
    
    function enviapeticionbuscarMisDietas(){
        
        xhr.open("get","ServRBuscarMisDietas",true);
        xhr.onreadystatechange=verificaDetalleBuscarMisDietas;
        xhr.send(null);
    }
    
    function verificaDetalleBuscarMisDietas(){
        if(xhr.readyState==4){
            document.getElementById("inicioPa").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    
    
    //MostrarDieta
    function mostrarDieta(id){
        creartObjeto();
        enviapeticionmostrarMiDieta(id);
        //alert("");
    }
    
    function enviapeticionmostrarMiDieta(id){
        
        xhr.open("get","ServRMostrarMiDieta?dieta="+id,true);
        xhr.onreadystatechange=verificaDetallesMostrarMiDieta;
        xhr.send(null);
    }
    
    function verificaDetallesMostrarMiDieta(){
        if(xhr.readyState==4){
            document.getElementById("detalleMisDieta").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    
    //MostrarDieta2
    function mostrarDieta2(id){
        creartObjeto();
        enviapeticionmostrarMiDieta2(id);
        //alert("");
    }
    
    function enviapeticionmostrarMiDieta2(id){
        var fecha=document.getElementById("fechadieta").value;
        
        xhr.open("get","ServRMostrarMiDieta2?dieta="+id+"&fecha="+fecha,true);
        xhr.onreadystatechange=verificaDetallesMostrarMiDieta2;
        xhr.send(null);
    }
    
    function verificaDetallesMostrarMiDieta2(){
        if(xhr.readyState==4){
            document.getElementById("inicioPa").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }



function actDatosPaciente(){
        creartObjeto();
        enviapeticionactDatosPaciente();
        //alert("");
    }
    
    function enviapeticionactDatosPaciente(){
        
        xhr.open("get","ServActRDatosPaciente",true);
        xhr.onreadystatechange=verificaDetalleactDatosPaciente;
        xhr.send(null);
    }
    
    function verificaDetalleactDatosPaciente(){
        if(xhr.readyState==4){
            document.getElementById("inicioPa").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    function actDatosPaciente2(){
        creartObjeto();
        enviapeticionactDatosPaciente2();
        //alert("");
    }
    
    function enviapeticionactDatosPaciente2(){
        var correo=document.getElementById("cor").value;
        var foto=document.getElementById("fileFoto").value;
        
        xhr.open("get","ServActRDatosPaciente2?cor="+correo+"&fileFoto="+foto,true);
        xhr.onreadystatechange=verificaDetalleactDatosPaciente2;
        xhr.send(null);
    }
    
    function verificaDetalleactDatosPaciente2(){
        if(xhr.readyState==4){
            document.getElementById("actPaciente").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    function contarCaloriasServPaci1()
{

    var tipo = document.getElementById("tipoComida");
    var tipoComida = tipo.options[tipo.selectedIndex].value;
    //alert(tipoComida);
    xhr.open("GET", "servContarCaloriasPaciente1?tipoComida=" + tipoComida, true);
    xhr.onreadystatechange = verificaDetalle9;
    xhr.send(null);

}

function verificaDetalle9() {
    if (xhr.readyState == 4) {
        document.getElementById("categoriaServPaciente").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}


function contarCaloriasServPaci2()
{
   
    var cat = document.getElementById("categoria");
    var categoria = cat.options[cat.selectedIndex].value;
    //alert(categoria);
    xhr.open("GET", "servContarCaloriasPaciente2?categoria=" + categoria, true);
    xhr.onreadystatechange = verificaDetalle10;
    xhr.send(null);
}

function verificaDetalle10() {
    if (xhr.readyState == 4) {
        document.getElementById("AlimentoServPaci").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}


function contarCaloriasServPaci3()
{
   
    var ali = document.getElementById("alimento");
    var alimento = ali.options[ali.selectedIndex].value;
    var categoria = document.getElementById("categoria").value;
    var gramos = document.getElementById("gramos").value;
    var tipoComida =  document.getElementById("tipoComida").value;
    var fecha =  document.getElementById("fechadieta").value;
    var dieta =  document.getElementById("dietaa").value;
    //alert(alimento + " " + categoria + " " + gramos+ " " +tipoComida);
    xhr.open("GET", "servContarCaloriasPaci4?alimento=" + alimento + "&categoria=" + categoria + "&gramos="
            + gramos + "&tipoComida=" + tipoComida+ "&fechadieta=" + fecha+ "&dietaa=" + dieta, true);
    xhr.onreadystatechange = verificaDetalle11;
    xhr.send(null);
}

function verificaDetalle11() {
    if (xhr.readyState == 4) {
        document.getElementById("AlimentoServPaci2").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}




function imprimirDieta(diet){
        creartObjeto();
        enviapeticionImprimirDietas(diet);
        //alert("");
    }
    
    function enviapeticionImprimirDietas(diet){
        //alert(diet);
        var fecha =  document.getElementById("fechadieta").value;
        
        xhr.open("get","ServRImprimirDietas?diet="+diet+"&fech="+fecha,true);
        xhr.onreadystatechange=verificaDetalleImprimirDietas;
        xhr.send(null);
    }
    
    function verificaDetalleImprimirDietas(){
        if(xhr.readyState==4){
            document.getElementById("comprobante").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    function preguntaPlanDieta(){
        creartObjeto();
        enviapeticionPlaDietas();
        //alert("");
    }
    
    function enviapeticionPlaDietas(){
        //alert(diet);
        
        
        xhr.open("get","ServRPreguntaDietas",true);
        xhr.onreadystatechange=verificaDetallePreguntaPlaDieta;
        xhr.send(null);
    }
    
    function verificaDetallePreguntaPlaDieta(){
        if(xhr.readyState==4){
            document.getElementById("inicioPa").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    function renovarPlanDieta(){
        creartObjeto();
        enviapeticionRenovarPlaDietas();
        //alert("");
    }
    
    function enviapeticionRenovarPlaDietas(){
        xhr.open("get","ServRRenovarDietas",true);
        xhr.onreadystatechange=verificaDetalleRenovarPlanDieta;
        xhr.send(null);
    }
    
    function verificaDetalleRenovarPlanDieta(){
        if(xhr.readyState==4){
            document.getElementById("inicioPa").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    
    function renovarPlanDieta2(id){
        creartObjeto();
        enviapeticionRenovarPlaDietas2(id);
        //alert("");
    }
    
    function enviapeticionRenovarPlaDietas2(id){
        xhr.open("get","ServRRenovarDietas2?id="+id,true);
        xhr.onreadystatechange=verificaDetalleRenovarPlanDieta2;
        xhr.send(null);
    }
    
    function verificaDetalleRenovarPlanDieta2(){
        if(xhr.readyState==4){
            document.getElementById("detalleMisDietaRenovar").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    //Consultar saldo
    function consultarSaldo2(){
        creartObjeto();
        enviapeticionbuscarSaldo2();
       // alert("");
    }
    
    function enviapeticionbuscarSaldo2(){
        var tar=document.getElementById("tarjetaa").value;
        var cot=document.getElementById("costoo1").value;
        
        xhr.open("get","ServRBuscarSaldo2?tarjet="+tar+"&prec="+cot,true);
        xhr.onreadystatechange=verificaDetalleBuscarSaldo2;
        xhr.send(null);
    }
    
    function verificaDetalleBuscarSaldo2(){
        if(xhr.readyState==4){
            document.getElementById("detalleTarjeta2").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    
    function confirmarDieta8(){
        
        
        creartObjeto();
        enviapeticionConfirmarDieta8();
       // alert("");
    }
    
    function enviapeticionConfirmarDieta8(){
        var usuario=document.getElementById("userr1").value;
        var tar=document.getElementById("tarjetaa").value;
        var dieta=document.getElementById("dietaa1").value;
        var ced=document.getElementById("cedulaa1").value;
        var cos=document.getElementById("costoo1").value;
        
        
        xhr.open("get","ServRRenovarFinal?user="+usuario+"&diet="+dieta+"&cedu="+ced+"&card="+tar+"&costoo="+cos,true);
        xhr.onreadystatechange=verificaDetalleComnfirmarDieta8;
        xhr.send(null);
    }
    
    function verificaDetalleComnfirmarDieta8(){
        if(xhr.readyState==4){
            document.getElementById("confirmarDieta8").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }


