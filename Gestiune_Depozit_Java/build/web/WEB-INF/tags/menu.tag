<%-- 
    Document   : menu
    Created on : Nov 14, 2020, 1:33:05 AM
    Author     : papad
--%>

<%@tag import="Helpers.UserHelper"%>
<%@tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

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
<!DOCTYPE html>
<html>
    <head>
        <title>Gestiune Depozit</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    
    
    
    <header>        
        <ul class="menu" id="menu">
            <li class="<c:if test="${'ACASA' eq pagina}">active</c:if>"><a href="ACASA.jsp">Acasa</a></li>
            &nbsp;
            <li><form action="CategController" method="POST" class="categForm">
                    <button type="submit" class="categBtn" id="categBtn"
                            style="float: left;width: 200px; height: 40px; background-color: #0e110e; opacity: .8; line-height: 40px; text-align: center; font-size: 20px; text-decoration: none; color: white; display: block; border: 0px" 
                            onmouseover="this.style.backgroundColor='green'" onmouseout="this.style.backgroundColor='#0e110e'"
                            name="submit"
                            value="menu">
                        Meniu
                    </button>
                </form>
                    <ul>
                        <sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"  
                                           url="jdbc:mysql://localhost/php"  
                                           user="root"  password=""/>  

                        <sql:query dataSource="${db}" var="categ">  
                            SELECT * from categ where idParent is null;  
                        </sql:query>    
                        <c:forEach items="${categ.rows}" var="cat">
                            <li class="<c:if test="${cat.den eq pagina}">active</c:if>" <c:if test="${cat.den eq pagina}">style="background-color: green; color: white; "</c:if>>
                                <form action="CategController" method="POST" class="categForm">
                                    <button type="submit" class="categBtn" id="categBtn"
                                            style="float: left;width: 200px; height: 40px; background-color: #0e110e; opacity: .8; line-height: 40px; text-align: center; font-size: 20px; text-decoration: none; color: white; display: block; border: 0px" 
                                            onmouseover="this.style.backgroundColor='green'" onmouseout="this.style.backgroundColor='#0e110e'"
                                            name="submit"
                                            value="${cat.den}">
                                        ${cat.den}
                                    </button>
                                </form>
                            <t:submenu subcateg="${cat.categID}" pagina="${pagina}">   
                            </t:submenu>
                            </li>
                        </c:forEach>
                    </ul>
            <c:if test="${'admin' eq SES_TYPE}">
            &nbsp;    
            <li class="<c:if test="${'CLIENTI' eq pagina}">active</c:if>">  
                <form action="ClientController" method="post" id="clienti">
                    <button type="submit" id="btnClienti">Clienti</button>
                </form>
            </li>
            </c:if>
            </li>
            
            <sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"  
                                url="jdbc:mysql://localhost/php"  
                                user="root"  password=""/>  

             <sql:query dataSource="${db}" var="prods">  
                 SELECT denumire from prod;  
             </sql:query> 
            
            <div class="search-container">
                <form action="SearchController" method="POST" autocomplete="off">
                  <input type="text" placeholder="Search.." id="search" name="search">
                  <button type="submit"><i class="fa fa-search"></i></button>
                </form>
            </div>
            
        </ul>       
    </header>
<style>
* {
  box-sizing: border-box;
}


/*the container must be positioned relative:*/
.autocomplete {
  position: relative;
  display: inline-block;
}



.autocomplete-items {
  position: absolute;
  border: 1px solid #d4d4d4;
  border-bottom: none;
  border-top: none;
  z-index: 99;
  /*position the autocomplete items to be the same width as the container:*/
  top: 100%;
  
}

.autocomplete-items div {
  padding: 10px;
  cursor: pointer;
  background-color: #fff; 
  border-bottom: 1px solid #d4d4d4; 
}

/*when hovering an item:*/
.autocomplete-items div:hover {
  background-color: #e9e9e9; 
}

/*when navigating through the items using the arrow keys:*/
.autocomplete-active {
  background-color: DodgerBlue !important; 
  color: #ffffff; 
}
</style> 
<script>

var availableTags = new Array();
<c:forEach var="row" items="${prods.rows}">
    availableTags.push("${row.denumire}");
</c:forEach>  
console.log(" VALUES => "+availableTags[0]);

