/*
 * Project: FabricaAutomotriz
 * Package: PACKAGE_NAME
 * Class: GUI
 * Version: 1.0
 * Date: 02/10/2024 19:39
 * Author: Gustavo Aráuz
 * Copyright (c) 2024
 */

import Almacen.Inventario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI extends JFrame {
    private JPanel contentPane;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel marcaLabel;
    private JTextField marcaTextField;
    private JTextArea textVehiculos;
    private JRadioButton claseMotor;
    private JRadioButton claseCarroceria;
    private JButton crearObjetoButton;
    private JButton mostrarAtributosButton;
    private JList list1;
    private JRadioButton autoRadioButton;

    //TODO: hacer muchos inventarios
    private ArrayList<Inventario> inventarios = new ArrayList<>();


    public GUI() {
        //TODO: NOTE se crea un inventario con la marca obtenida del campo marca
        Inventario inv = new Inventario(marcaTextField.getText());

        crearObjetoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inventarios.add(inv);
            }
        });


    }

    public static void main(String[] args) {
        GUI dialog = new GUI();
    }
}
