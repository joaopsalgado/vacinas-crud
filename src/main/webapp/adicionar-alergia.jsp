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
<h2 class="row justify-content-center">Adicionar Alergia</h2>
<form action="adicionarAlergia" method="post">
    <div class="row justify-content-center">
        <div class="col-md-6">
            Nome: <input class="form-control" type="text" name="nome" required>
            <br>
         <input class="form-control btn btn-primary" type="submit" value="Enviar">
           <br>
           <br>
           <a href="listarAgendas" class="form-control btn btn-primary">
            Voltar
           </a>

        </div>



    </div>
</form>

</body>
</html>