package ulbra.saolucas.appcalculasalario;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup rbopcoes;
    Button btncalcular;
    EditText edtsalario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtsalario = findViewById(R.id.edsalario);
        rbopcoes = findViewById(R.id.rgopcoes);
        btncalcular = findViewById(R.id.btcalcular);

        btncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                calcularSalario();
            }
        });
    }

    private void calcularSalario() {
        // Verifica se o campo de salário está vazio
        if (edtsalario.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Por favor, insira o salário.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Obtendo o salário inserido
        double salario = Double.parseDouble(edtsalario.getText().toString());
        int op = rbopcoes.getCheckedRadioButtonId();

        // Verifica se nenhuma opção foi selecionada
        if (op == -1) {
            Toast.makeText(MainActivity.this, "Por favor, selecione uma opção.", Toast.LENGTH_SHORT).show();
            return;
        }

        double novo_salario = 0;

        // Calcula o novo salário com base na opção selecionada
        if (op == R.id.rb40) {
            novo_salario = salario + (salario * 0.4);
        } else if (op == R.id.rb45) {
            novo_salario = salario + (salario * 0.45);
        } else if (op == R.id.rb50) {
            novo_salario = salario + (salario * 0.5);
        }


        AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
        dialogo.setTitle("Novo salário");
        dialogo.setMessage("Seu novo salário é: R$ " + String.format("%.2f", novo_salario));
        dialogo.setNeutralButton("OK", null);
        dialogo.show();
    }
}