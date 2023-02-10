import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class Signup2 extends JFrame implements ActionListener {

    JComboBox religion,category,income,education,occupation;
    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    String formno;
    Signup2(String formno){

        setLayout(null);
        formno=this.formno;

        setTitle("NEW ACCOUNT APPLICATION FORM: PAGE 2");

        JLabel additionalDetails=new JLabel("Page 2:Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,38));
        additionalDetails.setBounds(140,20,600,40);
        add(additionalDetails);



        JLabel name=new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add(name);

        String valReligion[] = {"Hindu","Muslim","Christian","Others"};
        religion=new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);




        JLabel Fname=new JLabel("Category:");
        Fname.setFont(new Font("Raleway",Font.BOLD,22));
        Fname.setBounds(100,190,200,30);
        add(Fname);

        String valcategory[]={"General","OBC","SC","ST"};
        category=new JComboBox(valcategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel dob=new JLabel("Income");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100,240,200,30);
        add(dob);

        String incomecategory[]={"NULL","<1,50,000","<2,50,000","<5,00,000","Upto 30,00,000"};
        income=new JComboBox(incomecategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);




        JLabel gender=new JLabel("Educational Qualification");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100,315,200,30);
        add(gender);

        String educationcategory[]={"Non Graduate","Graduate","Post Graduate","Doctrate","Others"};
        education=new JComboBox(educationcategory);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);


        JLabel martialStatus=new JLabel("Occupation");
        martialStatus.setFont(new Font("Raleway",Font.BOLD,22));
        martialStatus.setBounds(100,390,200,30);
        add(martialStatus);

        String occupationcategory[]={"Salaried","Self Employed","Business","Student","Retaired","Others"};
        occupation=new JComboBox(occupationcategory);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);


        JLabel address=new JLabel("Pan number");
        address.setFont(new Font("Raleway",Font.BOLD,22));
        address.setBounds(100,440,200,30);
        add(address);

        pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);

        JLabel city=new JLabel("Aadhar No");
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100,490,200,30);
        add(city);

        aadhar=new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);

        JLabel state=new JLabel("Senior Citizen");
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(100,540,200,30);
        add(state);

        syes=new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno=new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup citizengrp=new ButtonGroup();
        citizengrp.add(syes);
        citizengrp.add(sno);




        JLabel pin=new JLabel("Existing Account");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,590,200,30);
        add(pin);

        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno=new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup existgrp=new ButtonGroup();
        existgrp.add(eyes);
        existgrp.add(eno);

        next=new JButton("Next");
        next.setForeground(Color.BLACK);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        String sreligion=(String)religion.getSelectedItem();
        String scategory=(String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seduaction=(String)education.getSelectedItem();
        String soccypation=(String)occupation.getSelectedItem();


        String seniorCitizen=null;
        if(syes.isSelected()) {
            seniorCitizen="YES";
        }
        else if(sno.isSelected()){
            seniorCitizen="NO";
        }

        String existing=null;
        if(eyes.isSelected()){
            existing="YES";
        }
        else if(eno.isSelected()){
            existing="NO";
        }

        String span=pan.getText();
        String saadhar=aadhar.getText();


        try {

                Conn c=new Conn();
                //4.CREATE QUERY
                String query="insert into Signup2 values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seduaction+"','"+soccypation+"','"+span+"','"+saadhar+"','"+existing+"','"+seniorCitizen+"')";
                //EXECUTE QUERY
                c.s.executeUpdate(query);

                setVisible(false);
                new Signup3(formno).setVisible(true);

        } catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
        new Signup2("");
    }
}

