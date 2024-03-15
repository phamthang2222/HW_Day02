package vn.phamthang.hw_day02;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    private EditText edtUserName;
    private EditText edtPassword;
    private Button btnLogin;
    private TextView tvRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getVariable();
        onClick();
    }

    private void onClick() {

        Intent intent= getIntent();
        String dataUsername = intent.getStringExtra("USERNAME");
        String dataPassword = intent.getStringExtra("PASS");
        Log.d("Oncreat:",dataUsername+" "+dataPassword);
        
        btnLogin.setOnClickListener(v -> {
            String username = edtUserName.getText().toString().trim();
            String password = edtPassword.getText().toString().trim();

            if(username.isEmpty()){
                edtUserName.setError("Chưa điền");
            }else if( password.isEmpty()){
                edtPassword.setError("Chưa điền");
            }else{
                if(username.equals(dataUsername) && password.equals(dataPassword)){
                    Intent intent2 = new Intent(LoginActivity.this,MainActivity.class);
                    Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    startActivity(intent2);
                    finish();
                }else{
                    Toast.makeText(this, "Sai tên đăng nhập hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }
            }
        });
        tvRegister.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            finish();
        });

    }

    private void getVariable() {
       edtUserName = findViewById(R.id.edtUserName1);
       edtPassword = findViewById(R.id.edtPass);
       btnLogin = findViewById(R.id.btnnLogin);
       tvRegister = findViewById(R.id.tvRegister);
    }


}