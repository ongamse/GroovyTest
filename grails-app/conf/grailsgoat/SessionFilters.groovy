package grailsgoat

class SessionFilters {

    def filters = {

       /* Use a whitelist instead - shouldBeLoggedIn(controller: 'user', action: '*', invert: true) { */
       shouldBeLoggedIn(controller: 'profile|main|messages|session', action: '*') {
           before = {
              /*if (flash.userid) {
                session.user = User.get(flash.userid)
              }*/

              if (!session.user) {
                  redirect(controller: 'user', action: 'signin')
                  return false
               }
           }
       }
       shouldNotBeLoggedIn(controller: 'user', action: '*') {
           before = {
              if (session.user) {
                  redirect(controller: 'main', action: 'index')
                  return false
               }
           }
       }
    }
}
