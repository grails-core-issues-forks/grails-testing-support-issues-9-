package coconut

import grails.validation.Validateable

class UserCreateCommand implements Validateable {
    String email

    static constraints = {
        email nullable: false, email: true
    }
}