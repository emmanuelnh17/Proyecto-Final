<%-- 
    Document   : index
    Created on : 12 nov 2023, 1:24:18
    Author     : Emmanuel
--%>
<%@page import="com.mycompany.blog.Mensaje"%>
<%@page import="java.util.*"%>
<%@page import="com.mycompany.blog.MensajeDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>


        <!-- Modal -->

        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <form action="index.jsp" method="POST">
                    <div class="modal-header">
                        <h5 class="modal-title" >Di lo que quieras</h5>

                    </div>
                    <div class="modal-body">

                        <div class="form-group">
                            <label >En que piensas?</label>
                            <textarea type="text" class="form-control"  name = "mensaje" rows = "3"></textarea

                        </div>
                        <div class="form-group">
                            <label >Quien eres?</label>
                            <input type="text" name = "autor" class="form-control" >
                        </div>



                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary" name = "enviar">Expresarme</button>
                    </div>
                </form>
            </div>
        </div>
        <%
            MensajeDAO mensajeDao = new MensajeDAO();
            if (request.getParameter("enviar") != null) {
                Mensaje mensaje = new Mensaje(request.getParameter("mensaje"), request.getParameter("autor"));
                mensajeDao.insertar(mensaje);
            }


        %>


        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" >Todos los mensajes</h5>

                </div>
                <%                    List<Mensaje> mensajes = mensajeDao.seleccionar();
                    Collections.reverse(mensajes);

                    for (Mensaje mensaje : mensajes) {


                %>
                <div class="modal-body">
                    <div class="card" >
                        <div class="card-body">
                            <h5 class="card-title"><%=mensaje.getAutor()%></h5>

                            <p class="card-text"><%=mensaje.getMensaje()%></p>
                            <p class="blockquote-footer"><cite><%=mensaje.getFecha()%></cite></p>
                            <a href="editar.jsp?id=<%=mensaje.getId()%>&&mensaje=<%=mensaje.getMensaje()%>&&autor=<%=mensaje.getAutor()%>"class="card-link">Editar</a>
                            <a href="eliminar.jsp?id=<%=mensaje.getId()%>" class="card-link">Eliminar</a>
                        </div>
                    </div>
                </div>
                <%}%>


            </div>
        </div>
    </div>



</body>
</html>
