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
        
        <!--================Header Menu Area =================-->
        <header class="header_area">
            <div class="main_menu">
            	<nav class="navbar navbar-expand-lg navbar-light">
					<div class="container">
						<!-- Brand and toggle get grouped for better mobile display -->
						<a class="navbar-brand logo_h" href="index.html"><img src="img/logo.png" alt=""></a>
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
							<ul class="nav navbar-nav menu_nav ml-auto">
								<li class="nav-item active"><a class="nav-link" href="index.jsp">Inicio</a></li> 
								<li class="nav-item"><a class="nav-link" href="about-us.html">Calcular IMC</a></li> 
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Editar</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="ServActRDatosNutriologo">Perfil</a>
										<li class="nav-item"><a class="nav-link" href="actRStatusNutriologo.jsp">Status</a></li>
									</ul>
								</li> 
								 <li class="nav-item"><a class="nav-link" href="DNutriologoPublicacionRYC.jsp">Publicar</a></li>
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Nombre nutri?logo</a>
									<ul class="dropdown-menu">
										
										<li class="nav-item"><a class="nav-link" href="single-blog.html">Cerrar Sesi?n</a></li>
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
            </div>
        </section>
        <!--================End Home Banner Area =================-->
        
        <!--================About Area =================-->
        <section class="about_area pad_top">
        	<div class="container">
        		<div class="about_inner row">
        			<div class="col-lg-6">
        				<div class="about_text">
        					<form action="ServRegistroDieta" action="get">
                    <h1>Registra plan de dietas</h1>
                    <br><br>
                    <h2>Nombre de dieta:</h2>
                    
                    <input type="text" name="nombre">
                    
                    <h2>Cedula de nutriologo:</h2>
                    
                    <input type="text" name="cedula">
                    </br><br><h2>Costo:</h2>
                   
                    <input type="text" name="costo">
                    <h2>Descripci&oacute;n de la dieta:</h2>
                    
                    <textarea name="descrip"></textarea>
                    <br><input type="submit" name="registro" value="Registrar" class="main_btn2"/>
       </form>
                    <br><div>${resp}</div>
                                                
        				</div>
        			</div>
        			<div class="col-lg-6">
        				<div class="about_img"><img class="img-fluid" src="img/paciente.jpg" alt=""></div>
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
								<img class="img-fluid" src="img/home-blog/usuario.jpeg" alt="">
							</div>
						</div>
						<div class="col-lg-6">
							<div class="about_text">
                                                            <h3>?Solo deseas llevar un control de tus calorias?</h3>
                                                            <h5>Registrate en nuestro sitio y sin costo alguno recibe gran informaci?n nutrimental</h5>
                                                            <p>Registra tus calorias diarias y recibe las mejores recetas y consejos de nuestros nutriologos<br />
                                                            Si en algun momento deseas comprar un plan de dieta puedes hacerlo...</p>
                                                            <br>
                                                            <a href="regRNutriologo2.jsp"><input type='submit' name='registrarse' value='Registrame como Usuario Normal'class="main_btn2"></a>
                                                
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
        			<h2>Services Offered by Us</h2>
        			<p>If you are looking at blank cassettes on the web, you may be very confused at the difference in price. You may see some for as low as $.17 each.</p>
        		</div>
        		<div class="row m0 service_inner">
        			<div class="col-lg-3 col-md-6 p0">
        				<div class="service_img">
        					<img class="img-fluid" src="img/service/service-1.jpg" alt="">
        				</div>
        			</div>
        			<div class="col-lg-3 col-md-6 p0">
        				<div class="service_text">
        					<h4>Spreading <br />Peace to world</h4>
        					<p>If you are looking at blank cassettes on the web, you may be very confused at the difference.</p>
        				</div>
        			</div>
        			<div class="col-lg-3 col-md-6 p0">
        				<div class="service_img">
        					<img class="img-fluid" src="img/service/service-2.jpg" alt="">
        				</div>
        			</div>
        			<div class="col-lg-3 col-md-6 p0">
        				<div class="service_text">
        					<h4>Spreading <br />Peace to world</h4>
        					<p>If you are looking at blank cassettes on the web, you may be very confused at the difference.</p>
        				</div>
        			</div>
        			<div class="col-lg-3 col-md-6 p0">
        				<div class="service_text">
        					<h4>Spreading <br />Peace to world</h4>
        					<p>If you are looking at blank cassettes on the web, you may be very confused at the difference.</p>
        				</div>
        			</div>
        			<div class="col-lg-3 col-md-6 p0">
        				<div class="service_img">
        					<img class="img-fluid" src="img/service/service-3.jpg" alt="">
        				</div>
        			</div>
        			<div class="col-lg-3 col-md-6 p0">
        				<div class="service_text">
        					<h4>Spreading <br />Peace to world</h4>
        					<p>If you are looking at blank cassettes on the web, you may be very confused at the difference.</p>
        				</div>
        			</div>
        			<div class="col-lg-3 col-md-6 p0">
        				<div class="service_img">
        					<img class="img-fluid" src="img/service/service-4.jpg" alt="">
        				</div>
        			</div>
        		</div>
        	</div>
        </section>
        <!--================End Service Area =================-->
        
        <!--================Feedback Area =================-->
        <section class="feedback_area pad_bt">
        	<div class="container">
        		<div class="feedback_inner p_100">
        			<div class="row">
        				<div class="col-lg-5">
        					<div class="feedback_text">
        						<h3>Client?s Feedback</h3>
        						<p>Quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderitin.</p>
        					</div>
        				</div>
        				<div class="col-lg-7">
							<div class="testi_slider_inner">
								<div class="testi_slider owl-carousel">
									<div class="item">
										<div class="media">
											<div class="d-flex">
												<img src="img/testimonials/testi-1.jpg" alt="">
											</div>
											<div class="media-body">
												<p>?Accessories Here you can find the best computer accessory for your laptop, monitor, printer, scanner, speaker, projector, hardware?.</p>
												<h4>Mark Alviro Wiens</h4>
												<h5>CEO at Google</h5>
											</div>
										</div>
									</div>
									<div class="item">
										<div class="media">
											<div class="d-flex">
												<img src="img/testimonials/testi-1.jpg" alt="">
											</div>
											<div class="media-body">
												<p>?Accessories Here you can find the best computer accessory for your laptop, monitor, printer, scanner, speaker, projector, hardware?.</p>
												<h4>Mark Alviro Wiens</h4>
												<h5>CEO at Google</h5>
											</div>
										</div>
									</div>
									<div class="item">
										<div class="media">
											<div class="d-flex">
												<img src="img/testimonials/testi-1.jpg" alt="">
											</div>
											<div class="media-body">
												<p>?Accessories Here you can find the best computer accessory for your laptop, monitor, printer, scanner, speaker, projector, hardware?.</p>
												<h4>Mark Alviro Wiens</h4>
												<h5>CEO at Google</h5>
											</div>
										</div>
									</div>
								</div>
							</div>
        				</div>
        			</div>
        		</div>
        	</div>
        </section>
        <!--================End Feedback Area =================-->
        
        <!--================Instagram Area =================-->
        <section class="instagram_area">
        	<div class="container box_1620">
        		<div class="insta_btn">
        			<a class="btn theme_btn" href="#">Follow us on instagram</a>
        		</div>
        		<div class="instagram_image row m0">
        			<a href="#"><img src="img/instagram/ins-1.jpg" alt=""></a>
        			<a href="#"><img src="img/instagram/ins-2.jpg" alt=""></a>
        			<a href="#"><img src="img/instagram/ins-3.jpg" alt=""></a>
        			<a href="#"><img src="img/instagram/ins-4.jpg" alt=""></a>
        			<a href="#"><img src="img/instagram/ins-5.jpg" alt=""></a>
        			<a href="#"><img src="img/instagram/ins-6.jpg" alt=""></a>
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
        						<h3>About Me</h3>
        					</div>
        					<p>Do you want to be even more successful? Learn to love learning and growth. The more effort you put into improving your skills,</p>
        					<p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
</p>
        				</aside>
        			</div>
        			<div class="col-lg-5 col-sm-6">
        				<aside class="f_widget news_widget">
        					<div class="f_title">
        						<h3>Newsletter</h3>
        					</div>
        					<p>Stay updated with our latest trends</p>
        					<div id="mc_embed_signup">
                                <form target="_blank" action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01" method="get" class="subscribe_form relative">
                                	<div class="input-group d-flex flex-row">
                                        <input name="EMAIL" placeholder="Enter email address" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Email Address '" required="" type="email">
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
        						<h3>Follow Me</h3>
        					</div>
        					<p>Let us be social</p>
        					<ul class="list">
        						<li><a href="#"><i class="fa fa-facebook"></i></a></li>
        						<li><a href="#"><i class="fa fa-twitter"></i></a></li>
        						<li><a href="#"><i class="fa fa-dribbble"></i></a></li>
        						<li><a href="#"><i class="fa fa-behance"></i></a></li>
        					</ul>
        				</aside>
        			</div>
        		</div>
        	</div>
        </footer>
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

