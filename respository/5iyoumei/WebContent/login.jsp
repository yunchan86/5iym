<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
        <title>登录</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
        <link rel="stylesheet" href="css/matrix-login.css" />
        <link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
        <script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				console.log("11");
				$("#tijiao").click(function(){
					console.log("22");
					var userName = $("#userName") ;
					var passWord = $("#passWord") ;
					var error = $("#error") ;
					if($.trim(userName.val()) == ""){
						error.html("用户名不能为空！") ;
						userName.focus() ;
						return false;
					}
					if($.trim(passWord.val()) == ""){
						error.html("密码不能为空！") ;
						passWord.focus() ;
						return false;
					}
					
					$("#loginform").submit();
					return true ;
				}) ;
			});
		</script>
    </head>
    <body>
	<div id="loginbox">
		<form id="loginform" class="form-vertical" method="POST"
			action="login.action">
			<div class="control-group normal_text">
				<h3>
					<img src="img/logo.png" alt="Logo" />
				</h3>
			</div>
			<div class="control-group">
				<div class="controls">
					<div class="main_input_box">
						<span class="add-on bg_lg"><i class="icon-user"></i></span><input id="userName"
							type="text"  placeholder="userName" name="userName" value='<s:property value="#request.userName"/>' />
					</div>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<div class="main_input_box">
						<span class="add-on bg_ly"><i class="icon-lock"></i></span><input id="passWord"
							type="password" placeholder="passWord" name="passWord" />
					</div>
				</div>
			</div>
			<div id="error" style="color:red; text-align:center;"><s:property value="#request.resultDetail"/></div>
			<div class="form-actions">
				<span class="pull-left"><a href="#"
					class="flip-link btn btn-info" id="to-recover">Lost password?</a></span> <span
					class="pull-right"><input id="tijiao" type="submit"
					class="btn btn-success" /> </span>
			</div>
		</form>
		<form id="recoverform" action="#" class="form-vertical">
			<p class="normal_text">Enter your e-mail address below and we
				will send you instructions how to recover a password.</p>

			<div class="controls">
				<div class="main_input_box">
					<span class="add-on bg_lo"><i class="icon-envelope"></i></span><input
						type="text" placeholder="E-mail address" />
				</div>
			</div>

			<div class="form-actions">
				<span class="pull-left"><a href="#"
					class="flip-link btn btn-success" id="to-login">&laquo; Back to
						login</a></span> <span class="pull-right"><a class="btn btn-info">Reecover</a></span>
			</div>
		</form>
	</div>

	<script src="js/jquery.min.js"></script>  
        <script src="js/matrix.login.js"></script> 
    </body>

</html>