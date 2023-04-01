package usandoget3.model;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class ControllerProduto {

	@Autowired
	RepositoryProduto produtoRepository;
	
	// persiste no banco de dados 
	@PostMapping
	public @ResponseBody Produto enviarNovoProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		
		return produto;
	}
	
	
	
	
	@GetMapping(path = "/todos")
	public Iterable<Produto> retornaProduto() {
		return produtoRepository.findAll();
	}
	
	@GetMapping(path = "{id}")
	public Optional<Produto> retornarId(@PathVariable int id){
		return produtoRepository.findById(id);
	}

	
	
	
}
