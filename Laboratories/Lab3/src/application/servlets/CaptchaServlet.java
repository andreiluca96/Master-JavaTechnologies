package application.servlets;

import application.Captcha;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CaptchaServlet", urlPatterns = {"/captcha"})
public class CaptchaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String captchaText = Captcha.generateText();
        request.getSession().setAttribute("captcha", captchaText);

        response.setContentType("image/png");
        response.getOutputStream().write(Captcha.generateImage(captchaText));
    }
}
