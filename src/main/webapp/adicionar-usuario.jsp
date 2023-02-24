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
<h2 class="row justify-content-center">Adicionar Usuário</h2>
<form action="adicionarUsuario" method="post">
    <div class="row justify-content-center">
        <div class="col-md-6">
            Nome: <input class="form-control" type="text" name="nome" required>
            Data Nascimento: <input  class="form-control" type="date" name="data_nascimento" required>
            Sexo: <select name="sexo" class="form-control" required>
            <option value="M" selected>Masculino</option>
            <option value="F">Feminino</option>
            </select>
            Logradouro: <input class="form-control" type="text" name="logradouro" required>
            Numero: <input class="form-control" type="text" name="numero" required>
            Setor: <input class="form-control" type="text" name="setor" required>
            Cidade: <input class="form-control" type="text" name="cidade" required>
            UF:  <select class="form-control" name="uf" required>
            <option value="AC">1 - Acre</option>
            <option value="AL">2 - Alagoas</option>
            <option value="AP">3 - Amapá</option>
            <option value="AM">4 - Amazonas</option>
            <option value="BA">5 - Bahia</option>
            <option value="CE">6 - Ceará</option>
            <option value="DF">7 - Distrito Federal</option>
            <option value="ES">8 - Espírito Santo</option>
            <option value="GO">9 - Goiás</option>
            <option value="MA">10 - Maranhão</option>
            <option value="MT">11 - Mato Grosso</option>
            <option value="MS">12 - Mato Grosso do Sul</option>
            <option value="MG">13 - Minas Gerais</option>
            <option value="PA">14 - Pará</option>
            <option value="PB">15 - Paraíba</option>
            <option value="PR">16 - Paraná</option>
            <option value="PE">17 - Pernambuco</option>
            <option value="PI">18 - Piauí</option>
            <option value="RJ">19 - Rio de Janeiro</option>
            <option value="RN">20 - Rio Grande do Norte</option>
            <option value="RS">21 - Rio Grande do Sul</option>
            <option value="RO">22 - Rondônia</option>
            <option value="RR">23 - Roraima</option>
            <option value="SC">24 - Santa Catarina</option>
            <option value="SP">25 - São Paulo</option>
            <option value="SE">26 - Sergipe</option>
            <option value="TO">27 - Tocantins</option>
            <option value="EX">99 - Estrangeiro</option>
             </select>
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
</html