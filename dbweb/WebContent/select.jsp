<%@page contentType="text/html; charset=Windows-31J"%>
<%@page import="java.util.List, websample.Account"%>

<html>
<body>


<table border="1">

<tr>
<th>ID
<th>NAME
<th>MONEY

<%
	List list = (List)request.getAttribute("list");
	for(int i=0; i<list.size(); i++){
		Account account = (Account)list.get(i);
%>
		<tr>
			<td><%=account.getId()%>
			<td><%=account.getName()%>
			<td><%=account.getMoney()%>
<%
	}
%>

</table>


</body>
</html>
