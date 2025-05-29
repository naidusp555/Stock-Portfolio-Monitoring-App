package com.bridgelabz.stockportfoliomonitoringapp.controller;

import com.bridgelabz.stockportfoliomonitoringapp.dto.HoldingRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.HoldingResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.service.HoldingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HoldingController.class)
public class HoldingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HoldingService holdingService;

    @Autowired
    private ObjectMapper objectMapper;

    private HoldingRequestDto holdingRequestDto;
    private HoldingResponseDto holdingResponseDto;

    @BeforeEach
    void setUp() {
        holdingRequestDto = new HoldingRequestDto();
        holdingRequestDto.setPortfolioId(1L);
        holdingRequestDto.setStockSymbol("AAPL");
        holdingRequestDto.setQuantity(10);
        holdingRequestDto.setBuyPrice(150.50);

        holdingResponseDto = new HoldingResponseDto();
        holdingResponseDto.setStockSymbol("AAPL");
        holdingResponseDto.setQuantity(10);
        holdingResponseDto.setBuyPrice(150.50);
    }

    @Test
    void testAddHolding_Success() throws Exception {
        when(holdingService.addHolding(any(HoldingRequestDto.class))).thenReturn(holdingResponseDto);

        mockMvc.perform(post("/api/holdings/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(holdingRequestDto)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.stockSymbol").value("AAPL"))
                .andExpect(jsonPath("$.quantity").value(10))
                .andExpect(jsonPath("$.buyPrice").value(150.50));
    }
}
