package com.example.omegar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button register = findViewById(R.id.register);
        final EditText nameField = findViewById(R.id.registerName);
        final EditText emailField = findViewById(R.id.registerEmail);
        final EditText pwdField = findViewById(R.id.registerPwd);
        final EditText pwdConfField = findViewById(R.id.registerPwdConfirm);

        final CheckBox terms = findViewById((R.id.checkedTextView));
        String Terms = "I accept the terms and conditions";
        SpannableString termsspan = new SpannableString(Terms);
        ClickableSpan LinktoTerms = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent TermsIntent = new Intent(getBaseContext(),TermsAndConditions.class);
                startActivity(TermsIntent);
            }
        };
        termsspan.setSpan(LinktoTerms,13,33, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        terms.setText(termsspan);
        terms.setMovementMethod(LinkMovementMethod.getInstance());
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean[] validFields = new boolean[5];
                    /*  [0]: name
                        [1]: email
                        [2]: pwd
                        [3]: pwdConf
                        [4]: terms
                     */

                if(!terms.isChecked()){
                    Toast.makeText(Register.this,"Please agree the terms and conditions before moving on",Toast.LENGTH_SHORT).show();
                    return;
                }

                String name = nameField.getText().toString();
                String email = emailField.getText().toString();
                String pwd = pwdField.getText().toString();
                String pwdConf = pwdConfField.getText().toString();

                if(name.isEmpty()){

                }


                /*
                Intent intent = new Intent(getBaseContext(), Homepage.class);
                intent.putExtra("Name",name.getText().toString());
                intent.putExtra("Email",email.getText().toString());
                intent.putExtra("Phone",phone.getText().toString());
                intent.putExtra("Pwd",pwd.getText().toString());
                startActivity(intent);
                 */
            }

        });
    }
}
