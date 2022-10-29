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
    
    
    
    
    
    

