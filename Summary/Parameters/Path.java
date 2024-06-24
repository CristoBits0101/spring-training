import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/book")
public class Path {

    /**
     * URL path: http://localhost:8080/api/book/values
     */
    @GetMapping("/values")
    public Map<String, Object> values() {
        Map<String, Object> json = new HashMap<>();
        json.put("name", name);
        json.put("password", password);
        json.put("listOfValue", listOfValue);

        // With autowired
        json.put("name2", environment.getProperty("config.name"));

        // Los 2 devuelven un numerico son formas distintas.
        json.put("password2", Integer.valueOf(environment.getProperty("config.password")));
        json.put("password3", environment.getProperty("config.password", Long.class));
        return json;
    }

    /**
     * URL path: http://localhost:8080/api/book/mensaje
     */
    @GetMapping("/foo5/{message}")
    public ParamDto foo5(@PathVariable() String message) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        paramDto.setEdad(1);
        return paramDto;
    }

    /**
     * URL path: http://localhost:8080/api/book/mensaje/edad
     */
    @GetMapping("/foo6/{message}/{edad}")
    public Map<String, Object> foo6(@PathVariable String message, @PathVariable("edad") Long id) {
        Map<String, Object> json = new HashMap<>();
        json.put("message", message);
        json.put("edad", id);
        return json;
    }

    /**
     * URL path: http://localhost:8080/api/book/create
     */
    @PostMapping("/create")
    public Book saveBook(@RequestBody Book book) {
        return book;
    }
    
}
