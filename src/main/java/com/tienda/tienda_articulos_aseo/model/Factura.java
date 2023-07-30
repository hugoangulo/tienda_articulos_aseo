package com.tienda.tienda_articulos_aseo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "factura")
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private double num_factura;

	@Column(name = "id_cliente", length = 60, nullable = false)
	private long id_cliente;

	@Column(name = "fecha", length = 60, nullable = false)
	private String fecha;

	public Factura() {

	}

	public Factura(double num_factura, long id_cliente, String fecha) {
		super();
		this.num_factura = num_factura;
		this.id_cliente = id_cliente;
		this.fecha = fecha;
	}

	public double getNum_factura() {
		return num_factura;
	}

	public void setNum_factura(double num_factura) {
		this.num_factura = num_factura;
	}

	public long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
