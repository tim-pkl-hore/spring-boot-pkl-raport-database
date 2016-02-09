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
@Table(name="kecamatan")
public class Kecamatan {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@NotBlank
	@Column(name="kodeKecamatan")
	private String kodeKecamatan;
	
	@NotBlank
	@Column(name="namaKecamatan")
	private String namaKecamatan;
	
	@ManyToOne
	@JoinColumn(name="kabupaten_id", referencedColumnName="id")
	private Kabupaten kabupaten;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKodeKecamatan() {
		return kodeKecamatan;
	}

	public void setKodeKecamatan(String kodeKecamatan) {
		this.kodeKecamatan = kodeKecamatan;
	}

	public String getNamaKecamatan() {
		return namaKecamatan;
	}

	public void setNamaKecamatan(String namaKecamatan) {
		this.namaKecamatan = namaKecamatan;
	}

	public Kabupaten getKabupaten() {
		return kabupaten;
	}

	public void setKabupaten(Kabupaten kabupaten) {
		this.kabupaten = kabupaten;
	}
	
	
	
	
}
