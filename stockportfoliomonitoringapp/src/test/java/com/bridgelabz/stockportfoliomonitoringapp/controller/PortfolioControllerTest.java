package com.bridgelabz.stockportfoliomonitoringapp.controller;

import com.bridgelabz.stockportfoliomonitoringapp.dto.HoldingResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.service.PortfolioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PortfolioController.class)
public class PortfolioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PortfolioService portfolioService;

    @Autowired
    private ObjectMapper objectMapper;

    private Long portfolioId;
    private List<HoldingResponseDto> holdingsList;
    private HoldingResponseDto holding1;
    private HoldingResponseDto holding2;

    @BeforeEach
    void setUp() {
        portfolioId = 1L;
        
        holding1 = new HoldingResponseDto();
        holding1.setStockSymbol("AAPL");
        holding1.setQuantity(10);
        holding1.setBuyPrice(150.50);

        holding2 = new HoldingResponseDto();
        holding2.setStockSymbol("GOOGL");
        holding2.setQuantity(5);
        holding2.setBuyPrice(2500.75);

        holdingsList = Arrays.asList(holding1, holding2);
    }

    @Test
    void testGetHoldingsByPortfolioId_Success() throws Exception {
        when(portfolioService.getHoldingsByPortfolioId(portfolioId)).thenReturn(holdingsList);

        mockMvc.perform(get("/api/portfolios/{id}/holdings", portfolioId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].stockSymbol").value("AAPL"))
                .andExpect(jsonPath("$[0].quantity").value(10))
                .andExpect(jsonPath("$[0].buyPrice").value(150.50))
                .andExpect(jsonPath("$[1].stockSymbol").value("GOOGL"))
                .andExpect(jsonPath("$[1].quantity").value(5))
                .andExpect(jsonPath("$[1].buyPrice").value(2500.75));
    }
}
