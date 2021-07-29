package tlacuariders.mx.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "articulos")
public class ArticulosModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable =false)
	private int id;
	
	
	
	
	@Column(nullable = false, length = 255)
	private String nombre;
	
	@Column(nullable = false, length = 255)
	private String descripcion;
	
	@Column(nullable = false, length = 255)
	private String talla;
	
	@Column(nullable = false, length = 255)
	private String colores; 
	
	@Column(nullable = false)
	private int categoria;
	
	@Column(nullable = false)
	private float precio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getColores() {
		return colores;
	}

	public void setColores(String colores) {
		this.colores = colores;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
}
