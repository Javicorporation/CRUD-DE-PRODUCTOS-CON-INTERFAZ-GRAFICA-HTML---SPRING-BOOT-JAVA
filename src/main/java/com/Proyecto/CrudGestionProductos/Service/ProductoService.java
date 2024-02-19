package com.Proyecto.CrudGestionProductos.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.CrudGestionProductos.Repository.ProductoRepository;
import com.Proyecto.CrudGestionProductos.model.Producto;

@Service
public class ProductoService {
    @Autowired 
    ProductoRepository productoRepository;

    public List<Producto> getAll(){
        return productoRepository.findAll();
    }

    public Producto findByIdPro(long id){
        return productoRepository.findById(id).orElse(null);
    }

    public Producto save(Producto producto){
        return productoRepository.save(producto);
    }

    public void delete(long id){
        productoRepository.deleteById(id);
    }

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


}
