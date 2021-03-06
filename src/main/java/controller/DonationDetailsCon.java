package controller;

import data.model.DonationDetails;


import javax.faces.bean.ManagedBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@ManagedBean(name = "donorbean")

public class DonationDetailsCon {

    public ArrayList<DonationDetails>getDonationDetails(){

        ArrayList<DonationDetails>records=new ArrayList<>();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","username","Oracle_1");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select* from donation");
            while(rs.next())
            {
                DonationDetails don=new DonationDetails();
                don.setDonation_type(rs.getString(1));
                don.setDonation_date(rs.getDate(2));
                don.setDistributor_id(rs.getInt(3));
                don.setDonor_type(rs.getString(4));
                records.add(don);
            }

        }
        catch (Exception e){
            System.out.println(e);
        }
        return records;
    }

    public String isNextPage(){
        return "donation_details"; //same name as next page
    }
}