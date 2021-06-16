<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<html>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<body>
<header>
<div class="menudiv">
<t:menu pagina="ACASA">   
</t:menu>
<t:cont>   
</t:cont>
</div>
</header>    
<%--out.println(request.getSession().getAttribute("SES_NAME"));--%>



<style>
    
/* http://meyerweb.com/eric/tools/css/reset/ 
   v2.0 | 20110126
   License: none (public domain)
*/

html, body, div, span, applet, object, iframe,
h1, h2, h3, h4, h5, h6, p, blockquote, pre,
a, abbr, acronym, address, big, cite, code,
del, dfn, em, img, ins, kbd, q, s, samp,
small, strike, strong, sub, sup, tt, var,
b, u, i, center,
dl, dt, dd, ol, ul, li,
fieldset, form, label, legend,
table, caption, tbody, tfoot, thead, tr, th, td,
article, aside, canvas, details, embed, 
figure, figcaption, footer, header, hgroup, 
menu, nav, output, ruby, section, summary,
time, mark, audio, video {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	vertical-align: baseline;
}
/* HTML5 display-role reset for older browsers */
article, aside, details, figcaption, figure, 
footer, header, hgroup, menu, nav, section {
	display: block;
}
body {
	line-height: 1;
}
ol, ul {
	list-style: none;
}
blockquote, q {
	quotes: none;
}
blockquote:before, blockquote:after,
q:before, q:after {
	content: '';
	content: none;
}
table {
	border-collapse: collapse;
	border-spacing: 0;
} 

</style>

<link href='http://fonts.googleapis.com/css?family=Crete+Round' rel='stylesheet' type='text/css'>

<style>
 
body {
    background-color: #000;
    color: #777;
    font: normal 15px "Helvetica Neue", Arial, Helvetica, Geneva, sans-serif;
}
p {
    line-height: 20px;
    margin-bottom: 20px;
}
h1 {
    font-family: 'Crete Round', serif;
    font-weight: bold;
    color: red;
    font-size: 45px;
    margin-bottom: 20px;
}
h2 {
    font-weight: 300;
    color: white;
    font-size: 55px;
    background-color: #003300;
    text-transform: uppercase;
    text-align: center;
    margin-bottom: 20px;
    opacity: 0.5;
}
h3 {
    font-size: 30px;
    color: #444;
    font-weight: bold;
    text-transform: uppercase;
    text-align: center;
    margin-bottom: 20px;
}
h4 {
    font-size: 24px;
    color: #444;
    font-weight: bold;
    text-transform: uppercase;
    margin-bottom: 20px;
}
h5 {
    font-size: 15px;
    color: #444;
    font-weight: bold;
    text-transform: uppercase;
}
a {
    text-decoration: none;
    color: #444;
}
a:hover {
    color: #02b8dd;
}
strong {
    font-weight: bold;
}
small {
    font-size: 13px;
    color: #777;
    font-style: italic;
}
.clear {
    clear: both;
}
.wrapper {
    margin: 0 auto;
    padding: 0 10px;
    width: 940px;
}

header {
    height: 120px;
}
header h1 {
    float: left;
    margin-top: 32px;
}
header h1 .color {
    color: #02b8dd;
}
header nav {
    float: right;
}
header nav ul li {
    float: left;
    display: inline-block;
    margin-top: 50px;
}
header nav ul li a {
    color: #444;
    text-transform: uppercase;
    font-weight: bold;
    display: block;
    margin-right: 20px;
}

#hero-image, #hero-imag {
    height: 580px;
    padding-top: 1px;
    width: 100%;

}
#hero-image h2, #hero-imag h2 {
    margin: 180px 0 40px 0;

}
.button-1 {
    display: block;
    text-align: center;
    background: #444;
    border-radius: 3px;
    color: #fff;
    width: 180px;
    height: 50px;
    font-size: 20px;
    line-height: 50px;
    margin: 0 auto;
}
.button-1:hover {
    background-color: #02b8dd;
    color: #fff;
}

#features ul {
    margin: 80px 0;
}
#features ul li {
    width: 300px;
    padding-top: 140px;
    float: left;
    margin-right: 10px;
    text-align: center;
}
#features ul li.feature-1 {
    background: url('') no-repeat top center;
}
#features ul li.feature-2 {
    background: url('') no-repeat top center;
}
#features ul li.feature-3 {
    background: url('') no-repeat top center;
}

