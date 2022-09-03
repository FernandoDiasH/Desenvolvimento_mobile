package br.com.up.mensagemwpp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout inputLayoutNum;
    private TextInputLayout inputLayoutMsg;

    private TextInputEditText inputEditNum;
    private TextInputEditText inputEditMsg;

    private Button buttonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputLayoutNum = findViewById(R.id.input_Layout_Num);
        inputLayoutMsg =findViewById(R.id.input_Layout_Msg);

        inputEditNum =findViewById(R.id.input_Edit_Num);
        inputEditMsg =findViewById(R.id.input_Edit_Msg);

        buttonEnviar =findViewById(R.id.button_Enviar);

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String num = inputEditNum.getText().toString();
            String msg = inputEditMsg.getText().toString();

            if(num.length()< 11){
                inputEditNum.setError("Inserir um numero certo");
                return;
            }
            if(msg.isEmpty()){
                inputEditMsg.setError("Campo de mensagem vazia");
                return;
            }





            Uri webpage = Uri.parse("https://wa.me/"+ num + "?text="+msg);
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(webIntent);


        }
    });

    }


}