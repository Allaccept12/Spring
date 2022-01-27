package hello.sringmvc.basic.requestmapping;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());


    @RequestMapping(value = {"/hello-basic","/hello-go"}, method = RequestMethod.GET)
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }
    @GetMapping("/mapping-get-v1")
    public String mappingGetV1() {
        log.info("helloGetv1");
        return "ok";
    }
    @PostMapping("/mapping-get-v2")
    public String mappingGetV2() {
        log.info("helloGetv2");
        return "ok";
    }
    // /mapping/userA -> 이런식으로 넘어감
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        log.info("mappingPath userId {}",data);
        return "ok";
    }
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath2(@PathVariable String userId, @PathVariable String orderId) {
        log.info("mappingPath userId {} , orderId {}", userId,orderId);
        return "ok";
    }

    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsume() {
        log.info("mappingConsumes");
        return "oh";
    }
    @PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduce() {
        log.info("mappingProduce");
        return "oh";
    }



}
