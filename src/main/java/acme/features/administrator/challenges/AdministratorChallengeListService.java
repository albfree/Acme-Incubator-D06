
package acme.features.administrator.challenges;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challenges.Challenge;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorChallengeListService implements AbstractListService<Administrator, Challenge> {

	// Internal state --------------------------------------------------------

	@Autowired
	AdministratorChallengeRepository repository;


	// AbstractListService<Authenticated, Requests> interface ------------

	@Override
	public boolean authorise(final Request<Challenge> request) {
		// TODO Auto-generated method stub
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Challenge> request, final Challenge entity, final Model model) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline");
	}

	@Override
	public Collection<Challenge> findMany(final Request<Challenge> request) {
		// TODO Auto-generated method stub
		assert request != null;

		Collection<Challenge> result;

		result = this.repository.findManyAll();

		return result;
	}

}
