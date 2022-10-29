/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var divInicial="inicio";

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
            document.getElementById("regPaciente").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    //Registrar pacientes
    
    function registrarPacientes(){
        creartObjeto();
        enviapeticionRegPaci();
        //alert("");
    }
    
    function enviapeticionRegPaci(){
        //alert("hola");
            var nombre=document.getElementById("nom").value;
            var paterno=document.getElementById("pat").value;
            var materno=document.getElementById("mat").value;
            var usuario=document.getElementById("us").value;
            var contra=document.getElementById("pass").value;
            var confir=document.getElementById("confpass").value;
            var foto=document.getElementById("fileFoto").value;
            var correo=document.getElementById("email").value;
            //alert(id+no+ho+te+co);
        
     
        xhr.open("get","ServRegRPaciente?nom="+nombre+"&pat="+paterno+"&mat="+materno+"&pass="+contra+"&confpass="+confir+"&us="+usuario+"&email="+correo+"&fileFoto="+foto,true);
        xhr.onreadystatechange=verificaDetalleRegPaci;
        xhr.send(null);
    }
    
    function verificaDetalleRegPaci(){
        if(xhr.readyState==4){
            document.getElementById("respuestaRegPaciente").innerHTML="<em>"+xhr.responseText+"</em>";
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
            document.getElementById("regPaciente").innerHTML="<em>"+xhr.responseText+"</em>";
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
        
        xhr.open("get","ServRBuscarSaldo?tarjet="+tar,true);
        xhr.onreadystatechange=verificaDetalleBuscarSaldo;
        xhr.send(null);
    }
    
    function verificaDetalleBuscarSaldo(){
        if(xhr.readyState==4){
            document.getElementById("detalleTarjeta").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    
    //Buscar dieta
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
            document.getElementById("regPaciente").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    
    //Comprar dieta
    function comprarDieta(dieta,ced){
        creartObjeto();
        enviapeticioncomprarDietas(dieta,ced);
       // alert("");
    }
    
    function enviapeticioncomprarDietas(dieta,ced){
       /* var tar=document.getElementById("tarjeta").value;
        var tar=document.getElementById("tarjeta").value;
        var tar=document.getElementById("tarjeta").value;
        var tar=document.getElementById("tarjeta").value;*/
        
        xhr.open("get","ServRComprarDietas?die="+dieta+"&cedu="+ced,true);
        xhr.onreadystatechange=verificaDetalleComprarDietas;
        xhr.send(null);
    }
    
    function verificaDetalleComprarDietas(){
        if(xhr.readyState==4){
            document.getElementById("detalleDieta").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    
    //Comprar dieta2
    function comprarDieta2(){
        creartObjeto();
        enviapeticioncomprarDietas2();
       // alert("");
    }
    
    function enviapeticioncomprarDietas2(){
        var usuario=document.getElementById("user1").value;
        var tar=document.getElementById("tarjeta").value;
        var dieta=document.getElementById("dieta1").value;
        var ced=document.getElementById("cedula1").value;
        
        xhr.open("get","ServRComprarDietas2?user="+usuario+"&diet="+dieta+"&cedu="+ced+"&card="+tar,true);
        xhr.onreadystatechange=verificaDetalleComprarDietas2;
        xhr.send(null);
    }
    
    function verificaDetalleComprarDietas2(){
        if(xhr.readyState==4){
            document.getElementById("regPaciente").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }


function verRecetas() {
    creartObjeto();
    verRecetasServ();
    //alert();
}

function verRecetasServ()
{
    xhr.open("GET", "servVerPublicacionRecetas", true);
    xhr.onreadystatechange = verificaDetalle5;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalle5() {
    if (xhr.readyState == 4) {
        document.getElementById("inicio").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}
function verConsejos() {
    creartObjeto();
    verConsejosServ();
}

function verConsejosServ()
{
    xhr.open("GET", "servVerPublicacionConsejos", true);
    xhr.onreadystatechange = verificaDetalle6;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalle6() {
    if (xhr.readyState == 4) {
        document.getElementById("inicio").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}


function verHistoriasDeExito(){
    creartObjeto();
    verHistoriasDeExitoServ();
}

function verHistoriasDeExitoServ()
{
    //alert("buu");
    xhr.open("GET", "servVerHistoriasExito", true);
    xhr.onreadystatechange = verificaDetalle38;
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificaDetalle38() {
    if (xhr.readyState == 4) {
        document.getElementById("inicio").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}





function registrarUsu(){
        creartObjeto();
        enviapeticionRegUsu();
        //alert("");
    }
    
    function enviapeticionRegUsu(){
        //alert("hola");
            var nombre=document.getElementById("nom7").value;
            var paterno=document.getElementById("pat7").value;
            var materno=document.getElementById("mat7").value;
            var usuario=document.getElementById("us7").value;
            var contra=document.getElementById("pass7").value;
            var confir=document.getElementById("confpass7").value;
            
            var correo=document.getElementById("email7").value;
            
            //alert(nombre+paterno+materno+usuario+contra+confir+correo);
        
     
        xhr.open("get","ServRegRUsuarioWeb?nom="+nombre+"&pat="+paterno+"&mat="+materno+"&pass="+contra+"&confpass="+confir+"&us="+usuario+"&email="+correo,true);
        xhr.onreadystatechange=verificaDetalleRegUsu;
        xhr.send(null);
    }
    
    function verificaDetalleRegUsu(){
        if(xhr.readyState==4){
            document.getElementById("respuUsu").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    
    
    function registrarNutrios(){
        creartObjeto();
        enviapeticionRegNutri();
        //alert("");
    }
    
    function enviapeticionRegNutri(){
        //alert("hola");
            var nombre=document.getElementById("nom4").value;
            var paterno=document.getElementById("pat4").value;
            var materno=document.getElementById("mat4").value;
            var usuario=document.getElementById("us4").value;
            var contra=document.getElementById("pass4").value;
            var confir=document.getElementById("confpass4").value;
            var cedula=document.getElementById("ced4").value;
            var foto=document.getElementById("fileFoto4").value;
            var colonia=document.getElementById("col4").value;
            var calle=document.getElementById("calle4").value;
            var casa=document.getElementById("cas4").value;
            var descrip=document.getElementById("desc4").value;
            
            var cuenta=document.getElementById("cuenta4").value;
            
            //alert(nombre+paterno+materno+usuario+contra+confir+correo);
        
     
        xhr.open("get","ServRegRNutriologo?nom="+nombre+"&pat="+paterno+"&mat="+materno+"&pass="+contra+"&confpass="+confir+"&us="+usuario+"&cuenta="+cuenta+"&fileFoto="+foto+"&col="+colonia+"&calle="+calle+"&cas="+casa+"&desc="+descrip+"&ced="+cedula,true);
        xhr.onreadystatechange=verificaDetalleRegNutri;
        xhr.send(null);
    }
    
    function verificaDetalleRegNutri(){
        if(xhr.readyState==4){
            document.getElementById("respuNutrio").innerHTML="<em>"+xhr.responseText+"</em>";
        }
    }
    
    
    
  