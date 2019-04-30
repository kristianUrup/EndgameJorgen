/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package endgame.GUI.Controller;

import endgame.BE.Department;
import endgame.BE.Order;
import endgame.BLL.Exception.BllException;
import endgame.GUI.Model.OrderModel;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kristian Urup laptop
 */
public class PostItController implements Initializable
{
    Department department;
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
    
    PlatformController pfcontroller;
    OrderModel OMO;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button done;
    @FXML
    private TableColumn<Department, String> statusColumn;
    @FXML
    private TableColumn<?, ?> departmentNameColumn;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        try
        {
            pfcontroller = new PlatformController();
            OMO = new OrderModel();
            //setProgressBar();
        } catch (BllException ex)
        {
            Logger.getLogger(PostItController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
       
    public void setOrderInfo(Order order)
    {
        ordersForDepartment = order;
        lblOrderNumber.setText(ordersForDepartment.getOrderNumber());
        lblCustomer.setText(ordersForDepartment.getCustomer());
        lblDeliveryDate.setText(ordersForDepartment.toStringDeliveryDate());
    }
    
    public void setDepartment(Department department) {
        this.department = department; 
    }
    
    public Button getButton() {
        return done;
    }
    
    public void setDone() throws BllException
    {
        OMO.changeOrderState(ordersForDepartment, department);
    }
    
    public void departmentList(Order order) throws BllException
    {
        
        List<Department> departments = new ArrayList();
        
        Department d1 = new Department(1,"Fisk", false);
        Department d2 = new Department(2, "Funky", false);
        Department d3 = new Department(3, "Frederik", false);
        
        departments.add(d1);
        departments.add(d2);
        departments.add(d3);  
        
        for (int i = 0; i > departments.size(); i++)
        {
            
        }
    }
}
