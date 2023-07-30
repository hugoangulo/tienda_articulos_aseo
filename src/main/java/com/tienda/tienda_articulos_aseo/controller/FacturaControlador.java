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

public class FacturaControlador {
	
	@Autowired
	private FacturaRepositorio repositorio;

	//este metodo sirve para listar todos las facturas
	@GetMapping("/factura")
	public List<Factura> listarTodasLasFacturas() {
		return repositorio.findAll();
	}
	

	//este metodo sirve para guardar la factura
	@PostMapping("/factura")
	public Factura guardarFactura(@RequestBody Factura factura) {
		return repositorio.save(factura);
	}
    
	//este metodo sirve para buscar una factura
	@GetMapping("/factura/{num_factura}")
	public ResponseEntity<Factura> obtenerFacturaPorId(@PathVariable Long id){
		Factura factura = repositorio.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe la factura con el ID : " + id));
			return ResponseEntity.ok(factura);
	}
	
	//este metodo sirve para actualizar la factura
	@PutMapping("/factura/{num_factura}")
	public ResponseEntity<Factura> actualizarFactura(@PathVariable Long id,@RequestBody Factura detallesFactura){
		Factura factura = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe la factura con el ID : " + id));
		
		factura.setId_cliente(detallesFactura.getId_cliente());
		factura.setFecha(detallesFactura.getFecha());
		
		Factura FacturaActualizada = repositorio.save(factura);
		return ResponseEntity.ok(FacturaActualizada);
    }
	
	//este metodo sirve para eliminar una factura
	@DeleteMapping("/factura/{num_factura}")
	public ResponseEntity<Map<String,Boolean>> eliminarFactura(@PathVariable Long id){
		Factura factura = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe la factura con el ID : " + id));
		
		repositorio.delete(factura);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
}
