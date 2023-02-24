<html lang="pt">
    <head>
        <meta charset="UTF-8" />
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> <%@
        page contentType="text/html; charset=UTF-8" %>
        <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
            integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
            crossorigin="anonymous"
        />
    </head>
<body>
<h2 class="row justify-content-center">Consultar Agenda</h2>
    <div class="row justify-content-center">
        <div class="col-md-6">
            Data: <input class="form-control" type="date" name="data" disabled value="${agenda.data}">
            Hora: <input class="form-control" type="time" name="hora" disabled value="${agenda.hora}">
            Situação: <select class="form-control" name="situacao" disabled value="${agenda.situacao}">
                                                         <option value="Agendado">Agendado</option>
                                                         </select>
            Observacoes: <input class="form-control" type="text" name="observacoes" disabled value="${agenda.observacoes}">
            <br>

               <a href="listarAgendas" class="btn btn-primary">
                                    Voltar
                                    </a>

        </div>
    </div>




</body>
</html>