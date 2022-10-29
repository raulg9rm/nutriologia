<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="icon" href="img/favicon.png" type="image/png">
        <title>Nutri Web</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="vendors/linericon/style.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css">
        <link rel="stylesheet" href="vendors/lightbox/simpleLightbox.css">
        <link rel="stylesheet" href="vendors/nice-select/css/nice-select.css">
        <link rel="stylesheet" href="vendors/animate-css/animate.css">
        <link rel="stylesheet" href="vendors/popup/magnific-popup.css">
        <!-- main css -->
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/responsive.css">
    </head>
    <body>
        <script src="scriptPaciente10.js" type="text/javascript"></script>
        <script src="scriptDanPaciente1.js" type="text/javascript"></script>
        <!--================Header Menu Area =================-->
        <a onclick="DinamicoDiv('mensajespaciente');" accesskey="m"></a>
        <a href="principalRPaciente.jsp" accesskey="i"></a>
        <a onclick="buscarMisDietas();" accesskey="t"></a>
            <a onclick="DinamicoDiv('imc');" accesskey="l"></a>
        <div id="inicioPa">
            
        <header class="header_area">
            <div class="main_menu">
            	<nav class="navbar navbar-expand-lg navbar-light">
					<div class="container">
						<!-- Brand and toggle get grouped for better mobile display -->
						<a class="navbar-brand logo_h" href="principalRPaciente.jsp"><img src="img/logo.png" alt=""></a>
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
							<ul class="nav navbar-nav menu_nav ml-auto">
								<li class="nav-item active"><a class="nav-link" href="principalRPaciente.jsp">Inicio</a></li> 
                                                                <li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Ver</a>
									<ul class="dropdown-menu">
                                                                                 <li class="nav-item"><a class="nav-link" onclick="boletinP();" >Boletin</a></li>
                                                                        </ul>
								</li>
								<li class="nav-item"><a class="nav-link"  onclick="DinamicoDiv('imc');">Calcular IMC</a></li> 
                                                                <li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dieta</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="#" onclick="preguntaPlanDieta();">Comprar / Renovar</a>
										<li class="nav-item"><a class="nav-link" href="#" onclick="buscarMisDietas();">Mirar</a></li>
                                                                                <li class="nav-item"><a class="nav-link" onclick="CancelarDieta();">Cancelar Plan</a></li>
									</ul>
								</li> 
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Editar</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" onclick="actDatosPaciente();">Perfil</a>
									</ul>
								</li> 
								<li class="nav-item"><a class="nav-link" onclick="DinamicoDiv('mensajespaciente');">Mensajes</a></li> 
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Paciente</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="single-blog.html">Mi cuenta</a></li>
                                                                                <li class="nav-item"><a class="nav-link" onclick="recomendarAmigoPA();">Recomendar amigo</a></li>
										<li class="nav-item"><a class="nav-link" href="index.jsp">Cerrar Sesión</a></li>
									</ul>
								</li> 
								
							</ul>
						</div> 
					</div>
            	</nav>
            </div>
        </header>
        <!--================Header Menu Area =================-->
        
        <!--================Home Banner Area =================-->
        <section class="banner_area">
            <div class="box_1620">
				<div class="banner_inner d-flex align-items-center">
					<div class="container">
						<div class="banner_content text-center">
							<h2>Bienvenido Paciente</h2>
							</div>
						</div>
					</div>
				</div>
            
        </section>
        <!--================End Home Banner Area =================-->
        
       <!--================Blog Categorie Area =================-->
        <section class="blog_categorie_area">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4">
                        <div class="categories_post">
                            <img src="img/blog/cat-post/cat-post-3.png" alt="post">
                            <div class="categories_details">
                                <div class="categories_text">
                                    <a href="#" onclick="DinamicoDiv('menuexpediente');"><h5>Mi expediente</h5></a>
                                    <div class="border_line"></div>
                                    <p>Accede a tu expediente las veces que lo necesites.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="categories_post">
                            <img src="img/blog/cat-post/cat-post-2.png" alt="post">
                            <div class="categories_details">
                                <div class="categories_text">
                                    <a onclick="buscarOpcionMPacienEvaluar();"><h5>Evaluar nutriólogo</h5></a>
                                    <div class="border_line"></div>
                                    <p>Mira los consejos que los nutri&oacutelogos tienen para tí.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--<div class="col-lg-4">
                        <div class="categories_post">
                            <img src="img/blog/cat-post/cat-post-1.png" alt="post">
                            <div class="categories_details">
                                <div class="categories_text">
                                    <a onclick="verRecetas1();"><h5>Recetas</h5></a>
                                    <div class="border_line"></div>
                                    <p>Cocina saludable con estas increibles recetas</p>
                                </div>
                            </div>
                        </div>
                    </div>-->
                </div>
            </div>
        </section>
        <!--================Blog Categorie Area =================-->
        
        <!--================About Area =================-->
            <section class="about_area pad_top">
                <div class="container">
                                <div class="about_inner row">
        				<div class="col-lg-6">
							<div class="h_blog_img">
								<img class="img-fluid" src="img/home-blog/exito.jpg" alt="">
							</div>
						</div>
						<div class="col-lg-6">
							<div class="about_text">
                                                            <h3>Comparte tu experiencia</h3>
                                                            <h5>Pública tu historia de éxito</h5>
                                                            <p>¿Has obtenido muy buenos resultados?, Comparte tu historia con los demás pacientes para animarlos y que sigan tu ejemplo</p>
                                                            <br>
                                                            <button onclick="registraHistoria();" class="main_btn2">Publicar mi historia</button>
                                                
                                                        </div>
						</div>
        			</div>
                </div>
            </section>
        <!--================End About Area =================-->
        
        <!--================Service Area =================-->
        <section class="service_area p_120">
        	<div class="container box_1620">
        		<div class="main_title">
        			<h2>Increíbles cosas que puedes hacer en nuestro sitio</h2>
        			<p>Ahora que eres paciente puedes empezar a gozar de increibles beneficios, esperemos aproveches al máximo los consejos, dietas y recetas de tu nutriólogo.</p>
        		</div>
        		<div class="row m0 service_inner">
        			<div class="col-lg-3 col-md-6 p0">
        				<div class="service_img">
        					<img class="img-fluid" src="img/service/service-2.jpg" alt="">
        				</div>
        			</div>
        			<div class="col-lg-3 col-md-6 p0">
        				<div class="service_text">
                                            <h4>Mira tu historial de compras aqu&iacute;</h4>
        					<p>Cuentas claras, clientes felices, mira las compras que has realizado.</p>
                                                    <button onclick="buscarCompras();" class="main_btn2">Ver historial</button>
        				</div>
        			</div>
        			<div class="col-lg-3 col-md-6 p0">
        				<div class="service_img">
        					<img class="img-fluid" src="img/service/service-5.jpg" alt="">
        				</div>
        			</div>
        			<div class="col-lg-3 col-md-6 p0">
        				<div class="service_text">
        					<h4>Reporte de paciente</h4>
        					<p>Genera tu reporte de paciente para ver como van esos objetivos</p>
                                                    <button onclick="reportePacientes();" class="main_btn2">Ver mi reporte</button>
        				</div>
        			</div>
        			
        		</div>
        	</div>
        </section>
        </div>
        <!--================End Service Area =================-->
        
        
        <!--================Calcular IMC======================-->
        <!--================Header Menu Area =================-->
        <div id="imc" style="display: none">
        <header class="header_area">
            <div class="main_menu">
            	<nav class="navbar navbar-expand-lg navbar-light">
					<div class="container">
						<!-- Brand and toggle get grouped for better mobile display -->
						<a class="navbar-brand logo_h" href="principalRPaciente.jsp"><img src="img/logo.png" alt=""></a>
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
							<ul class="nav navbar-nav menu_nav ml-auto">
								<li class="nav-item active"><a class="nav-link" href="principalRPaciente.jsp">Inicio</a></li> 
                                                                <li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Ver</a>
									<ul class="dropdown-menu">
                                                                                 <li class="nav-item"><a class="nav-link" onclick="boletinP();" >Boletin</a></li>
                                                                        </ul>
								</li>
								<li class="nav-item"><a class="nav-link"  onclick="DinamicoDiv('imc');">Calcular IMC</a></li> 
                                                                <li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dieta</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="#" onclick="preguntaPlanDieta();">Comprar / Renovar</a>
										<li class="nav-item"><a class="nav-link" href="#" onclick="buscarMisDietas();">Mirar</a></li>
                                                                                <li class="nav-item"><a class="nav-link" onclick="CancelarDieta();">Cancelar Plan</a></li>
									</ul>
								</li> 
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Editar</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" onclick="actDatosPaciente();">Perfil</a>
									</ul>
								</li> 
								<li class="nav-item"><a class="nav-link" onclick="DinamicoDiv('mensajespaciente');">Mensajes</a></li> 
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Paciente</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="single-blog.html">Mi cuenta</a></li>
                                                                                <li class="nav-item"><a class="nav-link" onclick="recomendarAmigoPA();">Recomendar amigo</a></li>
										<li class="nav-item"><a class="nav-link" href="index.jsp">Cerrar Sesión</a></li>
									</ul>
								</li> 
								
							</ul>
						</div> 
					</div>
            	</nav>
            </div>
        </header>
        <!--================Header Menu Area =================-->
        
        <!--================Home Banner Area =================-->
        <section class="banner_area">
            <div class="box_1620">
				<div class="banner_inner d-flex align-items-center">
					<div class="container">
						<div class="banner_content text-center">
							<h2>Calcula tu IMC</h2>
							</div>
						</div>
					</div>
				</div>
            
        </section>
        <!--================End Home Banner Area =================-->
        <!--================About Area =================-->
        <section>
                                <div class="row h_blog_item">
        				<div class="col-lg-6">
							<div class="h_blog_img">
								<img class="img-fluid" src="img/home-blog/indice2.jpg" alt="">
							</div>
						</div>
						<div class="col-lg-6">
							<div class="h_blog_text">
								<div class="h_blog_text_inner left">
									<h4>Calcula tu Índice de Masa Corporal (IMC)</h4>
                                                             
                                                                        
                                                                        <h3>Peso:</h3>
                                                                        <input type='text' id='kilos'>Kg.
                                                                        <h3>Estatura:</h3>
                                                                        <input type='text' id='metros'>mts.
                                                                        <h3>Género:</h3>
                                                                        <input type='radio' name='gen' value="Vieja">Mujer&nbsp;&nbsp;<input type='radio' name='gen' value="Hombre">Hombre
                                                                        <br>
                                                                        <br>
                                                                        <button onclick="calcularIMC();" class="main_btn2">Calcular</button>
                                                                        
                                                                        <br>
                                                                        <br/>
                                                                        <h3>IMC: </h3>
                                                                        <h3><div id="indice"></div></h3>
                                                                        
                                                                        
                                                                        <br>
                                                                        <br>
                                                                        
								</div>
							</div>
						</div>
        			</div>
            </section>
        <br>
        <br/>
        <br/>
        <br/>
                    </div>
        <!--================About Area =================-->
        <!--================Calcular IMC======================-->
        
        
        <!--================Menu Expediente======================-->
        <div id="menuexpediente" style="display: none">
        <header class="header_area">
            <div class="main_menu">
            	<nav class="navbar navbar-expand-lg navbar-light">
					<div class="container">
						<!-- Brand and toggle get grouped for better mobile display -->
						<a class="navbar-brand logo_h" href="principalRPaciente.jsp"><img src="img/logo.png" alt=""></a>
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
							<ul class="nav navbar-nav menu_nav ml-auto">
								<li class="nav-item active"><a class="nav-link" href="principalRPaciente.jsp">Inicio</a></li> 
                                                                <li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Ver</a>
									<ul class="dropdown-menu">
                                                                                 <li class="nav-item"><a class="nav-link" onclick="boletinP();" >Boletin</a></li>
                                                                        </ul>
								</li>
								<li class="nav-item"><a class="nav-link"  onclick="DinamicoDiv('imc');">Calcular IMC</a></li> 
                                                                <li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dieta</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="#" onclick="preguntaPlanDieta();">Comprar / Renovar</a>
										<li class="nav-item"><a class="nav-link" href="#" onclick="buscarMisDietas();">Mirar</a></li>
                                                                                <li class="nav-item"><a class="nav-link" onclick="CancelarDieta();">Cancelar Plan</a></li>
									</ul>
								</li> 
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Editar</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" onclick="actDatosPaciente();">Perfil</a>
									</ul>
								</li> 
								<li class="nav-item"><a class="nav-link" onclick="DinamicoDiv('mensajespaciente');">Mensajes</a></li> 
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Paciente</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="single-blog.html">Mi cuenta</a></li>
                                                                                <li class="nav-item"><a class="nav-link" onclick="recomendarAmigoPA();">Recomendar amigo</a></li>
										<li class="nav-item"><a class="nav-link" href="index.jsp">Cerrar Sesión</a></li>
									</ul>
								</li> 
								
							</ul>
						</div> 
					</div>
            	</nav>
            </div>
        </header>
        <!--================Header Menu Area =================-->
        
        <!--================Home Banner Area =================-->
        <section class="banner_area">
            <div class="box_1620">
				<div class="banner_inner d-flex align-items-center">
					<div class="container">
						<div class="banner_content text-center">
							<h2>Expediente</h2>
							</div>
						</div>
					</div>
				</div>
            
        </section>
        <!--================End Home Banner Area =================-->
        <!-- Start Align Area -->
			<div class="whole-wrap">
				<div class="container">
					
					<div class="section-top-border">
                                            <center><h3 class="mb-30 title_color">Mi expediente</h3></center>
						<div class="row">
							<div class="col-md-4">
								<div class="single-defination">
									<h4 class="mb-20">Crear</h4>
                                                                        <p>Crea tu expediente médico para que tu nutriólogo pueda asignarte la mejor dieta según tus necesidades</p>
									<p>P.D.No debes crear más de un expediente</p>
                                                                        <a class="main_btn2" href="#" onclick="DinamicoDiv('Crearexpediente');">Crear expediente</a>
								</div>
							</div>
							<div class="col-md-4">
								<div class="single-defination">
									<h4 class="mb-20">Ver mi expediente</h4>
                                                                        <p>Puedes consultar tu expediente para conocer tus datos cuando lo necesites</p><br><br>
                                                                        <a class="main_btn2" onclick="verExpediente();">Ver</a>
								</div>
							</div>
							<div class="col-md-4">
								<div class="single-defination">
									<h4 class="mb-20">Editar expediente o control de peso</h4>
									<p>Edita tu expediente cada que lo necesites, además puedes actualizar tu peso constantemente para tener un mejor control</p>
                                                                        <br><button class="main_btn2" onclick="editarExpediente();">Editar</button>
								</div>
							</div>
						</div>
					</div>
					
                                    
					<div class="section-top-border">
                                            <br><br><br><br>
						
					</div>
                                </div>
                        </div>
        <br>
        <br/>
        <br/>
        <br/>
                    </div>
        <!--================Menu Expediente======================-->
        
        
        <!--================Craer Expediente======================-->
        <!--================Header Menu Area =================-->
        <div id="Crearexpediente" style="display: none">
        <header class="header_area">
            <div class="main_menu">
            	<nav class="navbar navbar-expand-lg navbar-light">
					<div class="container">
						<!-- Brand and toggle get grouped for better mobile display -->
						<a class="navbar-brand logo_h" href="principalRPaciente.jsp"><img src="img/logo.png" alt=""></a>
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
							<ul class="nav navbar-nav menu_nav ml-auto">
								<li class="nav-item active"><a class="nav-link" href="principalRPaciente.jsp">Inicio</a></li> 
                                                                <li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Ver</a>
									<ul class="dropdown-menu">
                                                                                 <li class="nav-item"><a class="nav-link" onclick="boletinP();" >Boletin</a></li>
                                                                        </ul>
								</li>
								<li class="nav-item"><a class="nav-link"  onclick="DinamicoDiv('imc');">Calcular IMC</a></li> 
                                                                <li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dieta</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="#" onclick="preguntaPlanDieta();">Comprar / Renovar</a>
										<li class="nav-item"><a class="nav-link" href="#" onclick="buscarMisDietas();">Mirar</a></li>
                                                                                <li class="nav-item"><a class="nav-link" onclick="CancelarDieta();">Cancelar Plan</a></li>
									</ul>
								</li> 
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Editar</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" onclick="actDatosPaciente();">Perfil</a>
									</ul>
								</li> 
								<li class="nav-item"><a class="nav-link" onclick="DinamicoDiv('mensajespaciente');">Mensajes</a></li> 
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Paciente</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="single-blog.html">Mi cuenta</a></li>
                                                                                <li class="nav-item"><a class="nav-link" onclick="recomendarAmigoPA();">Recomendar amigo</a></li>
										<li class="nav-item"><a class="nav-link" href="index.jsp">Cerrar Sesión</a></li>
									</ul>
								</li> 
								
							</ul>
						</div> 
					</div>
            	</nav>
            </div>
        </header>
        <!--================Header Menu Area =================-->
        
        <!--================Home Banner Area =================-->
        <section class="banner_area">
            <div class="box_1620">
				<div class="banner_inner d-flex align-items-center">
					<div class="container">
						<div class="banner_content text-center">
							<h2>Historial de Peso</h2>
							</div>
						</div>
					</div>
				</div>
            
        </section>
        <!--================End Home Banner Area =================-->
        <br><br><br><center><h1>Primero ingresa tu peso para continuar</h1></center>
        <section class="about_area pad_top">
        	<div class="container">
                    
        		<div class="about_inner row">
        			<div class="col-lg-6">
        				<div class="h_blog_text_inner left">
                                            <h1>Llena tu expediente</h1><br>
                                                                        
                                                                        <h3>Altura</h3>
                                                                        <input type='text' id='altu'>
                                                                        <h3>Genero</h3>
                                                                        <input type='radio' name='gen' value="femenino" id="gen1">Mujer&nbsp;&nbsp;<input type='radio' name='gen' value="masculino" id="gen2">Hombre
                                                                        <br>
                                                                        <h3>Edad</h3>
                                                                        <input type='text' id='edad'>
                                                                        <h3>Enfermedades</h3><h5>Si no tienes favor de ingresar *ninguna*</h5>
                                                                        <textarea id='enfer' rows="5" cols="50"></textarea>
                                                                        <h3>Alergias</h3><h5>Si no tienes favor de ingresar *ninguna*</h5>
                                                                        <textarea id='aler' rows="5" cols="50"></textarea>
                                                                        <h3>Peso inicial</h3>
                                                                        <div id="peso"></div>
                                                                        <h3>Peso meta</h3>
                                                                        <h5>Ingresa el peso al cual desearias llegar</h5>
                                                                        <input type='text' id='pesoM'>
                                                                        <br>
                                                                        <br>
                                                                        <button class="main_btn2" id="btnEx" onclick="registrarExpediente();">Crear expediente</button>
                                                                       
                                                                        <br>
                                                                        <br>
                                                                        <div id="confirExp"></div>
                                                                        
								</div>
        			</div>
        			<div class="col-lg-6">
        				<div class="h_blog_text_inner">
									<h1>Ingresa tu peso</h1>
                                                                        <input type='text' id='pesoI'>
                                                                        
                                                                        
                                                                        <br>
                                                                        <br>
                                                                        <button class="main_btn2" id='btnPes' value='0' onclick='registrarPeso();'>Registrar</button>
                                                                       
                                                                        <br>
                                                                        <br>
                                                                        
                                                                        
								</div>
        			</div>
        		</div>
        	</div>
        </section>
        <br>
        <br/>
        <br/>
        <br/>
                    </div>
        <!--================Craer Expediente======================-->
        
         <!--================Menu mensajes======================-->
        <div id="mensajespaciente" style="display: none">
        <header class="header_area">
            <div class="main_menu">
            	<nav class="navbar navbar-expand-lg navbar-light">
					<div class="container">
						<!-- Brand and toggle get grouped for better mobile display -->
						<a class="navbar-brand logo_h" href="principalRPaciente.jsp"><img src="img/logo.png" alt=""></a>
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
							<ul class="nav navbar-nav menu_nav ml-auto">
								<li class="nav-item active"><a class="nav-link" href="principalRPaciente.jsp">Inicio</a></li> 
                                                                <li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Ver</a>
									<ul class="dropdown-menu">
                                                                                 <li class="nav-item"><a class="nav-link" onclick="boletinP();" >Boletin</a></li>
                                                                        </ul>
								</li>
								<li class="nav-item"><a class="nav-link"  onclick="DinamicoDiv('imc');">Calcular IMC</a></li> 
                                                                <li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dieta</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="#" onclick="preguntaPlanDieta();">Comprar / Renovar</a>
										<li class="nav-item"><a class="nav-link" href="#" onclick="buscarMisDietas();">Mirar</a></li>
                                                                                <li class="nav-item"><a class="nav-link" onclick="CancelarDieta();">Cancelar Plan</a></li>
									</ul>
								</li> 
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Editar</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" onclick="actDatosPaciente();">Perfil</a>
									</ul>
								</li> 
								<li class="nav-item"><a class="nav-link" onclick="DinamicoDiv('mensajespaciente');">Mensajes</a></li> 
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Paciente</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="single-blog.html">Mi cuenta</a></li>
                                                                                <li class="nav-item"><a class="nav-link" onclick="recomendarAmigoPA();">Recomendar amigo</a></li>
										<li class="nav-item"><a class="nav-link" href="index.jsp">Cerrar Sesión</a></li>
									</ul>
								</li> 
								
							</ul>
						</div> 
					</div>
            	</nav>
            </div>
        </header>
        <!--================Header Menu Area =================-->
        
        <!--================Home Banner Area =================-->
        <section class="banner_area">
            <div class="box_1620">
				<div class="banner_inner d-flex align-items-center">
					<div class="container">
						<div class="banner_content text-center">
							<h2>Mensajes</h2>
							</div>
						</div>
					</div>
				</div>
            
        </section>
        <!--================End Home Banner Area =================-->
        <!-- Start Align Area -->
			<div class="whole-wrap">
				<div class="container">
					
					<div class="section-top-border">
                                            <center><h3 class="mb-30 title_color">Mensajes</h3></center>
						<div class="row">
							<div class="col-md-4">
								<div class="single-defination">
									 <center><h4 class="mb-20">Redactar</h4> </center>
                                                                       
                                                                         <center><a class="main_btn2" onclick="enviarMensajes();">Redactar mensaje</a> </center>
								</div>
							</div>
							<div class="col-md-4">
								<div class="single-defination">
									 <center><h4 class="mb-20">Mis mensajes enviados</h4> </center>
                                                                        
                                                                         <center><a class="main_btn2" onclick="verMensajes();">Ver</a> </center>
								</div>
							</div>
							<div class="col-md-4">
								<div class="single-defination">
									 <center><h4 class="mb-20">Mensajes recibidos</h4> </center>
									
                                                                        <center><br><button class="main_btn2" onclick="verMensajesRecibidosPaciente();">Ver</button> </center>
								</div>
							</div>
						</div>
					</div>
					
                                    
					<div class="section-top-border">
                                            <br><br><br><br>
						
					</div>
                                </div>
                        </div>
        <br>
        <br/>
        <br/>
        <br/>
                    </div>
        <!--================Menu mensajes======================-->
        
        
        
        <!--================Instagram Area =================-->
        <br><br><br><br><br><br>
        <div id="pie">
        <section class="instagram_area">
        	<div class="container box_1620">
        		<div class="insta_btn">
        			<a class="main_btn2" href="#">Recomendar a un amigo</a>
        		</div>
        		
        	</div>
        </section>
        <!--================End Instagram Area =================-->
                        
        
       <!--================Footer Area =================-->
        
        <footer class="footer_area">
        	<div class="container">
        		<div class="row footer_inner">
        			<div class="col-lg-5 col-sm-6">
        				<aside class="f_widget ab_widget">
        					<div class="f_title">
        						<h3>¿Quiénes somos?</h3>
        					</div>
        					<p>Somos una empresa desarrolladora de software, cuyo objetivo es mejorar la calidad de vida de las personas a través de la tecnología y lo que podemos desarrollar, siempre anteponiendo el bienestar de las personas.</p>
        					<p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
