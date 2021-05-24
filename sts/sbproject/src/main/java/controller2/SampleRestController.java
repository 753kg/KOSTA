package controller2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController		// Browser Body로 return
public class SampleRestController {

	@RequestMapping("/test1")
	public String test1() {
		return "hello~~ 헬로우";
	}
}
