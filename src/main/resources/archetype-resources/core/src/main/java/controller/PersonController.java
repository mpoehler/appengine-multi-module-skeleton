package ${package}.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ${package}.entity.Person;
import ${package}.service.OfyService;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

	public static Log logger = LogFactory.getLog(PersonController.class);

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Person get(@PathVariable Long id) {
		return OfyService.ofy().load().type(Person.class).id(id).now();
	}

	@RequestMapping(value = "/fetchAll", method = RequestMethod.GET)
	public List<Person> fetchAll() {
		return OfyService.ofy().load().type(Person.class).list();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Person save(@RequestBody Person person) {
		OfyService.ofy().save().entity(person).now();
		return person;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		OfyService.ofy().delete().type(Person.class).id(id).now();
	}

}