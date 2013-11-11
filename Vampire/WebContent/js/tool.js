jQuery(document).ready(function($){
   $(".sendEmail").click(function(){
     var name = $("#name").val();
     var email = $("#email").val();
     var message = $("#message").val();
     
     $.ajax({
       url:getRootPath()+"/dashboard/email/send",
       data:{
         name:name,
         email:email,
         message:message
        },
        type:"POST",
        success:function(data){
          $("#note").html('<div style="text-align:center;">Thank you for contacting me. I will be in touch with you very soon.</div>');
        },
        error:function(data){
        
        }
     });
 });
 
  function getRootPath(){  
    var curWwwPath=window.document.location.href;  
    var pathName=window.document.location.pathname;  
    var pos=curWwwPath.indexOf(pathName);  
    var localhostPath=curWwwPath.substring(0,pos);  
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);  
    return localhostPath+projectName;  
}
});