StarWeb Copyright &copy;<script>document.write(new Date().getFullYear());</script> Derechos reservados | En colaboracion para la página <i class="fa fa-heart-o" aria-hidden="true"></i> <a href="https://colorlib.com" target="_blank">NutriWeb</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
</p>
        				</aside>
        			</div>
        			<div class="col-lg-5 col-sm-6">
        				<aside class="f_widget news_widget">
        					<div class="f_title">
        						<h3>Contacto</h3>
        					</div>
        					<p>Mándanos un correo si te agrado la página.</p>
        					<div id="mc_embed_signup">
                                <form target="_blank" action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01" method="get" class="subscribe_form relative">
                                	<div class="input-group d-flex flex-row">
                                        <input name="EMAIL" placeholder="Ingresa tu email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Email Address '" required="" type="email">
                                        <button class="btn sub-btn"><span class="lnr lnr-arrow-right"></span></button>		
                                    </div>				
                                    <div class="mt-10 info"></div>
                                </form>
                            </div>
        				</aside>
        			</div>
        			<div class="col-lg-2">
        				<aside class="f_widget social_widget">
        					<div class="f_title">
        						<h3>Síguenos...!!!</h3>
        					</div>
        					<p>Nuestras redes sociales</p>
        					<ul class="list">
        						<li><a href=""><i class="fa fa-facebook"></i></a></li>
        						<li><a href="#"><i class="fa fa-twitter"></i></a></li>
        						<li><a href="https://www.youtube.com/watch?v=WCi2DLYE82A"><i class="fa fa-dribbble"></i></a></li>
        						<li><a href="#"><i class="fa fa-behance"></i></a></li>
        					</ul>
                                                <br>
                                                <div class="f_title">
        						<h3>Manual de usuario</h3>
        					</div>
                                                <p>¿No encuentras lo que buscabas?, puedes buscar aquí.</p>
                                                <a href="#" onclick="BuscarManual();">Manual de Usuario</a>
        				</aside>
        			</div>
                            
                            
                            
        		</div>
        	</div>
        </footer>
        </div>
        <!--================End Footer Area =================-->
        
        
        
        
        
        
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/popper.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/stellar.js"></script>
        <script src="vendors/lightbox/simpleLightbox.min.js"></script>
        <script src="vendors/nice-select/js/jquery.nice-select.min.js"></script>
        <script src="vendors/isotope/imagesloaded.pkgd.min.js"></script>
        <script src="vendors/isotope/isotope.pkgd.min.js"></script>
        <script src="vendors/owl-carousel/owl.carousel.min.js"></script>
        <script src="vendors/popup/jquery.magnific-popup.min.js"></script>
        <script src="js/jquery.ajaxchimp.min.js"></script>
        <script src="vendors/counter-up/jquery.waypoints.min.js"></script>
        <script src="vendors/counter-up/jquery.counterup.js"></script>
        <script src="js/mail-script.js"></script>
        <script src="js/theme.js"></script>
    </body>
</html>
