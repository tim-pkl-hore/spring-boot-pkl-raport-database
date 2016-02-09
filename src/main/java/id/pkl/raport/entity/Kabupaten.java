package id.pkl.raport.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="kabupaten")
public class Kabupaten {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@NotBlank
	@Column(name="kode_kabupaten")
	private String kodeKabupaten;
	
	@NotBlank
	@Column(name="nama_kabupaten")
	private String namaKabupaten;
	
	@ManyToOne
	@JoinColumn(name="provinsi_id", referencedColumnName="id")
	private Provinsi provinsi;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKodeKabupaten() {
		return kodeKabupaten;
	}

	public void setKodeKabupaten(String kodeKabupaten) {
		this.kodeKabupaten = kodeKabupaten;
	}

	public String getNamaKabupaten() {
		return namaKabupaten;
	}

	public void setNamaKabupaten(String namaKabupaten) {
		this.namaKabupaten = namaKabupaten;
	}

	public Provinsi getProvinsi() {
		return provinsi;
	}

	public void setProvinsi(Provinsi provinsi) {
		this.provinsi = provinsi;
	}
	
	
	
	
	
}
