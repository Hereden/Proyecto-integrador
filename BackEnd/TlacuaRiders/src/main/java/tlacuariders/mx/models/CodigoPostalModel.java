package tlacuariders.mx.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="codigo_postal")
public class CodigoPostalModel {

		@Id
		@Column(nullable = false)
		private int id;
		
		@Column(nullable = false, length = 255)
		private String estado;
		
		@Column(nullable = false, length = 255)
		private String municipio;
		
		@Column(nullable = false, length = 255)
		private String ciudad;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}

		public String getMunicipio() {
			return municipio;
		}

		public void setMunicipio(String municipio) {
			this.municipio = municipio;
		}

		public String getCiudad() {
			return ciudad;
		}

		public void setCiudad(String ciudad) {
			this.ciudad = ciudad;
		}
		
		
		
}
