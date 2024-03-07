package com.softgraf.primavera.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.softgraf.primavera.data.entity.Produto;
import com.softgraf.primavera.data.repository.ProdutoRepository;

@Controller
public class HomeController {

	@Autowired
	private ProdutoRepository repository;
	private final int PAGESIZE = 12;
	
	public static List<Produto> listarProdutos(){
		Produto p1 = new Produto(1L, "iphone 15 Pro Max 256GB", 10099.0f, 2);
		Produto p2 = new Produto(2L, "Samsung Galaxy S23 Ultra 1TB", 8600.0f, 3);
		Produto p3 = new Produto(3L, "Motorola Edge 30 Fusion 256GB", 2999.0f, 5);
		return List.of(p1, p2, p3);
	}
	
	@GetMapping("model")
	public String homeModel(Model model) {
		List<Produto> lista = listarProdutos();
		model.addAttribute("produtos", lista);
		
		return "home";
	}
	
	@GetMapping("modelmap")
	public String homeModelMap(ModelMap map) {
		List<Produto> lista = listarProdutos();
		map.put("produtos", lista);	
		return "home";
	}
	
	@GetMapping("modelandview")
	// ModelAndView é uma classe contendo objetos ModelMap e View
	public ModelAndView homeModelAndView() {
		List<Produto> lista = listarProdutos();
		ModelAndView mview = new ModelAndView("home");	// nome da view para carregar
		mview.addObject("produtos", lista);	
		return mview;	// retorna um Model View
	}
	
	@GetMapping("homepage")
	public ModelAndView homePage(ModelAndView mview, @PageableDefault(page=0, size=PAGESIZE) Pageable pageable) {
		mview.setViewName("home");
		Page<Produto> pagina = repository.findAll(pageable);
		mview.addObject("produtos", pagina);
		mview.addObject("uploads", "/uploads");
		
		int next = pagina.hasNext() ? pagina.nextPageable().getPageNumber() : pagina.getNumber();
		mview.addObject("nextPage", next);
		mview.addObject("previousPage", pageable.previousOrFirst().getPageNumber());
		mview.addObject("lastPage", pagina.getTotalPages());
		mview.addObject("pageSize", PAGESIZE);
		mview.addObject("hastNext", pagina.hasNext());
		mview.addObject("hasprevious", pagina.hasPrevious());
		
		return mview;
	}
	
	@GetMapping("/")
	public String index() {
		return "redirect:/homepage";
	}
	
	@GetMapping("sobre")
	public String sobre() {
		return "sobre";
	}
	
}
