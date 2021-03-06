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

import id.pkl.raport.entity.Guru;
import id.pkl.raport.repository.GuruRepository;

@RestController
@RequestMapping(value="/guru")
public class GuruController {
	@Autowired
	private GuruRepository guruRepository;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Guru> addGuru(@Validated @RequestBody Guru guru, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<Guru>(HttpStatus.BAD_REQUEST);
		}
		Guru newGuru = guruRepository.save(guru);
		return new ResponseEntity<Guru>(newGuru, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public Page<Guru> listGuru(Pageable pageable)
	{
		return guruRepository.findAll(pageable);
	}
}
