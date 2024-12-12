package dev.group4.veterinaryClinic.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dev.group4.veterinaryClinic.Models.Tutor;
import dev.group4.veterinaryClinic.repository.TutorRepository;

public class TutorServiceTest {
     @Mock
    private TutorRepository tutorRepository;

    @InjectMocks
    private TutorService tutorService;

    public TutorServiceTest() {
        MockitoAnnotations.openMocks(this); // Inicializar los mocks
    }

@Test
public void testGetTutorById() {
    // Datos simulados
    Tutor tutor = new Tutor(1L, "Mickey", "Mouse", "666438412", null);

    when(tutorRepository.findById(1L)).thenReturn(Optional.of(tutor));

    // Ejecutar método
    Tutor result = tutorService.getTutorById(1L);

    // Verificar resultados
    assertNotNull(result);
    assertEquals("Mickey", result.getFirstName());
    verify(tutorRepository, times(1)).findById(1L);
}

@Test
public void testGetTutorByIdNotFound() {
    when(tutorRepository.findById(1L)).thenReturn(Optional.empty());

    // Verificar que lanza una excepción
    RuntimeException exception = assertThrows(RuntimeException.class, () -> {
        tutorService.getTutorById(1L);
    });

    assertEquals("Tutor no encontrado", exception.getMessage());
    verify(tutorRepository, times(1)).findById(1L);
}

}
