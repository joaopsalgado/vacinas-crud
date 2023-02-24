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
<h2 class="row justify-content-center">Adicionar Vacina</h2>
<form action="adicionarVacina" method="post">
    <div class="row justify-content-center">
        <div class="col-md-6">
            Titulo: <input class="form-control" type="text" name="titulo" required>
            Descricao: <input  class="form-control" type="text" name="descricao" required>
            Doses: <input id="doses" onchange="setZeroInputs()" class="form-control" type="number" name="doses" required>
            Periodicidade: <select name="periodicidade" id="periodicidade" class="form-control">
                                           <option value="0"></option>
                                           <option value="1">Dias</option>
                                           <option value="2">Semanas</option>
                                           <option value="3">Meses</option>
                                           <option value="4">Anos</option>
                                </select>
            Intervalo: <input id="intervalo"  value="" class="form-control" type="number" name="intervalo">
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

<script type="text/javascript">
function setZeroInputs() {
  var x = document.getElementById("doses").value;

  if(x <= 1){
    document.getElementById("intervalo").style.display = 'none';
    document.getElementById("periodicidade").style.display = 'none';
    document.getElementById("intervalo").value = 0;
    document.getElementById("periodicidade").value = 0;
  }else{
      document.getElementById("intervalo").style.display = 'block';
      document.getElementById("periodicidade").style.display = 'block';
    }

}
</script>