package com.itla.mudat.components.users;

import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by maste on 12/14/2017.
 */

public class UserLoginComponent {

    private final ImageButton login;
    private final ImageButton cancel;

    private UserLoginComponent(UserLoginComponentBuilder builder) {

        this.login = builder.login;
        this.cancel = builder.cancel;

    }

    public ImageButton getLogin() {
        return login;
    }

    public ImageButton getCancel() {
        return cancel;
    }

    public static class UserLoginComponentBuilder {
        private static ImageButton login;
        private static ImageButton cancel;

        public UserLoginComponentBuilder(ImageButton login, ImageButton cancel){
            this.login = login;
            this.cancel = cancel;
        }

        public UserLoginComponentBuilder login(ImageButton login){
            this.login = login;
            return this;
        }

        public UserLoginComponentBuilder cancel(ImageButton cancel){
            this.cancel = cancel;
            return this;
        }

        public UserLoginComponent build(){
            return new UserLoginComponent(this);
        }
    }




}
