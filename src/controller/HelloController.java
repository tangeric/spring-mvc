package controller;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import entity.Player;

@Controller
//ָʾ��������
@RequestMapping(value="/player")
public class HelloController {

	private static final Log logger=LogFactory.getLog(HelloController.class);
	private static List<Player> playerList;
	public HelloController() {
		// TODO Auto-generated constructor stub
		super();
		playerList=new ArrayList<Player>();
	}
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registerForm(){
		logger.info("register get....");
		return "register";
		//��ת��register.jsp
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(
			@RequestParam("name") String playerName,
			@RequestParam("team") String team,
			@RequestParam("number") int number
			
			){
		logger.info("register post..");
		Player p=new Player();
		p.setName(playerName);
		p.setTeam(team);
		p.setNumber(number);
		playerList.add(p);
		return "loginForm";
		//ע�ᣬ��ת��loginForm.jsp
	}
	@RequestMapping(value="/login")
	public String login(
			@RequestParam("name") String playerName,
			@RequestParam("number") int number,
			Model model
			){
		logger.info(playerName+number);
		for(Player p:playerList){
			if(p.getName().equals(playerName)&&p.getNumber()==number){
				model.addAttribute("player", p);
				return "welcome";
			}
		}
		return "loginForm";
		//��¼��֤����ȷ��ת�� welcome.jsp,������ת��loginForm.jsp
	}

	
}
