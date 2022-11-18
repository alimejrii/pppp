package tn.esprit.rh.achat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.SecteurActiviteServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class SecteurActiviteServiceMockTest {

    @InjectMocks
    SecteurActiviteServiceImpl secteurActiviteService;
    
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this); //without this you will get NPE
    }

    @Mock
    SecteurActiviteRepository secteurActiviteRepository;

    SecteurActivite s = new SecteurActivite((long)1,"12","45");
    SecteurActivite s1 = new SecteurActivite((long)2,"65","44");
    SecteurActivite s2 = new SecteurActivite((long)3,"74","88");
    List<SecteurActivite> secteurActivite = new ArrayList<SecteurActivite>() {
        {
            add(s1);
            add(s2);
        }
    };

    

    @Test
    public void testaddSecteurActivite() {
        Mockito.when(secteurActiviteRepository.save(Mockito.any(SecteurActivite.class))).thenReturn(s);
        assertNotNull(secteurActiviteService.addSecteurActivite(s));
    }

    @Test
    public void testdeleteSecteurActivite() {
    	secteurActiviteService.deleteSecteurActivite((long)3);
        verify(secteurActiviteRepository).deleteById((long)3);
    }

    @Test
    public void testupdateStock() {
        Mockito.when(secteurActiviteRepository.save(Mockito.any(SecteurActivite.class))).thenReturn(s);
        s.setLibelleSecteurActivite("741");
        assertNotNull(secteurActiviteService.updateSecteurActivite(s));
       // assertEquals(Optional.of(55), s.getQte());
    }
}