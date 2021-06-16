package turanberlin.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import turanberlin.hrms.business.abstracts.KnownTechService;
import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.entities.concretes.KnownTech;

@RestController
@RequestMapping(value="/api/knownTechs")
public class KnownTechsController {

	private KnownTechService knownTechService;

	@Autowired
	public KnownTechsController(KnownTechService knownTechService) {
		super();
		this.knownTechService = knownTechService;
	}
	
	@PostMapping(value = "/add/knownTech")
	public Result add(@RequestBody KnownTech knownTech) {
		return this.knownTechService.add(knownTech);
	}
	
}
