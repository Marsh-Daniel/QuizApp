package com.example.danielmarsh.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int questionNumber = 1;
    int numberQuestionsRight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean bothClicked(){
        CheckBox trueBox = (CheckBox) findViewById(R.id.true_checkbox);
        CheckBox falseBox = (CheckBox) findViewById(R.id.false_checkbox);

        if (trueBox.isChecked() && falseBox.isChecked()){
            return true;
        }
        return false;
    }

    public boolean neitherIsClicked(){
        CheckBox trueBox = (CheckBox) findViewById(R.id.true_checkbox);
        CheckBox falseBox = (CheckBox) findViewById(R.id.false_checkbox);

        if(!trueBox.isChecked() && !falseBox.isChecked()){
            return true;
        }
        return false;
    }

    public void checkQuestionNumber(View view){
        if(bothClicked()){
           Toast.makeText(MainActivity.this, "Please only select one answer", Toast.LENGTH_SHORT).show();

            return;
        }
        if(neitherIsClicked()){
            Toast.makeText(MainActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
            return;
        }
        if(questionNumber == 1){
            firstQuestionCheck();
        }else if(questionNumber == 2){
            secondQuestionCheck();
        }else if (questionNumber == 3){
            thirdQuestionCheck();
        }else if (questionNumber == 4){
            fourthQuestionCheck();
        }else if (questionNumber == 5){
            fifthQuestionCheck();
        }else if(questionNumber == 6){
            questionNumber = 1;
            restart();
        }
    }
    public void clearAnswers(){
        CheckBox trueBox = (CheckBox) findViewById(R.id.true_checkbox);
        CheckBox falseBox = (CheckBox) findViewById(R.id.false_checkbox);
        if(trueBox.isChecked()){
        trueBox.toggle();
        }
        if(falseBox.isChecked()) {
            falseBox.toggle();
        }
    }

    public void nextQuestion(){
        TextView questionTextView = (TextView) findViewById(R.id.Question_text);
        clearAnswers();
        if(questionNumber == 1){
            questionTextView.setText("Are vipers Poisonous?");
        }
        if(questionNumber == 2){
            questionTextView.setText("The space between your eyebrows is called the glabella");
        }else if (questionNumber == 3){
            questionTextView.setText("Every day more money is printed for monopoly than the US Treasury");
        }else if (questionNumber == 4){
            questionTextView.setText("Carl Lewis holds the record for the most Olympic medals");
        }else if (questionNumber == 5){
            questionTextView.setText("The Tango originated in Brazil");
        }
    }
    public void firstQuestionCheck(){
        CheckBox questionView = (CheckBox) findViewById(R.id.false_checkbox);
        if (questionView.isChecked()){
            Toast.makeText(MainActivity.this,"Correct! vipers are venomous not Poisonous.", Toast.LENGTH_LONG).show();
            numberQuestionsRight++;

        }else{
            Toast.makeText(MainActivity.this, "false, vipers are venomous not Poisonous.", Toast.LENGTH_LONG).show();
        }
        questionNumber++;
        nextQuestion();
    }

    public void secondQuestionCheck(){
        CheckBox questionView = (CheckBox) findViewById(R.id.true_checkbox);


        if(questionView.isChecked()){
            Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_LONG).show();
            numberQuestionsRight++;
        }
        else{
            Toast.makeText(MainActivity.this, "False", Toast.LENGTH_LONG).show();
        }
        questionNumber++;
        nextQuestion();
    }
    public void thirdQuestionCheck(){
        CheckBox questionView = (CheckBox) findViewById(R.id.true_checkbox);
        if(questionView.isChecked()){
            Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_LONG).show();
            numberQuestionsRight++;
        }
        else{
            Toast.makeText(MainActivity.this, "False", Toast.LENGTH_LONG).show();
        }
        questionNumber++;
        nextQuestion();
    }
    public void fourthQuestionCheck(){
CheckBox questionView = (CheckBox) findViewById(R.id.false_checkbox);
        if (questionView.isChecked()){
            Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_LONG).show();
            numberQuestionsRight++;
        }else{
            Toast.makeText(MainActivity.this, "False, Micheal Phelps holds this honor", Toast.LENGTH_LONG).show();
        }
        questionNumber++;
        nextQuestion();
    }
    public void fifthQuestionCheck(){
        CheckBox questionView = (CheckBox) findViewById(R.id.false_checkbox);
        if (questionView.isChecked()){
            Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_LONG).show();
            numberQuestionsRight++;
        }else{
            Toast.makeText(MainActivity.this, "False", Toast.LENGTH_LONG).show();
        }
        questionNumber++;
        showScore();
    }

    public void showScore(){
        TextView questionTextView = (TextView) findViewById(R.id.Question_text);
        CheckBox falseBox = (CheckBox) findViewById(R.id.false_checkbox);
        CheckBox trueBox = (CheckBox) findViewById(R.id.true_checkbox);
        Button buttonView = (Button) findViewById(R.id.button_view);
        buttonView.setText("Retry?");

        falseBox.setVisibility(View.GONE);
        trueBox.setVisibility(View.GONE);
        questionTextView.setText("Congratulations you got " + numberQuestionsRight + " out of 5 right");

    }

    public void restart(){
        CheckBox falseBox = (CheckBox) findViewById(R.id.false_checkbox);
        CheckBox trueBox = (CheckBox) findViewById(R.id.true_checkbox);
        Button buttonView = (Button) findViewById(R.id.button_view);

        buttonView.setText("Next Question/Check Answer");

        falseBox.setVisibility(View.VISIBLE );
        trueBox.setVisibility(View.VISIBLE);
        questionNumber = 1;
        nextQuestion();
    }
}
