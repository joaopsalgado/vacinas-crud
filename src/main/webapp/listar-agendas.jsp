<html>
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
    <h2 class="row justify-content-center">Lista de Agendas</h2>
    <div class="row justify-content-center">
        <div class="col-auto">
            <table class="table table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Data</th>
                        <th scope="col">Hora</th>
                        <th scope="col">Situação</th>
                        <th scope="col">Data Situação</th>
                        <th scope="col">Observacoes</th>
                        <th scope="col">Usuário</th>
                        <th scope="col">Vacina</th>
                        <th scope="col">Doses</th>
                        <th scope="col">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="agenda" items="${agendas}">
                        <tr>
                            <td><input class="form-control" type="date" name="data" disabled value="${agenda.data}"></td>
                            <td>${agenda.getHora()}</td>
                            <td>${agenda.getSituacao()}</td>
                            <td> <c:if test="${agenda.data_situacao != null}">
                             <input class="form-control" type="date" name="data" disabled value="${agenda.data_situacao}">
                             </c:if>
                             </td>
                            <td>${agenda.getObservacoes()}</td>
                            <td>${agenda.getUsuario().nome}</td>
                            <td>${agenda.getVacina().titulo}</td>
                            <td>${agenda.getVacina().doses}</td>
                            <td>
                                <a class="btn btn-outline-danger btn-small my-2" href="removerAgenda?id=${agenda.id}">Remover Agenda</a>
                                <br />
                                <a class="btn btn-outline-success btn-small my-2" href="consultarAgenda?id=${agenda.id}">Consultar Agenda</a>
                                <br />
                                <c:if test="${agenda.data_situacao == null}">
                                <a class="btn btn-outline-primary btn-small my-2" href="darBaixaAgenda?id=${agenda.id}">Dar Baixa Agenda</a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

           <h2 class="row justify-content-center">Controle</h2>

            <table class="table table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Agendas</th>
                        <th scope="col">Alergias</th>
                        <th scope="col">Usuarios</th>
                        <th scope="col">Vacinas</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <a class="btn btn-outline-primary btn-sm my-2" href="adicionarAgenda">Adicionar Agenda</a>
                        </td>
                        <td>
                            <a class="btn btn-outline-primary btn-sm my-2" href="adicionarAlergia">Adicionar Alergia</a>
                            <br />
                            <a class="btn btn-outline-primary btn-sm my-2" href="listarAlergias">Listar Alergias</a>
                        </td>
                        <td>
                            <a class="btn btn-outline-primary btn-sm my-2" href="adicionarUsuario">Adicionar Usuário</a>
                            <br />
                            <a class="btn btn-outline-primary btn-sm my-2" href="listarUsuarios">Listar Usuários</a>
                        </td>
                        <td>
                            <a class="btn btn-outline-primary btn-sm my-2" href="adicionarVacina">Adicionar Vacina</a>
                            <br />
                            <a class="btn btn-outline-primary btn-sm my-2" href="listarVacinas">Listar Vacinas</a>
                        </td>
                    </tr>
                </tbody>
            </table>
</body>

</html>