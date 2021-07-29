package tlacuariders.mx.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name =  "rodadas")
public class RodadasModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(nullable =false)
		private int id;
	
	@ManyToOne
	private UsuariosModel usuario;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private String descripcion;
	
	@Column(nullable = false)
	private int condición;
	
	@Column(nullable = false)
	private String inicio;
	
	@Column(nullable = false)
	private String fin;
	
	@Column(nullable = false)
	private String encuentro;
	
	@Column(nullable = false)
	private int bicis;
	
	@Column(nullable = false)
	private int compania;
	
	@Column(nullable = false)
	private int usuarios_confirmados;
	
	@Column(nullable = false)
	private int usuarios_interesados;
	
	@Column(nullable = false)
	private int turno;

}
