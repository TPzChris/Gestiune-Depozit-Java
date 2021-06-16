<%-- 
    Document   : cont
    Created on : Nov 14, 2020, 3:00:08 PM
    Author     : papad
--%>

<%@tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@tag import="java.sql.Connection"%>
<%@tag import="java.sql.DriverManager"%>
<%@tag import="java.sql.PreparedStatement"%>
<%@tag import="java.sql.ResultSet"%>
<%@tag import="java.sql.Blob"%>
<%@tag import="java.awt.image.BufferedImage"%>
<%@tag import="java.io.ByteArrayInputStream"%>
<%@tag import="java.io.IOException"%>
<%@tag import="javax.imageio.ImageIO"%>
<%@tag import="java.io.ByteArrayOutputStream"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>

<%-- any content can be specified here e.g.: --%>

<c:choose>
<c:when test="${SES_NAME eq null}">   
    <div id="guest" class="guest" style="position: absolute; top: 8px; right: 16px; font-size: 18px;">
        <strong>
            <form action="LoginController" method="post">
                    <input type="text" name="uname" placeholder="nume"/>
                    <input type="password" name="pass" placeholder="parola"/>
                    <button type="submit" class="loginbtn">Log in</button>
            </form>
        </strong>
        <strong><a href="register.html">Nu aveti cont?</a></strong>
    </div>
</c:when>
<c:otherwise>
    <div id="user" style="position: absolute; top: 8px; right: 16px; font-size: 18px; background-color: #0e110e; opacity: .8;">
        <ul style="list-style: none;">
            <li>
                <form action="LogoutController" method="post" id="logout">
                    <button type="submit" id="logoutBtn">Log out</button>
                </form>
            </li>
            <li>
                <form action="ProfileController" method="post" id="profile">
                    <button type="submit" id="profileBtn">PROFIL</button>
                </form>
            </li>
            <li><img src="data:image/jpg;base64, ${SES_IMG}" width="40" height="40"/></li> 
        </ul>
    </div>
</c:otherwise>    
</c:choose> 
 
