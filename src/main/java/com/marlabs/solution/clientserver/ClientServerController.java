package com.marlabs.solution.clientserver;

import java.util.Arrays;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClientServerController {
	
	@GetMapping("/")
	public String index(HttpServletResponse res) {
		//res.addHeader("X-Requested-With", "XMLHttpRequest");
		return "redirect:index.html";
	}

	@GetMapping(path="/findDigitsToSum") // Map ONLY GET Requests
	public @ResponseBody ClientServerPOJO clientServerPOJO () {
		ClientServerPOJO csPojo = new ClientServerPOJO();
		csPojo.setDigits(findRandomDigits());
		return csPojo;
	}
	
	@PostMapping(path="/verifySum")
	public ResponseEntity<ClientServerPOJO> verifySum(@RequestBody ClientServerPOJO csPojo){
		if(Arrays.stream(csPojo.getDigits()).sum() == csPojo.getSum()){
			csPojo.setSuccess(true);
			return new ResponseEntity<>(csPojo,HttpStatus.OK);
		}else{
			csPojo.setSuccess(false);
			return new ResponseEntity<>(csPojo,HttpStatus.BAD_REQUEST);
		}
	}
	
	
	/*
	 * This method finds a random digit which will be number of digits in the array.
	 * Populate the array with some random numbers between 0 to 10
	 */
	private int[] findRandomDigits(){
		Random r = new Random();

		//Finds a random of 2 or 3 digits to sum		
		int digitsToSum = r.nextBoolean() ? 2 : 3;
		int[] digits = new int[digitsToSum];
		for(int i=0;i<digitsToSum;i++)
			digits[i] = r.nextInt(10);
		return digits;
	}
	
}
