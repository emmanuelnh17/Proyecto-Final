<%-- 
    Document   : eliminar
    Created on : 12 nov 2023, 16:30:04
    Author     : Emmanuel
--%>

<%@page import="com.mycompany.blog.MensajeDAO"%>
<%@page import="com.mycompany.blog.Mensaje"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String id =request.getParameter("id");
            Mensaje mensaje = new Mensaje(Integer.valueOf(id));
            MensajeDAO mensajeDao = new MensajeDAO();
            mensajeDao.borrar(mensaje);
            request.getRequestDispatcher("index.jsp").forward(request,response);
            
        %>
    </body>
</html>
