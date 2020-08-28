
package acme.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import acme.entities.banners.Banner;

@ControllerAdvice
public class BannerAdvisor {

	@Autowired
	BannerRepository bannerRepository;


	@ModelAttribute("banner")
	public Banner getBanner() {
		Banner result;

		result = this.bannerRepository.findRandomBanner();

		return result;
	}

}
