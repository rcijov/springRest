package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private ArrayList<Greeting> list = new ArrayList<Greeting>();

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public ArrayList<Greeting> test(@RequestParam(value="name", defaultValue="World") String name) {
        return list;
                 
    }

    @RequestMapping(method = RequestMethod.POST, value = "/test")
    public Greeting test(@RequestBody Greeting greeting) {
	list.add(greeting);
	return greeting;
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/test")
    public Greeting testPatch(@RequestBody Greeting greeting) {
	updateGreeting(greeting);
        return greeting;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/test")
    public Response testDelete(@RequestParam(required=true) long id) {
	deleteGreeting(id);
	return new Response("Id removed");
    }


    @RequestMapping(method = RequestMethod.GET, value = "/greeting")
    public Greeting greeting(@RequestParam(required=false, defaultValue="World") String name) {
	return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    public void updateGreeting(Greeting greet)
    {
       for(Greeting greeting : list)
       {
	   if(greeting.getId() == greet.getId())
	   {
		greeting.setContent(greet.getContent());
	   }
       }  
    }

    public void deleteGreeting(long id)
    {
        for (Iterator<Greeting> iterator = list.iterator(); iterator.hasNext(); ) {
		Greeting greet = iterator.next();
		if (greet.getId() ==  id) {
			iterator.remove();
		}
	}
    }

}
