package tlacuariders.mx.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class PedidosModel {
	
	@Id
	@Column(nullable =false)
	private int id;
	
	@ManyToOne
	private ArticulosModel articulo;
	
	@ManyToOne
	private VentasModel venta;
	
	@Column(nullable = false)
	private int cantidad;
	
	@Column(nullable = false)
	private float precio_total;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArticulosModel getArticulo() {
		return articulo;
	}

	public void setArticulo(ArticulosModel articulo) {
		this.articulo = articulo;
	}

	public VentasModel getVenta() {
		return venta;
	}

	public void setVenta(VentasModel venta) {
		this.venta = venta;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(float precio_total) {
		this.precio_total = precio_total;
	}
	
	
}
