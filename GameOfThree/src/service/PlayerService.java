package service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/PlayerService")
public class PlayerService {

	@GET
	@Path("/numbers/{name}/{number}")
	public Integer getNumber(@PathParam("name") String name, @PathParam("number") Integer number) {
		Integer responseNumber = 0;
		Integer a[] = { -1, 0, 1 }; // Game Requirement

		for (int i = 0; i < a.length; i++) {
			if ((number + a[i]) % 3 == 0) {
				/*
				 * If {number} + {-1 / 0 / 1} is divisible by 3 then store result in
				 * {responseNumber} and send the response back
				 */
				responseNumber = (number + a[i]) / 3;
			}
		}
		return responseNumber;
	}
}
