package br.com.vacinas;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/teste"})
public class PrimeiraServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest reqquest, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer =  response.getWriter();
        writer.print("teste");
    }
}
