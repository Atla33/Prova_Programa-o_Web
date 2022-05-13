package Controllers;

import Banco.frutaRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ClienteController {

        @GetMapping("/cliente")
        public void doListAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
            var writer = response.getWriter();
            writer.println("<html><body>");
            writer.println("<table>");
            var listaFrutas = frutaRepositorio.buscarTodos();
            for (var p:listaFrutas ){
                writer.println("<tr>");

                writer.println("<td>");
                writer.println(p.getNome());
                writer.println("</td>");

                writer.println("<td>");
                writer.println(p.getTamanho());
                writer.println("</td>");

                writer.println("<td>");
                writer.println(p.getPreco());
                writer.println("</td>");

                writer.println("<td>");
                writer.println(p.getDescricao());
                writer.println("</td>");

                writer.println("<td>");
                writer.println(p.getData_validade());
                writer.println("</td>");

                writer.println("<td>");
                writer.println("<a href='/adicionarCarrinho?id="+p.getIdFruta()+"'>Adicionar</a>");
                writer.println("</td>");

                writer.println("</tr>");
            }
            writer.println("</table>");
            writer.println("</body></html>");


            writer.println("\n" +
                    "<a href=\"http://localhost:8080/verCarrinho\">Ver Carrinho</a>");
        }
}
