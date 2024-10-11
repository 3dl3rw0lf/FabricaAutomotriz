/*
 * Project: FabricaAutomotriz
 * Package: PACKAGE_NAME
 * Class: GUI
 * Version: 1.2.0
 * Date: 02/10/2024 19:39
 * Author: Gustavo Aráuz
 * Copyright (c) 2024
 */

import Almacen.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI extends JFrame {
    private JPanel panel;

    private JRadioButton claseAuto;
    private JRadioButton claseInventario;

    private JLabel motorJLabel;
    private JLabel cantidadDeCilindrosLabel;
    private JComboBox<String> cantidadCilindrosComboBox;
    private JLabel cilindradaLabel;
    private JComboBox cilindradaComboBox;
    private JLabel precioMotorJLabel;
    private JSpinner precioMotorJSpinner;

    private JLabel carroceriaJLabel;
    private JLabel descripcionCarroceriaJlabel;
    private JComboBox descripcionCarroceriaComboBox;
    private JLabel colorCarroceriaJLabel;
    private JComboBox colorCarroceriaComboBox;
    private JSpinner precioCarroceriaJSpinner;
    private JLabel precioCarroceriaJLabel;

    private JLabel marcaLabel;
    private JTextField marcaTextField;
    private JTextArea textVehiculos;
    private JButton agregarAutoAlInventarioButton;
    private JButton actualizarInventarioButton;
    private JList inventariosList;
    private DefaultListModel<String> listModel;
    private JButton agregarAlInventarioButton;

    //TODO: hacer muchos inventarios
    private ArrayList<Inventario> inventarios = new ArrayList<>();


    public GUI() {
        super("Fábrica Automotriz");

        cantidadCilindrosComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cilindradaComboBox.removeAllItems();

                String seleccionCilindros = (String) cantidadCilindrosComboBox.getSelectedItem();

                if (seleccionCilindros != null) {
                    int cantidadCilindros = Integer.parseInt(seleccionCilindros);

                    switch (cantidadCilindros) {
                        case 4:
                            cilindradaComboBox.addItem("1.3");
                            cilindradaComboBox.addItem("1.4");
                            cilindradaComboBox.addItem("1.6");
                            cilindradaComboBox.addItem("1.8");
                            cilindradaComboBox.addItem("2.0");
                            cilindradaComboBox.addItem("2.5");
                            break;
                        case 6:
                            cilindradaComboBox.addItem("2.7");
                            cilindradaComboBox.addItem("3.0");
                            cilindradaComboBox.addItem("3.6");
                            break;
                        case 8:
                            cilindradaComboBox.addItem("5.0");
                            cilindradaComboBox.addItem("6.6");
                            break;
                        case 12:
                            cilindradaComboBox.addItem("7.0");
                            cilindradaComboBox.addItem("8.4");
                            break;
                        case 16:
                            cilindradaComboBox.addItem("10.0");
                            cilindradaComboBox.addItem("12.0");
                            break;
                        default:
                            cilindradaComboBox.addItem("N/A");
                    }
                }
            }
        });

        setContentPane(panel);
        setSize(907, 358);
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

        actualizarInventarioButton.addActionListener(new ActionListener() {
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
                }
            }
        });

        agregarAutoAlInventarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String descripcionCarroceria = (String) descripcionCarroceriaComboBox.getSelectedItem();
                    String colorCarroceria = (String) colorCarroceriaComboBox.getSelectedItem();
                    float precioCarroceria = ((Number) precioCarroceriaJSpinner.getValue()).floatValue();

                    Carroceria carroceria = new Carroceria(descripcionCarroceria, colorCarroceria, precioCarroceria);

                    int cilindros = Integer.parseInt((String) cantidadCilindrosComboBox.getSelectedItem());
                    float cilindradaLitros = Float.parseFloat((String) cilindradaComboBox.getSelectedItem());
                    int cilindrada = (int) (cilindradaLitros * 1000);
                    float precioMotor = ((Number) precioMotorJSpinner.getValue()).floatValue();

                    Motor motor = new Motor(cilindros, cilindrada, precioMotor);

                    Vehiculo vehiculo = new Vehiculo(motor, carroceria, 1000);

                    int selectedInventarioIndex = inventariosList.getSelectedIndex();
                    if (selectedInventarioIndex != -1) {
                        Inventario inventarioSeleccionado = inventarios.get(selectedInventarioIndex);
                        inventarioSeleccionado.agregar(vehiculo);
                        JOptionPane.showMessageDialog(panel, "Vehículo agregado al inventario: " + inventarioSeleccionado.getMarca());
                        mostrarDatosVehiculo(vehiculo);
                    } else {
                        JOptionPane.showMessageDialog(panel, "Seleccione un inventario para agregar el vehículo.");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, "Error al crear el vehículo: " + ex.getMessage());
                }
            }

            private void mostrarDatosVehiculo(Vehiculo vehiculo) {
                StringBuilder datos = new StringBuilder();
                // TODO: agregar datos inventario
                datos.append(vehiculo);

                for (Componente parte : vehiculo.getPartes()) {
                    if (parte instanceof Motor) {
                        Motor motor = (Motor) parte;
                        datos.append(motor);
                    } else if (parte instanceof Carroceria) {
                        Carroceria carroceria = (Carroceria) parte;
                        datos.append(carroceria);
                    }
                }

                datos.append("------------------\n");

                // Mostrar los datos en el JTextArea
                textVehiculos.append(datos.toString());
            }
        });
    }

    private void inicializarVisibilidad(){
        claseAuto.setVisible(true);
        claseInventario.setVisible(true);

        motorVisible(false);

        carroceriaVisible(false);

        agregarAutoAlInventarioButton.setVisible(false);
        marcaLabel.setVisible(false);
        marcaTextField.setVisible(false);
        actualizarInventarioButton.setVisible(false);
        inventariosList.setVisible(false);
        textVehiculos.setVisible(false);
        agregarAlInventarioButton.setVisible(false);

    }

    private void mostrarCamposAuto(){

        motorVisible(true);

        carroceriaVisible(true);

        agregarAutoAlInventarioButton.setVisible(true);
        textVehiculos.setVisible(true);
        marcaLabel.setVisible(false);
        marcaTextField.setVisible(false);
        agregarAlInventarioButton.setVisible(false);
        if (inventariosList.getModel().getSize() == 0 ){
            inventariosList.setVisible(false);
        } else {
            inventariosList.setVisible(true);
        }
        actualizarInventarioButton.setVisible(false);
    }

    private void mostrarCamposInventario(){
        marcaLabel.setVisible(true);
        marcaTextField.setVisible(true);
        agregarAlInventarioButton.setVisible(true);
        inventariosList.setVisible(true);
        actualizarInventarioButton.setVisible(true);

        motorVisible(false);

        carroceriaVisible(false);

        textVehiculos.setVisible(false);
        agregarAutoAlInventarioButton.setVisible(false);
    }

    private void createUIComponents() {
        inventariosList = new JList<>();
    }

    public void motorVisible(Boolean booleanM){
        motorJLabel.setVisible(booleanM);
        cilindradaLabel.setVisible(booleanM);
        cilindradaComboBox.setVisible(booleanM);
        cantidadDeCilindrosLabel.setVisible(booleanM);
        cantidadCilindrosComboBox.setVisible(booleanM);
        precioMotorJLabel.setVisible(booleanM);
        precioMotorJSpinner.setVisible(booleanM);
    }

    public void carroceriaVisible(Boolean booleanC){
        carroceriaJLabel.setVisible(booleanC);
        descripcionCarroceriaJlabel.setVisible(booleanC);
        descripcionCarroceriaComboBox.setVisible(booleanC);
        colorCarroceriaJLabel.setVisible(booleanC);
        colorCarroceriaComboBox.setVisible(booleanC);
        precioCarroceriaJLabel.setVisible(booleanC);
        precioCarroceriaJSpinner.setVisible(booleanC);
    }

    public static void main(String[] args) {
        JFrame panel = new GUI();
    }

}
