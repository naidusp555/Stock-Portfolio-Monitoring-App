package com.bridgelabz.stockportfoliomonitoringapp.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import com.bridgelabz.stockportfoliomonitoringapp.dto.HoldingRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.HoldingResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Holding;
import com.bridgelabz.stockportfoliomonitoringapp.repository.HoldingRepository;
import com.bridgelabz.stockportfoliomonitoringapp.serviceimpl.HoldingServiceImpl;

import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HoldingTest {
	
	@Mock
    private HoldingRepository holdingRepository;

    @InjectMocks
    private HoldingServiceImpl holdingService;

    @Test
    public void testUpdateHolding() {
        Long id = 1L;

        Holding existing = new Holding();
        existing.setStockSymbol("AAPL");
        existing.setQuantity(10);
        existing.setBuyPrice(140.00);

        HoldingRequestDto requestDto = new HoldingRequestDto();
        requestDto.setQuantity(20);
        requestDto.setBuyPrice(155.50);

        Holding updated = new Holding();
        updated.setStockSymbol("AAPL");
        updated.setQuantity(20);
        updated.setBuyPrice(155.50);

        when(holdingRepository.findById(id)).thenReturn(Optional.of(existing));
        when(holdingRepository.save(any(Holding.class))).thenReturn(updated);

        HoldingResponseDto response = holdingService.updateHolding(id, requestDto);

        assertEquals("AAPL", response.getStockSymbol());
        assertEquals(20, response.getQuantity());
        assertEquals(155.50, response.getBuyPrice());
    }

}
