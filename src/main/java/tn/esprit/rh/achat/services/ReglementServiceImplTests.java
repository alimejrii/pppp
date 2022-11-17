package tn.esprit.rh.achat.services;

import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.repositories.ReglementRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@Slf4j
//@ExtendWith(MockitoExtension.class)
@SpringBootTest //(classes=ProduitServiceImpl.class)
@RunWith(MockitoJUnitRunner.class)
public class ReglementServiceImplTests {
	@Mock
	ReglementRepository reglementRepository ;
	@InjectMocks
	ReglementServiceImpl reglementService ;
	
	@Test
	public void saveReglementTest() {
		Reglement fc = new Reglement(12,15);
		when(reglementRepository.save(fc)).thenReturn(fc);
		assertEquals(fc, reglementService.addReglement(fc));
	}
	
	@Test
	public void getReglementTest() {
	      
			when(reglementRepository.findAll()).thenReturn(Stream
	                .of(new Reglement(12,15),  new Reglement(12,15)).collect(Collectors.toList()));
	        Assertions.assertEquals(2, reglementService.retrieveAllReglements().size());
			}
	
	
}
