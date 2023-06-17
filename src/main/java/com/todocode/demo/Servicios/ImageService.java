package com.todocode.demo.Servicios;

import com.todocode.demo.Entity.Image;
import com.todocode.demo.Excepciones.MyException;
import com.todocode.demo.Repository.ImageRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imagenRepositorio;
    
    public Image guardar(MultipartFile archivo) throws MyException{
        if (archivo != null) {
            try {
                Image imagen = new Image();
                imagen.setMime(archivo.getContentType());
                imagen.setNombre(archivo.getName());
                imagen.setContenido(archivo.getBytes());
                
                return imagenRepositorio.save(imagen);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
    
    public Image actualizar (MultipartFile archivo, String idImagen) throws MyException{
         if (archivo != null) {
            try {
                Image imagen = new Image();
                if (idImagen != null) {
                    Optional<Image> respuesta = imagenRepositorio.findById(idImagen);
                    if (respuesta.isPresent()) {
                        imagen = respuesta.get();
                    }
                }
                
                imagen.setMime(archivo.getContentType());
                imagen.setNombre(archivo.getName());
                imagen.setContenido(archivo.getBytes());
                
                return imagenRepositorio.save(imagen);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
}
