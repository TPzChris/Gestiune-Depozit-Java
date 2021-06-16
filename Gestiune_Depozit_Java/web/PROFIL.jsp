<%-- 
    Document   : PROFIL
    Created on : Nov 14, 2020, 6:44:32 PM
    Author     : papad
--%>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<link rel="stylesheet" type="text/css" href="profile.css">

<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript" src="JSHelper.js"></script>
<script>

$(function(){
        $('#fpic').change(function(){
                var file = $('#fpic')[0].files[0];
                if (file) {
                    var reader = new FileReader();
                    reader.readAsDataURL(file);
                    reader.onload = function(e) {
                        $(".img").attr("src",e.target.result);
                        document.getElementById('changePic').style.display = 'block';
                        document.getElementById('cancelPic').style.display = 'block';
                    };
                }
        })
})


window.onload = function() {
    document.getElementById('changePic').style.display = 'none';
    document.getElementById('cancelPic').style.display = 'none';
    document.getElementById('cancelEdit').style.display = 'none';
    document.getElementById('confirmEdit').style.display = 'none';
    
};
        
function addd(element, type, name, value){      
    $(element).append($('<input/>').attr({
            type: type,
            name: name,
            value: value
        }));  
        };  
        
function addDiv6(text, idParent){
    
}        
        
function addinputFields6(type, idParent, name, value, text){
    
    var parent = document.getElementById(idParent);
    
    var div1 = document.createElement("div");
    var label = document.createElement("label");
    div1.className = "col-md-6";
    label.innerHTML = text;
    div1.append(label);
    parent.append(div1);
    
    
    var div2 = document.createElement("div");
    var input = document.createElement("input");
    var p = document.createElement("p");
    div2.className = "col-md-6";
    input.type = type;
    input.name = name;
    input.id = name;
    input.value = value;

    //var containerText = document.getElementById(idParent);
    //var containerField = document.getElementById(idParentField);
    p.appendChild(input);
    div2.appendChild(p);
    
    parent.append(div2);
}
    
function toEditProfile() {
        
      
      
      add('profileForm', 'row', 'rowParola2', '');
      addinputFields6("password", "rowParola2", "Ppass1", "", "Reintroduceti parola");
      //add('rowParola2', 'col-md-6', '', '<p><input type="password" name="Ppass1"/></p>');
      //add('rowParola2', 'col-md-6', '', '<label>Reintroduceti parola</label>'); 
      
      add('profileForm', 'row', 'rowParola', '');
      addinputFields6("password", "rowParola", "Ppass", "", "Parola");
      //add('rowParola', 'col-md-6', '', '<p><input type="password" id="Ppass" name="Ppass"/></p>');
      //add('rowParola', 'col-md-6', '', '<label>Modificare parola</label>'); 
        
      add('profileForm', 'row', 'rowName', '');
      addinputFields6("text", "rowName", "Pname", "${current.getName()}", "Nume");
      //add('rowName', 'col-md-6', '', '<p><input type="text" id="Pname" name="Pname" value="${current.getName()}"/></p>');
      //add('rowName', 'col-md-6', '', '<label>Nume</label>');
      
      
     
      document.getElementById('colEmail').innerHTML = '<p><input type="text" id="Pemail" name="Pemail" value="${current.getEmail()}"/></p>';
      document.getElementById('colNrTel').innerHTML = '<p><input type="tel" name="PTel"value="${current.getNrTel()}" required/></p>';
      document.getElementById('colSex').innerHTML = '<p><input type="radio" name="gender" id="male" value="male">Male<br><input type="radio" name="gender" id="female" value="female">Female<br><input type="radio" name="gender" id="other" value="other">Other</p>';
      setGender('${current.getSex()}');  
    
  
    
      jQuery.get('options.txt', function(data) {

         var s = '<select id="country-select" name="country-select">';
         s += data;
         s += '</select>';
         
         document.getElementById('colTara').innerHTML = s;
         
         document.getElementById('country-select').value = '${current.getTara()}';
       });

      document.getElementById('cancelEdit').style.display = 'block';
      document.getElementById('confirmEdit').style.display = 'block';
      
      
}

