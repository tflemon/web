<%@page contentType="text/html; charset=Windows-31J"%>
<%@page import="reqattr.SampleBean"%>

<HTML>
<BODY>

<H2>�l�������Ƃ�JSP</H2>

<%
SampleBean bean = (SampleBean)request.getAttribute("bean");
String message = bean.getMessage();
out.println(message);
%>

</BODY>
</HTML>
