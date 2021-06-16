<%-- 
    Document   : submenu
    Created on : Jan 3, 2021, 10:08:19 PM
    Author     : papad
--%>



<%-- The list of normal or fragment attributes can be specified here: --%>

<%@attribute name="pagina" required="true" rtexprvalue="true" %>

<%-- any content can be specified here e.g.: --%>
<%@tag import="java.sql.DriverManager"%>
<%@tag import="java.util.ArrayList"%>
<%@tag import="java.sql.ResultSet"%>
<%@tag import="java.sql.PreparedStatement"%>
<%@tag import="java.sql.Connection"%>
<%@tag import="java.sql.SQLException"%>
<%@tag import="javax.servlet.ServletException"%>
<%@tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>


<br><br><br><br><br><br><br>

<div class="wrapper">
  <fieldset class="filter-price">

    <div class="price-field" id="price-field">
      <c:choose>
          <c:when test="${Number.isInteger(max)}">
              <input type="range" name="min" min="0" max="500" value="${min}" id="lower">
              <input type="range" name="max" min="0" max="500" value="${max}" id="upper">
          </c:when>
          <c:otherwise>  
              <input type="range" name="min" min="0" max="500" value="0" id="lower">
              <input type="range" name="max" min="0" max="500" value="500" id="upper">
          </c:otherwise>    
      </c:choose>
    </div>
    <div class="price-wrap">
      <span class="price-title">
          <form action="FilterController" id="filterForm" method="POST">
              <input type="hidden" name="hid" value="${pageContext.request.getParameter('categ')}"/>
              <button type="submit" id="btnFilter" style="width: 50px; height: 30px; background-color: #0e110e; opacity: .8; line-height: 40px; text-align: center; font-size: 20px; text-decoration: none; color: white; display: block; border: 0px;">Filter</button>
          </form>
      </span>
      <div class="price-container">
        <div class="price-wrap-1">

          <label for="one"></label>
          <input id="one" name="one" form="filterForm" value="${min}">
        </div>
        <div class="price-wrap_line">-</div>
        <div class="price-wrap-2">
          
          <input id="two" name="two" form="filterForm" value="${max}">
          <label for="two">LEI</label>
        </div>
      </div>
    </div>
  </fieldset>
</div>

<style>
    
body {
  font-family: 'Karla', 'Arial', sans-serif;
  font-weight: 500;
  background: #fff;
}

p {
  padding: 0;
  margin: 0;
}