function setGender(x){
    document.getElementById(x).checked = true;
}    
</script>

<script type="text/javascript" src="regForm.js"></script>



<br><br><br><br><br>
<div class="container emp-profile">
            
                <div class="row">
                    <div class="col-md-4">
                        <div class="profile-img">
                                <img class="img" src="data:image/jpg;base64, ${SES_IMG}" width="40" height="40"/>
                                <br>
                                <br>
                                <form action="ImageController" method="post" name="imageForm" enctype="multipart/form-data">    
                                    <div type="submit" class="file btn btn-lg btn-primary">
                                        Schimba imaginea de profil
                                        <input type="file" id="fpic" name="fpic" accept="image/png, image/jpeg, image/jpg" onchange={handleChange} style="background-position: center;"/>
                                    </div>
                                    <br>
                                    <input type="submit" class="profile-edit-btn" name="btnAddMore" id="changePic" value="Submit"/>
                                </form>
                                <br>
                                <input type="submit" class="profile-edit-btn" name="btnAddMore" id="cancelPic" value="Cancel" onclick="location.reload()"/>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="profile-head">
                                    <h5>
                                        <c:out value="${current.getName()}"/>
                                    </h5>
                                    <h6>
                                        <c:if test = "${'user' ne current.getTip()}">
                                            <c:out value = "${current.getTip()}"/>
                                        </c:if>
                                    </h6>
                                    <br>
                            <ul class="nav nav-tabs" id="myTab" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Despre</a>
                                </li>
                                
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-2">

                        <input type="submit" class="profile-edit-btn" name="btnAddMore" id="cancelEdit" value="Cancel" onclick="location.reload()"/>
                        <input type="submit" class="profile-edit-btn" name="btnAddMore" value="Edit Profile" onclick="toEditProfile(); this.style.display = 'none';"/>
                        <form action="EditProfileController" method="POST">
 `                           <input type="submit" class="profile-edit-btn" name="btnAddMore" id="confirmEdit" value="Confirm" form="profileForm" onclick="formValidationPass('Pname', 'Ppass', 'Pemail');"/>
                        </form>

                    </div>
                </div>
                
                <div class="row">
                    <div style="z-index: -1" class="col-md-4">
                        <br><br><br><br><br><br><br><br><br><br><br>
                    </div>
                    <div class="col-md-8">
                        <div class="tab-content profile-tab" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                <form action="EditProfileController" method="POST" id="profileForm">
                                <div class="row" id="rowEmail">
                                    <div class="col-md-6">
                                        <label>Email</label>
                                    </div>
                                    <div class="col-md-6" id="colEmail">
                                        <p><c:out value="${current.getEmail()}"/></p>
                                    </div>
                                </div>
                                <div class="row" id="rowNrTel">
                                    <div class="col-md-6">
                                        <label>Numar de telefon</label>
                                    </div>
                                    <div class="col-md-6" id="colNrTel">
                                        <p><c:out value="${current.getNrTel()}"/></p>
                                    </div>
                                </div>
                                <div class="row" id="rowSex">
                                    <div class="col-md-6">
                                        <label>Sex</label>
                                    </div>
                                    <div class="col-md-6" id="colSex">
                                        <p><c:out value="${current.getSex()}"/></p>
                                    </div>
                                </div>
                                <div class="row" id="rowTara">
                                    <div class="col-md-6">
                                        <label>Tara</label>
                                    </div>
                                    <div class="col-md-6" id="colTara">
                                        <p><c:out value="${current.getTara()}"/></p>
                                    </div>    
                                </div>
                                </form>            
                            <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Experience</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>Expert</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Hourly Rate</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>10$/hr</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Total Projects</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>230</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>English Level</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>Expert</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Availability</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>6 months</p>
                                            </div>
                                        </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <label>Your Bio</label><br/>
                                        <p>Your detail description</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>           
        </div>





<div class="menudiv">
<t:menu pagina="PROFIL">
</t:menu>
<t:cont>   
</t:cont>
</div>