package com.example.mvptwo;

public interface MainActivityView {

    interface view{
        void onSuccess(String message);
        void onFailure(String message);

    }

    interface Presenter{
        void doLogin(String email,String password);
    }


}
