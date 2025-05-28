package com.bridgelabz.stockportfoliomonitoringapp.serviceimpl;



import com.bridgelabz.stockportfoliomonitoringapp.dto.PortfolioRequestDto;
import com.bridgelabz.stockportfoliomonitoringapp.dto.PortfolioResponseDto;
import com.bridgelabz.stockportfoliomonitoringapp.entity.Portfolio;
import com.bridgelabz.stockportfoliomonitoringapp.entity.User;
import com.bridgelabz.stockportfoliomonitoringapp.repository.PortfolioRepository;
import com.bridgelabz.stockportfoliomonitoringapp.repository.UserRepository;
import com.bridgelabz.stockportfoliomonitoringapp.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PortfolioServiceImpl implements PortfolioService {

	@Autowired
	private PortfolioRepository portfolioRepository;

	@Autowired
	private UserRepository userRepository;

	// Create Portfolio
	@Override
	public PortfolioResponseDto createPortfolio(PortfolioRequestDto request, long portfolioId) {
		//fetching portfolio by id
		Portfolio portfolio = portfolioRepository.findById(portfolioId)
			    .orElseThrow(() -> new RuntimeException("Portfolio not found"));

			User user = portfolio.getUser(); // if bi-directional mapping exists

	
		portfolio.setName(request.getName());
		portfolio.setUser(user);

		Portfolio savedPortfolio = portfolioRepository.save(portfolio);

		return new PortfolioResponseDto(
				savedPortfolio.getPortfolioId(),
				savedPortfolio.getName(),
				user.getUsername()
				);
	}
}



