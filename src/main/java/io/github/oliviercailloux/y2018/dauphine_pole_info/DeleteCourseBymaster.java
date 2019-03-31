package io.github.oliviercailloux.y2018.dauphine_pole_info;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.SystemException;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("DeleteCourseByMaster")
@Stateless
public class DeleteCourseBymaster {

	@PersistenceContext(unitName = "dauphine")
    private EntityManager manager;

	@Transactional
	@DELETE
	public void delete(@QueryParam("master") int master) {
		int q = manager.createQuery("DELETE  FROM Course s WHERE s.id.master = " + master).executeUpdate();
	}

}
