package com.prueba.clienteconsulta.service;

import com.prueba.clienteconsulta.dto.ClienteDTO;
import com.prueba.clienteconsulta.exception.ClienteNoEncontradoException;
import com.prueba.clienteconsulta.exception.TipoDocumentoInvalidoException;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    public ClienteDTO consultarCliente(String tipoDocumento, String numeroDocumento)
            throws TipoDocumentoInvalidoException, ClienteNoEncontradoException {

        // Validar tipo de documento
        if (!"C".equals(tipoDocumento) && !"P".equals(tipoDocumento)) {
            throw new TipoDocumentoInvalidoException("Tipo de documento inválido");
        }

        // Solo consulta para documento específico como indica la prueba
        if (!"23445322".equals(numeroDocumento)) {
            throw new ClienteNoEncontradoException("Cliente no encontrado");
        }

        // Datos mockeados para el cliente específico
        return ClienteDTO.builder()
            .primerNombre("Juan")
            .segundoNombre("Carlos")
            .primerApellido("Pérez")
            .segundoApellido("Gómez")
            .telefono("3105551234")
            .direccion("Calle 123 # 45-67")
            .ciudadResidencia("Bogotá")
            .build();
    }
}