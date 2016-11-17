package tuiter;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by rafa on 11/11/2016.
 */

@SpringBootApplication
@RestController
public class TuiterController {

    @Autowired
    private MensagemRepository mensagemRepository;

    @RequestMapping("/mensagem")
    public List<Mensagem> getMsgg() {
        return Lists.newArrayList(mensagemRepository.findAll());
    }


    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(
            value = "/mensagem",
            method = RequestMethod.POST)
    public @ResponseBody
    Mensagem postMsg(@RequestBody Mensagem mensagem){
        mensagem.setDatahora(new Date());
        return mensagemRepository.save(mensagem);
    }
}

