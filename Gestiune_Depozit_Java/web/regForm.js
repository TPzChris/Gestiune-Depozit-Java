function formValidation(name, pass, email)
{
var passid = document.getElementById(pass).value;
var uname = document.getElementById(name).value;
var uemail = document.getElementById(email).value;
{
    if(passid_validation(passid,7,12) && userid_validation(uname, 7, 12) && ValidateEmail(uemail))
    {
        
    }
} 
return false;
}

function formValidationPass(name, pass, email)
{
if(document.GetElementById("pass"))    
   var passid = document.getElementById(pass).value;
    
var uname = document.getElementById(name).value;
var uemail = document.getElementById(email).value;
{
    if(document.GetElementById("pass")) if(passid_validation(passid,7,12)) {};
    if(userid_validation(uname, 7, 12) && ValidateEmail(uemail))
    {
        
    }
} 
return false;
}

function userid_validation(uid,mx,my)
{
var uid_len = uid.value.length;
if (uid_len == 0 || uid_len >= my || uid_len < mx)
{
alert("Lungimea username-ului trebuie sa fie cuprinsa intre "+mx+" si "+my);
uid.focus();
return false;
}
return true;
}

function passid_validation(passid,mx,my)
{
var passid_len = passid.value.length;
if (passid_len == 0 ||passid_len >= my || passid_len < mx)
{
alert("Parola trebuie sa aiba lungimea cuprinsa intre "+mx+" si "+my+" caractere");
passid.focus();
return false;
}
return true;
}

function ValidateEmail(uemail)
{
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
if(uemail.value.match(mailformat))
{
return true;
}
else
{
alert("Ati introdus o adresa de email invalida.");
uemail.focus();
return false;
}
}
