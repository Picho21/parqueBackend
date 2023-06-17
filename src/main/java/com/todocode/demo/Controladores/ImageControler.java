package com.todocode.demo.Controladores;

import com.todocode.demo.Entity.Users;
import com.todocode.demo.Servicios.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


public class ImageControler {
    
    @Autowired
    UserService userService;
    @GetMapping("/perfil/{id}")
    public ResponseEntity<byte[]> imagenUsuario (@PathVariable String id){
        Users user = userService.getOne(id);
        
        byte[] imagen = user.getImage().getContenido();
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        
        return new ResponseEntity<>(imagen, headers, HttpStatus.OK);
    }
    
}
