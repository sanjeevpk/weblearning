<!--
 * Copyright 2013. All rights reserved by AdvocatesOnline. 
 * Do not copy or try to reproduce the source file.
 * Please write to admin@advocatesonline.com for any communications.
 *
 * Author           : Sanjeev Kulkarni
 * Project          : AdvocatesOnline
 * Created On       : 29-May-2013 12:07:00 PM
 *
 *<b>Revision History</b>
 *-------------------------------------------------------------------------------------------------------------------------------------------------
 *<b> Sl No.  | Changed By                    | Date & Time          		| Remarks                                                                     
 *-------------------------------------------------------------------------------------------------------------------------------------------------
 *     1      | Sanjeev Kulkarni              | 15-May-2013 8:46:11 PM      | Initial Version
 * 
 *
-->


<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
		<form name="doublecombo" action = "ComboResult.jsp" method = "post">
			<p>
				<select multiple name="select1" size=10 style="width:250px;" onChange="redirect(this.options.selectedIndex)">
					<option>Technology Sites</option>
					<option>News Sites</option>
					<option>Search Engines</option>
				</select>
				
				<select name="select2" multiple size=10 style="width:250px;">
					<option value="http://javascriptkit.com">JavaScript Kit</option>
					<option value="http://www.news.com">News.com</option>
					<option value="http://www.wired.com">Wired News</option>
				</select>
		
				<input type="submit" name="test" value="Go!" >
			</p>
			<script>
				<!--
				
				/*
				Double Combo Script Credit
				By JavaScript Kit (www.javascriptkit.com)
				Over 200+ free JavaScripts here!
				*/
				
				var groups=document.doublecombo.select1.options.length
				var group=new Array(groups)
				for (i=0; i<groups; i++)
				group[i]=new Array()
				
				group[0][0]=new Option("JavaScript Kit","http://javascriptkit.com")
				group[0][1]=new Option("News.com","http://www.news.com")
				group[0][2]=new Option("Wired News","http://www.wired.com")
				
				group[1][0]=new Option("CNN","http://www.cnn.com")
				group[1][1]=new Option("ABC News","http://www.abcnews.com")
				
				group[2][0]=new Option("Hotbot","http://www.hotbot.com")
				group[2][1]=new Option("Infoseek","http://www.infoseek.com")
				group[2][2]=new Option("Excite","http://www.excite.com")
				group[2][3]=new Option("Lycos","http://www.lycos.com")
				
				var temp=document.doublecombo.select2;
				
				function redirect(x){
				for (m=temp.options.length-1;m>0;m--)
				temp.options[m]=null
				for (i=0;i<group[x].length;i++){
				temp.options[i]=new Option(group[x][i].text,group[x][i].value)
				}
				temp.options[0].selected=true
				}
				
				function go(){
				location=temp.options[temp.selectedIndex].value
				}
				//-->
			</script> 
		</form>
	</body>
</html>