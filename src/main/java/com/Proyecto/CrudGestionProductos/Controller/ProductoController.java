package com.Proyecto.CrudGestionProductos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Proyecto.CrudGestionProductos.Service.ImProductoService;
import com.Proyecto.CrudGestionProductos.model.Producto;

@Controller
public class ProductoController {
    @Autowired
    private ImProductoService imProductoService;

    /*
    @GetMapping
    public ResponseEntity<?> traer(){
        List<Producto> getp = imProductoService.getListAll();
        return ResponseEntity.ok(getp);
    }

    @PostMapping()
    public ResponseEntity<?> sav(@RequestBody Producto producto){
        Producto ppr = imProductoService.save(producto);
        return ResponseEntity.ok(ppr);
    }
    */

    @RequestMapping("/")
    public String verPaginaPrincipal(Model model){
        return "index";
    }

    @GetMapping("/productos")
    public String verPaginaTabla(Model model){
        List<Producto> productos = imProductoService.getListAll();
        model.addAttribute("productoss", productos);
        return "tablaProductos";
    }
       
    @RequestMapping("/Nuevo")
    public String newProducto(Model model){
        Producto producto = new Producto();
        model.addAttribute("producto",producto);
        return "ProductoNuevo";
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardarProducto(@ModelAttribute("producto") Producto producto){
        imProductoService.save(producto);
        return "redirect:productos";
    } 
    
    @RequestMapping("/editar/{id}")
    public ModelAndView ProductoEditado(@PathVariable(name="id") Long id){
        ModelAndView model = new ModelAndView("EditarProducto");
        Producto producto = imProductoService.findByIdPro(id);
        model.addObject("producto", producto);
        return model;
    }
    @RequestMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable(name="id") Long id){
        imProductoService.delete(id);
        return "redirect:/productos";
    }

    @RequestMapping("/buscar")
    public String buscarProducto(@RequestParam(name = "name") String name, @RequestParam(name = "brand") String brand, @RequestParam(name = "supplier") String supplier, Model model){
        List<Producto> productosEncontrados = imProductoService.findByNombreContainingAndMarcaContainingAndProveedorContaining(name, brand, supplier);
        model.addAttribute("productoss", productosEncontrados);
        return "tablaProductos";
     }

}
