package start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


@Controller
public class GreetingController {

    @Autowired
    private MessageRepository messageRepository;

    BlockingQueue<Greeting> queueMessages = new ArrayBlockingQueue<Greeting>(50);

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
        queueMessages.add(greeting);
        messageRepository.save(greeting);
        return "result";

    }

    @RequestMapping("/findall")
    public void findAll() {
        for (Greeting greeting : messageRepository.findAll()) {
            System.out.println(greeting.toString());
        }
    }

    @RequestMapping("/cleanqueue")
    public void cleanqueu() {
        for(Greeting g: queueMessages){
            System.out.println(g);
            queueMessages.poll();
        }
    }

}
