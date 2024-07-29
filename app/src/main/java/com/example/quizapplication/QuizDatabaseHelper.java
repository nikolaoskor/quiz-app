package com.example.quizapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuizDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "QuizDB";
    public static final int DATABASE_VERSION = 3;
    public static final String TABLE_QUESTIONS = "Questions";
    public static final String TABLE_SCORES = "Scores";

    public QuizDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_QUESTIONS_TABLE = "CREATE TABLE " + TABLE_QUESTIONS +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Question TEXT," +
                "Option1 TEXT," +
                "Option2 TEXT," +
                "Option3 TEXT," +
                "Option4 TEXT," +
                "CorrectAnswer INTEGER)";
        db.execSQL(CREATE_QUESTIONS_TABLE);

        String CREATE_SCORES_TABLE = "CREATE TABLE " + TABLE_SCORES +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "PlayerName TEXT," +
                "Score INTEGER)";
        db.execSQL(CREATE_SCORES_TABLE);

        addInitialQuestions(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTIONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORES);
        onCreate(db);
    }

    private void addInitialQuestions(SQLiteDatabase db) {
        addQuestion(db, "What is the capital of France?", "Paris", "Rome", "Berlin", "Madrid", 1);
        addQuestion(db, "What is the largest planet in our solar system?", "Mars", "Venus", "Saturn", "Jupiter", 4);
        addQuestion(db, "What is the capital of Italy?", "Rome", "Paris", "Berlin", "Madrid", 1);
        addQuestion(db, "What is the smallest planet in our solar system?", "Mars", "Venus", "Mercury", "Jupiter", 3);
        addQuestion(db, "What is the capital of Spain?", "Madrid", "Paris", "Berlin", "Rome", 1);
        addQuestion(db, "What is the farthest planet from the sun in our solar system?", "Mars", "Neptune", "Saturn", "Jupiter", 2);
        addQuestion(db, "Which team won the FIFA World Cup in 2018?", "France", "Croatia", "Brazil", "Germany", 1);
        addQuestion(db, "Which player won the Golden Boot of the 2014 FIFA World Cup?", "James Rodriguez", "Thomas Müller", "Lionel Messi", "Neymar", 2);
        addQuestion(db, "Who is the all-time top scorer of the UEFA Champions League?", "Lionel Messi", "Cristiano Ronaldo", "Raúl", "Robert Lewandowski", 2);
        addQuestion(db, "Which country has won the most FIFA World Cup titles?", "Brazil", "Germany", "Italy", "Argentina", 1);
        addQuestion(db, "Who is the only player to have won the UEFA Champions League with three different clubs?", "Cristiano Ronaldo", "Lionel Messi", "Andrés Iniesta", "Clarence Seedorf", 4);
        addQuestion(db, "Who won the UEFA European Championship in 2016?", "Portugal", "France", "Germany", "Spain", 1);
        addQuestion(db, "Which club has won the most UEFA Champions League titles?", "Real Madrid", "Barcelona", "Bayern Munich", "Liverpool", 1);
        addQuestion(db, "Who is the youngest player to score in a FIFA World Cup?", "Pelé", "Kylian Mbappé", "Michael Owen", "Lionel Messi", 2);
        addQuestion(db, "Which country hosted the FIFA World Cup in 2014?", "Brazil", "Germany", "South Africa", "Russia", 1);
        addQuestion(db, "Who won the UEFA Champions League in 2020?", "Bayern Munich", "Paris Saint-Germain", "Real Madrid", "Manchester City", 1);
        addQuestion(db, "Who has won the most Ballon d'Or awards?", "Lionel Messi", "Cristiano Ronaldo", "Michel Platini", "Johan Cruyff", 1);
        addQuestion(db, "Which player has the most assists in the history of the Premier League?", "Ryan Giggs", "Frank Lampard", "Cesc Fàbregas", "Thierry Henry", 1);
        addQuestion(db, "Who is the all-time top scorer of the English Premier League?", "Alan Shearer", "Wayne Rooney", "Thierry Henry", "Sergio Agüero", 1);
        addQuestion(db, "Which club won the English Premier League title in the 2019-2020 season?", "Liverpool", "Manchester City", "Manchester United", "Chelsea", 1);
        addQuestion(db, "Who is the only player to have scored in a UEFA Champions League final for three different clubs?", "Cristiano Ronaldo", "Lionel Messi", "Sergio Ramos", "Steven Gerrard", 1);
        addQuestion(db, "Which player has the most appearances in the history of the UEFA Champions League?", "Cristiano Ronaldo", "Iker Casillas", "Xavi", "Ryan Giggs", 2);
        addQuestion(db, "Which country won the first ever FIFA World Cup in 1930?", "Uruguay", "Argentina", "Brazil", "Italy", 1);
        addQuestion(db, "Who was the top scorer of the FIFA World Cup in 2010?", "David Villa", "Thomas Müller", "Wesley Sneijder", "Diego Forlán", 4);
        addQuestion(db, "Which player has won the most FIFA World Cup titles?", "Pelé", "Diego Maradona", "Cafu", "Franz Beckenbauer", 1);
        addQuestion(db, "Which nation has won the most UEFA European Championship titles?", "Germany", "Spain", "France", "Italy", 2);
        addQuestion(db, "What is the capital of Germany?", "Berlin", "Paris", "Rome", "Madrid", 1);
        addQuestion(db, "What is the closest planet to the sun in our solar system?", "Mars", "Mercury", "Saturn", "Jupiter", 2);
        addQuestion(db, "What is the capital of England?", "London", "Paris", "Berlin", "Madrid", 1);
        addQuestion(db, "What is the hottest planet in our solar system?", "Mars", "Venus", "Saturn", "Jupiter", 2);
        addQuestion(db, "What is the capital of Greece?", "Athens", "Rome", "Berlin", "Madrid", 1);
        addQuestion(db, "What is the second smallest planet in our solar system?", "Mars", "Venus", "Mercury", "Earth", 3);
        addQuestion(db, "What is the capital of Japan?", "Tokyo", "Paris", "Rome", "Madrid", 1);
        addQuestion(db, "What is the fastest planet in our solar system?", "Mars", "Venus", "Mercury", "Jupiter", 3);
        addQuestion(db, "What is the capital of India?", "New Delhi", "Rome", "Berlin", "Madrid", 1);
        addQuestion(db, "What is the largest moon in our solar system?", "Ganymede", "Titan", "Europa", "Callisto", 1);
        addQuestion(db, "What is the capital of Brazil?", "Brasília", "Paris", "Rome", "Madrid", 1);
        addQuestion(db, "What is the coldest planet in our solar system?", "Mars", "Venus", "Saturn", "Neptune", 4);
        addQuestion(db, "What is the capital of Russia?", "Moscow", "Paris", "Rome", "Madrid", 1);
        addQuestion(db, "What is the brightest planet in our solar system?", "Mars", "Venus", "Jupiter", "Mercury", 3);
    }

    public void addQuestion(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int correctAnswer) {
        ContentValues values = new ContentValues();
        values.put("Question", question);
        values.put("Option1", option1);
        values.put("Option2", option2);
        values.put("Option3", option3);
        values.put("Option4", option4);
        values.put("CorrectAnswer", correctAnswer);
        db.insert(TABLE_QUESTIONS, null, values);
    }


    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_QUESTIONS, null);
        if (cursor.moveToFirst()) {
            do {
                Question question = new Question();
                question.setId(cursor.getInt(0));
                question.setQuestion(cursor.getString(1));
                question.setOption1(cursor.getString(2));
                question.setOption2(cursor.getString(3));
                question.setOption3(cursor.getString(4));
                question.setOption4(cursor.getString(5));
                question.setCorrectAnswer(cursor.getInt(6));
                questionList.add(question);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return questionList;
    }

    public List<Question> getRandomQuestions() {
        List<Question> allQuestions = getAllQuestions();
        Collections.shuffle(allQuestions);
        return allQuestions.subList(0, Math.min(10, allQuestions.size()));
    }


    public List<String> getTop10() {
        List<String> top10List = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT PlayerName, Score FROM " + TABLE_SCORES + " ORDER BY Score DESC LIMIT 10", null);
        if (cursor.moveToFirst()) {
            do {
                String playerName = cursor.getString(0);
                int score = cursor.getInt(1);
                top10List.add(playerName + " - Score: " + score);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return top10List;
    }

    public void addScore(String playerName, int score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("PlayerName", playerName);
        values.put("Score", score);
        db.insert(TABLE_SCORES, null, values);
        db.close();
    }

    public void deleteAllScores() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SCORES, null, null);
        db.close();
    }

}
