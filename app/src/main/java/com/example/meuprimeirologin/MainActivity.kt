package com.example.meuprimeirologin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity

class MainActivity : ComponentActivity() {
    // Declaração das variáveis para os componentes da UI
    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var textViewError: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Define o layout XML

        // Inicializa os componentes da UI
        editTextUsername = findViewById(R.id.editTextUsername)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
        textViewError = findViewById(R.id.textViewError)

        // Configura o listener de clique para o botão de login
        buttonLogin.setOnClickListener {
            performLogin() // Chama a função que conterá a lógica de login
        }
    }

    private fun performLogin() {
        // Obtém o texto digitado nos campos de usuário e senha
        val username = editTextUsername.text.toString().trim() // Remove espaços extras
        val password = editTextPassword.text.toString().trim()

        // Reseta a mensagem de erro e a visibilidade antes de uma nova tentativa de login
        textViewError.text = ""
        textViewError.visibility = View.GONE

        // Validação: verifica se o campo de usuário está vazio
        if (username.isEmpty()) {
            textViewError.text = "Por favor, insira seu nome de usuário ou e-mail."
            textViewError.visibility = View.VISIBLE // Torna o TextView visível
            editTextUsername.requestFocus() // Coloca o foco no campo de usuário
            return // Interrompe a execução da função
        }

        // Validação: verifica se o campo de senha está vazio
        if (password.isEmpty()) {
            textViewError.text = "Por favor, insira sua senha."
            textViewError.visibility = View.VISIBLE
            editTextPassword.requestFocus()
            return
        }

        // Simulação de login com credenciais fixas: usuário "teste", senha "123"
        if (username == "teste" && password == "123") {
            Toast.makeText(this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show()


        } else {
            // Credenciais inválidas
            textViewError.text = "Nome de usuário ou senha inválidos."
            textViewError.visibility = View.VISIBLE
        }
    }
}