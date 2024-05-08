package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;

import com.example.demo.Game.FillTheGap;

// import javax.swing.plaf.multi.MultiButtonUI;

import com.example.demo.Game.MultipleOptions;
import com.example.demo.Game.Question;
import com.example.demo.Game.Questionnaire;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class GameGameController extends MainController {

    @FXML
    private Label questionText;
    @FXML
    private Label scoreText;
    @FXML
    private Label reply;
    @FXML
    private TextField fillField;
    @FXML
    private Button butA;
    @FXML
    private Button butB;
    @FXML
    private Button butC;
    @FXML
    private Button butD;
    @FXML
    private Button goNext;
    @FXML
    private Button submitBut;

    @FXML
    private Label labA;
    @FXML
    private Label labB;
    @FXML
    private Label labC;
    @FXML
    private Label labD;
    @FXML
    private Label nextLab;

    private int iter;
    private int score = 0;
    private int max_score = 100;
    ArrayList<Button> arrButtons = new ArrayList<>();
    private int bussyMode;

    @FXML
    private AnchorPane window;
    @FXML
    public void initialize() {
        bussyMode = Questionnaire.get().getAllowRedo();
        
        // System.out.println("" + bussyMode);
        goNext.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                iter++;
                loadQuestion();
            }
        });
        arrButtons.add(butA);
        arrButtons.add(butB);
        arrButtons.add(butC);
        arrButtons.add(butD);
        Collections.shuffle(Questionnaire.get());
        iter = 0;
        loadQuestion();
        
    }

    public void loadQuestion() {
        if (iter == max_score / 10) {
            Questionnaire.get().setScore(score);
            // changeWindow("GameSelect.fxml", gameWindow);
            fillField.setVisible(false);
            butA.setVisible(false);
            butB.setVisible(false);
            butC.setVisible(false);
            butD.setVisible(false);
            submitBut.setVisible(false);
            scoreText.setVisible(false);
            questionText.setText("CONGRATULATION!!!");
            if (bussyMode == 1) {
                reply.setText("You did it!");
            } else {
                reply.setText("You got a score of " + Questionnaire.get().getScore() + " out of " + max_score);
            }
            nextLab.setText("Finish");
            
            goNext.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    changeWindow("GameMenu.fxml", window);
                }
            });

        } else {
            reply.setText("");
        if (bussyMode == 1) {
            scoreText.setText("Take it easy!");
            enableNext(true);
        } else {
            scoreText.setText("Your current score: " + score);
            enableNext(false);
        }
        resetButton();
        Question ques = Questionnaire.get().get(iter);
        
        if (ques instanceof MultipleOptions) {
            fillField.setVisible(false);
            butA.setVisible(true);
            butB.setVisible(true);
            butC.setVisible(true);
            butD.setVisible(true);
            submitBut.setVisible(false);
            
            

            MultipleOptions question = (MultipleOptions) ques;            
            ArrayList<String> selectionList = question.toStringArr();
            questionText.setText(selectionList.get(0));
            labA.setText(selectionList.get(1));
            labB.setText(selectionList.get(2));
            labC.setText(selectionList.get(3));
            labD.setText(selectionList.get(4));
            
            setupButton(question.getAnswerKey());
        } else {
            fillField.setVisible(true);
            butA.setVisible(false);
            butB.setVisible(false);
            butC.setVisible(false);
            butD.setVisible(false);
            submitBut.setVisible(true);
            submitBut.setDisable(false);

            FillTheGap question = (FillTheGap) ques;
            ArrayList<String> selectionList = question.toStringArr();
            questionText.setText(selectionList.get(0));

            submitBut.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (fillField.getText().toString().equals(selectionList.get(1))) {
                        reply.setText(Questionnaire.get().get(iter).getReply("CORRECT"));
                        enableNext(true);
                        if (bussyMode == 0) {
                            score += 10; 
                            scoreText.setText("Your current score: " + score);
                        }
                        submitBut.setDisable(true);
                    }

                    if (!fillField.getText().toString().equals("") && !fillField.getText().toString().equals(selectionList.get(1))) {
                        reply.setText(Questionnaire.get().get(iter).getReply("INCORRECT"));  
                        if (bussyMode == 0) {
                            enableNext(true);
                            submitBut.setDisable(true);
                        }
                    }
                }
            });
        }  
        }
             
    }


    public void enableNext(boolean foo) {
        if (!foo) {
            goNext.setVisible(false);
            goNext.setDisable(true);
        } else {
            goNext.setVisible(true);
            goNext.setDisable(false);
        }
    }
    public void resetButton() {
        butA.setStyle("-fx-background-radius: 20"); 
        butB.setStyle("-fx-background-radius: 20"); 
        butC.setStyle("-fx-background-radius: 20"); 
        butD.setStyle("-fx-background-radius: 20"); 
        butA.setDisable(false);
        butB.setDisable(false);
        butC.setDisable(false);
        butD.setDisable(false);  

    }
    public void setEachButton(int ind ,int key) {
        if (ind == key) {
            arrButtons.get(ind).setStyle("-fx-background-color: #4CBB17; -fx-background-radius: 20;");   
            if (bussyMode == 0) {
                score += 10; 
                scoreText.setText("Your current score: " + score);
            }
            butA.setDisable(true);
            butB.setDisable(true);
            butC.setDisable(true);
            butD.setDisable(true);  
            reply.setText(Questionnaire.get().get(iter).getReply("CORRECT"));          
            enableNext(true);
            
        } else {
            arrButtons.get(ind).setStyle("-fx-background-color: #EE4B2B; -fx-background-radius: 20;");
            if (bussyMode == 0) {
                enableNext(true);
                butA.setDisable(true);
                butB.setDisable(true);
                butC.setDisable(true);
                butD.setDisable(true);
            }
            reply.setText(Questionnaire.get().get(iter).getReply("INCORRECT"));  
        }
    } 
    public void setupButton(int key) {
        arrButtons.get(0).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setEachButton(0, key);
            }
        });
        arrButtons.get(1).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setEachButton(1, key);
            }
        });
        arrButtons.get(2).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setEachButton(2, key);
            }
        });
        arrButtons.get(3).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setEachButton(3, key);
            }
        });
        
        
        
        
    }
    
}
