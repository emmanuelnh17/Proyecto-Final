<%-- 
    Document   : editar
    Created on : 12 nov 2023, 13:36:14
    Author     : Emmanuel
--%>

<%@page import="com.mycompany.blog.Mensaje"%>
<%@page import="com.mycompany.blog.MensajeDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Mensaje</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <!-- Modal -->

        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <form action="editar.jsp" method="POST">
                    <div class="modal-header">
                        <h5 class="modal-title" >Di lo que quieras</h5>

                    </div>
                    <div class="modal-body">

                        <div class="form-group">
                            <input type="hidden" name = "id" class="form-control" value = <%=request.getParameter("id")%>>
                            <label >Editar Mensaje</label>
                            
                            <textarea type="text" class="form-control"  name = "mensaje" rows = "3"><%=request.getParameter("mensaje")%></textarea
                            

                        </div>
                        <div class="form-group">
                            <label >Quien eres?</label>
                            <input type="text" name = "autor" class="form-control" value = <%=request.getParameter("autor")%>>
                        </div>
                        



                    </div>
                    <div class="modal-footer">
                        <a href="index.jsp" type="submit" class="btn btn-danger" >Volver</a>
                        <button type="submit" class="btn btn-primary" name = "enviar">Guardar cambios</button>
                    </div>
                </form>
            </div>
        </div>
                        
        <%
            MensajeDAO mensajeDao = new MensajeDAO();
            
            String id = request.getParameter("id");
            
            if (request.getParameter("enviar") != null) {
                Mensaje mensaje = new Mensaje(Integer.parseInt(id.trim()),request.getParameter("mensaje"), request.getParameter("autor"));
                mensajeDao.editar(mensaje);
                
            }


        %>
    </body>
</html>
