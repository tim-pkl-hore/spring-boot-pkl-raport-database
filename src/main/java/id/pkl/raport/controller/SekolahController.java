package id.pkl.raport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import id.pkl.raport.entity.Sekolah;
import id.pkl.raport.repository.SekolahRepository;

@RestController
@RequestMapping(value="/sekolah")
public class SekolahController {
	@Autowired
	private SekolahRepository sekolahRepository;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Sekolah> addSekolah(@Validated @RequestBody Sekolah sekolah, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<Sekolah>(HttpStatus.BAD_REQUEST);
		}
		
		Sekolah newSekolah = sekolahRepository.save(sekolah);
		return new ResponseEntity<Sekolah>(newSekolah, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public Page<Sekolah> listSekolah(Pageable pageable)
	{
		return sekolahRepository.findAll(pageable);
	}
	
	
	
}
