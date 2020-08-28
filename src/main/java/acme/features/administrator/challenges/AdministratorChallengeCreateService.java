
package acme.features.administrator.challenges;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challenges.Challenge;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorChallengeCreateService implements AbstractCreateService<Administrator, Challenge> {

	// Internal state -----------------------------------------------------

	@Autowired
	private AdministratorChallengeRepository repository;


	// AbstractCreateService<Authenticated, Requests> interface ---------

	@Override
	public boolean authorise(final Request<Challenge> request) {
		// TODO Auto-generated method stub
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Challenge> request, final Challenge entity, final Model model) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "description", "rookieGoal", "rookieReward", "averageGoal", "averageReward", "expertGoal", "expertReward");
	}

	@Override
	public Challenge instantiate(final Request<Challenge> request) {
		// TODO Auto-generated method stub
		Challenge result;

		result = new Challenge();

		return result;
	}

	@Override
	public void validate(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert errors != null;

		Calendar calendar;
		Date minimum;

		calendar = new GregorianCalendar();
		calendar.add(Calendar.MONTH, 1);
		minimum = calendar.getTime();

		if (entity.getDeadline() != null) {
			errors.state(request, entity.getDeadline().after(minimum), "deadline", "administrator.challenge.error.future-dead");
		}
	}

	@Override
	public void create(final Request<Challenge> request, final Challenge entity) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
