package tlacuariders.mx.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ventas")
public class VentasModel {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(nullable =false)
		private int id;
		
		@ManyToOne
		private UsuariosModel usuario;
		
		@Column(nullable = false)
		private int num_pedido;
		
		@Column(nullable = false)
		private float precio_total;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public UsuariosModel getUsuario() {
			return usuario;
		}

		public void setUsuario(UsuariosModel usuario) {
			this.usuario = usuario;
		}

		public int getNum_pedido() {
			return num_pedido;
		}

		public void setNum_pedido(int num_pedido) {
			this.num_pedido = num_pedido;
		}

		public float getPrecio_total() {
			return precio_total;
		}

		public void setPrecio_total(float precio_total) {
			this.precio_total = precio_total;
		}

		
		
		

	
		
}
