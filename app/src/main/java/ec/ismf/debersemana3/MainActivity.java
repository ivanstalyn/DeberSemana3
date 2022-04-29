package ec.ismf.debersemana3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtUsuario, txtClave;
    private Button btnLogin;

    private String usuario = "estudiante";
    private String clave = "1234567890";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUsuario = findViewById(R.id.txtUsuario);
        txtClave = findViewById(R.id.txtClave);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usr = txtUsuario.getText().toString();
                String pass = txtClave.getText().toString();

                txtUsuario.setText("");
                txtClave.setText("");

                if (usr.isEmpty() || pass.isEmpty()){
                    Toast.makeText(MainActivity.this, "Debe ingresasr usuario y clave", Toast.LENGTH_SHORT).show();
                }

                if (usr.equals(usuario) && pass.equals(clave)){
                    Toast.makeText(MainActivity.this, "Ingreso exitoso!!!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent( MainActivity.this, Calculadora.class );
                    startActivity(intent);

                } else {
                    Toast.makeText(MainActivity.this, "Usuario o clave inválidos", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}