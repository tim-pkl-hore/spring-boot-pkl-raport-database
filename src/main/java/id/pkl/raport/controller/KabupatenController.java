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

import id.pkl.raport.entity.Kabupaten;
import id.pkl.raport.repository.KabupatenRepository;

@RestController
@RequestMapping(value="/kabupaten")
public class KabupatenController {
	@Autowired
	private KabupatenRepository kabupatenRepository;
	
	@RequestMapping(method=RequestMethod.POST)
	
	public ResponseEntity<Kabupaten> addKabupaten(@Validated @RequestBody Kabupaten kabupaten, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<Kabupaten> (HttpStatus.BAD_REQUEST);
		}
		
		Kabupaten newKabupaten = kabupatenRepository.save(kabupaten);
		return new ResponseEntity<Kabupaten>(newKabupaten, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public Page<Kabupaten> listKabupaten(Pageable pageable)
	{
		return kabupatenRepository.findAll(pageable);
	}
	
}
