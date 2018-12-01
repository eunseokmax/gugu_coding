package org.zerock.controller;



import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;
import org.zerock.domain.Ticket;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {

	@GetMapping(value= "/getText", produces = "text/plain; charset=UTF-8")
	public String getText() {
		
		log.info("MIME TYPE: " + MediaType.TEXT_PLAIN_VALUE);
		
		return "안녕하세요 ";
	}
	
	@GetMapping(value="/getSample", 
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, 
						MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		
		return new SampleVO(112, "star", "load");
	}
	
	@GetMapping(value= "/getSample2")
	public SampleVO getSample2() {
		return new SampleVO(113, "로켓", "라쿤");
	}
	
	@GetMapping(value= "/getList")
	public List<SampleVO> getList(){
		
		return IntStream.range(1,10).mapToObj(i-> new SampleVO(i, i + "First", i + "Last")).collect(Collectors.toList());
	}
	
	@PostMapping(value = "/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		
		log.info("convert ................. ticket " + ticket);
		
		return ticket;
	}
	
}
