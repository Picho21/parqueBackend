package com.todocode.demo.Servicios;

import com.todocode.demo.Entity.Image;
import com.todocode.demo.Entity.Users;
import com.todocode.demo.Enum.Rol;
import com.todocode.demo.Excepciones.MyException;
import com.todocode.demo.Repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ImageService imagenServicio;

    @Transactional
    public void registrar(MultipartFile archivo, String nombre, String password, String password2) throws MyException {

        validar(nombre, password, password2);

        Users usuario = new Users();
        
        usuario.setName(nombre);
        usuario.setPassword(password);

        usuario.setPassword(new BCryptPasswordEncoder().encode(password));

        usuario.setRol(Rol.ADMIN);

        Image imagen = imagenServicio.guardar(archivo);
        usuario.setImage(imagen);

        userRepository.save(usuario);//persisto al usuario en el repo

    }

    @Transactional
    public void actualizar(MultipartFile archivo, String idUsuario, String nombre, String password, String password2) throws MyException {

        validar(nombre, password, password2);
        Optional<Users> respuesta = userRepository.findById(idUsuario);
        if (respuesta.isPresent()) {
            Users usuario = respuesta.get();
            usuario.setName(nombre);
            

            usuario.setPassword(new BCryptPasswordEncoder().encode(password));

            String idImagen = null;

            if (usuario.getImage() != null) {
                idImagen = usuario.getImage().getId();
            }
            Image imagen = imagenServicio.actualizar(archivo, idImagen);
            usuario.setImage(imagen);

            userRepository.save(usuario);//persisto al usuario en el repo
        }

    }

    private void validar(String nombre, String password, String password2) throws MyException {

        if (nombre.isEmpty() || nombre == null) {
            throw new MyException("El nombre no puede ser nulo o estar vacío");
        }
        if (password.isEmpty() || password == null || password.length() <= 5) {
            throw new MyException("La contraseña no puede estar vacía, y debe tener mas de 5 digitos");
        }
        if (!password.equals(password2)) {
            throw new MyException("Las contraseñas ingresadas deben coincidir");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {
        //Servicio de usuario de sprin. Busco uno en mi base de datos y crear uno de S.Secu con estos parametros
        Users usuario = userRepository.getById(dni);

        if (usuario != null) {

            List<GrantedAuthority> permisos = new ArrayList();//lista de objetos del s.secu

            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRol().toString()); //ROLE_USER
            permisos.add(p);

            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();//recupera los atributos de la solicitud http

            HttpSession session = attr.getRequest().getSession(true);//la variable sesion es un objeto de la interfas httpsession

            session.setAttribute("usuariosession", usuario);//seteamos el atributo usuariosession como llave q tiene los valores del objeto periodista 

            return new User(usuario.getName(), usuario.getPassword(), permisos);
            //
        } else {
            return null;
        }
    }
    
    public Users getOne(String id) {
        return userRepository.getOne(id);
    }
}
