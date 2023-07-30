package com.tienda.tienda_articulos_aseo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "producto")

public class Producto {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_Producto;
	
	@Column(name = "nombre", length = 60, nullable = false)
	private String nombre;
	
	@Column(name = "precio", length = 60, nullable = false)
	private int precio;
	
	@Column(name = "stock", length = 60, nullable = false)
	private int stock;
}
