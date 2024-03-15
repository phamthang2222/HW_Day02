package vn.phamthang.hw_day02;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {
    private EditText edtUserName;
    private EditText edtPassword;
    private EditText edtCheckPass;
    private Button btnRegis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getVariable();
        onClick();

    }

    private void onClick() {
        btnRegis.setOnClickListener(v -> {
            String username = edtUserName.getText().toString().trim();
            String password = edtPassword.getText().toString().trim();
            String checkPassword = edtCheckPass.getText().toString().trim();
            if(username.isEmpty() == false
                    && password.isEmpty()==false
                    && checkPassword.isEmpty() ==false
            ){
                if(password.equals(checkPassword)){
                    Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                    intent.putExtra("USERNAME",username);
                    intent.putExtra("PASS",password);

                    Toast.makeText(this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    finish();
                }   else{
                    edtCheckPass.setError("Chưa khớp mật khẩu!");
                }
            }else{
                Toast.makeText(this, "Chưa điền đủ thông tin", Toast.LENGTH_SHORT).show();
            }

        });
    }

    private void getVariable() {
        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPass);
        edtCheckPass = findViewById(R.id.edtPass3);
        btnRegis = findViewById(R.id.btnnLogin);
    }


}