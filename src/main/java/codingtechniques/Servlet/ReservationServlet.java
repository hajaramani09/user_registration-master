package codingtechniques.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {

    public ReservationServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("<html><body>");
        out.print("            <!-- start of wpo-contact-section -->\r\n" + //
                "            <section class=\"wpo-contact-section section-padding\">\r\n" + //
                "                <div class=\"container\">\r\n" + //
                "                    <div class=\"wpo-contact-section-wrapper\">\r\n" + //
                "                        <div class=\"wpo-contact-form-area\">\r\n" + //
                "                            <div class=\"wpo-section-title\">\r\n" + //
                "                                <span>Jnane Yasmine</span>\r\n" + //
                "                                <h1>Réservation</h1>\r\n" + //
                "                                <div class=\"section-title-img\">\r\n" + //
                "                                    <img src=\"assets/images/section-title.png\" alt=\"\">\r\n" + //
                "                                </div>\r\n" + //
                "                            </div>\r\n" + //
                "                            <form th:action=\"@{../reservation}\"  method=\"post\" class=\"contact-validation-active\" id=\"contact-form-main\">\r\n"
                + //
                "                                <div>\r\n" + //
                "                                    <input type=\"text\" class=\"form-control\" name=\"name\" id=\"name\"\r\n"
                + //
                "                                        placeholder=\"Nom complet \">\r\n" + //
                "                                </div>\r\n" + //
                "                                <div>\r\n" + //
                "                                    <input type=\"text\" class=\"form-control\" name=\"phone\" id=\"phone\"\r\n"
                + //
                "                                        placeholder=\"Téléphone \">\r\n" + //
                "                                </div>\r\n" + //
                "                                <div>\r\n" + //
                "                                    <input type=\"email\" class=\"form-control\" name=\"email\" id=\"email\"\r\n"
                + //
                "                                        placeholder=\"Email\">\r\n" + //
                "                                </div>\r\n" + //
                "                                <div>\r\n" + //
                "                                    <input type=\"text\" class=\"form-control\" name=\"Adress\" id=\"Adress\"\r\n"
                + //
                "                                        placeholder=\"Adresse\">\r\n" + //
                "                                </div>\r\n" + //
                "\r\n" + //
                "\r\n" + //
                "                                <div>\r\n" + //
                "                                    <input type=\"date\" class=\"form-control\" name=\"dR\" id=\"dR\">\r\n"
                + //
                "                                </div>\r\n" + //
                "                                <div>\r\n" + //
                "                                    <select name=\"service\" class=\"form-control\">\r\n" + //
                "                                        <option disabled=\"disabled\" selected=\"\">S'il vous plaît,sélectionnez un service\r\n"
                + //
                "                                        </option>\r\n" + //
                "                                        <option>Restaurant</option>\r\n" + //
                "                                        <option>Piscine </option>\r\n" + //
                "                                        <option>Salle de Fête</option>\r\n" + //
                "                                        <option>Activités et Détent</option>\r\n" + //
                "                                        <option>cuisine Marocaine</option>\r\n" + //
                "                                        <option>Traiteur</option>\r\n" + //
                "                                        <option>Neggafa</option>\r\n" + //
                "                                        <option>Bungalows</option>\r\n" + //
                "                                    </select>\r\n" + //
                "                                </div>\r\n" + //
                "                                <div>\r\n" + //
                "                                    <textarea class=\"form-control\" name=\"note\" id=\"note\"\r\n" + //
                "                                        placeholder=\"Message...\"></textarea>\r\n" + //
                "                                </div>\r\n" + //
                "                                <div class=\"submit-area\">\r\n" + //
                "                                    <button type=\"submit\" class=\"theme-btn-s3\" valeur=\"reservation\">Réserver</button>\r\n"
                + //
                "                                    <div id=\"c-loader\">\r\n" + //
                "                                        <i class=\"ti-reload\"></i>\r\n" + //
                "                                    </div>\r\n" + //
                "                                </div>\r\n" + //
                "                                <div class=\"clearfix error-handling-messages\">\r\n" + //
                "                                    <div id=\"success\">Merci</div>\r\n" + //
                "                                    <div id=\"error\"> Une erreur s'est produite lors de l'envoi du courrier électronique.\r\n"
                + //
                "                                        Veuillez réessayer plus tard.\r\n" + //
                "                                    </div>\r\n" + //
                "                                </div>\r\n" + //
                "                            </form>\r\n" + //
                "                            <div class=\"border-style\"></div>\r\n" + //
                "                        </div>\r\n" + //
                "                        <div class=\"vector-1\">\r\n" + //
                "\r\n" + //
                "                        </div>\r\n" + //
                "                        <div class=\"vector-2\">\r\n" + //
                "\r\n" + //
                "                        </div>\r\n" + //
                "                    </div>\r\n" + //
                "                </div>\r\n" + //
                "            </section>\r\n" + //
                "            <!-- end of wpo-contact-section -->");
        out.print("</body></html>");

        super.doGet(req, resp);
    }

}
