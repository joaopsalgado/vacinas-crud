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
<h2 class="row justify-content-center">Consultar Vacina</h2>
    <div class="row justify-content-center">
        <div class="col-md-6">
            Titulo: <input class="form-control" type="text" name="titulo" disabled value="${vacina.titulo}">
            Descricao: <input  class="form-control" type="text" name="descricao" disabled value="${vacina.descricao}">
            Doses: <input class="form-control" type="text" name="doses" disabled value="${vacina.doses}">
            Periodicidade: <input class="form-control" type="text" name="periodicidade" disabled value="${vacina.periodicidade}">
            Intervalo: <input class="form-control" type="text" name="intervalo" disabled value="${vacina.intervalo}">
            <br>

               <a href="listarVacinas" class="btn btn-primary">
                                        Voltar
                                        </a>
        </div>
    </div>
</body>
</html>