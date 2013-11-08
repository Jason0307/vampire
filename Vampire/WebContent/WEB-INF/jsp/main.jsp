<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath() %>/css/reset.css">
    <link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath() %>/css/style.css">
    <link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath() %>/css/grid_12.css">
    <link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath() %>/css/slider.css">
    
	<!--[if lt IE 8]>
       <div style=' clear: both; text-align:center; position: relative;'>
         <a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
           <img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
        </a>
      </div>
    <![endif]-->
    <!--[if lt IE 9]>
   		<script type="text/javascript" src="js/html5.js"></script>
    	<link rel="stylesheet" type="text/css" media="screen" href="css/ie.css">
	<![endif]-->
</head>
<body>
  <div class="main">
  <!--==============================header=================================-->
    <header>
        <h1><a href="index.html"><img src="<%=request.getContextPath() %>/images/logo.png" alt=""></a></h1>
		
        <div class="form-search">
		    
            <form id="form-search" method="post">
              <input type="text" value="${_LOGIN_USER.address}" onBlur="if(this.value=='') this.value='Type here...'" onFocus="if(this.value =='Type here...' ) this.value=''"  />
              <a href="#" onClick="document.getElementById('form-search').submit()" class="search_button"></a>
            </form>
        </div>   
        <div class="clear"></div>    
        <nav class="box-shadow">
            <div>
                <ul class="menu">
                    <li class="home-page current"><a href="index.html"><span></span></a></li>
                    <li><a href="about.html">About</a></li>
                    <li><a href="services.html">Services</a></li>
                    <li><a href="projects.html">Projects</a></li>
                    <li><a href="clients.html">Clients</a></li>
                    <li><a href="contacts.html">Contacts</a></li>
                </ul>
                <div class="social-icons">
                    <span>Follow us:</span>
                    <a href="#" class="icon-3"></a>
                    <a href="#" class="icon-2"></a>
                    <a href="#" class="icon-1"></a>
                </div>
                <div class="clear"></div>
            </div>
        </nav>
    </header>   
  <!--==============================content================================-->
    <section id="content"><div class="ic"></div>
        <div id="slide" class="box-shadow">		
            <div class="slider">
                <ul class="items">
                    <li><img src="<%=request.getContextPath() %>/images/slider-1.jpg" alt="" /><div class="banner">The Next Level of Your Success&nbsp;</div></li>
                    <li><img src="<%=request.getContextPath() %>/images/slider-2.jpg" alt="" /><div class="banner">We Offer Different Ways of Problem Solving&nbsp;</div></li>
                    <li><img src="<%=request.getContextPath() %>/images/slider-3.jpg" alt="" /><div class="banner">We Craft Practical Solutions&nbsp;</div></li>
                </ul>
            </div>	
        </div>
        <div class="container_12">
          <div class="grid_12">
            <div class="pad-0 border-1">
                <h2 class="top-1 p0">We Will Show You The Way To Success!</h2>
                <p class="p2">Global is one of <a href="http://blog.templatemonster.com/free-website-templates/" target="_blank" class="link">free website templates</a> created by TemplateMonster.com team. This website template is optimized for 1280X1024 screen resolution. It is also XHTML &amp; CSS valid. The PSD source files of this <a href="http://blog.templatemonster.com/2012/04/16/free-website-template-business-site-jquery-slider/" target="_blank" class="link">Global Template</a> are available for free for the registered members of TemplateMonster.com. Feel free to get it!</p>
            </div>
            <div class="wrap block-1 pad-1">
                <div>
                    <h3>We Work For You</h3>
                    <img src="<%=request.getContextPath() %>/images/page1-img1.jpg" alt="" class="img-border">
                    <p>Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore.</p>
                    <a href="#" class="button">More</a>
                </div>
                <div>
                    <h3>Our Strategies</h3>
                    <img src="<%=request.getContextPath() %>/images/page1-img2.jpg" alt="" class="img-border">
                    <p>Teugiat nulla facilisis at vero eros etmsan et iusto odio dignissim qui blandit praesent luptatum zzril.</p>
                    <a href="#" class="button">More</a>
                </div>
                <div class="last">
                    <h3>Clients Choose Us</h3>
                    <img src="<%=request.getContextPath() %>/images/page1-img3.jpg" alt="" class="img-border">
                    <p>Buis dolore te feugait nulla facilisi lorem ipsum dolor siamet consectetuer adipiscing elit, sed diam nonummy.</p>
                    <a href="#" class="button">More</a>
                </div>
            </div>
          </div>
          <div class="clear"></div>
        </div>
        <div class="aside">
            <div class="container_12">	
                <div class="grid_12">
                    <div class="pad-2 block-2 wrap">
                        <div>
                            <h3 class="p3">Advance Your Business!</h3>
                            <p class="p4">Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore etdolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.</p>
                            <a href="#" class="button">More</a>
                        </div>
                        <div class="last">
                            <h3 class="p3">We Work For You!</h3>
                            <p class="p4">Consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr.</p>
                            <a href="#" class="button">More</a>
                        </div>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
        </div>  
    </section> 
  </div>    
<!--==============================footer=================================-->
    <footer>
		<p>Professional free web templates <a href="http://www.websitetemplatesonline.com" target="_blank">at www.websitetemplatesonline.com</a>. | <a href="http://www.flashtemplates.com/" title="Flash Templates">Flashtemplates.com</a>. Flash Design - the Smart Choice.</p>
        <p>© 2012 Global</p>
        <p><a rel="nofollow" href="http://templatemonster.com/" target="_blank" class="link">Website Template</a> by TemplateMonster.com</p>
    </footer>
    
<script src="<%=request.getContextPath() %>/js/jquery-1.7.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/jquery.easing.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/tms-0.4.x.js"></script>
    <script>
		$(document).ready(function(){				   	
			$('.slider')._TMS({
				show:0,
				pauseOnHover:true,
				prevBu:false,
				nextBu:false,
				playBu:false,
				duration:1000,
				preset:'fade',
				pagination:true,
				pagNums:false,
				slideshow:7000,
				numStatus:true,
				banners:'fromRight',
				waitBannerAnimation:false,
				progressBar:false
			})		
		});
	</script>    	    
</body>
</html>