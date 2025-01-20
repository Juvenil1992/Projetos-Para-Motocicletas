package com.example.calculadorarelaomotocicleta;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
///atribuindo os componentes da tela ao algoritmo
public class MainActivity extends AppCompatActivity {
    EditText pinOrig;
    EditText coroaOrig;
    EditText velOrig;
    EditText pinNovo;
    EditText coroaNovo;
    EditText velNovo;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        /// componentes de tela
        pinOrig = findViewById(R.id.pinOrig);
        coroaOrig = findViewById(R.id.coroaOrig);
        velOrig = findViewById(R.id.velOrig);
        pinNovo = findViewById(R.id.pinNovo);
        coroaNovo = findViewById(R.id.coroaNovo);
        velNovo = findViewById(R.id.velNovo);
        btnCalcular = findViewById(R.id.btnCalcular);

        // Definindo o listener do botão para calcular a média

        btnCalcular.setOnClickListener(v -> calcularNovaVel());


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calcularNovaVel() {
        try {
            float pinorig = Float.parseFloat(pinOrig.getText().toString());
            float coroaorig = Float.parseFloat(coroaOrig.getText().toString());
            float velorig = Float.parseFloat(velOrig.getText().toString());
            float pinnovo = Float.parseFloat(pinNovo.getText().toString());
            float coroanovo = Float.parseFloat(coroaNovo.getText().toString());


            // Fórmula do calculo da relação e nova velocidade final
            float calcularNovaVel = (velorig / (pinorig / coroaorig)) * (pinnovo / coroanovo);

            // Exibindo o resultado
            velNovo.setText(String.format("%.2f", calcularNovaVel));

        } catch (NumberFormatException e) {
            velNovo.setText("Insira todos os dados");

        }
    }
}