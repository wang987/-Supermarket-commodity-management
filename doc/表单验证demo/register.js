window.onload = function(){
    var email= document.getElementById("email");
    var divTipMail= document.getElementById("divTipMail");
    //divTipMail.style.display="block";
    var emailOk=document.getElementById("emailOk");
    var mailError=document.getElementById("mailError");

    var password= document.getElementById("password");
     var passwordOk= document.getElementById("passwordOk");
    //divTipMail.style.display="block";
    var divTipPwd=document.getElementById("divTipPwd");
    var pwdError=document.getElementById("pwdError");

     var repwd= document.getElementById("repwd");
     var repwdOk= document.getElementById("repwdOk");
    //divTipMail.style.display="block";
    var repwdError=document.getElementById("repwdError");
    var divTipRepwd=document.getElementById("divTipRepwd");
    var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;

    var reg= /^0-9A-Za-z_{6,16}$/;
    email.onfocus=function(){
        this.parentNode.style.borderColor = "#8dcffe";
        var icon = this.previousSibling.previousSibling;
        icon.style.backgroundPosition = "-100px -48px";
        if(email.value=="")
        {
            divTipMail.style.display="block";
        }
        else if(!myreg.test(email.value))
        {
            mailError.style.display="block";
        }
        else
        {
            emailOk.style.display="block";
        }
    }
    email.onblur=function (){
        this.parentNode.style.borderColor = "#8dcffe";
        var icon = this.previousSibling.previousSibling;
        icon.style.backgroundPosition = "-100px -24px";
        if(email.value=="")
        {
            divTipMail.style.display="block";
            mailError.style.display="none";
            emailOk.style.display="none";
        }
        else if(!myreg.test(email.value))
        {
            mailError.style.display="block";
             divTipMail.style.display="none";
             emailOk.style.display="none";
        }
        else
        {
            emailOk.style.display="block";
             divTipMail.style.display="none";
            mailError.style.display="none";
        }
    }
   password.onfocus=function(){
        this.parentNode.style.borderColor = "#8dcffe";
        var icon = this.previousSibling.previousSibling;
        icon.style.backgroundPosition = "-50px -48px";
        if(password.value=="")
        {
            divTipPwd.style.display="block";
            pwdError.style.display="none";
            passwordOk.style.display="none";
        }

       else if(password.value.length<6&&password.value.length>0)
        {
            pwdError.style.display="block";
             divTipPwd.style.display="none";
            passwordOk.style.display="none";
        }
        else
        {
            passwordOk.style.display="block";
            divTipPwd.style.display="none";
            pwdError.style.display="none";
        }
    }

    password.onblur=function (){
        this.parentNode.style.borderColor = "#8dcffe";
        var icon = this.previousSibling.previousSibling;
        icon.style.backgroundPosition = "-50px -24px";
        if(password.value=="")
        {
            divTipPwd.style.display="block";
            pwdError.style.display="none";
            passwordOk.style.display="none";
        }

           else if(password.value.length<6&&password.value.length>0)
            {
                pwdError.style.display="block";
                 divTipPwd.style.display="none";
                passwordOk.style.display="none";
            }
            else
                {
                    passwordOk.style.display="block";
                    divTipPwd.style.display="none";
                    pwdError.style.display="none";
                }

  }
repwd.onfocus=function(){
        this.parentNode.style.borderColor = "#8dcffe";
        var icon = this.previousSibling.previousSibling;
        icon.style.backgroundPosition = "-75px -48px";
        if(repwd.value=="")
        {
            divTipRepwd.style.display="block";
        }
        else if(password.value!==repwd.value)
        {
           repwdError.style.display="block";
        }
        else
        {
            repwdOk.style.display="block";
        }
    }
   repwd.onblur=function (){
        this.parentNode.style.borderColor = "#8dcffe";
        var icon = this.previousSibling.previousSibling;
        icon.style.backgroundPosition = "-75px -24px";
        if(repwd.value=="")
        {
            divTipRepwd.style.display="block";
            repwdError.style.display="none";
             repwdOk.style.display="none";
        }
        else if(password.value!==repwd.value)
        {
             repwdError.style.display="block";
            divTipRepwd.style.display="none";
            repwdOk.style.display="none";
        }
        else
        {
            repwdOk.style.display="block";
             repwdError.style.display="none";
            divTipRepwd.style.display="none";
        }
  }
}