function autocomplete(inp, arr) {
  /*the autocomplete function takes two arguments,
  the text field element and an array of possible autocompleted values:*/
  var currentFocus;
  /*execute a function when someone writes in the text field:*/
  inp.addEventListener("input", function(e) {
      var a, b, i, val = this.value;
      /*close any already open lists of autocompleted values*/
      closeAllLists();
      if (!val) { return false;}
      currentFocus = -1;
      /*create a DIV element that will contain the items (values):*/
      a = document.createElement("DIV");
      a.setAttribute("id", this.id + "autocomplete-list");
      a.setAttribute("class", "autocomplete-items");
      /*append the DIV element as a child of the autocomplete container:*/
      this.parentNode.appendChild(a);
      /*for each item in the array...*/
      for (i = 0; i < arr.length; i++) {
        /*check if the item starts with the same letters as the text field value:*/
        if (arr[i].substr(0, val.length).toUpperCase() == val.toUpperCase()) {
          /*create a DIV element for each matching element:*/
          b = document.createElement("DIV");
          /*make the matching letters bold:*/
          b.innerHTML = "<strong>" + arr[i].substr(0, val.length) + "</strong>";
          b.innerHTML += arr[i].substr(val.length);
          /*insert a input field that will hold the current array item's value:*/
          b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
          /*execute a function when someone clicks on the item value (DIV element):*/
          b.addEventListener("click", function(e) {
              /*insert the value for the autocomplete text field:*/
              inp.value = this.getElementsByTagName("input")[0].value;
              /*close the list of autocompleted values,
              (or any other open lists of autocompleted values:*/
              closeAllLists();
          });
          a.appendChild(b);
        }
      }
  });
  /*execute a function presses a key on the keyboard:*/
  inp.addEventListener("keydown", function(e) {
      var x = document.getElementById(this.id + "autocomplete-list");
      if (x) x = x.getElementsByTagName("div");
      if (e.keyCode == 40) {
        /*If the arrow DOWN key is pressed,
        increase the currentFocus variable:*/
        currentFocus++;
        /*and and make the current item more visible:*/
        addActive(x);
      } else if (e.keyCode == 38) { //up
        /*If the arrow UP key is pressed,
        decrease the currentFocus variable:*/
        currentFocus--;
        /*and and make the current item more visible:*/
        addActive(x);
      } else if (e.keyCode == 13) {
        /*If the ENTER key is pressed, prevent the form from being submitted,*/
        e.preventDefault();
        if (currentFocus > -1) {
          /*and simulate a click on the "active" item:*/
          if (x) x[currentFocus].click();
        }
      }
  });
  function addActive(x) {
    /*a function to classify an item as "active":*/
    if (!x) return false;
    /*start by removing the "active" class on all items:*/
    removeActive(x);
    if (currentFocus >= x.length) currentFocus = 0;
    if (currentFocus < 0) currentFocus = (x.length - 1);
    /*add class "autocomplete-active":*/
    x[currentFocus].classList.add("autocomplete-active");
  }
  function removeActive(x) {
    /*a function to remove the "active" class from all autocomplete items:*/
    for (var i = 0; i < x.length; i++) {
      x[i].classList.remove("autocomplete-active");
    }
  }
  function closeAllLists(elmnt) {
    /*close all autocomplete lists in the document,
    except the one passed as an argument:*/
    var x = document.getElementsByClassName("autocomplete-items");
    for (var i = 0; i < x.length; i++) {
      if (elmnt != x[i] && elmnt != inp) {
        x[i].parentNode.removeChild(x[i]);
      }
    }
  }
  /*execute a function when someone clicks in the document:*/
  document.addEventListener("click", function (e) {
      closeAllLists(e.target);
  });
}


/*initiate the autocomplete function on the "myInput" element, and pass along the countries array as possible autocomplete values:*/
autocomplete(document.getElementById("search"), availableTags);
</script>           
            
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
* {box-sizing: border-box;}


.search-container {
  margin-left: 960px;
}

.search-container input[type=text] {
  padding: 6px;
  margin-top: 8px;
  font-size: 17px;
  border: none;
}

.search-container button {
  
  padding: 6px 10px;
  margin-top: 8px;
  margin-right: 16px;
  background: #ddd;
  font-size: 17px;
  border: none;
  cursor: pointer;
}

.search-container button:hover {
  background: #ccc;
}


</style>               
</html>