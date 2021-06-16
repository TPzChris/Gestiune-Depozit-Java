<%-- 
    Document   : CLIENTI
    Created on : Nov 14, 2020, 7:46:11 PM
    Author     : papad
--%>

<%@page import="Helpers.UserHelper"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.awt.Image"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.io.ByteArrayInputStream"%>
<%@page import="java.io.IOException"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  

<div class="menudiv">
<t:menu pagina="CLIENTI">   
</t:menu>
<t:cont>   
</t:cont>
</div>

<div id="clientiDiv" style="background-color: aliceblue; position: absolute; margin-top: 10%; height: fit-content; width: 800px">
    
    <div>
        <form action="ExcelController" method="POST">
            <button type="submit" name="excelBtn">Export raport log-uri sub format xlsx</button>
        </form>
    </div>
    
    
    
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css"/>
    <script
        src="https://code.jquery.com/jquery-3.5.1.min.js"
        integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
    crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
    <table id="clienttable" border="2px solid" width="100%" align="center" table-layout="fixed" >
        <thead>
            <tr>
                <th>Id</th>
                <th>Username</th>
                <th>Poza</th>
                <th>Numar de telefon</th>
                <th>Email</th>
                <th>Sex</th>
                <th>Tara</th>
                <th>Stergere</th>
            </tr>
        </thead>

        <tbody>
        <c:forEach items="${clients}" var="user">
            <tr>
            <br>
            <div>
                <td>${user.getIdUser()}</td>
            </div>
            <div>
                <td>${user.getName()}</td>
            </div>
            <div>
                <td><img src="data:image/jpg;base64, ${user.getPoza()}" width="40" height="40"/></td>
            </div>
            <div>
                <td>${user.getNrTel()}</td>
            </div>
            <div>
                <td>${user.getEmail()}</td>
            </div>
            <div>
                <td>${user.getSex()}</td>
            </div>
            <div>
                <td>${user.getTara()}</td>
            </div>
            <div>
                <td>
                    <form action="DelUserController" method="POST">
                        <input type="hidden" name="delHid" value="${user.getName()}"/>
                        <button type="submit" name="delUserButton">Stergere user</button>
                    </form>
                </td>
            </div>
            </tr>
        </c:forEach>
        </tbody>

    </table>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#clienttable').DataTable();
        });
    </script>
    
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {

        var data = google.visualization.arrayToDataTable([
         
        ['Categ', 'Numar de produse'],    
            
        
         <sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"  
                            url="jdbc:mysql://localhost/php"  
                            user="root"  password=""/>  

         <sql:query dataSource="${db}" var="categ">  
             SELECT *, (SELECT count(1) from prod where categID = (select categID from categ where den = c.den)) as ct from categ c where c.categID not in (select idParent from categ where idParent is not null);  
         </sql:query>    
         <c:forEach items="${categ.rows}" var="cat">
             ['${cat.den}',     ${cat.ct}],    
         </c:forEach>  
           
          ['',    0]
        ]);
         
        var options = {
          title: 'Produse din categorii'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
    
    
    <div id="piechart" style="width: 900px; height: 500px;"></div>
</div>