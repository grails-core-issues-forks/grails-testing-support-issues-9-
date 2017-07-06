package coconut

import groovy.transform.CompileStatic

@CompileStatic
class UserController {

	UserService userService

	def create(UserCreateCommand cmd) {
		if ( cmd.hasErrors() ) {
			response.status = 422
			return
		}
		String email = cmd.email
		if (userService.existsByEmail(email) ) {
			response.status = 409 // conflict
			return
		}

		userService.saveByEmail(email)

		response.status = 201 // created
		render "created"
	}

}
