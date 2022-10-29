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
        <script src="administrador.js" type="text/javascript"></script>
        <!--================Header Menu Area =================-->
        <div id="inicioAd">
        <header class="header_area">
            <div class="main_menu">
            	<nav class="navbar navbar-expand-lg navbar-light">
					<div class="container">
						<!-- Brand and toggle get grouped for better mobile display -->
						<a class="navbar-brand logo_h" href="principalRAdministrador.jsp"><img src="img/logo.png" alt=""></a>
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
							<ul class="nav navbar-nav menu_nav ml-auto">
                                                            
								<li class="nav-item active"><a class="nav-link" href="principalRAdministrador.jsp">Inicio</a></li> 
								<li class="nav-item"><a class="nav-link" onclick="buscarOpcionMAdministradorSub();">Subir alimentos</a></li> 
                                                               
							 
                                                                <li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Planes de Nutri�logo</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" onclick="buscarOpcionMAdministrador();">Crear suscripci&oacute;n</a></li>
										<li class="nav-item"><a class="nav-link" onclick="buscarOpcionMAdministrador2();">Editar</a></li>
                                                                                
									</ul>
								</li>
                                                                <li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Ver</a>
									<ul class="dropdown-menu">
                                                                                 <li class="nav-item"><a class="nav-link" onclick="boletin();" >Boletin</a></li>
                                                                        </ul>
								</li>
                                                                <li class="nav-item submenu dropdown">
                                                                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Admin</a>
									<ul class="dropdown-menu">
										
										<li class="nav-item"><a class="nav-link" href="index.jsp">Cerrar Sesi�n</a></li>
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
                    <div id="nose" class="about_inner row">
        			<div class="col-lg-6">
        				<div class="about_text">
        					<h3>�Deseas ver tus ganancias?</h3>
        					<h5>Suscribete a nuestro sitio y empieza a cuidar tu salud comprando un plan de dieta</h5>
        					<p>Conoce los planes de dieta que nuestros nutri�logos tienen para ti.<br />
                                                Administra tu consumo de calorias, recibe consejos y mas...</p>
                                                <br>
                                                <button onclick="buscarOpcionMAdminGanancias();" class="main_btn2">Mis ganancias</button>
                                                
        				</div>
        			</div>
        			<div class="col-lg-6">
        				<div class="about_img"><img class="img-fluid" src="img/paciente.jpg" alt=""></div>
        			</div>
        		</div>
        	</div>
        </section>
        <!--================End About Area =================-->

        <!--================Feedback Area =================-->
        
        <br><br><br></div>
        <!--================End Feedback Area =================-->
        
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
        						<h3>�Qui�nes somos?</h3>
        					</div>
        					<p>Somos una empresa desarrolladora de software, cuyo objetivo es mejorar la calidad de vida de las personas a trav�s de la tecnolog�a y lo que podemos desarrollar, siempre anteponiendo el bienestar de las personas.</p>
        					<p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
StarWeb Copyright &copy;<script>document.write(new Date().getFullYear());</script> Derechos reservados | En colaboracion para la p�gina <i class="fa fa-heart-o" aria-hidden="true"></i> <a href="https://colorlib.com" target="_blank">NutriWeb</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
</p>
        				</aside>
        			</div>
        			<div class="col-lg-5 col-sm-6">
        				<aside class="f_widget news_widget">
        					<div class="f_title">
        						<h3>Contacto</h3>
        					</div>
        					<p>M�ndanos un correo si te agrado la p�gina.</p>
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
        						<h3>S�guenos...!!!</h3>
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
                                                <p>�No encuentras lo que buscabas?, puedes buscar aqu�.</p>
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
