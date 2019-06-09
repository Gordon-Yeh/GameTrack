package ubc.cs304.gametrack.controllers.postalcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ubc.cs304.gametrack.entities.PostalCode;

import java.util.List;

@RestController
public class PostalCodeController {

    @Autowired
    PostalCodeService postalCodeService;

    @RequestMapping(method= RequestMethod.POST, value="/postalcodes")
    public void registerUser(@RequestBody PostalCode PostalCode) {
        postalCodeService.createPostalCode(PostalCode);
    }

    @RequestMapping(method=RequestMethod.GET, value="/postalcodes")
    public List<PostalCode> getAllPostalCodes() {
        return postalCodeService.findAllPostalCodes();
    }

    @RequestMapping(method=RequestMethod.GET, value="/postalcodes/{postal_ code}")
    public PostalCode getPostalCodeBooking(@PathVariable String postal_code) {
        return postalCodeService.findPostalCodeBy(postal_code);
    }

}
