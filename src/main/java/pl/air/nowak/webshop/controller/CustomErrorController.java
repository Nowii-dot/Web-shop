package pl.air.nowak.webshop.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @GetMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                model.addAttribute("errorCode", "404");
                model.addAttribute("errorMessage", "Strona nie została znaleziona.");
                return "error404"; // Nazwa pliku HTML w katalogu templates
            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
                model.addAttribute("errorCode", "403");
                model.addAttribute("errorMessage", "Nie masz dostępu do tej strony.");
                return "error404";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                model.addAttribute("errorCode", "500");
                model.addAttribute("errorMessage", "Wystąpił błąd serwera.");
                return "error404";
            }
        }

        model.addAttribute("errorCode", "Nieznany błąd");
        model.addAttribute("errorMessage", "Coś poszło nie tak.");
        return "error404"; // Domyślna strona błędu
    }
}
