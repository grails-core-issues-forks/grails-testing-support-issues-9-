package coconut

class UrlMappings {

    static mappings = {
        post "/user"(controller: "user", action: "create")
    }
}
