package pl.matisoft.soy.example;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ExampleController {

	@RequestMapping(value="/")
	public ModelAndView openHomepage(HttpServletRequest request, final Model model, HttpSession httpSession) throws IOException {
		addServerTimeStringToModel(model);
		model.addAttribute("words", Lists.newArrayList("hello", "world", "from", "spring", "controller!"));

        return new ModelAndView("soy:soy.example.index", model.asMap());
	}

	@RequestMapping(value="/server-time")
	public String getServerTime(Model model, HttpSession httpSession) {
		addServerTimeStringToModel(model);

		return "soy:soy.example.serverTime";
	}

	private void addServerTimeStringToModel(Model model) {
		String serverTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		model.addAttribute("serverTime", serverTime);
	}

}
