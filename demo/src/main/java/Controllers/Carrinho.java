package Controllers;

import Banco.frutaRepositorio;
import entidades.Frutas;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequestMapping
public class Carrinho {

    @GetMapping("/adicionarCarrinho")
    public void doAdicionarCarrinho(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        var idProduto = request.getParameter("id");

        var livro = frutaRepositorio.listarProdutosPorId(Integer.parseInt(idProduto));

        HttpSession session = request.getSession();

        if (livro != null){
            if (session.getAttribute("carrinho") != null){
                session.setAttribute("id", livro.getIdFruta());
                session.setAttribute("nome", livro.getNome());
                session.setAttribute("tamanho", livro.getTamanho());
                session.setAttribute("preco", livro.getPreco());
                session.setAttribute("descricao", livro.getDescricao());
                session.setAttribute("data_validade", livro.getData_validade());
                session.setMaxInactiveInterval(60*1);
            }
            HttpSession s = request.getSession(true);
            session.setAttribute("id", livro.getIdFruta());
            session.setAttribute("nome", livro.getNome());
            session.setAttribute("tamanho", livro.getTamanho());
            session.setAttribute("preco", livro.getPreco());
            session.setAttribute("descricao", livro.getDescricao());
            session.setAttribute("data_validade", livro.getData_validade());
            session.setMaxInactiveInterval(60*1);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/cliente");
        dispatcher.forward(request, response);
    }

    @GetMapping("/finalizarCompra")
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.sendRedirect("/cliente");
    }
}
