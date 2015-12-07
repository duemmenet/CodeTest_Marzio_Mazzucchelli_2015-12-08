<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function dopoint(who) {
	document.mainForm.WHO.value = who;
	document.mainForm.submit();
}



</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15">
<title>Tennis</title>
<h2 style="margin: 5px">Tennis</h2>
</head>
<body spellCheck="false">
	<form method="POST" action="calcTennis" name="mainForm">
		<input type="hidden" name="WHO" />
		
		<br> 
		<hr>
		<br>
		<table style="width: 100%">
		<tr>
		   <td align="center"  colspan="2"><input type="button" value="new game"  onClick="javascript:dopoint(0)">
		</tr>
			<tr>
			  <%
			  String res;
			   if(null!= (String)request.getSession().getAttribute("res")){
				   res = (String)request.getSession().getAttribute("res");
			   }else{
				   res = "";  
			   }
	           
			  
               String disabled = (String)request.getSession().getAttribute("dis");
		      %>
			  <td align="center"><input type="button" value="point player 1"  <%= disabled %> onClick="javascript:dopoint(1)"> </td>
			  <td align="center"><input type="button" value="point player 2"  <%= disabled %> onClick="javascript:dopoint(2)"> </td>
            <tr>
			<tr>
		      <td align="center"  colspan="2"><input type="button" value="point rnd"  <%= disabled %>  onClick="javascript:dopoint(9)">	       
		    </tr>

		</table>


        <table style="width: 100%">
        
           <tr>
             <td align="center" colspan="2">
			   <%= res %>
	         </td>
	   </table>



	</form>
</body>
</html>