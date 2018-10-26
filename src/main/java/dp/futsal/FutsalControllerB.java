package dp.futsal;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import dp.futsal.service.FutsalServiceA;
import dp.futsal.service.FutsalServiceB;
import dp.futsal.service.MatchDayForm;
import dp.futsal.service.TeamForm;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class FutsalControllerB {

    private static final Logger LOGGER = Logger.getLogger(FutsalControllerB.class.getName());
    @Autowired
    private FutsalServiceB serviceB;

    @PostConstruct
    public void init() {
        LOGGER.info("inside controller postconstruct");
        serviceB.init();
    }
    
    
    

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError(Exception e) {
        LOGGER.severe("jebatanja bracala");
        e.printStackTrace();
    }

}
