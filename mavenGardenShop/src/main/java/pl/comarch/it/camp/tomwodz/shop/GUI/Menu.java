package pl.comarch.it.camp.tomwodz.shop.GUI;

public enum Menu {
    HEADMENU1("Menu:"),
    HEADMENU2("1. Zaloguj"),
    HEADMENU3("2. Zarejestruj"),
    HEADMENU4("3. Exit"),
    USERMENU1("Menu:"),
    USERMENU2("1. Wyswietl liste produktow"),
    USERMENU3("2. Kup produkt"),
    USERMENU4("3. Wyloguj"),
    ADMINMENU1("4. Uzupelnij produkt"),
    ADMINMENU2("5. Nadaj role");

    private final String menu;

    Menu(String menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(this.menu).toString();
    }

}
