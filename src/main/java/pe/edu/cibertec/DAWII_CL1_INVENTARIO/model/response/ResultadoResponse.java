package pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultadoResponse {
    private Boolean respuesta;
    private String mensaje;

}
