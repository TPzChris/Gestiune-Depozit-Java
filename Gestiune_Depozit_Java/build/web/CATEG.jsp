<%-- 
    Document   : CATEG
    Created on : Nov 14, 2020, 4:26:48 AM
    Author     : papad
--%>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>

<div class="menudiv">
<t:menu pagina="${pageContext.request.getParameter('categ')}">
</t:menu>

<t:cont>   
</t:cont>
</div>

<c:if test="${test}">
    <t:filter pagina="${pageContext.request.getParameter('categ')}">   
    </t:filter>
</c:if>


<c:if test="${test == false}">
    <br><br><br><br><br><br><br>
</c:if>

<body style="background-image: url('download.png'); background-repeat: repeat; background-size: cover;">
<div style="background-color: white;">    
    <ul>      
        <c:forEach items="${categs}" var="cat">
            <li style="position:relative !importnant;float: left;">
                <form action="CategController" method="POST" class="categForm">
                    <button type="submit" class="categBtn" id="categBtn"
                            style="position:relative !importnant;float: left;width: 200px; height: 40px; background-color: #0e110e; opacity: .8; line-height: 40px; text-align: center; font-size: 20px; text-decoration: none; color: white; display: block; border: 0px" 
                            onmouseover="this.style.backgroundColor='green'" onmouseout="this.style.backgroundColor='#0e110e'"
                            name="submit"
                            value="${cat.getDen()}">
                        ${cat.getDen()}
                    </button>
                </form>
            </li>
        </c:forEach>
    </ul>
</div>

<c:if test="${test}">
<t:prods></t:prods>
</c:if>   
</body>           