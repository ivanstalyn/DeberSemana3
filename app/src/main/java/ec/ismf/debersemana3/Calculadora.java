package ec.ismf.debersemana3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculadora extends AppCompatActivity {
    Button btnClickEventCalcular, btnClickEventLimpiar;
    TextView txtNota1, txtNota2, txtExamen1, txtExamen2,
            lblNotaParcial1, lblNotaParcial2, lblNotaFinal, lblEstado;
    String tmp;
    Double nota1, nota2, examen1, examen2, parcial1, parcial2, notaFinal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        txtNota1 = (TextView) findViewById(R.id.txtNota1);
        txtExamen1 = (TextView) findViewById(R.id.txtExamen1);
        txtNota2 = (TextView) findViewById(R.id.txtNota2);
        txtExamen2 = (TextView) findViewById(R.id.txtExamen2);
        lblNotaParcial1 = (TextView) findViewById(R.id.lblNotaParcial1);
        lblNotaParcial2 = (TextView) findViewById(R.id.lblNotaParcial2);
        lblNotaFinal = (TextView) findViewById(R.id.lblNotaFinal);
        lblEstado = (TextView) findViewById(R.id.lblEstado);
        limpiar();
        btnClickEventCalcular = (Button) findViewById(R.id.btnCalcular);
        btnClickEventCalcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                nota1 = Double.parseDouble(txtNota1.getText().toString()) * 0.3;
                examen1 = Double.parseDouble(txtExamen1.getText().toString()) * 0.2;
                parcial1 = nota1 + examen1;
                nota2 = Double.parseDouble(txtNota2.getText().toString()) * 0.3;
                examen2 = Double.parseDouble(txtExamen2.getText().toString()) * 0.2;
                parcial2 = nota2 + examen2;

                lblNotaParcial1.setText(String.format("%.2f", parcial1));

                lblNotaParcial2.setText(String.format("%.2f", parcial2));

                notaFinal = parcial1 + parcial2;
                lblNotaFinal.setText(String.format("%.2f", notaFinal));

                if(notaFinal >= 7.0){
                    tmp = "Aprobado";
                }

                if(notaFinal >= 5.0 && notaFinal <= 6.9){
                    tmp = "Complementario";
                }

                if(notaFinal < 5.0 ){
                    tmp = "REPROBADO";
                }

                lblEstado.setText(tmp);


            }
        });

        btnClickEventLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnClickEventLimpiar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                limpiar();
            }
        });

    }

    public void limpiar() {
        txtNota1.setText("0.00");
        txtExamen1.setText("0.00");
        txtNota2.setText("0.00");
        txtExamen2.setText("0.00");
        lblNotaParcial1.setText("0.00");
        lblNotaParcial2.setText("0.00");
        lblNotaFinal.setText("");
        lblEstado.setText("");
    }
}