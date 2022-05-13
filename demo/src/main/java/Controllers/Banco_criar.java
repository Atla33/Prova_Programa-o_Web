package Controllers;

import Banco.frutaRepositorio;
import entidades.Frutas;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class Banco_criar{

    @GetMapping("/config")
    public void doRemoverCarrinho(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String texto = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur molestie sed nulla sit amet pharetra. Phasellus congue tincidunt placerat. Phasellus et libero id justo malesuada interdum ut eu magna. Praesent est lectus, finibus et velit sed, vehicula ullamcorper enim. Aliquam sit amet porttitor tellus. Aliquam pulvinar elit odio, sit amet dignissim risus pretium nec. Vestibulum id nisl accumsan, convallis lorem quis, efficitur orci. Praesent congue, ligula ac dapibus congue, tortor velit iaculis velit, quis congue purus quam a ante. Quisque et nisl blandit massa vestibulum sodales. Aliquam volutpat nisi ligula, ac rutrum ipsum ultricies et. Maecenas auctor condimentum sodales.";
        Frutas frutas1 = new Frutas("1", "maça","médio", "2", "Maça importada", "05");
        Frutas frutas2 = new Frutas("2", "Banana","médio", "5", "Banana importada", "10");
        Frutas frutas3 = new Frutas("3", "melão","médio", "4", "Melão importada", "04");
        Frutas frutas4 = new Frutas("4", "uva","médio", "8", "Uva importada", "08");
        Frutas frutas5 = new Frutas("5", "melancia","grande", "10", "Melancia importada", "12");

        try {
            frutaRepositorio.criarTabela();
        }catch (Exception e){
            System.out.println(e);
        }

        try {
            frutaRepositorio.inserir(frutas1);
            frutaRepositorio.inserir(frutas2);
            frutaRepositorio.inserir(frutas3);
            frutaRepositorio.inserir(frutas4);
            frutaRepositorio.inserir(frutas5);
            var writer = response.getWriter();
            writer.println("sucesso na criação e população de banco de dados");
        } catch (Exception e){

            var writer = response.getWriter();
            writer.println("fracaçou!");
        }

    }



}
