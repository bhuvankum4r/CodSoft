package org.bank;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ATMGUI extends Application {
    private BankAccount userAccount;
    private ATM atm;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        userAccount = new BankAccount(1000.0);
        atm = new ATM(userAccount);

        primaryStage.setTitle("ATM System");
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        Label balanceLabel = new Label("Current Balance: $" + userAccount.getBalance());
        Button checkBalanceButton = new Button("Check Balance");
        TextField depositField = new TextField();
        Button depositButton = new Button("Deposit");
        TextField withdrawField = new TextField();
        Button withdrawButton = new Button("Withdraw");
        Button exitButton = new Button("Exit");

        checkBalanceButton.setOnAction(e -> {
            double balance = atm.checkBalance();
            balanceLabel.setText("Current Balance: $" + balance);
        });

        depositButton.setOnAction(e -> {
            try {
                double depositAmount = Double.parseDouble(depositField.getText());
                atm.deposit(depositAmount);
                double balance = atm.checkBalance();
                balanceLabel.setText("Current Balance: $" + balance);
                depositField.clear();
            } catch (NumberFormatException ex) {
                // Handle invalid input
                System.out.println("Invalid input. Please enter a valid amount.");
            }
        });

        withdrawButton.setOnAction(e -> {
            try {
                double withdrawAmount = Double.parseDouble(withdrawField.getText());
                atm.withdraw(withdrawAmount);
                double balance = atm.checkBalance();
                balanceLabel.setText("Current Balance: $" + balance);
                withdrawField.clear();
            } catch (NumberFormatException ex) {
                // Handle invalid input
                System.out.println("Invalid input. Please enter a valid amount.");
            }
        });

        exitButton.setOnAction(e -> {
            primaryStage.close();
        });

        root.getChildren().addAll(balanceLabel, checkBalanceButton, depositField, depositButton, withdrawField, withdrawButton, exitButton);
        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