#primary-content {
    background-color: #f8fafa;
    padding: 60px 0;
    text-align: center;
}
#primary-content h3 {
    display: block;
    margin: 0 auto 20px auto;
    width: 400px;
    border-bottom: 1px solid #02b8dd;
    padding: 0 0 20px 0;
}
#primary-content a img {
    margin: 20px 0;
}


#secondary-content {
    padding: 60px 0;
    text-align: center;
}
#secondary-content article {
    width: 460px;
    height: 270px;
    float: left;
    background-color: #f5f5f5;
}
#secondary-content article:first-child {
    margin-right: 20px;
}
#secondary-content article .overlay {
    background: rgba(255, 255, 255, .95);
    height: 230px;
    width: 190px;
    padding: 20px;
}
article h4 {
    border-bottom: 1px solid #02b8dd;
    padding-bottom: 20px;
}
.more-link {
    border: 1px solid #02b8dd;
    color: #02b8dd;
    padding: 6px 20px;
    border-radius: 3px;
}
.more-link:hover {
    background-color: #02b8dd;
    color: #fff;
}

#cta {
    padding: 60px 0;
    text-align: center;
}
#cta h3 {
    display: block;
    margin: 0 auto 20px auto;
    width: 400px;
    border-bottom: 1px solid #02b8dd;
    padding: 0 0 20px 0;
}
.button-2 {
    display: block;
    margin: 0 auto;
    border: 2px solid #02b8dd;
    color: #02b8dd;
    border-radius: 3px;
    width: 180px;
    height: 50px;
    font-size: 20px;
    line-height: 50px;
}
.button-2:hover {
    background-color: #02b8dd;
    color: #fff;
}

footer {
    padding: 60px 0;
    background-color: #f8fafa;
}
#footer-info {
    width: 380px;
    float: left;
    margin-top: 10px;
}
#footer-links {
    width: 520px;
    float: right;
}
#footer-links ul {
    width: 150px;
    float: left;
    margin-left: 20px;
}
#footer-links ul li {
    margin: 10px 0;
}

/*SLIDESHOW*/

.slideshow-container {
  max-width: 1000px;
  position: relative;
  margin: auto;
  left:0;
  right:0;
}

/* Hide the images by default */
.mySlides {
  display: none;
}

/* Next & previous buttons */
.prev, .next {
  cursor: pointer;
  position: absolute;
  top: 50%;
  width: auto;
  margin-top: -22px;
  padding: 16px;
  color: white;
  font-weight: bold;
  font-size: 18px;
  transition: 0.6s ease;
  border-radius: 0 3px 3px 0;
  user-select: none;
}

/* Position the "next button" to the right */
.next {
  right: 0;
  border-radius: 3px 0 0 3px;
}

/* On hover, add a black background color with a little bit see-through */
.prev:hover, .next:hover {
  background-color: rgba(0,0,0,0.8);
}

/* Caption text */
.text {
  color: #f2f2f2;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  bottom: 8px;
  width: 100%;
  text-align: center;
}

/* Number text (1/3 etc) */
.numbertext {
  color: #ffffff;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

/* The dots/bullets/indicators */
.dot {
  cursor: pointer;
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active, .dot:hover {
  background-color: #717171;
}

/* Fading animation */
.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 1.5s;
  animation-name: fade;
  animation-duration: 1.5s;
}

@-webkit-keyframes fade {
  from {opacity: .4}
  to {opacity: 1}
}

@keyframes fade {
  from {opacity: .4}
  to {opacity: 1}
}
    
</style>

<script>
//SLIDESHOW

var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

document.addEventListener("DOMContentLoaded", function() {
   showSlides(1);
});

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1;}    
  if (n < 1) {slideIndex = slides.length;}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";  
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
}


    
</script>

