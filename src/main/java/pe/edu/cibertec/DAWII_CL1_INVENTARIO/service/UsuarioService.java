package pe.edu.cibertec.DAWII_CL1_INVENTARIO.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.bd.Rol;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.bd.Usuario;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.request.UsuarioRequest;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.response.ResultadoResponse;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public ResultadoResponse guardarUsuario(UsuarioRequest usuario) {
        String mensaje = "Usuario registrado correctamente";
        Boolean respuesta = true;
        try {
            Usuario objUsuario = new Usuario();
            if (usuario.getIdusuario() > 0){
                objUsuario.setIdusuario(usuario.getIdusuario());
            }
            objUsuario.setUsuario(usuario.getUsuario());
            objUsuario.setNombre(usuario.getNombre());
            objUsuario.setApellido(usuario.getApellido());
            objUsuario.setTelefono(usuario.getTelefono());
            objUsuario.setCorreo(usuario.getCorreo());
            objUsuario.setComentario(usuario.getComentario());

            Boolean estado = false;
            if(usuario.getEstado() != null){
                estado = usuario.getEstado();
            }
            objUsuario.setEstado(estado);

            Rol rol = new Rol();
            rol.setIdrol(usuario.getIdrol());
            objUsuario.setRol(rol);
            usuarioRepository.save(objUsuario);
        }catch (Exception ex){
            mensaje = "Usuario no registrado";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }


}
