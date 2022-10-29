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
        <script src="ScriptUsuarioWeb.js" type="text/javascript"></script>
        <!--================Header Menu Area =================-->
            <a href="principalRUsuarioWeb.jsp" accesskey="i"></a>
            <a onclick="DinamicoDiv('imc1');" accesskey="l"></a>
            <a onclick="contarCalorias();" accesskey="c"></a>
            <a onclick="registrarregiEjercicio();" accesskey="j"></a>
            <a onclick="reporteSemanalCalorias();" accesskey="r"></a>
        <div id="inicioUs">
            
        <header class="header_area">
            <div class="main_menu">
            	<nav class="navbar navbar-expand-lg navbar-light">
					<div class="container">
						<!-- Brand and toggle get grouped for better mobile display -->
						<a class="navbar-brand logo_h" href="principalRUsuarioWeb.jsp"><img src="img/logo.png" alt=""></a>
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
							<ul class="nav navbar-nav menu_nav ml-auto">
								<li class="nav-item active"><a class="nav-link" href="principalRUsuarioWeb.jsp">Inicio</a></li> 
                                                                <li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Ver</a>
									<ul class="dropdown-menu">
                                                                                 <li class="nav-item"><a class="nav-link" onclick="boletinUW();" >Boletin</a></li>
                                                                        </ul>
								</li>
								<li class="nav-item"><a class="nav-link" onclick="DinamicoDiv('imc1');">Calcular IMC</a></li> 
								
                                                                <li class="nav-item submenu dropdown">
                                                                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Cita con nutri&oacute;logo</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" onclick="buscarOpcionMUsuWebCita();">Agendar</a>
                                                                                    <li class="nav-item"><a class="nav-link" onclick="buscarOpcionMUsuWebCancelarCita();">Cancelar</a>
                                                                                        <li class="nav-item"><a class="nav-link" onclick="buscarOpcionMUsuaRecordadCita();">Recordatorios</a>
										
									</ul>
								</li> 
								
                                                                <li class="nav-item"><a class="nav-link" onclick="actualizarUsuarioWeb();">Editar Datos</a></li> 
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Usuario Web</a>
									<ul class="dropdown-menu">
										
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
							<h2>Bienvenido...!!!</h2>
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
        					<h3>¿Deseas contar tus calorias?</h3>
        					<h5>Suscribete a nuestro sitio y empieza a cuidar tu salud comprando un plan de dieta</h5>
        					<p>Conoce los planes de dieta que nuestros nutriólogos tienen para ti.<br />
                                                Administra tu consumo de calorias, recibe consejos y mas...</p>
                                                <br>
                                                <button onclick="contarCalorias();" class="main_btn2">Contar calorias</button>
                                                
        				</div>
        			</div>
        			<div class="col-lg-6">
        				<div class="about_img"><img class="img-fluid" src="img/calo.png" alt=""></div>
        			</div>
        		</div>
        	</div>
        </section>
        <!--================End About Area =================-->
        
        <!--================About Area =================-->
            <section class="about_area pad_top">
                <div class="container">
                                <div class="about_inner row">
        				<div class="col-lg-6">
							<div class="h_blog_img">
								<img class="img-fluid" src="img/home-blog/ejer.png" alt="">
							</div>
						</div>
						<div class="col-lg-6">
							<div class="about_text">
                                                            <h3>Registrar Ejercicio</h3>
                                                            <h5>Registrate en nuestro sitio y sin costo alguno recibe gran información nutrimental</h5>
                                                            <p>Registra tus calorias diarias y recibe las mejores recetas y consejos de nuestros nutriologos<br />
                                                            Si en algun momento deseas comprar un plan de dieta puedes hacerlo...</p>
                                                            <br>
                                                            <button onclick="registrarregiEjercicio();" class="main_btn2">Registrar ejercicio</button>
                                                
                                                        </div>
						</div>
        			</div>
                </div>
            </section>
        <!--================End About Area =================-->
        <!--================About Area =================-->
        <section class="about_area pad_top">
        	<div class="container">
        		<div class="about_inner row">
        			<div class="col-lg-6">
        				<div class="about_text">
        					<h3>Genera tu reporte de calorias aquí</h3>
        					<h5>Suscribete a nuestro sitio y empieza a cuidar tu salud comprando un plan de dieta</h5>
        					<p>Conoce los planes de dieta que nuestros nutriólogos tienen para ti.<br />
                                                Administra tu consumo de calorias, recibe consejos y mas...</p>
                                                <br>
                                                <button onclick="reporteSemanalCalorias();" class="main_btn2">Reporte de calorias</button>
                                                
        				</div>
        			</div>
        			
        		</div>
        	</div>
        </section>
        <!--================End About Area =================-->
        
        
        <!--================Feedback Area =================-->
        
        <br><br><br>
        </div>
        <!--================End Feedback Area =================-->
        
        <!--================Calcular IMC =================-->
        <!--================Header Menu Area =================-->
        <div id="imc1" style="display: none">
        <header class="header_area">
            <div class="main_menu">
            	<nav class="navbar navbar-expand-lg navbar-light">
					<div class="container">
						<!-- Brand and toggle get grouped for better mobile display -->
						<a class="navbar-brand logo_h" href="principalRUsuarioWeb.jsp"><img src="img/logo.png" alt=""></a>
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
							<ul class="nav navbar-nav menu_nav ml-auto">
								<li class="nav-item active"><a class="nav-link" href="principalRUsuarioWeb.jsp">Inicio</a></li> 
                                                                <li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Ver</a>
									<ul class="dropdown-menu">
                                                                                 <li class="nav-item"><a class="nav-link" onclick="boletinUW();" >Boletin</a></li>
                                                                        </ul>
								</li>
								<li class="nav-item"><a class="nav-link" onclick="DinamicoDiv('imc1');">Calcular IMC</a></li> 
								
                                                                <li class="nav-item submenu dropdown">
                                                                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Cita con nutri&oacute;logo</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" onclick="buscarOpcionMUsuWebCita();">Agendar</a>
                                                                                    <li class="nav-item"><a class="nav-link" onclick="buscarOpcionMUsuWebCancelarCita();">Cancelar</a>
                                                                                        <li class="nav-item"><a class="nav-link" onclick="buscarOpcionMUsuaRecordadCita();">Recordatorios</a>
										
									</ul>
								</li> 
								
                                                                <li class="nav-item"><a class="nav-link" onclick="actualizarUsuarioWeb();">Editar Datos</a></li> 
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Usuario Web</a>
									<ul class="dropdown-menu">
										
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
        <!--================Calcular IMC =================-->
        
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

