package com.example.mvptwo;

public class MainActivityPresenter implements MainActivityView.Presenter{
   MainActivityView.view view;

    public MainActivityPresenter(MainActivityView.view view) {
        this.view = view;
    }

    @Override
    public void doLogin(String email, String password) {

        if(email.equals("mh2624127@gmail.com") && password.equals("123456")){
            view.onSuccess("Success");
        }else {
            view.onFailure("Ërror");
        }
    }
}
