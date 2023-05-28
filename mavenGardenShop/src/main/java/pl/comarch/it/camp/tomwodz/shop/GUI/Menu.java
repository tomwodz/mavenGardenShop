package pl.comarch.it.camp.tomwodz.shop.GUI;

public enum Menu {
    HEADMENU1("Menu:"),
    HEADMENU2("1. Login"),
    HEADMENU3("2. Registration"),
    HEADMENU4("3. Exit"),
    USERMENU1("Menu:"),
    USERMENU2("1. List products"),
    USERMENU3("2. Buy product"),
    USERMENU4("3. Logout"),
    ADMINMENU1("4. Complete product"),
    ADMINMENU2("5. Assign roles");

    private final String menu;

    Menu(String menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(this.menu).toString();
    }

}
