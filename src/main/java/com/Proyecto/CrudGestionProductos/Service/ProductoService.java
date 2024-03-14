package com.Proyecto.CrudGestionProductos.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.CrudGestionProductos.Repository.ProductoRepository;
import com.Proyecto.CrudGestionProductos.model.Producto;

@Service
public class ProductoService implements ImProductoService{

    @Autowired 
    ProductoRepository productoRepository;


    @Override
    public List<Producto> getListAll(){
        return (List<Producto>)productoRepository.findAll();
    }

    @Override
    public Producto findByIdPro(long id){
        return productoRepository.findById(id).orElse(null);
    }

    
    
    @Override
    public Producto save(Producto producto){
        return productoRepository.save(producto);
    }

    @Override
    public void delete(long id){
        productoRepository.deleteById(id);
    }


    @Override
    public Producto update(long id, Producto productoUpdate){
        Producto productoEncontrado = findByIdPro(id);
        if(productoEncontrado != null){
            productoEncontrado.setName(productoUpdate.getName());
            productoEncontrado.setBrand(productoUpdate.getBrand());
            productoEncontrado.setSupplier(productoUpdate.getSupplier());
            productoEncontrado.setFechaElb(productoUpdate.getFechaElb());
            productoEncontrado.setPrice(productoUpdate.getPrice());
            return productoRepository.save(productoEncontrado);
        }else{
            return null;
        }
    }

    @Override
    public List<Producto>busquedaProductos(String name, String brand, String supplier){
        return productoRepository.buscarProducto(name, brand, supplier);
    }

    


}
