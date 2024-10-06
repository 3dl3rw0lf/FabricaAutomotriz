/*
 * Project: FabricaAutomotriz
 * Package: PACKAGE_NAME
 * Class: GUI
 * Version: 1.1
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
    private JPanel panel;
    // private JTextField cantidadCilindrosTextField;
    private JTextField cilindradaTextField;
    private JTextField textField3;
    private JLabel marcaLabel;
    private JTextField marcaTextField;
    private JTextArea textVehiculos;
    private JRadioButton claseAuto;
    private JRadioButton claseInventario;
    private JButton agregarAutoAlInventarioButton;
    private JButton mostrarInventarioButton;
    private JList inventariosList;
    private DefaultListModel<String> listModel;
    private JButton agregarAlInventarioButton;
    private JLabel cantidadDeCilindrosLabel;
    private JLabel tres;
    private JLabel cilindradaLabel;
    private JComboBox<String> cantidadCilindrosComboBox;

    //TODO: hacer muchos inventarios
    private ArrayList<Inventario> inventarios = new ArrayList<>();


    public GUI() {
        super("Fábrica Automotriz");


        cantidadCilindrosComboBox.addItem("4");
        cantidadCilindrosComboBox.addItem("6");
        cantidadCilindrosComboBox.addItem("8");
        cantidadCilindrosComboBox.addItem("12");
        cantidadCilindrosComboBox.addItem("16");

        //  4 cilindros
        // 1.3
        // 1.4
        // 1.6
        // 1.8
        // 2.0
        // 2.5

        // 6 cilindros
        // 3.6
        setContentPane(panel);
        setSize(760, 319);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        listModel = new DefaultListModel<>();
        inventariosList.setModel(listModel);

        inicializarVisibilidad();

        claseAuto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCamposAuto();
            }
        });

        claseInventario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCamposInventario();
            }
        });

        agregarAlInventarioButton.addActionListener(new ActionListener() {
         /*   @Override
            public void actionPerformed(ActionEvent e) {
                inventarios.add(inv);
            }*/
            @Override
            public void actionPerformed(ActionEvent e) {
                String marca = marcaTextField.getText();
                if (!marca.isEmpty()) {
                    Inventario inv = new Inventario(marca);
                    inventarios.add(inv);
                    //listModel.addElement(marca);
                    JOptionPane.showMessageDialog(panel, "Inventario creado para la marca: " + marca);
                    marcaTextField.setText("");
                } else {
                    JOptionPane.showMessageDialog(panel, "Debe ingresar una marca.");
                }
            }
        });

        mostrarInventarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Estoy inseguro de querer limpiar el modelo
                listModel.clear();

                for (Inventario inv : inventarios) {
                    listModel.addElement(inv.getMarca());
                }
            }
        });

        inventariosList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedMarca = (String) inventariosList.getSelectedValue();
                if (selectedMarca != null) {
                    JOptionPane.showMessageDialog(panel, "Inventario seleccionado: " + selectedMarca);
                    // Aquí puedes agregar más lógica para mostrar detalles del inventario seleccionado si lo deseas
                }
            }
        });

        
    }

    private void inicializarVisibilidad(){
        claseAuto.setVisible(true);
        claseInventario.setVisible(true);

        marcaLabel.setVisible(false);
        marcaTextField.setVisible(false);
        agregarAlInventarioButton.setVisible(false);
        cantidadDeCilindrosLabel.setVisible(false);
        cantidadCilindrosComboBox.setVisible(false);
        cilindradaLabel.setVisible(false);
        cilindradaTextField.setVisible(false);
        tres.setVisible(false);
        textField3.setVisible(false);
        agregarAutoAlInventarioButton.setVisible(false);
        mostrarInventarioButton.setVisible(false);
        inventariosList.setVisible(false);
        textVehiculos.setVisible(false);

    }

    private void mostrarCamposAuto(){
        cantidadDeCilindrosLabel.setVisible(true);
        cantidadCilindrosComboBox.setVisible(true);
        cilindradaLabel.setVisible(true);
        cilindradaTextField.setVisible(true);
        tres.setVisible(true);
        textField3.setVisible(true);
        agregarAutoAlInventarioButton.setVisible(true);

        marcaLabel.setVisible(false);
        marcaTextField.setVisible(false);
        agregarAlInventarioButton.setVisible(false);
        inventariosList.setVisible(false);
        mostrarInventarioButton.setVisible(false);
    }

    private void mostrarCamposInventario(){
        marcaLabel.setVisible(true);
        marcaTextField.setVisible(true);
        agregarAlInventarioButton.setVisible(true);
        inventariosList.setVisible(true);
        mostrarInventarioButton.setVisible(true);

        cantidadDeCilindrosLabel.setVisible(false);
        cantidadCilindrosComboBox.setVisible(false);
        cilindradaLabel.setVisible(false);
        cilindradaTextField.setVisible(false);
        tres.setVisible(false);
        textField3.setVisible(false);
        agregarAutoAlInventarioButton.setVisible(false);
    }

    private void createUIComponents() {
        // Inicializar el componente JList
        inventariosList = new JList<>();
    }

    public static void main(String[] args) {
        JFrame panel = new GUI();
/*        JFrame frame = new JFrame("Inventario GUI");
        frame.setContentPane(new GUI().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);*/
    }

}
