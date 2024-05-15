package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		
		UserService userService = new UserService();
		boolean isSuccess = userService.loginUser(userID, userPW);
		
		// TODO 로그인 성공과 실패에 대한 추가 로직 작성
		// 세션을 이용해서 로그인 정보를 저장하는 것을 고려해 볼 것 
	}

}
