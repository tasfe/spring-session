package jp.inc.forrest.spring.session;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String attributeName = req.getParameter("attributeName");
		String attributeValue = req.getParameter("attributeValue");
		req.getSession().setAttribute(attributeName, attributeValue);
		resp.sendRedirect(req.getContextPath() + "/");

		Enumeration<String> attrKeys = req.getSession().getAttributeNames();
		System.out.println("--- > (Current Session)");
		while (attrKeys.hasMoreElements()) {
			String key = attrKeys.nextElement();
			System.out.println(key + "=" + req.getSession().getAttribute(key));
		}
		System.out.println("< --- (... End)");

	}

	private static final long serialVersionUID = 2878267318695777395L;
}
