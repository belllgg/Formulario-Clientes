package com.prueba.clienteconsulta.controller;

import com.prueba.clienteconsulta.dto.ClienteDTO;
import com.prueba.clienteconsulta.exception.ClienteNoEncontradoException;
import com.prueba.clienteconsulta.exception.TipoDocumentoInvalidoException;
import com.prueba.clienteconsulta.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/consultar")
    public ResponseEntity<?> consultarCliente(
            @RequestParam String tipoDocumento,
            @RequestParam String numeroDocumento) {

        try {
            // Validaciones de entrada
            if (tipoDocumento == null || tipoDocumento.isEmpty() ||
                    numeroDocumento == null || numeroDocumento.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Tipo y número de documento son obligatorios");
            }

            ClienteDTO cliente = clienteService.consultarCliente(tipoDocumento, numeroDocumento);
            return ResponseEntity.ok(cliente); // Código 200
        } catch (TipoDocumentoInvalidoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage()); // Código 400
        } catch (ClienteNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); // Código 404
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno del servidor"); // Código 500
        }
    }
}