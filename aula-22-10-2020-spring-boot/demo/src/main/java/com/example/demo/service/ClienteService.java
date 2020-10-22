package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository repository;


    public Cliente fromDTO(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setEndereco(clienteDTO.getEndereco());
        cliente.setNome(clienteDTO.getNome());
        return cliente;
	}

    public Cliente getClienteByCodigo(int codigo){
        
        Optional<Cliente> op = repository.getClienteByCodigo(codigo);
        //verificar a motivacao por tras do Optional
            //pesquisar um pouco mais em: https://blog.algaworks.com/chega-de-nullpointerexception/



        //caso nao encontre o cliente, vai executar o orElseThrow
        //orElseThrow vai retornar o que estiver entre os parenteses do metodo.
        return op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao cadastrado"));
        
        //dentro de orElseThrow, inserimos um conseito de programacao funcional
            //pesquisar um pouco mais em: https://www.devmedia.com.br/programacao-funcional-codigo-limpo-e-padroes-de-projeto/32902

    }

    public Cliente save(Cliente cliente){
        return repository.save(cliente);
    }

    public void removeByCodigo(int codigo){
        
        // Ao estruturar o remove dessa forma, caso exista o cadastro de cliente com este codigo, o cadastro sera excluido.
        // caso contrario, retorna o erro 404 (not found) devido o getClienteByCodigo(), nao necessitando retornar um valor null para a classe controller e realizar a verificacao dentro dela
        repository.remove(getClienteByCodigo(codigo));
        
    }

    public Cliente update(Cliente cliente) {
        //A proxima linha apenas serve para nos retornar se o cliente existe ou nao -> caso nao exista o metodo getClienteByCodigo() retorna o erro 404
        
        getClienteByCodigo(cliente.getCodigo()); //Tem um cliente cadastrado?? caso nao exista, lanca o erro 404

        //aqui atualizamos o cliente
        return repository.update(cliente);
    }

	public List<Cliente> getAllClientes() {
		return repository.getAllClientes();
	}

	

}
