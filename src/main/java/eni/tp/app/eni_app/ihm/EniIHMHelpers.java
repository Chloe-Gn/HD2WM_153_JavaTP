package eni.tp.app.eni_app.ihm;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class EniIHMHelpers {

    /**
     *
     * @param redirectAttributes retaper juste "redirectAttributes"
     * @param type Classe EniFlashMessage notation pointée, chercher la constante
     * @param message Libre, à taper à la main
     */
    public static void sendCommonFlashMessage(RedirectAttributes redirectAttributes, int type, String message) {

        // Ajouter un message temporaire (flash message)

        redirectAttributes.addFlashAttribute("flashMessage",
                new EniFlashMessage(type, message));
    }


    /**
     *
     * @param redirectAttributes retaper juste "redirectAttributes"
     * @param message Libre, à taper à la main
     */
    public static void sendSuccessFlashMessage(RedirectAttributes redirectAttributes, String message) {

        EniIHMHelpers.sendCommonFlashMessage(redirectAttributes, EniFlashMessage.TYPE_FLASH_SUCCESS,message);


    }


}
