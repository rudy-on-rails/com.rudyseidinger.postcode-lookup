package controllers
import models.Address
import org.springframework.web.bind.annotation.*
import services.PostcodeLookup

@RestController
class LookupController{

    @RequestMapping("/lookup")
    @ResponseBody
    fun retrieveAddress(@RequestParam postcode: String) : Address{
        return PostcodeLookup(postcode).execute()
    }
}