package com.tienda.tienda_articulos_aseo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda_articulos_aseo.excepciones.*;
import com.tienda.tienda_articulos_aseo.model.*;
import com.tienda.tienda_articulos_aseo.repository.*;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")

public class ClienteControlador {
	@Autowired
	private ClienteRepositorio repositorio;

	//este metodo sirve para listar todos los clientes
	@GetMapping("/cliente")
	public List<Cliente> listarTodosLosClientes() {
		return repositorio.findAll();
	}
	

	//este metodo sirve para guardar el cliente
	@PostMapping("/cliente")
	public Cliente guardarCliente(@RequestBody Cliente cliente) {
		return repositorio.save(cliente);
	}
    
	//este metodo sirve para buscar un cliente
	@GetMapping("/cliente/{id_cliente}")
	public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable Long id){
		Cliente cliente = repositorio.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el cliente con el ID : " + id));
			return ResponseEntity.ok(cliente);
	}
	
	//este metodo sirve para actualizar cliente
	@PutMapping("/empleados/{id_cliente}")
	public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id,@RequestBody Cliente detallesClientes){
		Cliente cliente = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el cliente con el ID : " + id));
		
		cliente.setNombre(detallesClientes.getNombre());
		cliente.setApellido(detallesClientes.getApellido());
		cliente.setDireccion(detallesClientes.getDireccion());
		cliente.setEmail(detallesClientes.getEmail());
		cliente.setFechaNacimiento(detallesClientes.getFechaNacimiento());
		cliente.setTelefono(detallesClientes.getTelefono());
		
		Cliente clienteActualizado = repositorio.save(cliente);
		return ResponseEntity.ok(clienteActualizado);
    }
	
	//este metodo sirve para eliminar un cliente
	@DeleteMapping("/empleados/{id_cliente}")
	public ResponseEntity<Map<String,Boolean>> eliminarEmpleado(@PathVariable Long id){
		Cliente cliente = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el cliente con el ID : " + id));
		
		repositorio.delete(cliente);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
}
