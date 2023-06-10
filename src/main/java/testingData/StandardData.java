package testingData;

import com.codeborne.selenide.conditions.CssValue;

public class StandardData {

    //login
    public static final String LOGIN_URL = "https://the-internet.herokuapp.com/login";
    public static final String USERNAME = "tomsmith";
    public static final String PASSWORD = "SuperSecretPassword!";
    public static final String LOGIN_MESSAGE = "You logged into a secure area!\n" + "×";
    public static final String LOGOUT_MESSAGE = "You logged out of the secure area!\n" + "×";
    public static final String USERNAME_INVALID = "tomislavschmitt";
    public static final String PASSWORD_INVALID = "supersifra01234";
    public static final String INVALID_USERNAME_MESSAGE = "Your username is invalid!\n" + "×";
    public static final String INVALID_PASSWORD_MESSAGE = "Your password is invalid!\n" + "×";

    //DOM
    public static final String DOM_URL = "https://the-internet.herokuapp.com/challenging_dom";

    //checkboxes
    public static final String CHECKBOXES_URL = "https://the-internet.herokuapp.com/checkboxes";

    //drag and drop
    public static final String DRAG_URL = "https://the-internet.herokuapp.com/drag_and_drop";

    //iFrame
    public static final String IFRAME_URL = "https://the-internet.herokuapp.com/iframe";
    public static final String IFRAME_TEXT = "iFrame Test";
    public static final String IFRAME_TEXT2 = "Paragraph text";
    public static final String IFRAME_SB_HEADING ="H3";
    public static final String IFRAME_SB_FORMAT = """
            P
            »
            STRONG""";
    public static final String IFRAME_ALIGN = "start";
    public static final String IFRAME_RGB = "rgba(224, 62, 45, 1)";


    //download
    public static final String DOWNLOAD_URL = "https://the-internet.herokuapp.com/download";
    public static final String DOWNLOAD_FILE_NAME = "some-file.txt";

    //scroll
    public static final String SCROLL_URL = "https://nicepage.com/k/locations-html-templates";
    public static final String SCROLL_TEXT = "office";

}
