package com.tienda.tienda_articulos_aseo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle")
public class Detalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num_detalle;

	@Column(name = "id_factura", length = 60, nullable = false)
	private double id_factura;

	@Column(name = "id_producto", length = 60, nullable = false)
	private double id_producto;

	@Column(name = "cantidad", length = 60, nullable = false)
	private int cantidad;

	@Column(name = "precio", length = 60, nullable = false)
	private long precio;

	public Detalle() {

	}

	public Detalle(int num_detalle, double id_factura, double id_producto, int cantidad, long precio) {
		super();
		this.num_detalle = num_detalle;
		this.id_factura = id_factura;
		this.id_producto = id_producto;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public int getNum_detalle() {
		return num_detalle;
	}

	public void setNum_detalle(int num_detalle) {
		this.num_detalle = num_detalle;
	}

	public double getId_factura() {
		return id_factura;
	}

	public void setId_factura(double id_factura) {
		this.id_factura = id_factura;
	}

	public double getId_producto() {
		return id_producto;
	}

	public void setId_producto(double id_producto) {
		this.id_producto = id_producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public long getPrecio() {
		return precio;
	}

	public void setPrecio(long precio) {
		this.precio = precio;
	}

}
