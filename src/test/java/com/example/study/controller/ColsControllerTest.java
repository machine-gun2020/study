package com.example.study.controller;

import com.example.study.dto.ColsDto;
import com.example.study.service.ColsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ColsControllerTest {

    @InjectMocks
    private SorteoController colsController;

    @Mock
    private ColsService colsService;

    @Test
    public void testGetRecordByDate_ValidDate() {
        LocalDate fecha = LocalDate.of(2023, 7, 1);
        ColsDto dto = new ColsDto(fecha, 1, 2, 3, 4, 5, 6);

        when(colsService.getRecordByDate(fecha)).thenReturn(Optional.of(dto));

        ResponseEntity<Object> response = colsController.getRecordByDate(fecha);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(dto, response.getBody());
    }

    @Test
    public void testGetRecordByDate_RecordNotFound() {
        LocalDate fecha = LocalDate.of(2023, 7, 2);

        when(colsService.getRecordByDate(fecha)).thenReturn(Optional.empty());

        ResponseEntity<Object> response = colsController.getRecordByDate(fecha);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Record not found", response.getBody());
    }

    @Test
    public void testGetRecordByDate_NullFecha() {
        ResponseEntity<Object> response = colsController.getRecordByDate(null);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Fecha parameter is required and must not be empty.", response.getBody());
    }
}
