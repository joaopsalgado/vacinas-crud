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
<h2 class="row justify-content-center">Dar Baixa Agenda</h2>
<form action="darBaixaAgenda" method="post">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <input class="form-control" type="text" name="id" value="${agenda.id}" hidden>
            Data: <input class="form-control" type="date" name="data" value="${agenda.data}" disabled>
            Hora: <input class="form-control" type="text" name="hora" value="${agenda.hora}" disabled>
            Situação: <input class="form-control" type="text" name="situacao" value="${agenda.situacao}" disabled>
            Data Situação: <input class="form-control" type="date" name="data_situacao" value="${agenda.data_situacao}">
            Observacoes: <input class="form-control" type="text" name="observacoes" value="${agenda.observacoes}" disabled>
            Situação:  <select class="form-control" name="situacao">
                        <option value="Realizado">Realizada</option>
                        <option value="Cancelado">Cancelada</option>
                        </select>
            <br>
            <input class="form-control" type="submit" value="Salvar">
        </div>
    </div>
</form>

</body>
</html>
