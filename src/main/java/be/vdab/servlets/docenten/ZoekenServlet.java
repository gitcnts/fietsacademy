package be.vdab.servlets.docenten;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.repository.DocentRepository;
import be.vdab.util.StringUtils;

/**
 * Servlet implementation class ZoekenServlet
 */
@WebServlet("/docenten/zoeken.htm")
public class ZoekenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/docenten/zoeken.jsp";
	private final transient DocentRepository docentRepository = new DocentRepository();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getQueryString() != null) {
			String idString = request.getParameter("id");
			if (StringUtils.isLong(idString)) {
				docentRepository.read(Long.parseLong(idString))
				.ifPresent(docent-> request.setAttribute("docent",docent));
			} else {
				request.setAttribute("fouten",
						Collections.singletonMap("id", "tik een getal"));
				// singletonMap maakt intern een Map met één entry (key=id,
				// value=tik een getal) en geeft die Map terug als returnwaarde
			}
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
