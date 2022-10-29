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
        <script src="scriptInicio3.js" type="text/javascript"></script>
        <!--================Header Menu Area =================-->
        <a href="index.jsp" accesskey="i"></a>
        <a onclick="DinamicoDiv('imc');" accesskey="l"></a>
            <a onclick="DinamicoDiv('sesion');" accesskey="s"></a>
        <div id="inicio">
            
        <header class="header_area">
            <div class="main_menu">
            	<nav class="navbar navbar-expand-lg navbar-light">
					<div class="container">
						<!-- Brand and toggle get grouped for better mobile display -->
						<a class="navbar-brand logo_h" href="index.jsp"><img src="img/logo.png" alt=""></a>
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
							<ul class="nav navbar-nav menu_nav ml-auto">
								<li class="nav-item active"><a class="nav-link" href="index.jsp">Inicio</a></li> 
                                                                 
								<li class="nav-item"><a class="nav-link" href="#" onclick="DinamicoDiv('imc');">Calcular IMC</a></li> 
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Contacto</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="indexStarWeb.jsp">Star Web</a></li>
									</ul>
								</li>
								<li class="nav-item"><a class="nav-link" href="#" onclick="DinamicoDiv('preguntaNutri');">¿Eres nutriólogo?</a></li>
                                                                <li class="nav-item"><a class="nav-link" href="#" onclick="DinamicoDiv('sesion');">Inicio Sesión</a></li>
							</ul>
						</div> 
					</div>
            	</nav>
            </div>
        </header>
        
        <!--================Header Menu Area =================-->
        
        <!--================Home Banner Area =================-->
        
        <section class="home_banner_area">
           	<div class="box_1620">
           		<div class="banner_inner d-flex align-items-center">
					<div class="container">
						<div class="banner_content text-center">
							<h3>Nutri Web<br />Mejora tu salud</h3>
							<p>Deseas llevar un plan de nutrición de manera fácil y sencilla, pues regístrate y nosotros te contactamos con un nutriólogo especializado.</p>
							<a class="main_btn" href="#" onclick="DinamicoDiv('pregunta');">Regístrarse</a>
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
                                    <a onclick="verHistoriasDeExito();"><h5>Historias de éxito</h5></a>
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
                                    <a onclick="verConsejos();"><h5>Consejos</h5></a>
                                    <div class="border_line"></div>
                                    <p>Mira los consejos que los nutri&oacutelogos tienen para ti.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="categories_post">
                            <img src="img/blog/cat-post/cat-post-1.png" alt="post">
                            <div class="categories_details">
                                <div class="categories_text">
                                    <a  onclick="verRecetas();"><h5>Recetas</h5></a>
                                    <div class="border_line"></div>
                                    <p>Cocina saludable con estas increíbles recetas.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--================Blog Categorie Area =================-->
        <!--================Home Blog Area =================-->
        <section class="home_blog_area pad_top">
        	<div class="container">
        		<div class="home_blog_inner">
        			<div class="row h_blog_item">
        				<div class="col-lg-6">
							<div class="h_blog_img">
								<img class="img-fluid" src="img/home-blog/h-blog-1.jpg" alt="">
							</div>
						</div>
						<div class="col-lg-6">
							<div class="h_blog_text">
								<div class="h_blog_text_inner left">
									<h4>Regístrate con un nutriólogo</h4>
									<p>Conoce los nutriólogos registrados en nuestro sitio, selecciona el que más te agrade y empieza tu plan de dieta para bajar de peso ahora mismo.</p>
									
								</div>
							</div>
						</div>
        			</div>
        			<div class="row h_blog_item">
						<div class="col-lg-6">
							<div class="h_blog_text">
								<div class="h_blog_text_inner right">
									<h4>Deseas controlar tu peso de manera correcta</h4>
									<p>En NutriWeb encontraras las mejores opciones para controlar tu peso, en nuestro sitio podrás: contar tus calorías por comida, calcular tu índice de masa corporal (IMC), comprar un plan de dieta y más...</p>
									
								</div>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="h_blog_img">
								<img class="img-fluid" src="img/home-blog/consejos.jpg" alt="">
							</div>
						</div>
        			</div>
        			<div class="row h_blog_item">
        				<div class="col-lg-6">
							<div class="h_blog_img">
								<img class="img-fluid" src="img/home-blog/historias.jpg" alt="">
							</div>
						</div>
						<div class="col-lg-6">
							<div class="h_blog_text">
								<div class="h_blog_text_inner left">
									<h4>¿Deseas comer saludable?</h4>
									<p>Encontrarás las mejores recetas saludables que los nutriólogos publican diariamente para que disfrutes de riquisamas comidas además de cuidar tu salud.</p>
									
								</div>
							</div>
						</div>
        			</div>
        			
                        </div>
                    </div>
            <br/>
        <br/>
        <br/>
                </div>
        <!--================Inico Sesión =================-->
        <div id="sesion" style="display: none">
           <header class="header_area">
            <div class="main_menu">
            	<nav class="navbar navbar-expand-lg navbar-light">
					<div class="container">
						<!-- Brand and toggle get grouped for better mobile display -->
						<a class="navbar-brand logo_h" href="index.jsp"><img src="img/logo.png" alt=""></a>
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
							<ul class="nav navbar-nav menu_nav ml-auto">
								<li class="nav-item active"><a class="nav-link" href="index.jsp">Inicio</a></li> 
                                                                 
								<li class="nav-item"><a class="nav-link" href="#" onclick="DinamicoDiv('imc');">Calcular IMC</a></li> 
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Contacto</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="indexStarWeb.jsp">Star Web</a></li>
									</ul>
								</li>
								<li class="nav-item"><a class="nav-link" href="#" onclick="DinamicoDiv('preguntaNutri');">¿Eres nutriólogo?</a></li>
                                                                <li class="nav-item"><a class="nav-link" href="#" onclick="DinamicoDiv('sesion');">Inicio Sesión</a></li>
							</ul>
						</div> 
					</div>
            	</nav>
            </div>
        </header>
        
        <!--================Header Menu Area =================-->
        <section class="banner_area">
            <div class="box_1620">
				<div class="banner_inner d-flex align-items-center">
					<div class="container">
						<div class="banner_content text-center">
							<h2>Bienvenido...!!!</h2>
							</div>
						</div>
					</div>
				</div>
            
        </section>
        <!--================End Home Banner Area =================-->
                        
                        
                        <section class="about_area pad_top">
        	<div class="container">
        		<div class="about_inner row">
        			<div class="col-lg-6">
        				<div class="about_text">
                                            <h3>Inicio de sesión</h3>
        					 <form action="DInicioSesionValidacion" method="post">
            USUARIO: <input type="text" name="nombre" id="usuario" maxlength="15">
            <br><br>
            PASSWORD: <input type="password" name="clave" id="password" maxlength="15">
            <br><br>
            <input type="submit" value="ENTRAR" name="enviar"  class="main_btn2">            
        </form>
        
                                                     
                                                
        				</div>
        			</div>
        			
        		</div>
        	</div>
        </section>
        <br/>
        <br/>
        <br/>
                    </div>
        
        <!--================Inicio Sesión =================-->
        
        <!--================IMC =================-->
        <div id="imc" style="display: none">
            <header class="header_area">
            <div class="main_menu">
            	<nav class="navbar navbar-expand-lg navbar-light">
					<div class="container">
						<!-- Brand and toggle get grouped for better mobile display -->
						<a class="navbar-brand logo_h" href="index.jsp"><img src="img/logo.png" alt=""></a>
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
							<ul class="nav navbar-nav menu_nav ml-auto">
								<li class="nav-item active"><a class="nav-link" href="index.jsp">Inicio</a></li> 
                                                                 
								<li class="nav-item"><a class="nav-link" href="#" onclick="DinamicoDiv('imc');">Calcular IMC</a></li> 
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Contacto</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="indexStarWeb.jsp">Star Web</a></li>
									</ul>
								</li>
								<li class="nav-item"><a class="nav-link" href="#" onclick="DinamicoDiv('preguntaNutri');">¿Eres nutriólogo?</a></li>
                                                                <li class="nav-item"><a class="nav-link" href="#" onclick="DinamicoDiv('sesion');">Inicio Sesión</a></li>
							</ul>
						</div> 
					</div>
            	</nav>
            </div>
        </header>
        
        <!--================Header Menu Area =================-->
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
                                                                        <input type='text' id='kilos' maxlength="6">Kg.
                                                                        <h3>Estatura:</h3>
                                                                        <input type='text' id='metros' maxlength="6">mts.
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
        
        <!--================IMC =================-->
        
        
        <!--================Pregunta Registro=================-->
        <div id="pregunta" style="display: none">
            <header class="header_area">
            <div class="main_menu">
            	<nav class="navbar navbar-expand-lg navbar-light">
					<div class="container">
						<!-- Brand and toggle get grouped for better mobile display -->
						<a class="navbar-brand logo_h" href="index.jsp"><img src="img/logo.png" alt=""></a>
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
							<ul class="nav navbar-nav menu_nav ml-auto">
								<li class="nav-item active"><a class="nav-link" href="index.jsp">Inicio</a></li> 
                                                                 
								<li class="nav-item"><a class="nav-link" href="#" onclick="DinamicoDiv('imc');">Calcular IMC</a></li> 
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Contacto</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="indexStarWeb.jsp">Star Web</a></li>
									</ul>
								</li>
								<li class="nav-item"><a class="nav-link" href="#" onclick="DinamicoDiv('preguntaNutri');">¿Eres nutriólogo?</a></li>
                                                                <li class="nav-item"><a class="nav-link" href="#" onclick="DinamicoDiv('sesion');">Inicio Sesión</a></li>
							</ul>
						</div> 
					</div>
            	</nav>
            </div>
        </header>
        
        <!--================Header Menu Area =================-->
        <section class="banner_area">
            <div class="box_1620">
				<div class="banner_inner d-flex align-items-center">
					<div class="container">
						<div class="banner_content text-center">
							<h2>¡Regístrate para obtener increíbles beneficios!</h2>
							</div>
						</div>
					</div>
				</div>
            
        </section>
        <!--================End Home Banner Area =================-->
        <!--================About Area =================-->
        <section class="about_area pad_top">
        	<div class="container">
        		<div class="about_inner row">
        			<div class="col-lg-6">
        				<div class="about_text">
        					<h3>¿Te gustaría contactar con un nutriólogo?</h3>
        					<h5>Suscríbete a nuestro sitio y empieza a cuidar tu salud comprando un plan de dieta</h5>
        					<p>Conoce los planes de dieta que nuestros nutriólogos tienen para ti.<br />
                                                Administra tu consumo de calorías, recibe consejos, recetas y más...</p>
                                                <br>
                                                <button class="main_btn2" href="#" onclick="DinamicoDiv('pregPaciente');">Registrarme como paciente</button>
                                                
        				</div>
        			</div>
        			<div class="col-lg-6">
        				<div class="about_img"><img class="img-fluid" src="img/paciente.jpg" alt=""></div>
        			</div>
        		</div>
        	</div>
        </section>
        <!--================End About Area =================-->
        <!--================About Area 2=================-->
            <section class="about_area pad_top">
                <div class="container">
                                <div class="about_inner row">
        				<div class="col-lg-6">
							<div class="h_blog_img">
								<img class="img-fluid" src="img/home-blog/usuario.jpeg" alt="">
							</div>
						</div>
						<div class="col-lg-6">
							<div class="about_text">
                                                            <h3>¿Sólo deseas llevar un control de tus calorías?</h3>
                                                            <h5>Registrate en nuestro sitio y sin costo alguno recibe gran información nutrimental</h5>
                                                            <p>Registra tus calorías diarias y recibe las mejores recetas y consejos de nuestros nutriólogos<br />
                                                            Si en algún momento deseas comprar un plan de dieta, puedes hacerlo...</p>
                                                            <br>
                                                            
                                                            <button class="main_btn2" href="#" onclick="DinamicoDiv('regUsuario');">Registrarme como usuario web</button>
                                                
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
        <!--================End About Area 2=================-->
        <!--================Pregunta Registro=================-->
        
        
        <!--================Registro Usuario Web=================-->
        <div id="regUsuario" style="display: none">
            <header class="header_area">
            <div class="main_menu">
            	<nav class="navbar navbar-expand-lg navbar-light">
					<div class="container">
						<!-- Brand and toggle get grouped for better mobile display -->
						<a class="navbar-brand logo_h" href="index.jsp"><img src="img/logo.png" alt=""></a>
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
							<ul class="nav navbar-nav menu_nav ml-auto">
								<li class="nav-item active"><a class="nav-link" href="index.jsp">Inicio</a></li> 
                                                                 
								<li class="nav-item"><a class="nav-link" href="#" onclick="DinamicoDiv('imc');">Calcular IMC</a></li> 
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Contacto</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="indexStarWeb.jsp">Star Web</a></li>
									</ul>
								</li>
								<li class="nav-item"><a class="nav-link" href="#" onclick="DinamicoDiv('preguntaNutri');">¿Eres nutriólogo?</a></li>
                                                                <li class="nav-item"><a class="nav-link" href="#" onclick="DinamicoDiv('sesion');">Inicio Sesión</a></li>
							</ul>
						</div> 
					</div>
            	</nav>
            </div>
        </header>
        
        <!--================Header Menu Area =================-->
        <section class="banner_area">
            <div class="box_1620">
				<div class="banner_inner d-flex align-items-center">
					<div class="container">
						<div class="banner_content text-center">
							<h2>Registro Usuario Web</h2>
							</div>
						</div>
					</div>
				</div>
            
        </section>
        <!--================End Home Banner Area =================-->
        <!--================About Area =================-->
            <section class="about_area pad_top">
                <div class="container">
                                <div class="row h_blog_item">
        				<div class="col-lg-6">
							<div class="h_blog_img">
								<img class="img-fluid" src="img/home-blog/usuarioReg.jpg" alt="">
							</div>
						</div>
						<div class="col-lg-6">
							<div class="h_blog_text">
								<div class="h_blog_text_inner left">
									<h4>Ingresa tus datos</h4>
                                                                        
                                                                        
                                                                        <h3>Nombre</h3>
                                                                        <input type='text' id='nom7' maxlength="15">
                                                                        <h3>Apellido paterno</h3>
                                                                        <input type='text' id='pat7' maxlength="15">
                                                                        <h3>Apellido materno</h3>
                                                                        <input type='text' id='mat7' maxlength="15">
                                                                        <h3>Usuario</h3>
                                                                        <input type='text' id='us7' maxlength="8">
                                                                        <h3>Contraseña</h3>
                                                                        <input type='password' id='pass7' maxlength="8">
                                                                        <h3>Confirma tu contraseña</h3>
                                                                        <input type='password' id='confpass7' maxlength="8">
                                                                        <h3>Correo</h3>
                                                                        <input type='text' id='email7' maxlength="20">
                                                                        <br>
                                                                        <br>
                                                                        <button class="main_btn2" href="#" onclick="registrarUsu();">Registrar</button>
                                                                        
                                                                        <br>
                                                                        <br>
                                                                        <div id="respuUsu"></div>
                                                                        
								</div>
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
        <!--================End About Area =================-->
        <!--================Registro Usuario Web=================-->
        
        
        <!--================Confirmar Paciente=================-->
        <div id="pregPaciente" style="display: none">
            <header class="header_area">
            <div class="main_menu">
            	<nav class="navbar navbar-expand-lg navbar-light">
					<div class="container">
						<!-- Brand and toggle get grouped for better mobile display -->
						<a class="navbar-brand logo_h" href="index.jsp"><img src="img/logo.png" alt=""></a>
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
							<ul class="nav navbar-nav menu_nav ml-auto">
								<li class="nav-item active"><a class="nav-link" href="index.jsp">Inicio</a></li> 
                                                                 
								<li class="nav-item"><a class="nav-link" href="#" onclick="DinamicoDiv('imc');">Calcular IMC</a></li> 
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Contacto</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="indexStarWeb.jsp">Star Web</a></li>
									</ul>
								</li>
								<li class="nav-item"><a class="nav-link" href="#" onclick="DinamicoDiv('preguntaNutri');">¿Eres nutriólogo?</a></li>
                                                                <li class="nav-item"><a class="nav-link" href="#" onclick="DinamicoDiv('sesion');">Inicio Sesión</a></li>
							</ul>
						</div> 
					</div>
            	</nav>
            </div>
        </header>
        
        <!--================Header Menu Area =================-->
        <section class="banner_area">
            <div class="box_1620">
				<div class="banner_inner d-flex align-items-center">
					<div class="container">
						<div class="banner_content text-center">
							<h2>Registro Paciente</h2>
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
						<h3 class="mb-30 title_color">¡Regístrate como paciente y te atenderá el nutriólogo que tu selecciones!</h3>
						<div class="row">
							<div class="col-md-3">
								<img src="img/elements/d.jpg" alt="" class="img-fluid">
							</div>
							<div class="col-md-9 mt-sm-20 left-align-p">
								<p>Porque sabemos que todas las personas somos diferentes, es por eso que en NutriWeb dejamos que tú mismo selecciones el nutriólogo que tu creas es el indicado para ti, mira sus calificaciones y comentarios de otros pacientes acerca del nutriólogo que selecciones y toma la mejor decisión para cuidar tu salud ahora mismo.</p>
							</div>
						</div>
					</div>
					
					<div class="section-top-border">
						<h3 class="mb-30 title_color">Registrate en 3 sencillos pasos</h3>
						<div class="row">
							<div class="col-md-4">
								<div class="single-defination">
									<h4 class="mb-20">PASO 1</h4>
									<p>Consulta los nutriólogos registrados en la plataforma, selecciona el que más te agrade y mira los planes de dieta que tiene disponibles para ti.</p>
								</div>
							</div>
							<div class="col-md-4">
								<div class="single-defination">
									<h4 class="mb-20">PASO 2</h4>
									<p>Compra un plan de dieta con tu nutriólogo seleccionado, llena un pequeño formulario para asignarte un usuario y así puedas ingresar cuando quieras a nuestro sitio.</p>
								</div>
							</div>
							<div class="col-md-4">
								<div class="single-defination">
									<h4 class="mb-20">PASO 3</h4>
									<p>Crea tu expediente médico para que tu nutriólogo te asigne los mejores alimentos, recetas y consejos para ti</p>
								</div>
							</div>
						</div>
					</div>
					<div class="section-top-border">
						<h3 class="mb-30 title_color">Comienza a cuidar tu salud ahora...!!!</h3>
						<div class="row">
							<div class="col-lg-12">
								<blockquote class="generic-blockquote">
									No esperes más, empieza a mejorar tu calidad de vida, y disfruta de todos los beneficios que NutriWeb tiene para ti. 
                                                                        <br/><br/><button class="main_btn2" href="#" onclick="DinamicoDiv('regPaciente');">Registrarme como paciente</button><br><br><a class="main_btn2" href="index.jsp">Regresar al Inicio</a>
								</blockquote>
                                                                
							</div>
						</div>
					</div>
					
					<div class="section-top-border">
						<h3 class="title_color">Disfruta los beneficios de registrarte como paciente.</h3>
						<div class="row gallery-item">
							<div class="col-md-4">
								<a href="img/elements/g1.jpg" class="img-gal"><div class="single-gallery-image" style="background: url(img/elements/g1.jpg);"></div></a>
							</div>
							<div class="col-md-4">
								<a href="img/elements/g2.jpg" class="img-gal"><div class="single-gallery-image" style="background: url(img/elements/g2.jpg);"></div></a>
							</div>
							<div class="col-md-4">
								<a href="img/elements/g3.jpg" class="img-gal"><div class="single-gallery-image" style="background: url(img/elements/g3.jpg);"></div></a>
							</div>
							<div class="col-md-6">
								<a href="img/elements/g4.jpg" class="img-gal"><div class="single-gallery-image" style="background: url(img/elements/g4.jpg);"></div></a>
							</div>
							<div class="col-md-6">
								<a href="img/elements/g5.jpg" class="img-gal"><div class="single-gallery-image" style="background: url(img/elements/g5.jpg);"></div></a>
							</div>
							<div class="col-md-4">
								<a href="img/elements/g6.jpg" class="img-gal"><div class="single-gallery-image" style="background: url(img/elements/g6.jpg);"></div></a>
							</div>
							<div class="col-md-4">
								<a href="img/elements/g7.jpg" class="img-gal"><div class="single-gallery-image" style="background: url(img/elements/g7.jpg);"></div></a>
							</div>
							<div class="col-md-4">
								<a href="img/elements/g8.jpg" class="img-gal"><div class="single-gallery-image" style="background: url(img/elements/g8.jpg);"></div></a>
							</div>
						</div>
					</div>
					
					
				</div>
			</div>
        </div>
			<!-- End Align Area -->
        <!--================Confirmar Paciente=================-->
        
        
        <!--================Confirmar Paciente2=================-->
        <div id="buscarNutri">
            
        </div>
        <!--================Confirmar Paciente2=================-->
        
        
        <!--================Registro Paciente=================-->
        <div id="regPaciente" style="display: none">
            <header class="header_area">
            <div class="main_menu">
            	<nav class="navbar navbar-expand-lg navbar-light">
					<div class="container">
						<!-- Brand and toggle get grouped for better mobile display -->
						<a class="navbar-brand logo_h" href="index.jsp"><img src="img/logo.png" alt=""></a>
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
							<ul class="nav navbar-nav menu_nav ml-auto">
								<li class="nav-item active"><a class="nav-link" href="index.jsp">Inicio</a></li> 
                                                                 
								<li class="nav-item"><a class="nav-link" href="#" onclick="DinamicoDiv('imc');">Calcular IMC</a></li> 
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Contacto</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="indexStarWeb.jsp">Star Web</a></li>
									</ul>
								</li>
								<li class="nav-item"><a class="nav-link" href="#" onclick="DinamicoDiv('preguntaNutri');">¿Eres nutriólogo?</a></li>
                                                                <li class="nav-item"><a class="nav-link" href="#" onclick="DinamicoDiv('sesion');">Inicio Sesión</a></li>
							</ul>
						</div> 
					</div>
            	</nav>
            </div>
        </header>
        
        <!--================Header Menu Area =================-->
        <section class="banner_area">
            <div class="box_1620">
				<div class="banner_inner d-flex align-items-center">
					<div class="container">
						<div class="banner_content text-center">
							<h2>Registro Paciente</h2>
							</div>
						</div>
					</div>
				</div>
            
        </section>
        <!--================End Home Banner Area =================-->
        <!--================About Area =================-->
            <section class="about_area pad_top">
                <div class="container">
                                <div class="row h_blog_item">
        				
						<div class="col-lg-6">
							<div class="h_blog_text">
								<div class="h_blog_text_inner left">
									<h4>Ingresa tus datos</h4>

                                                                        <h3>Nombre</h3>
                                                                        <input type='text' id='nom' required="required" maxlength="15">
                                                                        <h3>Apellido paterno</h3>
                                                                        <input type='text' id='pat' required maxlength="15">
                                                                        <h3>Apellido materno</h3>
                                                                        <input type='text' id='mat' required maxlength="15">
                                                                        <h3>Usuario</h3>
                                                                        <input type='text' id='us' required maxlength="8">
                                                                        <h3>Contraseña</h3>
                                                                        <input type='password' id='pass' required maxlength="8">
                                                                        <h3>Confirma tu contraseña</h3>
                                                                        <input type='password' id='confpass' required maxlength="8">
                                                                        <h3>Foto</h3>
                                                                        <input type='file' id='fileFoto' required>
                                                                        <h3>Correo</h3>
                                                                        <input type='text' id='email' required maxlength="20">
                                                                        <br>
                                                                        <br>
                                                                        
                                                                        <button class="main_btn2" href="#" onclick="registrarPacientes();">Registrar</button>
                                                                        <br>
                                                                        <br>
                                                                        <div id="respuestaRegPaciente">
                                                                            
                                                                        </div>
								</div>
							</div>
						</div>
                                                                        <div class="col-lg-6">
							<div class="h_blog_img">
								<img class="img-fluid" src="img/home-blog/paciente5.jpg" alt="">
							</div>
						</div>
        			</div>
                </div>
            </section>
                                                                        <br/>
        <br/>
        <br/>
        </div>
        <!--================End About Area =================-->
        <!--================Registro Paciente=================-->
        
        
        <!--================Pregunta Nutriologo=================-->
        <div id="preguntaNutri" style="display: none">
            <header class="header_area">
            <div class="main_menu">
            	<nav class="navbar navbar-expand-lg navbar-light">
					<div class="container">
						<!-- Brand and toggle get grouped for better mobile display -->
						<a class="navbar-brand logo_h" href="index.jsp"><img src="img/logo.png" alt=""></a>
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
							<ul class="nav navbar-nav menu_nav ml-auto">
								<li class="nav-item active"><a class="nav-link" href="index.jsp">Inicio</a></li> 
                                                                 
								<li class="nav-item"><a class="nav-link" href="#" onclick="DinamicoDiv('imc');">Calcular IMC</a></li> 
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Contacto</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="indexStarWeb.jsp">Star Web</a></li>
									</ul>
								</li>
								<li class="nav-item"><a class="nav-link" href="#" onclick="DinamicoDiv('preguntaNutri');">¿Eres nutriólogo?</a></li>
                                                                <li class="nav-item"><a class="nav-link" href="#" onclick="DinamicoDiv('sesion');">Inicio Sesión</a></li>
							</ul>
						</div> 
					</div>
            	</nav>
            </div>
        </header>
        
        <!--================Header Menu Area =================-->
        <section class="banner_area">
            <div class="box_1620">
				<div class="banner_inner d-flex align-items-center">
					<div class="container">
						<div class="banner_content text-center">
							<h2>Regístrate como Nutriólogo</h2>
							</div>
						</div>
					</div>
				</div>
            
        </section>
        <!--================End Home Banner Area =================-->
        <!--================About Area =================-->
        <section class="about_area pad_top">
        	<div class="container">
        		<div class="about_inner row">
        			<div class="col-lg-6">
        				<div class="about_text">
        					<h3>¿Eres nutriólogo?<br />¿Te gustaría atender pacientes en línea?</h3>
        					<h5>Suscribete a nuestro sitio y empieza a apoyar a tus nuevos pacientes</h5>
        					<p>Conoce los planes de suscripción que ofrecemos, selecciona el que mas te agrade y comienza a gestionar tu consultorio desde nuestro sitio web, crea planes de dieta, ofrece citas, lleva el control de todos tus pacientes y más...</p>
                                                
        				</div>
        			</div>
        			<div class="col-lg-6">
        				<div class="about_img"><img class="img-fluid" src="img/about-1.jpg" alt=""></div>
        			</div>
        		</div>
        	</div>
        </section>
        <!--================End About Area =================-->
        <!--================Service Area =================-->
        <section class="service_area p_120">
        	<div class="container box_1620">
        		<div class="main_title">
        			<h2>Beneficios de regístrarte como nutriólogo</h2>
        			<p>Establece tus planes de dieta y atiende tus pacientes desde la comodidad de tu casa o consultorio.</p>
        		</div>
        		<div class="row m0 service_inner">
        			<div class="col-lg-3 col-md-6 p0">
        				<div class="service_img">
        					<img class="img-fluid" src="img/service/service-1.jpg" alt="">
        				</div>
        			</div>
        			<div class="col-lg-3 col-md-6 p0">
        				<div class="service_text">
        					<h4>Crea tus planes de dieta</h4>
        					<p>Atiende pacientes y crea planes de nutrición para ellos.</p>
        				</div>
        			</div>
        			<div class="col-lg-3 col-md-6 p0">
        				<div class="service_img">
        					<img class="img-fluid" src="img/service/service-2.jpg" alt="">
        				</div>
        			</div>
        			<div class="col-lg-3 col-md-6 p0">
        				<div class="service_text">
        					<h4>Genera dinero</h4>
        					<p>Vende tus planes de dieta a personas que deseen contactar con un nutriólogo.</p>
        				</div>
        			</div>
        			<div class="col-lg-3 col-md-6 p0">
        				<div class="service_text">
        					<h4>Esfuérzate</h4>
        					<p>Tus pacientes podrán evaluarte para que así logres captar más personas y tener buenas evaluaciones.</p>
        				</div>
        			</div>
        			<div class="col-lg-3 col-md-6 p0">
        				<div class="service_img">
        					<img class="img-fluid" src="img/service/service-3.jpg" alt="">
        				</div>
        			</div>
        			<div class="col-lg-3 col-md-6 p0">
        				<div class="service_text">
        					<h4>Publica</h4>
        					<p>Publica recetas saludables y consejos para que los pacientes puedan seguir tu oreintación.</p>
        				</div>
        			</div>
        			<div class="col-lg-3 col-md-6 p0">
        				<div class="service_img">
        					<img class="img-fluid" src="img/service/service-4.jpg" alt="">
        				</div>
        			</div>
        		</div>
                    <div class="main_title">
                                <br/>
        			<h1>¡No lo pienses más, regístrate!</h1>
        			<br>
                                <button class="main_btn2" href="#" onclick="DinamicoDiv('registroNutri');">Regístrarme como nutriólogo</button>
        		</div>
                    
        	</div>
        </section>
        <br/>
        <br/>
        <br/>
        </div>
        <!--================End Service Area =================-->
        <!--================Pregunta Nutriologo=================-->
        <div id="registroNutri" style="display: none">
            <header class="header_area">
            <div class="main_menu">
            	<nav class="navbar navbar-expand-lg navbar-light">
					<div class="container">
						<!-- Brand and toggle get grouped for better mobile display -->
						<a class="navbar-brand logo_h" href="index.jsp"><img src="img/logo.png" alt=""></a>
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
							<ul class="nav navbar-nav menu_nav ml-auto">
								<li class="nav-item active"><a class="nav-link" href="index.jsp">Inicio</a></li> 
                                                                 
								<li class="nav-item"><a class="nav-link" href="#" onclick="DinamicoDiv('imc');">Calcular IMC</a></li> 
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Contacto</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="indexStarWeb.jsp">Star Web</a></li>
									</ul>
								</li>
								<li class="nav-item"><a class="nav-link" href="#" onclick="DinamicoDiv('preguntaNutri');">¿Eres nutriólogo?</a></li>
                                                                <li class="nav-item"><a class="nav-link" href="#" onclick="DinamicoDiv('sesion');">Inicio Sesión</a></li>
							</ul>
						</div> 
					</div>
            	</nav>
            </div>
        </header>
        
        <!--================Header Menu Area =================-->
        <section class="banner_area">
            <div class="box_1620">
				<div class="banner_inner d-flex align-items-center">
					<div class="container">
						<div class="banner_content text-center">
							<h2>Registrate como Nutriólogo</h2>
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
								<img class="img-fluid" src="img/home-blog/h-blog-1.jpg" alt="">
							</div>
						</div>
						<div class="col-lg-6">
							<div class="h_blog_text">
								<div class="h_blog_text_inner left">
									<h4>Ingresa tus datos</h4>
                                                                        
                                                                        
                                                                        <h5>Nombre</h5>
                                                                        <input type='text' id='nom4' maxlength="15">
                                                                        <h5>Apellido paterno</h5>
                                                                        <input type='text' id='pat4' maxlength="15">
                                                                        <h5>Apellido materno</h5>
                                                                        <input type='text' id='mat4' maxlength="15">
                                                                        <h5>Usuario</h5>
                                                                        <input type='text' id='us4' maxlength="8">
                                                                        <h5>Contraseña</h5>
                                                                        <input type='password' id='pass4' maxlength="8">
                                                                        <h5>Confirma tu contraseña</h5>
                                                                        <input type='password' id='confpass4' maxlength="8">
                                                                        <h5>CEDULA PROFESIONAL</h5>
                                                                        <input type='text' id='ced4' maxlength="8">
                                                                        <h5>Foto</h5>
                                                                        <input type='file' id='fileFoto4'>
                                                                        <h2>Registra la dirección de tu consultorio</h2>
                                                                        <h5>Colonia</h5>
                                                                        <input type='text' id='col4' maxlength="25">
                                                                        <h5>Calle</h5>
                                                                        <input type='text' id='calle4' maxlength="15">
                                                                        <h5>No.</h5>
                                                                        <input type='text' id='cas4' maxlength="5">
                                                                        <h5>Añade una pequeña descripción de tu esperiencia profesional y tus logros</h5>
                                                                        <textarea id='desc4' rows="10" cols="50"></textarea>
                                                                        
                                                                        <h5>Ingresa tu No. de tarjeta para que los usuarios puedan realizar las compras de tus dietas depositandote a este número</h5>
                                                                        <input type='text' id="cuenta4" maxlength="16">
                                                                        
                                                                        <br/>
                                                                        <button class="main_btn2" href="#" onclick="registrarNutrios();">Registrar</button>
                                                                        <br>
                                                                        <br>
                                                                        <p>La página no se hace responsable por ingresar incorrectamente tu número de tarjeta</p>
                                                                        
                                                                        <br>
                                                                        <br>
                                                                        <div id="respuNutrio"></div>
								</div>
							</div>
						</div>
        			</div>
            </section>
        <br/>
        <br/>
        <br/>
        </div>
        <!--================End About Area =================-->
        
        <!--================Teclas Rapidas=================-->
        <div id="teclas" style="display: none">
            <header class="header_area">
            <div class="main_menu">
            	<nav class="navbar navbar-expand-lg navbar-light">
					<div class="container">
						<!-- Brand and toggle get grouped for better mobile display -->
						<a class="navbar-brand logo_h" href="index.jsp"><img src="img/logo.png" alt=""></a>
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
							<ul class="nav navbar-nav menu_nav ml-auto">
								<li class="nav-item active"><a class="nav-link" href="index.jsp">Inicio</a></li> 
                                                                 
								<li class="nav-item"><a class="nav-link" href="#" onclick="DinamicoDiv('imc');">Calcular IMC</a></li> 
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Contacto</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="indexStarWeb.jsp">Star Web</a></li>
									</ul>
								</li>
								<li class="nav-item"><a class="nav-link" href="#" onclick="DinamicoDiv('preguntaNutri');">¿Eres nutriólogo?</a></li>
                                                                <li class="nav-item"><a class="nav-link" href="#" onclick="DinamicoDiv('sesion');">Inicio Sesión</a></li>
							</ul>
						</div> 
					</div>
            	</nav>
            </div>
        </header>
        
        <!--================Header Menu Area =================-->
        <section class="banner_area">
            <div class="box_1620">
				<div class="banner_inner d-flex align-items-center">
					<div class="container">
						<div class="banner_content text-center">
							<h2>¡Bienvenido!</h2>
							</div>
						</div>
					</div>
				</div>
            
        </section>
        <!--================End Home Banner Area =================-->
        <!--================About Area =================-->
        <section><center>
                                
        				
						
                <br><br><h1>Conoce las teclas rapidas</h1><br>
                                                                        
                                                                        
                                                                        <h3>Inicio</h3>
                                                                        <br><br>
                                                                        <p>Inicio   =   alt + i</p>
                                                                        
                                                                        <p>Calcular IMC   =   alt + l</p>
                                                                        
                                                                        <p>Iniciar sesión   =   alt + s</p>
                                                                        <br><br>
                                                                        
                                                                        <h3>Paciente</h3>
                                                                        <br><br>
                                                                        <p>Inicio   =   alt + i</p>
                                                                        
                                                                        <p>Calcular IMC   =   alt + l</p>
                                                                        
                                                                        <p>Mensajes   =   alt + m</p>
                                                                        
                                                                        <p>Ver mis dietas   =   alt + t</p>
                                                                        <br><br>
                                                                        
                                                                        <h3>Nutriólogo</h3>
                                                                        <br><br>
                                                                        <p>Inicio   =   alt + i</p>
                                                                        
                                                                        <p>Calcular IMC   =   alt + l</p>
                                                                        
                                                                        <p>Mensajes   =   alt + m</p>
                                                                        
                                                                        <p>Publicar   =   alt + p</p>
                                                                        <br><br>
                                                                        
                                                                        <h3>Usuario Web</h3>
                                                                        <br><br>
                                                                        <p>Inicio   =   alt + i</p>
                                                                        
                                                                        <p>Calcular IMC   =   alt + l</p>
                                                                        
                                                                        <p>Registrar calorías de alimentos   =   alt + c</p>
                                                                        
                                                                        <p>Registrar calorías de ejercicios   =   alt + j</p>
                                                                        
                                                                        <p>Generar reporte de calorías   =   alt + r</p>
                                                                        <br><br>
                                                                        
								
        			
            </center></section>
        <br/>
        <br/>
        <br/>
        </div>
        <!--================Teclas Rapidas=================-->
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
                                                    <br>
                                                <div class="f_title">
        						<h3>Teclas rapidas</h3>
        					</div>
                                                <p>¿Deseas navegar más rapido por el sitio?, conoce las teclas rapidas <a href="#" onclick="DinamicoDiv('teclas');">aquí</a></p>
                                                
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
                                                <p>¿No encuentras lo que buscabas?, puedes encontrarlo aquí.</p>
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
