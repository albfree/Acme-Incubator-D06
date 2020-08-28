
package acme.entities.creditCard;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.CreditCardNumber;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CreditCard extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	@Size(min = 1, max = 255)
	private String				holderName;

	@NotBlank
	@CreditCardNumber
	private String				number;

	@NotBlank
	@Size(min = 1, max = 255)
	private String				brand;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date				expirationDate;

	@NotBlank
	@Pattern(regexp = "(^[0-9]{3}$)|(^[0-9]{4}$)")
	@Size(min = 3, max = 4)
	private String				CVV;
}
