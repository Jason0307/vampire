<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>注册</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" media="screen" href="<%=request.getContextPath() %>/css/zzsc.css" />
  </head>
  
  <body>
   <form id="msform" action="<%=request.getContextPath() %>/dashboard/user/register" method="POST">
	<!-- progressbar -->
	<ul id="progressbar">
		<li class="active">Account Setup</li>
		<li>Social Profiles</li>
		<li>Personal Details</li>
	</ul>
	<!-- fieldsets -->
	<fieldset>
		<h2 class="fs-title">Create your account</h2>
		<h3 class="fs-subtitle">Basic Info</h3>
		<div class="control-group">
		     <div class="controls">
		       <input type="text" name="email" placeholder="Email" />
			  </div>
		</div>
        <div class="control-group">
		      <div class="controls">		
		         <input type="password" name="pass" id="pass"placeholder="Password" />
			  </div>
        </div>
        <div class="control-group">
		      <div class="controls">		
		         <input type="password" name="cpass" placeholder="Confirm Password" />
			  </div>
		</div>	  
		<input type="button" name="next" class="next action-button first" value="Next" />
	</fieldset>
	<fieldset>
		<h2 class="fs-title">Social Profiles</h2>
		<h3 class="fs-subtitle">Your presence on the social network</h3>
		<div class="control-group">
		     <div class="controls">
		         <input type="text" name="qq" id="qq" placeholder="QQ" />
		     </div>
		</div>
		<div class="control-group">
		     <div class="controls">
		        <input type="text" name="weibo" id="weibo" placeholder="Sina Weibo" />
			 </div>
		</div>
        <div class="control-group">
		     <div class="controls">		
		         <input type="text" name="facebook" id="facebook" placeholder="Facebook(Optional)" />
			 </div>
		</div>	 
		<input type="button" name="previous" class="previous action-button" value="Previous" />
		<input type="button" name="next" class="next action-button second" value="Next" />
	</fieldset>
	<fieldset>
		<h2 class="fs-title">Personal Details</h2>
		<h3 class="fs-subtitle">We will never sell it</h3>
		<div class="control-group">
		     <div class="controls">	
		        <input type="text" name="fname" id="fname" placeholder="First Name" />
			 </div>
		</div>	 
		<div class="control-group">
		     <div class="controls">			
		        <input type="text" name="lname" id="lname" placeholder="Last Name" />
			 </div>
		</div>
        <div class="control-group">
		     <div class="controls">		 
        		<input type="text" name="phone" id="phone" placeholder="Phone" />
			 </div>
		</div>	 
		<div class="control-group">
		     <div class="controls">	
		         <textarea name="address" id="address" placeholder="Address"></textarea>
			 </div>
		</div>	 
		<input type="button" name="previous" class="previous action-button" value="Previous" />
		<input type="submit" name="zhubao" class="submit action-button" value="Submit" />
	</fieldset>
</form>
<script src="<%=request.getContextPath() %>/js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.easing.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/validate.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/zzsc.js" type="text/javascript"></script>
</body>
</html>
