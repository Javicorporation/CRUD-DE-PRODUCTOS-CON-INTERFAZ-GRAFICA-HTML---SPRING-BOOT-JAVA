package com.Proyecto.CrudGestionProductos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Proyecto.CrudGestionProductos.Service.ProductoService;
import com.Proyecto.CrudGestionProductos.model.Producto;

@RestController
@RequestMapping("Gestion")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @RequestMapping("/")
    public String paginaPrincipal(Model model){
        List<Producto> ListaDeProductos = productoService.getAll();
        model.addAttribute("listaDeProductos", ListaDeProductos);
        return "Index";
    }
        

}