<div style="background-color: #003300;">
<div class="slideshow-container">

  <!-- Full-width images with number and caption text -->
  <div id="hero-image" class="mySlides fade" style="background: #003300 url('images/what-is-half-christmas-workaholics.jpg') no-repeat center scroll;" value="1">
    <div class="numbertext">1 / 3</div>  
        <div class="wrapper">
            <h2>Magazinul nostru va ureaza</br> 
                <strong>sarbatori fericite!</strong></h2>
        </div>
    </div>

  <div id="hero-image" class="mySlides fade" style="background: #003300 url('000-1068x534.jpg') no-repeat center scroll;" value="2">
    <div class="numbertext">2 / 3</div>  
        <div class="wrapper">
            <h2>Unelte de <strong>calitate</strong></br>
                la preturi <strong>avantajoase</strong>!</h2>
            <form action="CategController" method="POST" class="categForm">
                    <button type="submit" class="button-1" id="categBtn"
                            style="position:relative !importnant;width: 200px; height: 40px; background-color: #0e110e; opacity: .8; line-height: 40px; text-align: center; font-size: 20px; text-decoration: none; color: white; display: block; border: 0px" 
                            onmouseover="this.style.backgroundColor='green'" onmouseout="this.style.backgroundColor='#0e110e'"
                            name="submit"
                            value="Unelte">
                        Vezi produse
                    </button>
            </form>
            
        </div>
  </div>

  <div id="hero-image" class="mySlides fade" value="3">
    <div class="numbertext">3 / 3</div>  
        <div class="wrapper">
            <h2><strong>A Minimal, clean</strong><br/>
            layout for web design.</h2>
            <a href="#" class="button-1">Get Started</a>
        </div>
  </div>

  <!-- Next and previous buttons -->
  <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
  <a class="next" onclick="plusSlides(1)">&#10095;</a>
</div>
</div>
<br>

<!-- The dots/circles -->
<div style="text-align:center">
  <span class="dot" onclick="currentSlide(1)"></span>
  <span class="dot" onclick="currentSlide(2)"></span>
  <span class="dot" onclick="currentSlide(3)"></span>
</div>




<div id="features">
    <div class="wrapper">
        <ul>
            <li class="feature-1">
                <h4>Easy to Edit</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam mollis turpis ac libero interdum, id fringilla purus feugiat. Etiam malesuada mattis nibh at bibendum.</p>
            </li>
            <li class="feature-2">
                <h4>Layered PSD</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam mollis turpis ac libero interdum, id fringilla purus feugiat. Etiam malesuada mattis nibh at bibendum.</p>
            </li>
            <li class="feature-3">
                <h4>Ready to Go</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam mollis turpis ac libero interdum, id fringilla purus feugiat. Etiam malesuada mattis nibh at bibendum.</p>
            </li>
            <div class="clear"></div>
        </ul>
    </div>
</div>

<div id="primary-content">
    <div class="wrapper">
        <article>
            <h3>Featured Content</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec euismod leo a nibh dignissim tincidunt. Nam ultricies odio ac neque suscipit volutpat. Ut dictum adipiscing felis sed malesuada. Integer porta sem nec nibh hendrerit imperdiet. </p>
            <a href="#"><img src="" alt="video placeholder" /></a>
        </article>
    </div>
</div>

<div id="secondary-content">
    <div class="wrapper">
        <article style="background-image: url('');">
            <div class="overlay">
                <h4>Secondary Content</h4>
                <p><small>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec euismod leo a nibh dignissim tincidunt nam.</small></p>
                <a href="#" class="more-link">View more</a>
            </div>
        </article>
        <article style="background-image: url('');">
            <div class="overlay">
                <h4>Secondary Content</h4>
                <p><small>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec euismod leo a nibh dignissim tincidunt nam.</small></p>
                <a href="#" class="more-link">View more</a>
            </div>
        </article><div class="clear"></div>
    </div>
</div>

<div id="cta">
    <div class="wrapper">
        <h3>Heard Enough?</h3>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec euismod leo a nibh dignissim tincidunt. Nam ultricies odio ac neque suscipit volutpat. Ut dictum adipiscing felis sed malesuada. Integer porta sem nec nibh hendrerit imperdiet. </p>
        <a href="#" class="button-2">Get Started</a>
    </div>
</div>

<footer>
    <div class="wrapper">
        <div id="footer-info">
            <p>Copyright 2014 CompanyName. All rights reserved.</p>
            <p><a href="#">Terms of Service</a> I <a href="#">Privacy</a></p>
        </div>
        <div id="footer-links">
            <ul>
                <li><h5>Company</h5></li>
                <li><a href="#">About Us</a></li>
                <li><a href="#">Meet The Team</a></li>
                <li><a href="#">What We Do</a></li>
                <li><a href="#">Careers</a></li>
            </ul>
        </div>
        <div class="clear"></div>
    </div>
</footer>
<script>
  showSlides(slideIndex);
</script>
</body>
</html>
