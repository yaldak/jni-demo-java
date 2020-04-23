package cc.kako.examples.jni;

import java.time.Instant;
import java.util.Arrays;
import java.util.stream.Collectors;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainSceneController {
    /* Basic */
    @FXML
    private TextField nativeStringTextField;
    
    @FXML
    private TextField nativeIntTextField;
    
    @FXML
    private TextField nativeIntArrayTextField;
    
    @FXML
    private TextField nativeIntegerObjectTextField;
    
    /* Functions */
    @FXML
    private TextField rotateStringTextField;
    
    @FXML
    private Label nativeRotateStringPerfLabel;
    
    @FXML
    private Label javaRotateStringPerfLabel;
    
    @FXML
    private Label nativeArraySumPerfLabel;
    
    @FXML
    private Label nativeArraySumResultLabel;
    
    @FXML
    private TextField nativeArraySumN;
    
    /* Performance Metrics */
    @FXML
    private TextField metricsStringTextField;
    
    @FXML
    private LineChart<Number, Number> metricsBarChart;
    
    @FXML
    public void initialize() {
    }
    
    /* Basic */
    @FXML
    private void onGetNativeStringPressed() {
        String nativeString = NativeSampler.nativeString();
        
        this.nativeStringTextField.setText(nativeString);
    }
    
    @FXML
    private void onGetNativeIntPressed() {
        int nativeInt = NativeSampler.nativeInt();
        
        this.nativeIntTextField.setText(String.valueOf(nativeInt));
    }
    
    @FXML
    private void onGetNativeIntArrayPressed() {
        int[] nativeIntArray = NativeSampler.nativeIntArray();
        
        String text = Arrays.stream(nativeIntArray)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        
        this.nativeIntArrayTextField.setText(String.valueOf(text));
    }
    
    @FXML
    private void onGetNativeIntegerObjectPressed() {
        Integer nativeIntegerObject = NativeSampler.nativeIntegerObject();
        
        this.nativeIntegerObjectTextField.setText(String.valueOf(nativeIntegerObject));
    }
    
    /* Graphics */
    @FXML
    private void onOpenglTriangleDemoButtonPressed() {
        NativeSampler.nativeOpenGLTriangle();
    }
    
    /* Functions */
    @FXML
    private void onNativeRotateStringPressed() {
        String input = this.rotateStringTextField.getText();
        
        Instant start = Instant.now();
        String result = NativeSampler.nativeRotateString(input);
        Instant stop = Instant.now();
        
        this.rotateStringTextField.setText(result);
        this.nativeRotateStringPerfLabel.setText(Util.formatNanoDuration(start, stop));
    }
    
    @FXML
    private void onJavaRotateStringPressed() {
        String input = this.rotateStringTextField.getText();
        
        Instant start = Instant.now();
        String result = Util.rotateString(input);
        Instant stop = Instant.now();
        
        this.rotateStringTextField.setText(result);
        this.javaRotateStringPerfLabel.setText(Util.formatNanoDuration(start, stop));
    }
    
    @FXML
    private void onNativeArraySumPressed() {
        String nText = this.nativeArraySumN.getText();

        int n = Util.tryParseInt(nText).orElse(1);

        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = i;
        }
        
        Instant start = Instant.now();
        int result = NativeSampler.nativeArraySumParallel(values);
        Instant stop = Instant.now();
        
        this.nativeArraySumResultLabel.setText(String.valueOf(result));
        this.nativeArraySumPerfLabel.setText(Util.formatNanoDuration(start, stop));
    }
    
    @FXML
    private void onNativeExceptionPressed() {
        NativeSampler.nativeRaiseException();
    }
    
    @FXML
    private void onSpeedTestPressed() {
        String input = this.metricsStringTextField.getText();
        
        metricsBarChart.getData().clear();
        
        XYChart.Series<Number, Number> nativeSeries = new XYChart.Series<>();
        nativeSeries.setName("Native");
        for (int i = 0; i < 100; i++) {
            Instant start = Instant.now();
            String result = NativeSampler.nativeRotateString(input);
            Instant stop = Instant.now();
            
            nativeSeries.getData().add(new XYChart.Data<>(i, 
                    Util.calculateNanoDuration(start, stop)));
        }
        metricsBarChart.getData().add(nativeSeries);
        
        XYChart.Series<Number, Number> javaSeries = new XYChart.Series<>();
        javaSeries.setName("Java");
        for (int i = 0; i < 100; i++) {
            Instant start = Instant.now();
            String result = Util.rotateString(input);
            Instant stop = Instant.now();
            
            javaSeries.getData().add(new XYChart.Data<>(i, 
                    Util.calculateNanoDuration(start, stop)));
        }
        metricsBarChart.getData().add(javaSeries);
    }
}
