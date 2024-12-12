package com.prueba.clienteconsulta.exception;

public class TipoDocumentoInvalidoException extends Exception {
    public TipoDocumentoInvalidoException(String mensaje) {
        super(mensaje);
    }
}

package com.prueba.clienteconsulta.exception;

public class ClienteNoEncontradoException extends Exception {
    public ClienteNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}