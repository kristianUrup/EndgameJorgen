/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package endgame.DAL.json;

import endgame.DAL.Exception.DalException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Frederik Jensen
 */
public class JSONFileReader
{

    IOrder jsonOrder;
    IWorker jsonWorker;
    IDepartmentTask jsonTask;

    public JSONFileReader()
    {
        jsonOrder = new JSONOrder();
        jsonWorker = new JSONWorker();
        jsonTask = new JSONDepartmentTask();
    }

    public void getJsonFile(File folder) throws DalException
    {
        for (File fileEntry : folder.listFiles())
        {
            if (getFileExtension(fileEntry).equals("json"))
            {
                readJsonFile(fileEntry.getAbsolutePath());
            }
        }
    }

    private static String getFileExtension(File file)
    {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else
        {
            return "";
        }
    }

    public void readJsonFile(String json) throws DalException
    {
        getWorkersFromJson(json);
    }

    private void getWorkersFromJson(String json)
    {
        try
        {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(json));
            JSONArray avalWorkers = (JSONArray) jsonObject.get("AvailableWorkers");
            for (Object object : avalWorkers)
            {
                System.out.println(jsonWorker.getName(object));
                System.out.println(jsonWorker.getInitials(object));
                System.out.println(jsonWorker.getSalaryNumber(object));
            }
        } catch (IOException | ParseException ex)
        {
            Logger.getLogger(JSONFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void getOrdersFromJson(String json) throws DalException
    {
        try
        {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(json));
            JSONArray orders = (JSONArray) jsonObject.get("ProductionOrders");
            for (Object object : orders) {
                Date deliveryDate = jsonOrder.getDeliveryTime(object);
                String customer = jsonOrder.getCustomer(object);
                String orderNumber = jsonOrder.getOrderNumber(object);
                
                JSONObject jObject = (JSONObject) object;
                JSONArray tasks = (JSONArray) jsonObject.get("DepartmentTasks");
                for (Object object2 : orders) {
                    
                }
            }
        } catch (IOException | ParseException ex)
        {
            Logger.getLogger(JSONFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void getTasksFromJson(Object object) {
        JSONObject jObject = (JSONObject) object;
        
    }
}
