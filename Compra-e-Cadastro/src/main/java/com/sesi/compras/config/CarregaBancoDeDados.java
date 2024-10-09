package com.sesi.compras.config;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sesi.compras.model.Pedido;
import com.sesi.compras.model.Produto;
import com.sesi.compras.model.Status;
import com.sesi.compras.model.TipoUsuario;
import com.sesi.compras.model.Usuario;
import com.sesi.compras.repository.PedidoRepository;
import com.sesi.compras.repository.ProdutoRepository;
import com.sesi.compras.repository.UsuarioRepository;

@Configuration
public class CarregaBancoDeDados {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Bean
    CommandLineRunner executar() {
        return args -> {
            Usuario usuario = new Usuario();
            usuario.setNome("Luiz");
            usuario.setEmail("123teste@example.com");
            usuario.setTelefone("44988178153");
            usuario.setTipoUsuario(TipoUsuario.ALUNO);
            usuarioRepository.save(usuario);
            
            Produto produto1 = new Produto();
            produto1.setNome("Produto A");
            produto1.setEstoque(50);
            produto1.setPreco(25.0);
            produtoRepository.save(produto1);

            Produto produto2 = new Produto();
            produto2.setNome("Produto B");
            produto2.setEstoque(30);
            produto2.setPreco(15.0);
            produtoRepository.save(produto2);
            
            ArrayList<Produto> listaProdutos = new ArrayList<>();
            listaProdutos.add(produto1);
            listaProdutos.add(produto2);
            
            Pedido pedido = new Pedido();
            pedido.setProduto(listaProdutos); 
            pedido.setQuantidade(listaProdutos.size());
            pedido.setData(LocalDate.now());
            
            // Calcular o valor total do pedido
            double valorTotal = 0;
            for (Produto produto : listaProdutos) {
                valorTotal += produto.getPreco();
            }
            pedido.setValor(valorTotal); // Atribuir o valor total ao pedido
            pedido.setStatus(Status.ABERTO);
            
            pedidoRepository.save(pedido);
        };
    }
}
