/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package endgame.GUI.Controller;

import endgame.BE.Order;
import endgame.GUI.Model.OrderModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

/**
 * FXML Controller class
 *
 * @author Kristian Urup laptop
 */
public class PostItController implements Initializable
{
    Order ordersForDepartment;
    @FXML
    private Label lblOrderNumber;
    @FXML
    private Label lblCustomer;
    @FXML
    private Label lblDeliveryDate;
    @FXML
    private Label lblLastActive;
    @FXML
    private ProgressBar estimatedProgress;
    
    private Order order;
    
    OrderModel OMO;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        OMO = new OrderModel();
        setProgressBar();
        
    }    

    @FXML
    private void handleDoneBtn(ActionEvent event)
    {
        
    }
    
    @FXML
    private void setProgressBar()
    {
        estimatedProgress.setProgress(OMO.getProgressedTimeInProcent());
    }
    
    public void setOrderInfo(Order order)
    {
        ordersForDepartment = order;
        lblOrderNumber.setText(ordersForDepartment.getOrderNumber());
        lblCustomer.setText(ordersForDepartment.getCustomer());
        lblDeliveryDate.setText(ordersForDepartment.toStringDeliveryDate());
    }
    
}
