package br.com.forukode.matheusmartins.personaltravel.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.com.forukode.matheusmartins.personaltravel.R;

/**
 * Created by matheusmartins on 12/31/14.
 */
public class LoginActivity extends Activity {

    View.OnClickListener logInClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
    }

    public String getLogin() {
        return ((EditText) findViewById(R.id.login_layout_login_input)).getText().toString();
    }

    public String getPassword() {
        return ((EditText) findViewById(R.id.login_layout_password_input)).getText().toString();
    }
}
