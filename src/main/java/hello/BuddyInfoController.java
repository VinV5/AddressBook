package hello;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vincentvu on 2/2/2017.
 */
@RestController
public class BuddyInfoController {

    @RequestMapping("/buddyInfo")
    public BuddyInfo buddyInfo(@RequestParam(value="name") String name,
                               @RequestParam(value="address") String address,
                               @RequestParam(value ="phone") String phone,
                               Model model) {
        return new BuddyInfo(name, address, phone);
    }

}
