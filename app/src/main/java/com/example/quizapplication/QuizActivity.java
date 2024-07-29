package com.example.quizapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private List<Question> questionList;
    private int questionIndex = 0;
    private int score = 0;
    private QuizDatabaseHelper dbHelper;
    private TextView txtScore;
    private TextView txtQuestion;
    private TextView txtNoQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        radioGroup = findViewById(R.id.radioGroup);
        txtQuestion = findViewById(R.id.txtQuestion);
        txtScore = findViewById(R.id.txtScore);
        txtNoQuestions = findViewById(R.id.txtNoQuestions);
        dbHelper = new QuizDatabaseHelper(this);
        questionList = dbHelper.getRandomQuestions(); // Get 10 random questions

        if (questionList.isEmpty()) {
            txtNoQuestions.setVisibility(View.VISIBLE);
            txtQuestion.setVisibility(View.GONE);
            radioGroup.setVisibility(View.GONE);
            txtScore.setVisibility(View.GONE);
            findViewById(R.id.btnNext).setVisibility(View.GONE);
        } else {
            txtNoQuestions.setVisibility(View.GONE);
            txtQuestion.setVisibility(View.VISIBLE);
            radioGroup.setVisibility(View.VISIBLE);
            txtScore.setVisibility(View.VISIBLE);
            findViewById(R.id.btnNext).setVisibility(View.VISIBLE);
            displayQuestion();
        }
    }

    private void displayQuestion() {
        if (questionIndex < questionList.size()) {
            Question currentQuestion = questionList.get(questionIndex);

            txtQuestion.setText(currentQuestion.getQuestion());

            RadioButton radioButton1 = findViewById(R.id.radioButton1);
            RadioButton radioButton2 = findViewById(R.id.radioButton2);
            RadioButton radioButton3 = findViewById(R.id.radioButton3);
            RadioButton radioButton4 = findViewById(R.id.radioButton4);

            radioGroup.clearCheck();
            radioButton1.setText(currentQuestion.getOption1());
            radioButton2.setText(currentQuestion.getOption2());
            radioButton3.setText(currentQuestion.getOption3());
            radioButton4.setText(currentQuestion.getOption4());
        } else {
            endGame();
        }
    }

    public void nextQuestion(View view) {
        int selectedAnswerId = radioGroup.getCheckedRadioButtonId();
        if (selectedAnswerId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedAnswerId);
            int selectedAnswer = radioGroup.indexOfChild(selectedRadioButton) + 1;

            Question currentQuestion = questionList.get(questionIndex);
            if (selectedAnswer == currentQuestion.getCorrectAnswer()) {
                score++;
            }

            questionIndex++;
            displayQuestion();
            updateScore();
        } else {
            Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateScore() {
        txtScore.setText("Score: " + score);
    }

    private void endGame() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Quiz completed! Your score: " + score);
        builder.setMessage("Please enter your name:");

        final EditText input = new EditText(this);
        builder.setView(input);

        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String playerName = input.getText().toString().trim();
                if (!playerName.isEmpty()) {
                    dbHelper.addScore(playerName, score);

                    Intent intent = new Intent(QuizActivity.this, Top10Activity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                    finish();
                } else {
                    Toast.makeText(QuizActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();

                    endGame();
                }
            }
        });

        builder.setCancelable(false);
        builder.show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        endGame();
    }
}
