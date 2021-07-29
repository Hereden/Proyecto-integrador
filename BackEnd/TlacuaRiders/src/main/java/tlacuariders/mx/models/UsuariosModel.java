package tlacuariders.mx.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "usuarios")
public class UsuariosModel {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int id;
	
	@Column(nullable = false, length = 255)
	private String nombre;
	
	@Column(nullable = false, length = 255)
	private String alias;
	
	@Column(nullable = false, length = 255, unique=true)
	private String correo;
	
	@Column(nullable = false, length = 255)
	private String contra;
	
	@Column(nullable = false, length = 255)
	private String direccion;
	
	@Column(nullable = false, length = 12)
	private String telefono;
	
	@Column(nullable = false, length = 1)
	private int genero;
	
	@ManyToOne
    private CodigoPostalModel codigo_postal;

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

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getGenero() {
		return genero;
	}

	public void setGenero(int genero) {
		this.genero = genero;
	}

	public CodigoPostalModel getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(CodigoPostalModel codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	
	
	
	
}
