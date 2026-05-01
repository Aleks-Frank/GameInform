package com.example.infogames.specialMethods;

import com.example.infogames.audioWorker.SoundWorker;
import com.example.infogames.docxFileWorker.CreateAndOpenFileWord;
import com.example.infogames.entity.StudentAuth;
import com.example.infogames.entity.StudentLoginDTO;
import com.example.infogames.globalEntity.GlobalJSONLogin;
import com.example.infogames.globalEntity.GlobalJSONStudent;
import com.example.infogames.globalEntity.GlobalStudentUser;
import com.example.infogames.globalEntity.GlobalTask;
import com.example.infogames.listView.ListMessage;
import com.example.infogames.listView.ListViews;
import com.example.infogames.workerDB.TasksRepository;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class SwitchMethods {

    /**Метод для кнопки закрытия*/
    public static void closeWindow(Button button){
        button.setOnAction(event -> {
            Stage stage = (Stage) button.getScene().getWindow();
            stage.close();
        });
    }

    /**Метод для перемещения между окнами*/
    public static void switchWindow(Button button, String path){
        button.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(SwitchMethods.class.getResource(path));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                scene.setFill(Color.TRANSPARENT);
                Stage stage = (Stage) button.getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**Метод для открытия настроек*/
    public static void switchSettings(Button button, String path, ImageView prefon) {
        button.setOnAction(event -> {
            try {
                prefon.setVisible(true);
                FXMLLoader loader = new FXMLLoader(StageMethods.class.getResource(path));
                Parent newRoot = loader.load();
                Stage settingsStage = new Stage();

                settingsStage.initOwner(StageMethods.getPrimaryStage());
                settingsStage.initStyle(StageStyle.TRANSPARENT);

                Scene scene = new Scene(newRoot);
                scene.setFill(Color.TRANSPARENT);
                settingsStage.setScene(scene);

                settingsStage.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
                    if (!isNowFocused) {
                        settingsStage.close();
                        prefon.setVisible(false);
                    }
                });

                StageMethods.setSettingStage(settingsStage);
                settingsStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**Метод для закрытия настроек*/
    public static void switchFromSettingsToTheWindow(Button button) {
        button.setOnAction(event -> {
            StageMethods.getSettingStage().close();
        });
    }

    /**Метод для показа информации о задании*/
    public static void switchToWindowInfoTasks(Button button, String path, String id, ImageView prefon){
        button.setOnAction(event -> {
            try {
                getTasksInfoForDB(id);
                prefon.setVisible(true);
                FXMLLoader loader = new FXMLLoader(StageMethods.class.getResource(path));
                Parent newRoot = loader.load();
                Stage infoTaskStage = new Stage();

                infoTaskStage.initOwner(StageMethods.getPrimaryStage());
                infoTaskStage.initStyle(StageStyle.TRANSPARENT);

                Scene scene = new Scene(newRoot);
                scene.setFill(Color.TRANSPARENT);
                infoTaskStage.setScene(scene);

                infoTaskStage.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
                    if (!isNowFocused) {
                        infoTaskStage.close();
                        prefon.setVisible(false);
                    }
                });

                StageMethods.setInfoTasksSave(infoTaskStage);
                infoTaskStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static void getTasksInfoForDB(String id) throws Exception {
        getTasksInfoForDBConnect(id);
    }

    private static void getTasksInfoForDBConnect(String id) throws Exception {

        TasksRepository dbRepositoryController = new TasksRepository();
        dbRepositoryController.connect();
        GlobalTask.globalTasks = dbRepositoryController.getTasksById(id);
        dbRepositoryController.close();

    }

    public static void openWordFileOnButton(Button button){
        button.setOnAction(event -> {
            CreateAndOpenFileWord.workerFileWord();
            if (StageMethods.getSettingStage() != null && StageMethods.getSettingStage() .isShowing()){
                StageMethods.getSettingStage().close();
            }
            showTasksInfo();
            openWindowCorrect();
            openWindowResultTask();
        });
    }

    private static void showTasksInfo(){
        try {
            FXMLLoader loader = new FXMLLoader(SwitchMethods.class.getResource(ListViews.TASK_NAME_VIEW));
            Parent newRoot = loader.load();
            Stage infoTaskStage = new Stage();
            infoTaskStage.setAlwaysOnTop(true);
            infoTaskStage.initOwner(StageMethods.getPrimaryStage());
            infoTaskStage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(newRoot);
            scene.setFill(Color.TRANSPARENT);
            infoTaskStage.setScene(scene);
            infoTaskStage.initStyle(StageStyle.TRANSPARENT);

            StageMethods.setInfoTasksSave(infoTaskStage);
            infoTaskStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void openWindowCorrect(){
        try {
            FXMLLoader loader = new FXMLLoader(SwitchMethods.class.getResource(ListViews.CHECKER_VIEW));
            Parent newRoot = loader.load();
            Stage currectStage = new Stage();
            currectStage.setAlwaysOnTop(true);

            Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
            double screenWidth = primaryScreenBounds.getWidth();
            double screenHeight = primaryScreenBounds.getHeight();

            double x = screenWidth - 420; // Координата x для правого края
            double y = screenHeight - 330; // Координата y для нижнего края

            currectStage.setX(x);
            currectStage.setY(y);
            currectStage.setResizable(false);
            currectStage.initOwner(StageMethods.getPrimaryStage());
            currectStage.initModality(Modality.WINDOW_MODAL);
            Scene newScene = new Scene(newRoot);
            newScene.setFill(Color.TRANSPARENT);
            currectStage.setScene(newScene);
            currectStage.initStyle(StageStyle.TRANSPARENT);
            StageMethods.setCurrectSaveStage(currectStage);
            StageMethods.getPrimaryStage().hide();
            currectStage.show();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    private static void openWindowResultTask(){
        try {
            FXMLLoader loader = new FXMLLoader(SwitchMethods.class.getResource(ListViews.TASK_VISUAL_VIEW));
            Parent newRoot = loader.load();
            Stage resultStage = new Stage();
            resultStage.setAlwaysOnTop(true);

            Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
            double screenHeight = primaryScreenBounds.getHeight();

            double x = 40;
            double y = (screenHeight - 600) / 2;

            resultStage.setX(x);
            resultStage.setY(y);
            resultStage.setResizable(false);
            resultStage.initOwner(StageMethods.getPrimaryStage());
            resultStage.initModality(Modality.WINDOW_MODAL);
            Scene newScene = new Scene(newRoot);
            newScene.setFill(Color.TRANSPARENT);
            resultStage.setScene(newScene);
            resultStage.initStyle(StageStyle.TRANSPARENT);

            // Можно отцентрировать окно по левому краю после того, как оно загрузится
            resultStage.setOnShown(e -> {
                double actualWidth = resultStage.getWidth();
                resultStage.setX(x); // Фиксированный отступ
            });

            StageMethods.setResultSaveStage(resultStage);
            resultStage.show();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void switchWindowToSettings(Button button, String path){
        button.setOnAction(event -> {
            try {
                StageMethods.getSettingStage().close();
                FXMLLoader loader = new FXMLLoader(SwitchMethods.class.getResource(path));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                scene.setFill(Color.TRANSPARENT);
                Stage stage = StageMethods.getPrimaryStage();
                stage.setScene(scene);
                stage.centerOnScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void saveNewInfoStudent(Button button, Label labelError,
                                          TextField name, TextField surname,
                                          TextField classStudent, TextField school,
                                          TextField login, TextField password) {
        button.setOnAction(actionEvent -> {
            if (classStudent.getText().trim().isEmpty() ||
                    school.getText().trim().isEmpty() ||
                    name.getText().trim().isEmpty() ||
                    surname.getText().trim().isEmpty() ||
                    password.getText().trim().isEmpty() ||
                    login.getText().trim().isEmpty()) {

                labelError.setText(ListMessage.formNotFull);
                labelError.setVisible(true);
                SoundWorker.soundsError();
            } else {
                try {
                    StudentAuth student = new StudentAuth(
                            name.getText().trim(),
                            surname.getText().trim(),
                            Integer.parseInt(classStudent.getText().trim()),
                            school.getText().trim(),
                            login.getText().trim(),
                            password.getText().trim()
                    );
                    if (GlobalStudentUser.globalStudent != null &&
                            GlobalStudentUser.globalStudent.getId() != null) {
                        student.setId(GlobalStudentUser.globalStudent.getId());
                    } else {
                        labelError.setText("Ошибка: ID пользователя не найден");
                        labelError.setVisible(true);
                        SoundWorker.soundsError();
                        return;
                    }

                    SaveInfoMethods.sendJSON(student, labelError);

                } catch (NumberFormatException e) {
                    labelError.setText("Некорректный формат класса");
                    labelError.setVisible(true);
                    SoundWorker.soundsError();
                } catch (Exception e) {
                    labelError.setText("Ошибка: " + e.getMessage());
                    labelError.setVisible(true);
                    SoundWorker.soundsError();
                    e.printStackTrace();
                }
            }
        });
    }

    public static void logoutBottom(Button button){
        button.setOnAction(event -> {
            try {
                GlobalStudentUser.setGlobalStudent(null);
                GlobalJSONStudent.setGlobalEntityLSON(null);
                FXMLLoader loader = new FXMLLoader(SwitchMethods.class.getResource(ListViews.LOGIN_VIEW));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                scene.setFill(Color.TRANSPARENT);
                Stage stage = (Stage) button.getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void logoutBottomToSettings(Button button){
        button.setOnAction(event -> {
            try {
                GlobalStudentUser.setGlobalStudent(null);
                GlobalJSONStudent.setGlobalEntityLSON(null);
                StageMethods.getSettingStage().close();
                FXMLLoader loader = new FXMLLoader(SwitchMethods.class.getResource(ListViews.LOGIN_VIEW));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                scene.setFill(Color.TRANSPARENT);
                Stage stage = StageMethods.getPrimaryStage();
                stage.setScene(scene);
                stage.centerOnScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void switchSettingsToScoreMenu(Button button){
        button.setOnAction(actionEvent -> {
            try {
                FXMLLoader loader = new FXMLLoader(SwitchMethods.class.getResource(ListViews.SCORES_VIEW));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                scene.setFill(Color.TRANSPARENT);
                Stage stage = StageMethods.getSettingStage();
                stage.setScene(scene);
                stage.centerOnScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