.wrapper {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.filter-price {
  width: 220px;
  border: 0;
  padding: 0;
  margin: 0; 
}

.price-title {
  position: relative;
  color: #fff;
  font-size: 14px;
  line-height: 1.2em;
  font-weight: 400;
  background: green;
  padding:10px;
}

.price-container {
    display: flex;
    border: 1px solid #ccc;
    padding: 5px;
    margin-left: 57px;
    width:120px;
    background-color: white;
}

.price-field {
  position: relative;
  width: 100%;
  height: 36px;
  box-sizing: border-box;
  padding-top: 15px;
  padding-left: 0px;
}

.price-field input[type=range] {
    position: absolute;
}

/* Reset style for input range */

.price-field input[type=range] {
  width: 100%;
    height: 7px;
border: 1px solid #000;
    outline: 0;
    box-sizing: border-box;
    border-radius: 5px;
    pointer-events: none;
    -webkit-appearance: none;
}

.price-field input[type=range]::-webkit-slider-thumb {
    -webkit-appearance: none;
}

.price-field input[type=range]:active,
.price-field input[type=range]:focus {
  outline: 0;
}

.price-field input[type=range]::-ms-track {
  width: 188px;
  height: 2px; 
  border: 0;
  outline: 0;
  box-sizing: border-box;
  border-radius: 5px;
  pointer-events: none;
  background: transparent;
  border-color: transparent;
  color: red;
  border-radius: 5px;
}

/* Style toddler input range */

.price-field input[type=range]::-webkit-slider-thumb { 
  /* WebKit/Blink */
    position: relative;
    -webkit-appearance: none;
    margin: 0;
    border: 0;
    outline: 0;
    border-radius: 50%;
    height: 10px;
    width: 10px;
    margin-top: -4px;
    background-color: #fff;
    cursor: pointer;
    cursor: pointer;
    pointer-events: all;
    z-index: 100;
}

.price-field input[type=range]::-moz-range-thumb { 
  /* Firefox */
  position: relative;
  appearance: none;
  margin: 0;
  border: 0;
  outline: 0;
  border-radius: 50%;
  height: 10px;
  width: 10px;
  margin-top: -5px;
  background-color: #fff;
  cursor: pointer;
  cursor: pointer;
  pointer-events: all;
  z-index: 100;
}

.price-field input[type=range]::-ms-thumb  { 
  /* IE */
  position: relative;
  appearance: none;
  margin: 0;
  border: 0;
  outline: 0;
  border-radius: 50%;
  height: 10px;
  width: 10px;
  margin-top: -5px;
  background-color: #242424;
  cursor: pointer;
  cursor: pointer;
  pointer-events: all;
  z-index: 100;
}

/* Style track input range */

.price-field input[type=range]::-webkit-slider-runnable-track { 
  /* WebKit/Blink */
  width: 188px;
  height: 2px;
  cursor: pointer;
  background: #555;
  border-radius: 5px;
}

.price-field input[type=range]::-moz-range-track { 
  /* Firefox */
  width: 188px;
  height: 2px;
  cursor: pointer;
  background: #242424;
  border-radius: 5px;
}

.price-field input[type=range]::-ms-track { 
  /* IE */
  width: 188px;
  height: 2px;
  cursor: pointer;
  background: #242424;
  border-radius: 5px;
}

/* Style for input value block */

.price-wrap {
  display: flex;
  color: #242424;
  font-size: 14px;
  line-height: 1.2em;
  font-weight: 400;
  margin-bottom: 0px;
}

.price-wrap-1, 
.price-wrap-2 {
  display: flex;
  margin-left: 0px;
}

.price-title {
  margin-right: 5px;
}

.price-wrap_line {
    margin: 6px 0px 5px 5px;
}

.price-wrap #one, 
.price-wrap #two {
  width: 30px;
  text-align: right;
  margin: 0;
  padding: 0;
  margin-right: 2px;
  background:  0;
  border: 0;
  outline: 0;
  color: #242424;
  font-family: 'Karla', 'Arial', sans-serif;
  font-size: 14px;
  line-height: 1.2em;
  font-weight: 400;
}

.price-wrap label {
    text-align: right;
    margin-top: 6px;
    padding-left: 5px;
}

/* Style for active state input */
    
.price-field input[type=range]:hover::-webkit-slider-thumb {
  box-shadow: 0 0 0 0.5px #242424;
  transition-duration: 0.3s;
}

.price-field input[type=range]:active::-webkit-slider-thumb {
  box-shadow: 0 0 0 0.5px #242424;
  transition-duration: 0.3s;
}
    
</style>

<script>
    
var lowerSlider = document.querySelector('#lower');
var  upperSlider = document.querySelector('#upper');

document.querySelector('#two').value=upperSlider.value;
document.querySelector('#one').value=lowerSlider.value;

var  lowerVal = parseInt(lowerSlider.value);
var upperVal = parseInt(upperSlider.value);

upperSlider.oninput = function () {
    lowerVal = parseInt(lowerSlider.value);
    upperVal = parseInt(upperSlider.value);

    if (upperVal < lowerVal + 4) {
        lowerSlider.value = upperVal - 4;
        if (lowerVal == lowerSlider.min) {
        upperSlider.value = 4;
        }
    }
    document.querySelector('#two').value=this.value
};

lowerSlider.oninput = function () {
    lowerVal = parseInt(lowerSlider.value);
    upperVal = parseInt(upperSlider.value);
    if (lowerVal > upperVal - 4) {
        upperSlider.value = lowerVal + 4;
        if (upperVal == upperSlider.max) {
            lowerSlider.value = parseInt(upperSlider.max) - 4;
        }
    }
    document.querySelector('#one').value=this.value
};     
 
</script>