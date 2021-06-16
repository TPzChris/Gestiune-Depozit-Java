<%-- 
    Document   : submenu
    Created on : Jan 3, 2021, 10:08:19 PM
    Author     : papad
--%>



<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="subcateg" required="true" rtexprvalue="true" %>
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

<style>
    
    ul:not(.menu) li:last-child:hover > .sub, .sub li:hover > .sub{
        display: block !important;
        
    }    
    
    ul:not(.menu) li form button:last-child:hover, .sub li form button:hover{
        background-color: green ;
        
    }
    .sub{
        margin-top: -40px ;
    }
    
</style>


<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"  
                url="jdbc:mysql://localhost/php"  
                user="root"  password=""/>  

<sql:query dataSource="${db}" var="categ">  
 SELECT * from categ where idParent = ?
 <sql:param value="${subcateg}"/>
</sql:query>
<c:if test="${!(categ.rowsByIndex[0][0] eq null)}">
    <ul class="sub" style="position: relative; left: 200px; display: none; height:auto; top: -40px">
        <c:forEach items="${categ.rows}" var="cat">
            <li class="<c:if test="${cat.den eq pagina}">active</c:if>" <c:if test="${cat.den eq pagina}">style="background-color: green; color: white; "</c:if>>
                <form action="CategController" method="POST" class="categForm">
                    <button type="submit" class="categBtn" id="categBtn"
                            style="float: left;width: 200px; height: 40px; background-color: #0e110e; opacity: .8; line-height: 40px; text-align: center; font-size: 20px; text-decoration: none; color: white; display: block; border: 0px;" 
                            onmouseover="this.style.backgroundColor='green'" onmouseout="this.style.backgroundColor='#0e110e'"
                            name="submit"
                            value="${cat.den}">
                        ${cat.den}
                    </button>
                </form>
                <c:if test="${!(categ.rowsByIndex[0][0] eq null)}">
                    <t:submenu subcateg="${cat.categID}" pagina="${pagina}">   
                    </t:submenu> 
                </c:if>
            </li>
        </c:forEach>
    </ul>
</c:if>
