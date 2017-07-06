package coconut

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

@Slf4j
@CompileStatic
@Transactional
class UserService {

    User saveByEmail(String e) {
        def u = new User(email: e)
        if ( !u.save() ) {
            log.error 'could not save user {}', u.errors.toString()
        }
        u
    }

    @ReadOnly
    boolean existsByEmail(String e) {
        User.where { email == e }.count()
    }

    int deleteByEmail(String e) {
        User.where { email == e }.deleteAll() as int
    }

    @ReadOnly
    int userCount() {
        User.where { }.count() as int
    }
}