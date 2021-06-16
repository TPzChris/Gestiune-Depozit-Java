<%-- 
    Document   : prods
    Created on : Jan 12, 2021, 8:44:28 AM
    Author     : papad
--%>

<%@tag import="Helpers.UserHelper"%>
<%@tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>

    <div class="container">

    <div class="row">

      <!-- /.col-lg-3 -->

      <div class="col-lg-9" id="col-lg-9">

        <div class="row">
            <c:forEach items="${prods}" var="prod">
                <div class="col-lg-4 col-md-6 mb-4">
                  <div class="card h-100">
                      <form action="ProdController" method="POST">
                          <button type="submit" name="prodButton" value="${prod.getDenumire()}" style="height: auto; width: auto; border: 0"><img class="card-img-top" src="data:image/jpg;base64, ${prod.getImagine()}" alt=""></a></button>
                          <!--<input type="image" class="card-img-top" src="data:image/jpg;base64, ${prod.getImagine()}" alt="Submit" value="${prod.getDenumire()}">-->
                      </form>
                    <!--<a href="#"><img class="card-img-top" src="data:image/jpg;base64, ${prod.getImagine()}" alt=""></a>-->
                    <div class="card-body">
                      <h4 class="card-title">
                        <a href="#">${prod.getDenumire()}</a>
                      </h4>
                      <h5>${prod.getPret()} Lei</h5>
                      <p class="card-text">${prod.getDescriere()}</p>
                    </div>
                    <div class="card-footer">
                      <small class="text-muted">ADAUGA IN COS</small>
                    </div>
                  </div>
                </div>
            </c:forEach>    
            <c:if test="${'admin' eq SES_TYPE}">
                <div>
                    <form action="AddProdController" method="POST">
                        <button type="submit" name="addProdButton">Adauga Produs</button>
                    </form>
                </div>
            </c:if>
        </div>
        <!-- /.row -->

      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

  <!-- Bootstrap core JavaScript -->
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>