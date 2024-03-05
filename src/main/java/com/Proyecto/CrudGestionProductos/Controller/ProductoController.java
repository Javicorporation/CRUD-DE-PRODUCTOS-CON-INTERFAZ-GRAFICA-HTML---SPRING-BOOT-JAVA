package com.Proyecto.CrudGestionProductos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Proyecto.CrudGestionProductos.Service.ImProductoService;
import com.Proyecto.CrudGestionProductos.model.Producto;

@Controller
@RequestMapping
public class ProductoController {
    @Autowired
    private ImProductoService imProductoService;

    @GetMapping("/")
    public String verPaginaPrincipal(Model model){
        return "index";
    }
    @GetMapping("productos")
    public String verPaginaTabla(Model model){
        List<Producto> productos = imProductoService.getListAll();
        model.addAttribute("productoss", productos);
        return "tablaProductos";
    }
       
    @RequestMapping("/Nuevo")
    public Producto newProducto(Producto producto){
        Producto newP = imProductoService.save(producto);
        return newP;
    }

}
