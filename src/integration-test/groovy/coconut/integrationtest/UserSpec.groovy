package coconut.integrationtest

import coconut.UserService
import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse
import grails.testing.mixin.integration.Integration
import spock.lang.Specification

@Integration
class UserSpec extends Specification {
	private static final String USER_EMAIL = "joe@example.com"

	UserService userService
	
	void "create user"() {
		when:
		RestResponse response = new RestBuilder().post("http://localhost:$serverPort/user") {
			json([
				email: USER_EMAIL
			])
		}
		
		then:
		response.status == 201
		userService.userCount() == 1

		cleanup:
		userService.deleteByEmail(USER_EMAIL)
	}
}
